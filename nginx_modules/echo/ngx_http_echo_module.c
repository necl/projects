#include <ngx_core.h>

#include <ngx_http.h>
#include "echo.h"

static ngx_int_t ngx_http_echo_handler(ngx_http_request_t *r);
static char* ngx_http_echo_echo(ngx_conf_t *cf, ngx_command_t *cmd,
	void *conf);

static ngx_command_t ngx_http_echo_commands[] = {
	{
		ngx_string("echo"),
		NGX_HTTP_LOC_CONF | NGX_CONF_NOARGS,
		ngx_http_echo_echo,
		NGX_HTTP_LOC_CONF_OFFSET,
		0,
		NULL
	},
	ngx_null_command
};


static ngx_http_module_t ngx_http_echo_module_ctx = {
	NULL,
	NULL,
	NULL,
	NULL,
	NULL,
	NULL,
	NULL,
	NULL
};

ngx_module_t  ngx_http_echo_module = {
	NGX_MODULE_V1,
	&ngx_http_echo_module_ctx,
	ngx_http_echo_commands,
	NGX_HTTP_MODULE,
	NULL,
	NULL,
	NULL,
	NULL,
	NULL,
	NULL,
	NULL,
	NGX_MODULE_V1_PADDING
};

static char * ngx_http_echo_echo(ngx_conf_t *cf, ngx_command_t *cmd, void *conf)
{
	ngx_http_core_loc_conf_t* clcf = ngx_http_conf_get_module_loc_conf(cf, ngx_http_core_module);
	clcf->handler = ngx_http_echo_handler;
	return NGX_CONF_OK;
}

static ngx_int_t ngx_http_echo_handler(ngx_http_request_t *r)
{
	ngx_uint_t i;
	ngx_table_elt_t *header;
	ngx_keyval_t* kvHeader;
	EchoRequest req;
	req.method = r->method_name;
	req.uri = r->uri;

	ngx_array_init(&req.headers, r->pool, 20, sizeof(ngx_keyval_t));
	header = r->headers_in.headers.part.elts;	
	for (i = 0; i < r->headers_in.headers.part.nelts; i++){
		kvHeader = ngx_array_push(&req.headers);
		kvHeader->key = header[i].key;
		kvHeader->value = header[i].value;
	}

	EchoResponse rsp;
	echo(&req, &rsp, r->pool);

	r->headers_out.status = rsp.status;
	r->headers_out.content_type = rsp.content_type;

	r->headers_out.content_length_n = rsp.content.len;
	ngx_http_send_header(r);

	ngx_buf_t* b = ngx_pcalloc(r->pool, sizeof(ngx_buf_t));
	if (b == NULL){
		return NGX_HTTP_INTERNAL_SERVER_ERROR;
	}

	b->pos = rsp.content.data;
	b->last = rsp.content.data + rsp.content.len;

	b->memory = 1;
	b->last_buf = 1;
	
	ngx_chain_t* cl = ngx_alloc_chain_link(r->pool);
	if (cl == NULL) {
		return NGX_HTTP_INTERNAL_SERVER_ERROR;
	}

	cl->buf = b;
	cl->next = NULL;

	return ngx_http_output_filter(r, cl);
}
extern "C"{
#include <ngx_core.h>
#include <ngx_http.h>
}


#include "echo.h"

using namespace std;

static ngx_int_t ngx_http_echocpp_handler(ngx_http_request_t *r);
static char* ngx_http_echocpp_echo(ngx_conf_t *cf, ngx_command_t *cmd,
	void *conf);

static ngx_command_t ngx_http_echocpp_commands[] = {
	{
		ngx_string("echocpp"),
		NGX_HTTP_LOC_CONF | NGX_CONF_NOARGS,
		ngx_http_echocpp_echo,
		NGX_HTTP_LOC_CONF_OFFSET,
		0,
		nullptr
	},
	ngx_null_command
};


static ngx_http_module_t ngx_http_echocpp_module_ctx = {
	nullptr,
	nullptr,
	nullptr,
	nullptr,
	nullptr,
	nullptr,
	nullptr,
	nullptr
};

ngx_module_t  ngx_http_echocpp_module = {
	NGX_MODULE_V1,
	&ngx_http_echocpp_module_ctx,
	ngx_http_echocpp_commands,
	NGX_HTTP_MODULE,
	nullptr,
	nullptr,
	nullptr,
	nullptr,
	nullptr,
	nullptr,
	nullptr,
	NGX_MODULE_V1_PADDING
};

static char * ngx_http_echocpp_echo(ngx_conf_t *cf, ngx_command_t *cmd, void *conf)
{
	ngx_http_core_loc_conf_t* clcf = reinterpret_cast<ngx_http_core_loc_conf_t*>(
						ngx_http_conf_get_module_loc_conf(cf, ngx_http_core_module));
	clcf->handler = ngx_http_echocpp_handler;
	return NGX_CONF_OK;
}

static ngx_int_t ngx_http_echocpp_handler(ngx_http_request_t *r)
{
	EchocppRequest req;
	req.method.assign(reinterpret_cast<const char*>(r->method_name.data), 
		r->method_name.len);
	req.uri.assign(reinterpret_cast<const char*>(r->uri.data), r->uri.len);

	ngx_table_elt_t *header = 
		reinterpret_cast<ngx_table_elt_t *>(r->headers_in.headers.part.elts);
	for (ngx_uint_t i = 0; i < r->headers_in.headers.part.nelts; i++){
		string strKey, strVal;
		strKey.assign(reinterpret_cast<const char*>(header[i].key.data),
			header[i].key.len);
		strVal.assign(reinterpret_cast<const char*>(header[i].value.data),
			header[i].value.len);
		req.headers[strKey] = strVal;
	}

	EchocppResponse rsp;
	echocpp(req, rsp);
		
	r->headers_out.status = rsp.status;
	r->headers_out.content_type.data = reinterpret_cast<u_char*>(ngx_pnalloc(r->pool, rsp.content_type.size()));
	ngx_memcpy(r->headers_out.content_type.data, rsp.content_type.data(), rsp.content_type.size());
	r->headers_out.content_type.len = rsp.content_type.size();
	ngx_http_send_header(r);


	u_char * content = reinterpret_cast<u_char*>(
				ngx_pcalloc(r->pool, rsp.content.size()));
	if (content == nullptr){
		return NGX_HTTP_INTERNAL_SERVER_ERROR;
	}
	memcpy(content, rsp.content.c_str(), rsp.content.size());

	ngx_buf_t* b = reinterpret_cast<ngx_buf_t*>(ngx_pcalloc(r->pool, sizeof(ngx_buf_t)));
	if (b == NULL){
		return NGX_HTTP_INTERNAL_SERVER_ERROR;
	}

	b->pos = content;
	b->last = content + rsp.content.size();

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

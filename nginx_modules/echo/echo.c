#include <ngx_core.h>
#include <ngx_http.h>
#include <jansson.h>
#include "echo.h"

void echo(EchoRequest* req, EchoResponse* rsp, ngx_pool_t *pool)
{
	ngx_uint_t i;
	ngx_keyval_t * kvHeader;
	json_t * json;
	json_t * jsonMethod, *jsonUri, *jsonHeaders, *jsonHeader;
	char* szJson;
	size_t len;

	jsonMethod = json_stringn((const char*)req->method.data, req->method.len);
	jsonUri = json_stringn((const char*)req->uri.data, req->uri.len);

	jsonHeaders = json_array();
	kvHeader = req->headers.elts;
	for (i = 0; i < req->headers.nelts;i++)
	{
		jsonHeader = json_pack("{ss}", kvHeader[i].key.data, kvHeader[i].value.data);
		json_array_append_new(jsonHeaders, jsonHeader);
	}	

	json = json_object();
	json_object_set(json, "method", jsonMethod);
	json_object_set(json, "uri", jsonUri);
	json_object_set(json, "headers", jsonHeaders);

	szJson = json_dumps(json, 0);
	json_decref(json);

	len = strlen(szJson);
	rsp->status = NGX_HTTP_OK;
	rsp->content_type.data = (u_char *)"application/json";
	rsp->content_type.len = sizeof("application/json");
	rsp->content.data = ngx_palloc(pool, len);
	rsp->content.len = len;

	ngx_memcpy(rsp->content.data, szJson, len);
	free(szJson);
}

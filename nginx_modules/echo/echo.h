#ifndef _ECHO_H_
#define _ECHO_H_

typedef struct {
	ngx_str_t method;
	ngx_str_t uri;
	ngx_array_t headers; /*ngx_keyval_t*/
	ngx_str_t body;
}EchoRequest;

typedef struct {
	ngx_uint_t status;
	ngx_str_t content_type;
	ngx_str_t content;
}EchoResponse;

void echo(EchoRequest* req, EchoResponse* rsp, ngx_pool_t *pool);

#endif



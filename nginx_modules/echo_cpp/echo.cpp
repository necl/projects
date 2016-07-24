#include <ngx_core.h>
#include <ngx_http.h>
#include <algorithm>
#include "jansson.h"
#include "echo.h"

using namespace std;

void echocpp(const EchocppRequest req, EchocppResponse& rsp)
{
	json_t* jsonHeaders = json_array();
	for_each(req.headers.begin(), req.headers.end(), 
	[&jsonHeaders](const pair<string, string>& pariHeader){
		json_array_append_new(jsonHeaders, json_pack("{ss}", pariHeader.first.c_str(),
			pariHeader.second.c_str()));
	});

	json_t* json = json_pack("{ssss}",
						"method", req.method.c_str(),
						"uri", req.uri.c_str());
	json_object_set(json, "headers", jsonHeaders);
		
	rsp.content = json_dumps(json, 0);
	json_decref(json);

	rsp.status = NGX_HTTP_OK;
	rsp.content_type = "application/json";
}


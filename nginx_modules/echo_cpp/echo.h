#ifndef _ECHOCPP_H_
#define _ECHOCPP_H_

#include <string>
#include <map>

struct EchocppRequest{
	std::string method;
	std::string uri;
	std::map<std::string, std::string> headers;
	std::string body;
};

struct EchocppResponse{
	ngx_uint_t status;
	std::string content_type;
	std::string content;
};

void echocpp(const EchocppRequest req, EchocppResponse& rsp);

#endif
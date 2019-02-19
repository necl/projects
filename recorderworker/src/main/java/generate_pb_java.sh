#! /bin/bash 

#set -x 

PROTOC="${HOME}/appsvr/thirdparty/protobuf/bin/protoc"
DST_DIR=.

${PROTOC} --java_out=${DST_DIR} recordercomm.proto

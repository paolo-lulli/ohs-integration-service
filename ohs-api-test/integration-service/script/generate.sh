#! /bin/bash -x

cd $(dirname $0)

DIR_OF_PROTO_FILE=../ohs-common/src/main/proto/

PROTO_FILES="order.proto  product.proto  supplier.proto  user.proto"

for f in ${PROTO_FILES}; do
  PROTO=$(echo $f | sed -e 's/\.proto//')
  PROTO_FILE="/tmp/${PROTO}"
  OUTPUT_FILE="/tmp/${PROTO}"
  protoc --plugin=protoc-gen-grpc-java=build/exe/java_plugin/protoc-gen-grpc-java\
  --grpc-java_out="$OUTPUT_FILE" --proto_path="$DIR_OF_PROTO_FILE" "$f"
done

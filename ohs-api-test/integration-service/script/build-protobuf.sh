#! /bin/bash -x

PROTOBUF_VERSION=21.7
curl -LO https://github.com/protocolbuffers/protobuf/releases/download/v$PROTOBUF_VERSION/protobuf-all-$PROTOBUF_VERSION.tar.gz
tar xzf protobuf-all-$PROTOBUF_VERSION.tar.gz
cd protobuf-$PROTOBUF_VERSION
./configure --disable-shared
make   # You may want to pass -j to make this run faster; see make --help
sudo make install

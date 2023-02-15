#! /bin/bash 

cd $(dirname $0)

cd ..
docker run  ohc-integration-service:latest

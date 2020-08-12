#!/bin/sh

./consul agent -config-dir=/consul-config &

java -jar authenticationService-1.0.0.jar
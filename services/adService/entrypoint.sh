#!/bin/sh
./consul agent -config-dir=/consul-config &
java -jar AdService-1.0.0.jar

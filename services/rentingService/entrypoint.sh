#!/bin/sh
./consul agent -config-dir=/consul-config &
java -jar rentingService-1.0.0.jar

#!/bin/sh
./consul agent -config-dir=/consul-config &
java -jar gpsService-1.0.0.jar

#!/bin/sh
./consul agent -config-dir=/consul-config &
java -jar AdminService-1.0.0.jar

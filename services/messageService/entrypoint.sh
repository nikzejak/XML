#!/bin/sh
./consul agent -config-dir=/consul-config &
java -jar messageService-1.0.0.jar

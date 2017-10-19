#!/bin/bash
set -e

find -name "*.java" > sources.txt
javac @sources.txt -classpath "../json-simple-1.1.1.jar:." -d bin
rm sources.txt
cp -r ./src/views ./bin

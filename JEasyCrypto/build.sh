#!/bin/bash
set -e

mkdir -p bin
javac -d bin src/easycrypto/*.java
cd bin
jar cvf ../../EasyCryptoLib.jar easycrypto/*.class

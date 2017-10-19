#!/bin/bash
set -e

mkdir bin
javac src/EasyCryptoConsole/*.java -classpath "../EasyCryptoLib.jar:." -d bin

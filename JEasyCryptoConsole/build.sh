#!/bin/bash
set -e

javac src/EasyCryptoConsole/*.java -classpath "../EasyCryptoLib.jar:." -d bin

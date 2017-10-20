#!/bin/bash
set -e

if [ ! -d "./JEasyCrypto/bin/easycrypto/" ]; then mkdir -p JEasyCrypto/bin/easycrypto/ ; fi
if [ ! -d "./JEasyCryptoClient/bin/" ]; then mkdir -p JEasyCryptoClient/bin/ ; fi
if [ ! -d "./JEasyCryptoConsole/bin/EasyCryptoConsole/" ]; then mkdir -p JEasyCryptoConsole/bin/EasyCryptoConsole/ ; fi
if [ ! -d "./JEasyCryptoServer/bin/" ]; then mkdir -p JEasyCryptoServer/bin/ ; fi

sh clear.sh
echo ""
echo ""

echo "Building JEasyCrypto lib"
cd ./JEasyCrypto
sh build.sh
cd ..
echo ""
echo ""

echo "Building JEasyCryptoClient"
cd ./JEasyCryptoClient
sh build.sh
cd ..
echo ""
echo ""

echo "Building JEasyCryptoConsole"
cd ./JEasyCryptoConsole
sh build.sh
cd ..
echo ""
echo ""

echo "Building JEasyCryptoServer"
cd ./JEasyCryptoServer
sh build.sh
echo ""
echo ""

echo "Build done"

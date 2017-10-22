#!/bin/bash
set -e

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
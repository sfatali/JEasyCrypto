#!/bin/bash
set -e

echo "Removing previous build files"

rm -rf -- JEasyCrypto/bin
echo "JEasyCrypto lib clean"

rm -rf -- JEasyCryptoClient/bin
echo "JEasyCryptoClient clean"

rm -rf -- JEasyCryptoConsole/bin
echo "JEasyCryptoConsole clean"

rm -rf -- JEasyCryptoServer/bin
echo "JEasyCryptoServer clean"
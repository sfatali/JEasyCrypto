#!/bin/bash
set -e

echo "Removing previous build files"

rm -f -- JEasyCrypto/bin/easycrypto/*
echo "JEasyCrypto lib clean"

rm -f -- JEasyCryptoClient/bin/*
echo "JEasyCryptoClient clean"

rm -f -- JEasyCryptoConsole/bin/EasyCryptoConsole/*
echo "JEasyCryptoConsole clean"

rm -f -- JEasyCryptoServer/bin/*
echo "JEasyCryptoServer clean"

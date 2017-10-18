start /B /WAIT clear.cmd
echo ""
echo ""

echo "Building JEasyCrypto lib"
cd JEasyCrypto
start /B /WAIT build.cmd
cd ..
echo ""
echo ""

echo "Building JEasyCryptoClient"
cd .\JEasyCryptoClient
start /B /WAIT build.cmd
cd ..
echo ""
echo ""

echo "Building JEasyCryptoConsole"
cd .\JEasyCryptoConsole
start /B /WAIT build.cmd
cd ..
echo ""
echo ""

echo "Building JEasyCryptoServer"
cd .\JEasyCryptoServer
start /B /WAIT build.cmd
cd ..
echo ""
echo ""

echo "Build done"

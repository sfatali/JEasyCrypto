mkdir bin
dir *.java /b/s > sources.txt
javac @sources.txt -classpath "..\json-simple-1.1.1.jar;." -d bin
del sources.txt
xcopy /y src\views bin\views
exit
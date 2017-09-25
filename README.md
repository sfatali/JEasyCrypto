# README #

JEasyCrypto is a library and a collection of related applications enabling encryption and decryption of text using different methdods

### What is this repository for? ###

* Repository includes four components: 
 * JEasyCryptoLib which implements several crypto methods and is extensible with new methods.
 * JEasyCryptoConsole, a console app which enables using the cryptographic methods of the Lib
 * JEasyCryptoServer, which provides a way to use the Lib from internet, using UDP and JSON.
 * JEasyCryptoClient, which uses the Server over network for en-/decryption of text.

You can also run the Client and Server on the same machine. When launching the client, give "localhost" as the server address in this case.

### How do I get set up? ###

* Clone the project from bitbucket or use the code you have gotten by other means.
* Dependencies
 * Uses https://code.google.com/archive/p/json-simple/ on Server and Client to create/parse JSON.
 * Download the json-simple-1.1.1.jar to project root directory before building and running the Client or Server.
* Build the lib using build.sh, which exports it as a .jar file into the project root directory. 
* Then build the server and client, using build.sh files. 
* Use Client and Server for cryption. Use the provided start.sh files to start the client and server. 
 * Run Server in one console window, and the Client in another.
* For testing the Lib without network, you can use the Console without the overhead of networking between the Client and Server.


### Contribution guidelines ###

* TBD

### Who do I talk to? ###

* Antti Juustila
* OSSD 2017 team

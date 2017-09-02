# README #

JEasyCrypto is a library and a collection of related applications enabling encryption and decryption of text using different methdods

### What is this repository for? ###

* Repository includes four components: 
 * JEasyCryptoLib which implements several crypto methods and is extensible with new methods.
 * JEasyCryptoConsole, a console app which enables using the cryptographic methods of the Lib
 * JEasyCryptoServer, which provides a way to use the Lib from internet, using UDP and JSON.
 * JEasyCryptoClient, which uses the Server for en-/decryption of text.
* 0.9

### How do I get set up? ###

* Clone the project from bitbucket
* Build the lib, export it as a .jar file into the project root directory. Then build the server and client. Use Client and Server for cryption. Use the provided start.sh files to start the client and server from the bin directories. For testing purposes for the Lib, you can use the Console without the overhead of networking between the Client and Server.
* Dependencies
 * Uses https://code.google.com/archive/p/json-simple/ on Server and Client to create/parse JSON.


### Contribution guidelines ###

* TBD

### Who do I talk to? ###

* Antti Juustila
* OSSD 2017 team
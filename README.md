# JEasyCrypto

[![Build Status](https://travis-ci.org/a-rmz/JEasyCrypto.svg?branch=feat%2Fbuild)](https://travis-ci.org/a-rmz/JEasyCrypto)
[![PRs Welcome](https://img.shields.io/badge/PRs-welcome-brightgreen.svg?style=flat-square)](http://makeapullrequest.com)
[![first-timers-only](http://img.shields.io/badge/first--timers--only-friendly-blue.svg?style=flat-square)](http://www.firsttimersonly.com/)
[![Slack!](https://slackin-frcifywvtd.now.sh/badge.svg)](https://slackin-frcifywvtd.now.sh/)

JEasyCrypto is a library and a collection of related applications enabling encryption and decryption of text using different methdods

![encryption everywhere](https://h50003.www5.hpe.com/digmedialib/prodimg/lowres/c04165573.png)


## What can I find here?

* Repository includes four components: 
 * [JEasyCryptoLib](https://github.com/a-rmz/JEasyCrypto/tree/master/JEasyCrypto): implements several crypto methods and is extensible with new methods.
 * [JEasyCryptoConsole](https://github.com/a-rmz/JEasyCrypto/tree/master/JEasyCryptoConsole): a console app which enables using the cryptographic methods of the Lib.
 * [JEasyCryptoServer](https://github.com/a-rmz/JEasyCrypto/tree/master/JEasyCryptoServer): provides a way to use the Lib from internet, using UDP and JSON.
 * [JEasyCryptoClient](https://github.com/a-rmz/JEasyCrypto/tree/master/JEasyCryptoClient): uses the Server over network for en-/decryption of text.

You can also run the Client and Server on the same machine. When launching the client, give `localhost` as the server address in this case.


## Getting started

* Clone the project from GitHub or use the code you have gotten by other means.

### Setting up
* Build the lib using build.sh, which exports it as a .jar file into the project root directory. 
* Build the server and client, using build.sh files.

### Usage
* Use Client and Server for cryption. Use the provided start.sh files to start the client and server. 
 * Run `Server` in one console window, and the `Client` in another.
* For testing the Lib without network, you can use the Console without the overhead of networking between the Client and Server.

### Dependencies
- [JSON Simple](https://code.google.com/archive/p/json-simple/) - Server and Client to create/parse JSON.


## Contributing

If you're interested in contributing, you're awesome! Isn't OSS great? Please read the [contribution guide](./CONTRIBUTING.md) for details on the process for submitting pull requests, it's not as hard as it sounds. :wink:

This project follows the convention of [GitFlow](http://nvie.com/posts/a-successful-git-branching-model/), a branching model for product development, so all the Pull requests must use this model to be taken in consideration.

### Style guide
The project code follows the [Google Java Style Guide](google.github.io/styleguide/javaguide.html). All the submited Pull requests have to follow this convention.

### Roadmap
The management is done through a [project](https://github.com/a-rmz/JEasyCrypto/projects/2). There is the list of features and bugs on which we are working for the next release. The roadmap follows a Kanban-like methodology (backlog, development, revision, done). When you start working on an issue or feature, make sure you move the corresponding card on the project for the convenience of all the team.

You can also check the [features and issues](https://github.com/a-rmz/JEasyCrypto/issues) alone on the main board.


## In case of panic: Who you gonna call?

[Join](https://slackin-frcifywvtd.now.sh/) our Slack community!

* [Antti Juustila](mailto:antti.juustila@oulu.fi)
* OSSD 2017 team
* Ghostbusters :ghost:

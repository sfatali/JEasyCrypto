# JEasyCrypto

[![PRs Welcome](https://img.shields.io/badge/PRs-welcome-brightgreen.svg?style=flat-square)](http://makeapullrequest.com)
[![first-timers-only](http://img.shields.io/badge/first--timers--only-friendly-blue.svg?style=flat-square)](http://www.firsttimersonly.com/)
<script async defer src="https://slackin-frcifywvtd.now.sh/slackin.js?"></script>


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

If you're interested in contributing, you're awesome! Isn't OSS great? Please read the [contribution guide](#contrib-guide) for details on the process for submitting pull requests, it's not as hard as it sounds. :wink:

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


<a name="contrib-guide"></a>
# Contribution guide

Thanks for taking the time to reach this far! It's great to see that you're as interested in this project as I am. 😄 Here you'll find everything you need to know to contribute to this project. This project is made by people for people, so, by following this guidelines, you help your peer developers help you developing the new features you have in mind or fixing the bugs or issues you find. Of course, all the help is appreciated, from code to docs, even by recommending this project you're helping!

Also, this project is ruled by [Contributor Convenant](http://contributor-covenant.org)'s [code of conduct](./CODE_OF_CONDUCT.md).

# Your First Contribution

Would you like to contribute but you're just not sure where to start? Check out the [open issues](https://github.com/a-rmz/JEasyCrypto/issues)

> Working on your first Pull Request? You can learn how from this *free* series, [How to Contribute to an Open Source Project on GitHub](https://egghead.io/series/how-to-contribute-to-an-open-source-project-on-github).

If through the whole process of contributing you have any doubt, do not hesitate to contact [me](https://github.com/a-rmz) or any of the contributors: We're all here to learn and help! 🤓

# Getting started
## Code Contributions

Now, the fun part! (Based on [Node JS](github.com/nodejs/node/blob/master/CONTRIBUTING.md) contribution guide)

### Step 1: Fork

Fork the project [on GitHub](https://github.com/a-rmz/sbotify) and clone your fork in your local.

```text
$ git clone git@github.com:username/JEasyCrypto.git
$ cd sbotify
$ git remote add upstream https://github.com/a-rmz/JEasyCrypto.git
```

#### Which branch?

The `master` branch holds the latest release code, so for development and bug fixing, `develop` is your way to go.

### Step 2: Branch

Create a branch and start hacking:

```text
$ git checkout -b my-branch -t origin/develop
```
### Step 3: Commit

Make sure git knows your name and email address:

```text
$ git config --global user.name "J. Random User"
$ git config --global user.email "j.random.user@example.com"
```

Add and commit:

```text
$ git add my/changed/files
$ git commit
```

### Commit message guidelines

To avoid this:
![commits-xkcd](https://camo.githubusercontent.com/1c4989b1a9729535c11498bb990b6c4622ebfb8b/68747470733a2f2f696d67732e786b63642e636f6d2f636f6d6963732f6769745f636f6d6d69742e706e67)

The commit message should describe what changed and why. Write your commit message in the imperative: "Fix bug" and not "Fixed bug"
or "Fixes bug."  This convention matches up with commit messages generated by commands like git merge and git revert.

1. The first line should:
   - start with a capital letter
   - contain a short description of the change
   - be 50 characters or less
   - be entirely in lowercase with the exception of proper nouns, acronyms, and
   the words that refer to code, like function/variable names

2. Keep the second line blank.
3. Wrap all other lines at 72 columns.

4. If your patch fixes an open issue, you can add a reference to it at the end
of the log. Use the `Fixes:` prefix and the full issue URL. For other references
use `Refs:`.

   Examples:
   - `Fixes: https://github.com/nodejs/node/issues/1337`
   - `Refs: http://eslint.org/docs/rules/space-in-parens.html`
   - `Refs: https://github.com/nodejs/node/pull/3615`

Sample complete commit message:

```txt
explain the commit in one line

More detailed explanatory text, if necessary.  Wrap it to about 72
characters or so.  In some contexts, the first line is treated as the
subject of an email and the rest of the text as the body.  The blank
line separating the summary from the body is critical (unless you omit
the body entirely); tools like rebase can get confused if you run the
two together.

Further paragraphs come after blank lines.

- Bullet points are okay, too

- Typically a hyphen or asterisk is used for the bullet, followed by a
  single space, with blank lines in between, but conventions vary here

- Use a hanging indent

Fixes: https://github.com/nodejs/node/issues/1337
Refs: http://eslint.org/docs/rules/space-in-parens.html
```

### Step 4: Rebase

Use `git rebase` (not `git merge`) to synchronize your work with
the main repository.

```text
$ git fetch upstream
$ git rebase upstream/develop
```

### Step 5: Push

```text
$ git push origin my-branch
```

### Step 6: Discuss and update

You will probably get feedback or requests for changes to your Pull Request.
This is a big part of the submission process so don't be discouraged!

To make changes to an existing Pull Request, make the changes to your branch.
When you push that branch to your fork, GitHub will automatically update the
Pull Request.

You can push more commits to your branch:

```text
$ git add my/changed/files
$ git commit
$ git push origin my-branch
```

Or you can rebase against develop:

```text
$ git fetch --all
$ git rebase origin/develop
$ git push --force-with-lease origin my-branch
```

Or you can amend the last commit (for example if you want to change the commit
log).

```text
$ git add any/changed/files
$ git commit --amend
$ git push --force-with-lease origin my-branch
```

Feel free to post a comment in the Pull Request to ping reviewers if you are
awaiting an answer on something. If you encounter words or acronyms that
seem weird, check this
[glossary](https://sites.google.com/a/chromium.org/dev/glossary).

### Step 7: Landing

In order to land, a Pull Request needs to be reviewed and
[approved](#getting-approvals-for-your-pull-request) by
at least one Collaborator.
After that, as long as there are no objections
from a Collaborator, the Pull Request can be merged.

## Additional Notes
### Getting Approvals for Your Pull Request

A Pull Request is approved either by saying LGTM, which stands for
"Looks Good To Me", or by using GitHub's Approve button.
GitHub's Pull Request review feature can be used during the process.
For more information, check out
[the video tutorial](https://www.youtube.com/watch?v=HW0RPaJqm4g)
or [the official documentation](https://help.github.com/articles/reviewing-changes-in-pull-requests/).

After you push new changes to your branch, you need to get
approval for these new changes again, even if GitHub shows "Approved"
because the reviewers have hit the buttons before.


# How to report a bug
If you find a security vulnerability, do NOT open an issue.
Email [me](mailto:armzprz@gmail.com) instead.

If you want to report a bug or issue, go to the
[new issue](https://github.com/a-rmz/JEasyCrypto/issues/new) section and fill the template.
Also, add the tag `bug`.

# How to suggest a feature or enhancement
If you'd like a feature to be added, fill an issue describing what would you like
the new feature to do and tag it as `feature-suggestion`. Be as descriptive as possible!
A best description will make it clearer for other people to understand what you want
and help you achieve it. 😉

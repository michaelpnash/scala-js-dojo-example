An example project using scala-js-dojo

This project is designed to showcase the types and components [defined in scala-js-dojo](http://github.com/michaelpnash/scala-js-dojo).

You will need the referenced version of scala-js-dojo published on your local system (working on getting it in the standard repository).

On OSX you can start a simple web server with the server.sh script found in the root directory, or put the generated files under the document root of your webserver (you can't open the files directory from a browser, they must be server).

Start sbt and do a "packageJS" to compile the Scala to JavaScript.

Then go to index-dev.html (for the non-optimized version) to see the examples.


# PSE UML Design

This repository provides an exemplary set of tools for the PSE design phase.

It assumes you run Ubuntu and are fine with editing Makefiles etc.
It also requires graphviz and javadoc.
For javadoc, you might have to set your $JAVAHOME environment variable,
it points to your JDK installation.
In my case (Ubuntu 14.04 LTS), this means `/usr/lib/jvm/default-java`.

## The Lambda Example

The file `Lambda.java` contains our design.
In theory, it is possible to use multiple files,
but we have not figured out how to do that reliably.

You can `make Lambda.png` to generate a UML class diagram of the whole model.

You can `make docs.tex` to generate a tex file with your JavaDoc documentation.

You can `make observe.png` to generate an example UML sequence diagram.

## On Tooling

The major requirement to end up with this choice of tooling
is integration with version control.
This throws all WYSIWYG tools out of the window, as far as I know.

PlantUML is nice for sequence diagrams.

PlantUML could also do the class diagrams,
however UmlGraph can work with actual java code,
so we also get JavaDoc and code stubs for imlementation.

Major downside: They all use graphviz dot for layouting. It sucks.

## Licence

Makefile, Lambda.java and observe.plant are under MIT licence (see below).
Do whatever you want with it.
The included parts [UMLGraph](http://www.umlgraph.org/)
and [PlantUML](http://plantuml.sourceforge.net/)
have their own licences.
See their websites.

## The MIT License (MIT)

Copyright (c) 2015 Andreas Zwinkau

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.

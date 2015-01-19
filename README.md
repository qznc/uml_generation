# PSE UML Design

This repository provides an exemplary set of tools for the PSE design phase.

It assumes you run Ubuntu and are fine with editing Makefiles etc.
It also requires graphviz and javadoc.

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

default:
	@echo "Read the Makefile, dosser!"

Lambda.png: Lambda.java
	./umlgraph Lambda png

.PHONY: show docs

show: Lambda.png
	xdg-open $<

docs/index.html: Lambda.java
	mkdir -p docs
	javadoc -d docs -private Lambda.java

docs.tex: Lambda.java lib/texdoclet-0.9.3.jar
	javadoc -docletpath lib/texdoclet-0.9.3.jar -doclet org.wonderly.doclets.TexDoclet -private Lambda.java

observe.png: observe.pic Makefile
	pic2plot -Tpng --bitmap-size 1000x1000 $< >$@

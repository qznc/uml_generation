default:
	@echo "Read the Makefile, dosser!"

Lambda.png: Lambda.java
	umlgraph_installation/umlgraph Lambda png

.PHONY: show docs

show: Lambda.png
	xdg-open $<

docs/index.html: Lambda.java
	mkdir -p docs
	javadoc -d docs -private Lambda.java

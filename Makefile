default:

Lambda.png: Lambda.java
	UMLGraph/umlgraph Lambda png

.PHONY: show

show: Lambda.png
	xdg-open $<

default:

Lambda.png: Lambda.java
	umlgraph_installation/umlgraph Lambda png

.PHONY: show

show: Lambda.png
	xdg-open $<

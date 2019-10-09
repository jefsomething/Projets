#! /bin/bash

if [ $(id -u) != 0 ]
	then echo "the Maze isn't meant for you, $USER"
	exit
fi

uname -a
w
cat whatthen.pdf |base64 -d



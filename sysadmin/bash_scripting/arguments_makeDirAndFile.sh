#! /bin/sh

if [ $# != 3 ]
	then
	echo "usage: ./$0 dir file content"
	exit
fi

mkdir $1
touch $1/$2
echo "$3" > $1/$2

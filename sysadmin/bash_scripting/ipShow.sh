#! /bin/bash

if [ $# != 1 ]
 then
  echo "usage: $0 <iface>" 
  exit 1
fi

ip a show $1 | grep inet | awk '{ print $2; }'

#!/bin/bash
#usage vm.up <VM>

if [[ $(VBoxManage list runningvms | grep $1) ]]
  then
 	echo "... VM is up ..."
  	echo "... will now attempt to halt VM $1"
	VBoxManage controlvm $1 poweroff && exit 0
else
  echo "No such VM running" && exit 1
fi


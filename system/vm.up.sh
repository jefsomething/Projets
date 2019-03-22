#!/bin/bash
#usage vm.up <VM>

if [[ $(VBoxManage list runningvms | grep $1) ]]
  then
  echo "VM is already running."
  exit 1
fi

for i in $(VBoxManage list vms)
do
  #echo "$i" |grep -v { |sed 's|"||g'
  VM=$(echo "$i" |grep -v { |sed 's|"||g' )


if [[ $1 = $VM ]]
 then

 if [[ $(echo $1 |grep "_" ) ]]
 then
   #echo $1 |grep _
   echo '... will now attempt to boot $1'
   echo "... cd $1 && vagrant up && vagrant ssh"
   vag=$(echo "$1" |sed 's|_||' )
   cd /home/aj/VirtualBox\ VMs/$vag && vagrant up && vagrant ssh
   exit 0

 elif [[ $(echo "$1" |grep -v [_] ) ]]
 then

   echo 'run headless (h) or with gui (enter)'
   read ANSW

   if [[ "$ANSW" = "h" ]]
   then 
     echo "... will now attempt to boot $1 headless"
     echo "... VBoxManage startvm $1 --type headless"
     VBoxManage startvm $1 --type headless
     exit 0

   else
     echo "... will now attempt to boot $1" 
     echo "... VBoxManage startvm $1"
     VBoxManage startvm $1
     exit 0
   fi
 
 fi

fi

done
 
echo 'no such VM'
exit 1


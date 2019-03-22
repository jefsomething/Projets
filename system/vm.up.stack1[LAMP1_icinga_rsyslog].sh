#!/bin/bash

#which VMs to start:
N1=LAMP1_
N2=icinga_
N3=rsyslog_

#start VMs one at a time easier on memory resource on)
for i in $N1 $N2 $N3; do VBoxManage startvm "$i" --type headless; sleep 5; done

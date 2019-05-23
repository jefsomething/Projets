#! /usr/bin/env python2

import subprocess
import optparse


parser = optparse.OptionParser()
#parser.add.option(help="list VMs")

def vm_list():
	subprocess.call(["VBoxManage", "list", "vms"])

vm_list()



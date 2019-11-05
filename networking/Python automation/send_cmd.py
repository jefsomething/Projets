#!/usr/bin/env python

import yaml
from netmiko import Netmiko
from getpass import getpass


def read_yml(file):
    with open(file) as _:
        return yaml.safe_load(_)


def get_credential(s):
    return read_yml(credentials)[s]


credentials = "../yml/credentials.yml"
res = read_yml(credentials)

ip = "192.168.122.2"
login = Netmiko(
    ip,
    device_type=get_credential("device_type"),
    username=get_credential("username"),
    password=get_credential("password"),
)


def run(cmd):
    print(login.find_prompt())
    output = login.send_command(cmd)
    print(output)


def send_conf(cmd):
    print(login.find_prompt())
    output = login.send_config_set(cmd)
    print(output)


# login
print(login.find_prompt())


def debug(s):
    print("[debug] " + s)
    send_conf(s)


def config_device():
    d = str(input("Device :\t"))
    commands_file = "../templates/" + d + "_commands.txt"
    with open(commands_file, "r") as f:
        my_command = f.read()
        send_conf(my_command)


#config_device()
run("sh run")

# logout
login.disconnect()

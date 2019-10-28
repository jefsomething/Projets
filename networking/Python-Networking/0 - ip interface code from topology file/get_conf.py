#! /usr/bin/env python

import yaml
from jinja2 import Environment, FileSystemLoader


def read_yml(file):
    with open(file) as _:
        return yaml.safe_load(_)


def get_devices():
    available_dev_list = []
    for d in devices:
        for k, v in d.items():
            available_dev_list.append(k)
    return available_dev_list


def ask_for_config():
    print("\nTo create a template config, enter a device:")
    available_dev_list = get_devices()
    for d in available_dev_list:
        print(d)
    print("\nYour choice:")
    try:
        device = input()
        while device not in available_dev_list:
            print("[error] Not a device.\nEnter a valid one:\n")
            device = input()
    except:
        print("[error] not a valid value.\n")

    interface_list = get_interface_list_of_device(device)
    gen(device)
    get_data_of_device(device)


def get_data_of_device(device):
    for d in devices:
        for k, v in d.items():
            if device in k:
                return v


def get_ip(device, interface):
    for d in devices:
        for k, v in d.items():
            if k == device :
                for subK, subV in v.items():
                    if subK == interface:
                        return subV


def get_interface_list_of_device(device):
    interface_list = []
    for d in devices:
        for k, v in d.items():
            if k == device:
                for subK in v.keys():
                    interface_list.append(subK)
    return interface_list


def gen(d):
    env = Environment(loader=FileSystemLoader('../jinja/'))
    template = env.get_template('set_router_ip_interfaces.j2')
    interface_list = get_interface_list_of_device(d)
    print(interface_list)
    print("\n")
    for i in interface_list:
        res = template.render(interface=i, ip=get_ip(d, i))
        print(res)
        print("!")


#
yml_dir = '../yml/'
yml_file = yml_dir + "devices.yml"
print("Using file "+ yml_file)
devices = read_yml(yml_file)
print("[] debug, show config file:\n{}".format(devices))

step1 = get_devices()
step2 = ask_for_config()

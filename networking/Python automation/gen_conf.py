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
    get_devices()
    for d in get_devices():
        print(d)

    device = input("\nYour choice:\n")
    while device not in get_devices():
        print("[error] Not a device.\nEnter a valid one:\n")
        device = input()

    get_interface_list_from(device)
    gen(device)
    get_data_of(device)


def get_data_of(device):
    for d in devices:
        for k, v in d.items():
            if device in k:
                return v


def get_interface_list_from(device):
    interface_list = []
    for d in devices:
        for k, v in d.items():
            if k == device:
                for subK in v.keys():
                    interface_list.append(subK)
    return interface_list


def get_ip(device, interface):
    for d in devices:
        for k, v in d.items():
            if k == device :
                for subK, subV in v.items():
                    if subK == interface:
                        return subV


def gen(d):
    env = Environment(loader=FileSystemLoader('../jinja/'))
    template = env.get_template('set_router_ip_interfaces.j2')
    print(get_interface_list_from(d))
    print("\n")
    for i in get_interface_list_from(d):
        res = template.render(interface=i, ip=get_ip(d, i))
        print(res)
        print("!")

    print("\nIs that config ok? (y/n)")
    answer = input()
    if answer == "y":
        commands_file = "../templates/" + d + "_commands.txt"
        with open(commands_file, "w") as f:
            for i in get_interface_list_from(d):
                f.write(str(template.render(interface=i, ip=get_ip(d, i))))
                f.write("\n!\n")
        print("Config saved in {}".format(commands_file))


#
yml_dir = '../yml/'
yml_file = yml_dir + "devices.yml"
print("Using file "+ yml_file)
devices = read_yml(yml_file)
print("[] debug, show config file:\n{}".format(devices))

step1 = get_devices()
step2 = ask_for_config()

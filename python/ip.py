#! /usr/bin/env python3

#n='192.168.56.1'
n=input('[ip:]')
ip=n.split('.')[0:4]
print('[hex]',hex(int(ip[0])),'\t',hex(int(ip[1])),'\t',hex(int(ip[2])),'\t',hex(int(ip[3])))
print('[bin]',bin(int(ip[0])),' ',bin(int(ip[1])),' ',bin(int(ip[2])),' ',bin(int(ip[3])))


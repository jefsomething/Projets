############################################################
	Contact me if at jstutz@protonmail.com
	if you have improvement to suggests!
############################################################

# Purpose of this lab: 

Provide/update netw devices ip addressing on the fly using 
simple config files, and python. The only requirement
being an ssh connection to the networking device in
order to send those configs.

# Requirements :

Devices IPs' are are listed as list of dictionaries
in yml/devices.yml. 
Also, a Jinja template file is placed in jinja/<myfile>.j2, 
( here set_touter_ip_interfaces.j2 ).

# How to:
 
Python code parses devices.yml, expect a device 
to provide a config from and prints config.
Since yml and j2 files have a relative path, code 
should be run in the same dir as python code file.


# Next step:

Send conf to devices using netmiko or python 
subprocess calls.

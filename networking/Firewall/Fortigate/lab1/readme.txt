######################################################################################
				Fortigate lab1
######################################################################################
# this lab uses a Fortigate 6.2 KVM reformatted from RAW qcow2 to vdi for Virtualbox


The Fortigate firewall uses 2 network interfaces, port1 and port2
	port2 is lan, a host-only iface, static ip 192.168.56.2/24 
	port1 is wan using a NAT iface, static ip 10.0.2.99/24. Gateway is 10.0.2.2
	first CLI configuration is provided on screenshot #0

lan network uses nodes on isolated host-only network
	netw :	192.168.56.0/24 
	gateway:192.168.56.2 (fortigate port2)

static route 0.0.0.0 0.0.0.0 from lan (ingoing) to wan (outgoing)

All trafic is monitored using 'all session' config value

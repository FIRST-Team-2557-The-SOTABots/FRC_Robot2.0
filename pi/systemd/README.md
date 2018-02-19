# Example systemd service

The permissions on the unit file (service file) needs to be 644.

$ sudo chmod 644 /lib/systemd/system/generic.service



The unit file nmust be added to systemd.

$ sudo systemctl daemon-reload

$ sudo systemctl enable generic.service



More info and other ways to start a process or service can be found at

https://www.dexterindustries.com/howto/run-a-program-on-your-raspberry-pi-at-startup/


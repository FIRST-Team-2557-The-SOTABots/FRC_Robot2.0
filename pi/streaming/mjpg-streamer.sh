#!/bin/bash
# Above is the shebang. The required line to tell what to translate the
# script in

# A variable to hold one command. Adding more than one command causes the
# test below to fail.
#COMMAND="/bin/ls"
COMMAND="/opt/mjpg-streamer/mjpg-streamer-experimental/mjpg_streamer"

# Check to see if the command is empty or not executable.
if [ -z "${COMMAND}" ]; then
    echo "Command empty." 1>&2
    exit -1
fi

# Add arguments to the command here.
#COMMAND="${COMMAND} -la"

# If X11 is needed set the display variable.
#DISPLAY=

export LD_LIBRARY_PATH="/opt/mjpg-streamer/mjpg-streamer-experimental/"

echo ${COMMAND} -i "input_uvc.so -d /dev/video1 -r 640x480 -f 20" -o "output_http.so -w ./www"

# Execute the command.
exec ${COMMAND} -i "input_uvc.so -d /dev/video1 -r 640x480 -f 20" -o "output_http.so -w ./www" >/dev/null

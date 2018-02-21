#!/bin/bash
# Above is the shebang. The required line to tell what to translate the
# script in

# A variable to hold a command.
COMMAND=

# Check to see if the command is empty or not executable.
if [ -z ${COMMAND} ] || [! -e ${COMMAND} ]; then
    echo "Command empty or not executable." 1>&2
    exit -1
fi

# Execute the command.
exec ${COMMAND}

######################################
#
#    RoboPeak USB LCD Display Linux Driver
#    
#    Copyright (C) 2009 - 2013 RoboPeak Team
#    This file is licensed under the GPL. See LICENSE in the package.
#
#    http://www.robopeak.net
#
#    Author Shikai Chen
#
# Modified by Wallace to enable Robopeak in Yocto (Poky) for 
# Intel Galileo (based on kernel v3.8)
######################################
DRIVER_NAME := rp_usbdisplay

ccflags-y := -I$(src)/src -I$(src)/common -Wformat

obj-$(CONFIG_FB_RPUSBDISP) := $(DRIVER_NAME).o

DRIVER_FILES := src/main.o \
                src/usbhandlers.o \
		src/fbhandlers.o \
		src/touchhandlers.o

$(DRIVER_NAME)-objs:= $(DRIVER_FILES)

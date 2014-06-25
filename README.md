rpusbdisp 
=========

This is a fork from robopeak/rpusbdisp to enable Robopeak USB display on Intel(r) Galileo.

Please refer to README_robopeak.md for more information.

Follow the instruction below to install Robopeak driver on [Yocto BSP](https://downloadcenter.intel.com/Detail_Desc.aspx?DwnldID=23171) for Intel(r) Galileo:

1. Create a temporary folder in your working directory (i.e *~/workdir/temp*) with the following directory structure:
```log
|---/linux
|   |---/drivers
|       |---/video
|           |---/robopek
|               |---/common
|                   |---/inc
|                       |---+protocol.h
|               |---/src
|                   |---/inc
|                       |---+common.h
|                       |---+devconf.h
|                       |---+drvconf.h
|                       |---+fbhandlers.h
|                       |---+touchhandlers.h
|                       |---+types.h
|                       |---+usbhandlers.h
|                    |---+fbhandlers.c
|                    |---+main.c
|                    |---+touchhandlers.c
|                    |---+usbhandlers.c
|               |---/xserver_conf
|                   |---+10-disp.conf
|                   |---+README
|               |---+Kconfig
|               |---+LICENSE
|               |---+Makefile
|               |---+NewMakefile
|               |---+run.sh
|               |---+stop.sh
```

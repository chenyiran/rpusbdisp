rpusbdisp 
=========

This is a fork from robopeak/rpusbdisp to enable Robopeak USB display on Intel(r) Galileo.

Please refer to README_robopeak.md for more information.

Follow the instruction below to install Robopeak driver on [Yocto BSP](https://downloadcenter.intel.com/Detail_Desc.aspx?DwnldID=23171) for Intel(r) Galileo. You will need a host machine to build the BSP.

1. Create a temporary folder in your working directory (i.e *~/workdir/temp*). You will need to copy & rearrange the files under *drivers/* such that it map to the following directory structure:
```log
|---/linux
|   |---/drivers
|       |---/video
|           |---/robopeak (*note: copy all files & directories under rpusbdisp/drivers/linux-driver into this directory*)
|               |---/common (*note: copy all files & directories under rpusbdisp/drivers/common into this directory*)
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

2. Overwrite the *Makefile* in your working directory with the one in the *rpusbdisp/yocto* folder.

3. Compress all files & directories in your working directory into tar.bz2 format.

4. Download and edit the linux-yocto-clanton_3.8.bb with your favorite text editor. Modify the following line with the filename you gave in step 3.

```code
SRC_URI += "file://rpusbdispsrc.tar.bz2"
```

5. Download [Board_Support_Package_Sources_for_Intel_Quark_v1.0.0.7z](https://downloadcenter.intel.com/Detail_Desc.aspx?DwnldID=23171) from Intel Download Center.

6. Decompress the package, and navigate to */meta-clanton_vX.Y.Z/meta-clanton-bsp/recipes-kernel/linux* and overwrite the linux-yocto-clanton_3.8.bb with the one in step 4.

7. Copy all files in *rpusbdisp/yocto/files* into *BSP folder/meta-clanton_vX.Y.Z/meta-clanton-bsp/recipes-kernel/linux/files*

8. Once that is done, you are ready to enable Robopeak driver using kernel menuconfig. You can do that by issuing the following command  in the yocto build environment:
```code 
~$ bitbake linux-yocto-clanton -c menuconfig
```

9. In menuconfig, install Device Drivers->Graphics Support->Support for framebuffer devices->Displaylink USB framebuffer support as an external module. 

10. Build your kernel and all kernel modules using the command below.
```code
~$ bitbake linux-yocto-clanton -c build
```

11. Follow the BSP guide on steps to build the rootfs and boot your Intel(r) Galileo.

12. RP_USBDISPLAY driver is not loaded by default. You need load the driver manually by entering the following command on your Intel Galileo target.
```code 
modprobe rp_usbdisplay
```

#!/bin/bash
ndk-build

if [ "$?" = "0" ]
then
	ant debug
	adb install -r bin/GoomandroidActivity-debug.apk
fi

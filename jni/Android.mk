LOCAL_PATH:= $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE    := libgoom2k4jni
LOCAL_CFLAGS    := -Werror
LEX := -o goom/goomsl_lex.c goom/goomsl_lex.l
YACC := -y -o goom/goomsl_yacc.c goom/goomsl_yacc.y
LOCAL_SRC_FILES := goom/goomsl_yacc.c goom/goomsl_lex.c goom/goomsl.c \
        goom/goomsl_hash.c goom/goomsl_heap.c goom/goom_tools.c \
        goom/config_param.c \
        goom/convolve_fx.c goom/filters.c goom/flying_stars_fx.c goom/gfontlib.c \
        goom/gfontrle.c goom/goom_core.c goom/graphic.c goom/ifs.c goom/lines.c goom/mathtools.c \
        goom/sound_tester.c goom/surf3d.c goom/tentacle3d.c goom/plugin_info.c goom/v3d.c \
        goom/drawmethods.c goom/cpu_info.c
LOCAL_EXPORT_C_INCLUDES  := $(LOCAL_PATH)/goom

LOCAL_LDLIBS    := -llog
#LOCAL_LDLIBS    := -llog -lGLESv2 


include $(BUILD_SHARED_LIBRARY)
package br.com.belocodigo.goomandroid;

public class Goom2k4 {
	
    static {
        System.loadLibrary("goom2k4jni");
    }
    
    public static native void init(int rex, int rexy);
    public static native int[] update();
    public static native void close();
    
}

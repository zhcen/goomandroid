package br.com.belocodigo.goomandroid;


import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;


public class HelloOpenGLES20Renderer implements GLSurfaceView.Renderer {

	public void onSurfaceCreated(GL10 unused, EGLConfig config) {
		Goom2k4.init(320, 240);
		GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
		
	}
	
	public void onDrawFrame(GL10 unused) {
		GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT | GLES20.GL_DEPTH_BUFFER_BIT);
		
		GLES20.glFrontFace(GLES20.GL_CCW);
		GLES20.glEnable(GLES20.GL_CULL_FACE);
		GLES20.glCullFace(GLES20.GL_BACK);
		
		
	}
	
	
	public void onSurfaceChanged(GL10 unused, int width, int heigth) {
		GLES20.glViewport(0, 0, width, heigth);
	}
}

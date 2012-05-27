package br.com.belocodigo.goomandroid;

import android.content.Context;
import android.opengl.GLSurfaceView;

public class HelloOpenGLES20SurfaceView extends GLSurfaceView {

	
	public HelloOpenGLES20SurfaceView(Context context) {
		super(context);
		
		setEGLContextClientVersion(2);
		setRenderer(new HelloOpenGLES20Renderer());
	}
	
}

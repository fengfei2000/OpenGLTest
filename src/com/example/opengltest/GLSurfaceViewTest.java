package com.example.opengltest;


import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

public class GLSurfaceViewTest extends Activity {
	GLSurfaceView glView;
	
	private static final String TAG = "GLSurfaceViewTest"; 

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//去掉activity的标题，全屏显示
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		glView = new GLSurfaceView(this);
		glView.setRenderer(new SimpleRenderer());
		setContentView(glView);
	}

	@Override
	public void onResume() {
		super.onPause();
		glView.onResume();
	}

	@Override
	public void onPause() {
		super.onPause();
		glView.onPause();
	}

	static class SimpleRenderer implements Renderer {

		@Override
		public void onSurfaceCreated(GL10 gl, EGLConfig config) {
			Log.d("GLSurfaceViewTest", "surface created");
		}
		@Override
		public void onSurfaceChanged(GL10 gl, int width, int height) {
			Log.d("GLSurfaceViewTest", "surface changed: " + width + "x"
					+ height);
		}
		@Override
		public void onDrawFrame(GL10 gl) {
			//设置颜色为红色（glClearColor(float red, float green, float blue, float alpha)
		    Log.v(TAG, "onDrawFrame");
			gl.glClearColor(0 , 1, 0, 0);
			gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		}
	}
}

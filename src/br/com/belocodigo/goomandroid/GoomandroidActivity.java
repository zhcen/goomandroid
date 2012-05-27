package br.com.belocodigo.goomandroid;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GoomandroidActivity extends Activity {

	MySurfaceView mySurfaceView;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mySurfaceView = new MySurfaceView(this);
		setContentView(mySurfaceView);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		mySurfaceView.onResumeMySurfaceView();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		mySurfaceView.onPauseMySurfaceView();
	}

	class MySurfaceView extends SurfaceView implements Runnable {
		Thread thread = null;
		SurfaceHolder surfaceHolder;
		volatile boolean running = false;

		private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

		public MySurfaceView(Context context) {
			super(context);
			// TODO Auto-generated constructor stub
			surfaceHolder = getHolder();
		}

		public void onResumeMySurfaceView() {
			running = true;
			thread = new Thread(this);
			thread.start();
		}

		public void onPauseMySurfaceView() {
			boolean retry = true;
			running = false;
			while (retry) {
				try {
					thread.join();
					retry = false;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			boolean init = false;
			int width = 320;
			int hegth = 240;
			while (running) {
				if (surfaceHolder.getSurface().isValid()) {
					Canvas canvas = surfaceHolder.lockCanvas();
					if (! init) {
						init = true;
						Goom2k4.init(width, hegth);
					}
					// ... actual drawing on canvas
					
				    Bitmap buffer = Bitmap.createBitmap(Goom2k4.update(), width, hegth, Bitmap.Config.RGB_565);
				    buffer = Bitmap.createScaledBitmap(buffer, 320, 240, true);
					canvas.drawBitmap(buffer, 0, 0, null);

					surfaceHolder.unlockCanvasAndPost(canvas);
				}
			}

			if (init) {
				Goom2k4.close();
			}
		}

	}
}

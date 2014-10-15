package nz.ac.waikato.cms.comp204.assignment2;

//import nz.ac.waikato.cms.comp204.assignment2.classes.drawOverWorld;
import nz.ac.waikato.cms.comp204.assignment2.classes.Player;
import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;

public class OverWorld extends Activity implements OnTouchListener {
	drawOverWorld ow;
	Bitmap mveLeft;
	Bitmap mveRight;
	Bitmap pause;
	Player playr;
	Button btnLeft;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_overworld);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		ow = new drawOverWorld(this);
		mveLeft = BitmapFactory.decodeResource(getResources(), R.drawable.ic_left);
		mveRight = BitmapFactory.decodeResource(getResources(), R.drawable.ic_right);
		pause = BitmapFactory.decodeResource(getResources(), R.drawable.ic_pause);
		playr = new Player(1, 1, 1);
		playr.playerB = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
		setContentView(ow);
	
		
		ow.setOnTouchListener(this);
		
	}
	@Override
	protected void onPause()
	{
		super.onPause();
		ow.pause();
	}
	@Override
	protected void onResume()
	{
		super.onResume();
		ow.resume();
	}
	public class drawOverWorld extends SurfaceView implements Runnable{

		Thread world = null;
		SurfaceHolder holder;
		boolean isOK = true;
		
		public drawOverWorld(Context context) {
			super(context);
			holder = getHolder();
		}
		@Override
		public void run() {
			while(isOK == true)
			{
				if(!holder.getSurface().isValid())
				{
					continue;
				}
				Display display = getWindowManager().getDefaultDisplay();
				Point size = new Point();
				display.getRealSize(size);
				int width = size.x;
				int height = size.y;
				
				Log.d("Test", "Width: " + String.valueOf(width));
				Log.d("Test", "Height: " + String.valueOf(height));
				
				int leftX = 10;
				int leftY = height - 10 - mveLeft.getHeight();
				int rightX = width - 10 - mveRight.getWidth();
				int rightY = height - 10 - mveRight.getHeight();
				
				Log.d("Test", "Left Y: " + String.valueOf(leftY));
				Log.d("Test", "Right X: " + String.valueOf(rightX));
				Log.d("Test", "Right Y: " + String.valueOf(rightY));
				
				Canvas c = holder.lockCanvas();
				c.drawARGB(255,0,0,10);
				c.drawBitmap(playr.playerB,playr.xLoc-(playr.playerB.getWidth()/2),playr.yLoc-(playr.playerB.getHeight()/2),null);
				
				c.drawBitmap(mveLeft, 200, 500, null);
				c.drawBitmap(mveRight, 300, 500, null);
				c.drawBitmap(pause, 1800,10,null);
				holder.unlockCanvasAndPost(c);
			}
		}
		public void pause()
		{
			isOK = false;
			while(true)
			{
				try
				{
					world.join();
				}
				catch(InterruptedException e)
				{
					e.printStackTrace();
				}
				break;
			}
			world = null;
		}
		public void resume()
		{
			isOK = true;
			world = new Thread(this);
			world.start();
		}
		
		
	}
	@Override
	public boolean onTouch(View v, MotionEvent me) {
		switch(me.getAction())
		{
			case MotionEvent.ACTION_MOVE:
			{
				if(me.getX() > 200 && me.getX() <= 272 && me.getY() > 500 && me.getY() < 572)
				{
					if(ow.isOK == true)
					{
						playr.Move(-10);
						return true;
					}
				}
				else if(me.getX() > 300 && me.getX() <= 372 && me.getY() > 500 && me.getY() < 572)
				{
					if(ow.isOK == true)
					{
						playr.Move(10);
						return true;
					}
				}
			}break;
			case MotionEvent.ACTION_DOWN:
			{
				if(me.getX() > 1800 && me.getX() <= 1905 && me.getY() > 10 && me.getY()< 61)
				{
					if(ow.isOK == false)
					{
						ow.resume();
					}
					else
					{
						ow.pause();
					}
				}
			}break;
		}
		
		return true;
	}
	
}

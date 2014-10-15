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
/**
 * 
 * @author Harry
 * The OverWorld created a instance of a drawOverWorld class which initiates a thread and draws all the 
 * Overworld and draws a player onto the screen for the user to control. It also draws the buttons required to move the
 * player and pause the game.
 *
 */
public class OverWorld extends Activity implements OnTouchListener {
	drawOverWorld ow;
	Bitmap mveLeft;
	Bitmap mveRight;
	Bitmap pause;
	Player playr;
	Button btnLeft;
	/**
	 * Initializes all the bitmaps which are to be drawn onto the screen and draws the overworld
	 */
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
	/**
	 * Calls the pause method in the drawOverWorld class and pauses the game.
	 */
	@Override
	protected void onPause()
	{
		super.onPause();
		ow.pause();
	}
	/**
	 * Calls the resume method in the drawOverWorld class and resumes the game.
	 */
	@Override
	protected void onResume()
	{
		super.onResume();
		ow.resume();
	}
	/**
	 * 
	 * @author Harry
	 * drawOverWorld class which initializes the screen to be drawn onto
	 * and creates a thread which will draw all the bitmaps onto the canvas.
	 *
	 */
	public class drawOverWorld extends SurfaceView implements Runnable{

		Thread world = null;
		SurfaceHolder holder;
		boolean isOK = true;
		
		public drawOverWorld(Context context) {
			super(context);
			holder = getHolder();
		}
		/**
		 * Starts a thread which draws the player and the move buttons and also the pause button to the screen.
		 */
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
								
				int leftX = 30;
				int leftY = height - height/2 - mveLeft.getHeight();
				int rightX = width - 30 - mveRight.getWidth();
				int rightY = height - height/2 - mveRight.getHeight();
				
				Canvas c = holder.lockCanvas();
				c.drawARGB(255,0,0,10);
				c.drawBitmap(playr.playerB,playr.xLoc-(playr.playerB.getWidth()/2),playr.yLoc-(playr.playerB.getHeight()/2),null);
				
				c.drawBitmap(mveLeft, leftX, leftY, null);
				c.drawBitmap(mveRight, rightX, rightY, null);
				c.drawBitmap(pause, width - 10 - pause.getWidth(),10,null);
				holder.unlockCanvasAndPost(c);
			}
		}
		/**
		 * Upon call this method pauses the thread by killing the thread.
		 */
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
		/**
		 * Creates a new thread to break from the pause.
		 */
		public void resume()
		{
			isOK = true;
			world = new Thread(this);
			world.start();
		}
		
		
	}
	/**
	 * This method is prevoked when the screen is touched and 
	 * if the touch is on a certain spot in this case one of the buttons
	 * an action occurs either the player is moved or the game is paused.
	 */
	@Override
	public boolean onTouch(View v, MotionEvent me) {
		Display display = getWindowManager().getDefaultDisplay();
		Point size = new Point();
		display.getRealSize(size);
		int width = size.x;
		int height = size.y;
						
		int leftX = 30;
		int leftY = height - height/2 - mveLeft.getHeight();
		int rightX = width - 30 - mveRight.getWidth();
		int rightY = height - height/2 - mveRight.getHeight();
		switch(me.getAction())
		{
			case MotionEvent.ACTION_MOVE:
			{
				if(me.getX() > leftX && me.getX() <= leftX+mveLeft.getHeight() && me.getY() > leftY && me.getY() < leftY+mveLeft.getWidth())
				{
					if(ow.isOK == true)
					{
						playr.Move(-10);
						return true;
					}
				}
				else if(me.getX() > rightX && me.getX() <= rightX + mveRight.getHeight() && me.getY() > rightY && me.getY() < rightY + mveRight.getWidth())
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
				if(me.getX() > width - 10 - pause.getWidth() && me.getX() <= width - 10 && me.getY() > 10 && me.getY()< 10+pause.getWidth())
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

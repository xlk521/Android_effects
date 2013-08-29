package com.example.effects;
/**
 * 图片的旋转，平移，缩放，倾斜，显示设定形状区域
 * **/
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.view.Menu;
import android.view.View;
import android.widget.FrameLayout;

@SuppressLint("DrawAllocation")
public class MainActivity extends Activity {

	private FrameLayout frame = null;
	private Paint paint = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		frame = (FrameLayout)findViewById(R.id.frame);
		frame.addView(new myView(this));
	}

	@SuppressLint("DrawAllocation")
	private class myView extends View{

		public myView(Context context) {
			super(context);
		}

		@SuppressLint("DrawAllocation")
		@Override
		protected void onDraw(Canvas canvas) {
			paint = new Paint();
			Bitmap bm_bg = BitmapFactory.decodeResource(MainActivity.this.getResources(), R.drawable.myself);
			//绘制背景图片
			canvas.drawBitmap(bm_bg, 0, 0, paint);
			Bitmap bm_ra = BitmapFactory.decodeResource(MainActivity.this.getResources(), R.drawable.cans);
			//绘制原图
			canvas.drawBitmap(bm_ra, 0,0, paint);
			/******************************************************* 旋 转  & 平移    **********************************************************/
			/**
			 * 应用setRotate(float degree)方法进行旋转
			 * 
			 * **/
			Matrix matrix = new Matrix();
			//以0,0为轴心旋转30度
			matrix.setRotate(30);
			matrix.postTranslate(360, 100);
			//绘制图像并且按着设定的方式转换
			canvas.drawBitmap(bm_ra, matrix, paint);
			
			/**
			 * 应用setRotate(float degree, float px,float py)方法进行旋转
			 * 
			 * **/
			Matrix m = new Matrix();
			//按照87,87为圆心旋转90度
			m.setRotate(60,87,187);
			canvas.drawBitmap(bm_ra, m, paint);
			
			/*******************************************************缩 放**********************************************************/
			/**
			 * 应用setScale(float sx,float sy)方法缩放,表示圆心为0,0
			 * 应用setScale(float sx,float sy,float x,float y)缩放
			 * **/
			Matrix m2 = new Matrix();
			m2.setScale(0.8f, 0.8f, 389, 689);
			canvas.drawBitmap(bm_ra, m2, paint);
			
			/*******************************************************倾 斜**********************************************************/
			/**
			 * 应用setSkew(float sx,float sy)方法缩放,表示圆心为0,0
			 * 应用setSkew(float sx,float sy,float x,float y)缩放
			 * **/
			Matrix m3 = new Matrix();
			m3.setSkew(-0.5f, 0f, 600, 900);
			canvas.drawBitmap(bm_ra, m3, paint);
			
			/*******************************************************渲染图像：显示一个椭圆区域的图片**********************************************************/
			//创建一个在水平重复的BitmapShader对象
			BitmapShader bs = new BitmapShader(bm_ra, TileMode.REPEAT, TileMode.MIRROR);
			//设置渲染对象
			paint.setShader(bs);
			RectF oval = new RectF(0,0,180,80);
			//画布平移
			canvas.translate(140, 220);
			canvas.drawOval(oval, paint);
		}
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

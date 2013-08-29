package com.example.effects;
/**
 * ͼƬ����ת��ƽ�ƣ����ţ���б����ʾ�趨��״����
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
			//���Ʊ���ͼƬ
			canvas.drawBitmap(bm_bg, 0, 0, paint);
			Bitmap bm_ra = BitmapFactory.decodeResource(MainActivity.this.getResources(), R.drawable.cans);
			//����ԭͼ
			canvas.drawBitmap(bm_ra, 0,0, paint);
			/******************************************************* �� ת  & ƽ��    **********************************************************/
			/**
			 * Ӧ��setRotate(float degree)����������ת
			 * 
			 * **/
			Matrix matrix = new Matrix();
			//��0,0Ϊ������ת30��
			matrix.setRotate(30);
			matrix.postTranslate(360, 100);
			//����ͼ���Ұ����趨�ķ�ʽת��
			canvas.drawBitmap(bm_ra, matrix, paint);
			
			/**
			 * Ӧ��setRotate(float degree, float px,float py)����������ת
			 * 
			 * **/
			Matrix m = new Matrix();
			//����87,87ΪԲ����ת90��
			m.setRotate(60,87,187);
			canvas.drawBitmap(bm_ra, m, paint);
			
			/*******************************************************�� ��**********************************************************/
			/**
			 * Ӧ��setScale(float sx,float sy)��������,��ʾԲ��Ϊ0,0
			 * Ӧ��setScale(float sx,float sy,float x,float y)����
			 * **/
			Matrix m2 = new Matrix();
			m2.setScale(0.8f, 0.8f, 389, 689);
			canvas.drawBitmap(bm_ra, m2, paint);
			
			/*******************************************************�� б**********************************************************/
			/**
			 * Ӧ��setSkew(float sx,float sy)��������,��ʾԲ��Ϊ0,0
			 * Ӧ��setSkew(float sx,float sy,float x,float y)����
			 * **/
			Matrix m3 = new Matrix();
			m3.setSkew(-0.5f, 0f, 600, 900);
			canvas.drawBitmap(bm_ra, m3, paint);
			
			/*******************************************************��Ⱦͼ����ʾһ����Բ�����ͼƬ**********************************************************/
			//����һ����ˮƽ�ظ���BitmapShader����
			BitmapShader bs = new BitmapShader(bm_ra, TileMode.REPEAT, TileMode.MIRROR);
			//������Ⱦ����
			paint.setShader(bs);
			RectF oval = new RectF(0,0,180,80);
			//����ƽ��
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

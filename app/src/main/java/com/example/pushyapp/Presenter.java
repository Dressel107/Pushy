package com.example.pushyapp;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pushyapp.Models.GameElements.Goal;
import com.example.pushyapp.Models.GameElements.Key;
import com.example.pushyapp.Models.GameElements.Wall;
import com.example.pushyapp.Models.GameElements.WoodenBox;
import com.example.pushyapp.R;


public class Presenter extends AppCompatActivity {
    private ImageView imageView;
    private Bitmap bitmap;
    private Canvas canvas;
    private Paint paint;

    private int screenWidth;
    private int screenHeight;


    private  Rect srcRect;

    private Bitmap bmWall, bmGoal, bmKey, woodenBox;



    public Presenter(AppCompatActivity activity) {
        this.screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
        this.screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;

        this.bitmap = Bitmap.createBitmap(this.screenWidth, this.screenHeight, Bitmap.Config.ARGB_8888);
        this.canvas = new Canvas(this.bitmap);
        this.imageView = new ImageView(activity);
        this.imageView.setImageBitmap(this.bitmap);
        this.paint = new Paint();

        this.makeBitmaps(activity);

        this.srcRect =  new Rect(0, 0, bmWall.getWidth(), bmWall.getHeight());


        activity.setContentView(this.imageView);
    }

    public void draw(Wall wall, int left, int top){
        Rect dst = new Rect(left,top,(left+100),(top+100));
        this.canvas.drawBitmap(this.bmWall, srcRect, dst,null);
        imageView.invalidate();
    }

    public void draw(Goal goal, int left, int top){
        Rect dst = new Rect(left,top,(left+100),(top+100));
        this.canvas.drawBitmap(this.bmGoal, srcRect, dst,null);
        imageView.invalidate();
    }

    public void draw(Key key, int left, int top){
        Rect dst = new Rect(left,top,(left+100),(top+100));
        this.canvas.drawBitmap(this.bmKey, srcRect, dst,null);
        imageView.invalidate();
    }

    public void draw(WoodenBox woodenBox, int left, int top){
        Rect dst = new Rect(left,top,(left+100),(top+100));
        this.canvas.drawBitmap(this.woodenBox, srcRect, dst,null);
        imageView.invalidate();
    }

    //Wandelt PNG-Dateien aus den Resources in Bitmaps um
    private void makeBitmaps(AppCompatActivity activity){
        this.bmWall = BitmapFactory.decodeResource(activity.getResources(), R.drawable.wallps);
        this.bmGoal = BitmapFactory.decodeResource(activity.getResources(), R.drawable.goal);
        this.bmKey = BitmapFactory.decodeResource(activity.getResources(), R.drawable.key);
        this.woodenBox = BitmapFactory.decodeResource(activity.getResources(),R.drawable.woodenbox);
    }
}

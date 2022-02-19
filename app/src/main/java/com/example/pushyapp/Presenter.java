package com.example.pushyapp;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pushyapp.Models.GameElements.GameElement;

public class Presenter extends AppCompatActivity {
    private ImageView imageView;
    private Bitmap bitmap;
    private Canvas canvas;
    private Paint paint;

    private GameElement[][] elements;
    private int screenWidth;
    private int screenHeight;

    private Bitmap bm;

    public Presenter(AppCompatActivity activity) {
        this.screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
        this.screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;

        this.bitmap = Bitmap.createBitmap(this.screenWidth, this.screenHeight, Bitmap.Config.ARGB_8888);
        this.canvas = new Canvas(this.bitmap);
        this.imageView = new ImageView(this);
        this.imageView.setImageBitmap(this.bitmap);
        this.paint = new Paint();
        setContentView(this.imageView);

        this.paint.setColor(Color.GREEN);
        this.canvas.drawRect(100,100,200,200, this.paint);
        imageView.invalidate();

    }
}

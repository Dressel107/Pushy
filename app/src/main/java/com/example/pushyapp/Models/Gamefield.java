package com.example.pushyapp.Models;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pushyapp.Models.GameElements.GameElement;

public class Gamefield
{
    private final int MARGIN = 8;

    private ImageView imageView;
    private Bitmap bitmap;
    private Canvas canvas;
    private Paint paint;

    private GameElement[][] elements;
    private int screenWidth;
    private int screenHeight;

    public Gamefield(AppCompatActivity activity, GameElement[][] elements)
    {
        this.elements = elements;
        this.screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
        this.screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;

        this.bitmap = Bitmap.createBitmap(this.screenWidth, this.screenHeight, Bitmap.Config.ARGB_8888);
        this.canvas = new Canvas(this.bitmap);
        this.imageView = new ImageView(activity);
        this.imageView.setImageBitmap(this.bitmap);
        this.paint = new Paint();
    }

    public void drawGamefield()
    {


        imageView.invalidate();
    }
}

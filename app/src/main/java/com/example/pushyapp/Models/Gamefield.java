package com.example.pushyapp.Models;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pushyapp.Models.GameElements.GameElement;
import com.example.pushyapp.Models.GameElements.Wall;
import com.example.pushyapp.R;

public class Gamefield extends AppCompatActivity
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

    }



    public void drawGamefield()
    {


        imageView.invalidate();
    }
}

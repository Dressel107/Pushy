package com.example.pushyapp.Activities;

import androidx.appcompat.app.AppCompatActivity;


import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.pushyapp.Models.GameElements.GameElement;
import com.example.pushyapp.Models.GameElements.Wall;
import com.example.pushyapp.Models.Gamefield;
import com.example.pushyapp.R;



public class LevelOneActivity extends AppCompatActivity {

    private ImageView imageView;
    private Bitmap bitmap;
    private Canvas canvas;
    private Paint paint;

    private GameElement[][] elements;
    private int screenWidth;
    private int screenHeight;

    private Bitmap bm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_level_one_activity);




        this.screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
        this.screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;

        this.bitmap = Bitmap.createBitmap(this.screenWidth, this.screenHeight, Bitmap.Config.ARGB_8888);
        this.canvas = new Canvas(this.bitmap);
        this.imageView = new ImageView(this);
        this.imageView.setImageBitmap(this.bitmap);
        this.paint = new Paint();
        setContentView(this.imageView);


        this.bm = BitmapFactory.decodeResource(getResources(), R.drawable.wall);


        this.paint.setColor(Color.GREEN);
        this.canvas.drawRect(100,100,200,200, this.paint);
        this.canvas.drawBitmap(this.bm, 150, 150,null);
        imageView.invalidate();



//        GameElement[][] gameElement = new GameElement[13][10];
//        for(int i = 0; i < 13; i++){
//            for(int j = 0; j < 10; j++){
//                gameElement[i][j] = new Wall();
//            }
//        }
//
//        Gamefield gamefield = new Gamefield(this, gameElement);
//        gamefield.drawGamefield();


    }
}
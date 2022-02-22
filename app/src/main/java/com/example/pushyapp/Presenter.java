package com.example.pushyapp;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pushyapp.Activities.GamefieldActivity;
import com.example.pushyapp.Models.GameElements.Floor;
import com.example.pushyapp.Models.GameElements.GameElement;
import com.example.pushyapp.Models.GameElements.Wall;
import com.example.pushyapp.Services.OnSwipeTouchListener;

import java.util.ArrayList;


public class Presenter extends AppCompatActivity {
    private AppCompatActivity activity;
    public ImageView imageView;
    private Bitmap bitmap;
    private Canvas canvas;
    private Paint paint;

    private int screenWidth;
    private int screenHeight;

    private ArrayList<GameElement> gameElements;
    private int horizontalFieldsCount;
    private int verticalFieldsCount;


    public Presenter(AppCompatActivity activity, ArrayList<GameElement> elements, int horizontalFieldsCount, int verticalFieldsCount) {
        this.screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
        this.screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;

        this.gameElements = elements;
        this.horizontalFieldsCount = horizontalFieldsCount;
        this.verticalFieldsCount = verticalFieldsCount;

        this.activity = activity;
        this.bitmap = Bitmap.createBitmap(this.screenWidth, this.screenHeight, Bitmap.Config.ARGB_8888);
        this.canvas = new Canvas(this.bitmap);
        this.imageView = new ImageView(activity);
        this.imageView.setImageBitmap(this.bitmap);
        this.paint = new Paint();

        activity.setContentView(this.imageView);


        this.imageView.setOnTouchListener(new OnSwipeTouchListener(this) {
            public void onSwipeTop() {
                Toast.makeText(activity, "top", Toast.LENGTH_SHORT).show();
            }
            public void onSwipeRight() {
                Toast.makeText(activity, "right", Toast.LENGTH_SHORT).show();
            }
            public void onSwipeLeft() {
                Toast.makeText(activity, "left", Toast.LENGTH_SHORT).show();
            }
            public void onSwipeBottom() {
                Toast.makeText(activity, "bottom", Toast.LENGTH_SHORT).show();
            }

        });
    }

    public void draw(GameElement gameElement,  int top, int left){
        Bitmap bm = BitmapFactory.decodeResource(this.activity.getResources(), gameElement.getRes());
        Rect srcRect =  new Rect(0, 0, bm.getWidth(), bm.getHeight());
        Rect dstRect = new Rect(left,top, (int) (left+gameElement.getSize()), (int) (top+gameElement.getSize()));
        this.canvas.drawBitmap(bm, srcRect, dstRect,null);
        imageView.invalidate();
    }

    public void drawEmptyGamefield(){
            Wall wall = new Wall(0, 0, (screenWidth / verticalFieldsCount));
            Floor floor = new Floor(0, 0, (screenWidth / verticalFieldsCount));
            for(int i = 0; i < horizontalFieldsCount; i++){
                for(int j = 0; j < verticalFieldsCount; j++){
                    if(i == 0 || i == horizontalFieldsCount - 1 || j == 0 || j == verticalFieldsCount - 1){
                        draw(wall, (int)(i*wall.getSize()), (int)(j * wall.getSize()));
                    }else {
                        draw(floor, (int)(i*floor.getSize()), (int)(j * floor.getSize()));
                    }
                }
            }
    };

    public void clear()   {
        this.canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
    }





}

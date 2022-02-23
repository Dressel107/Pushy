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
import com.example.pushyapp.Enums.Direction;
import com.example.pushyapp.Models.GameElements.Floor;
import com.example.pushyapp.Models.GameElements.GameElement;
import com.example.pushyapp.Models.GameElements.Wall;
import com.example.pushyapp.Models.ScreenListener;
import com.example.pushyapp.Services.OnSwipeTouchListener;

import java.util.ArrayList;

public class Presenter extends AppCompatActivity {
    private AppCompatActivity activity;
    ScreenListener listener;
    public ImageView imageView;
    private Bitmap bitmap;
    private Canvas canvas;
    private Paint paint;

    private int screenWidth;
    private int screenHeight;
    private ArrayList<GameElement> gameElements;
    private int horizontalFieldsCount;
    private int verticalFieldsCount;
    private float elementSize;

    public Presenter(AppCompatActivity activity, ArrayList<GameElement> elements, int horizontalFieldsCount, int verticalFieldsCount)
    {
        this.gameElements = elements;
        this.horizontalFieldsCount = horizontalFieldsCount;
        this.verticalFieldsCount = verticalFieldsCount;

        // Bildschirmgröße ermitteln
        this.screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
        this.screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;

        // Dynamische Levelelemente anhand der Bildschirmgröße skalieren
        elementSize = screenWidth / horizontalFieldsCount;
        for (GameElement element : gameElements)
        {
            element.setSize(elementSize);
        }

        this.activity = activity;
        this.bitmap = Bitmap.createBitmap(this.screenWidth, this.screenHeight, Bitmap.Config.ARGB_8888);
        this.canvas = new Canvas(this.bitmap);
        this.imageView = new ImageView(activity);
        this.imageView.setImageBitmap(this.bitmap);
        this.paint = new Paint();

        activity.setContentView(this.imageView);
        setSwipeListener();

        // Spielfeld mit seinen Startelementen zeichnen
        drawEmptyGamefield();
        for (GameElement element : gameElements)
        {
            draw(element);
        }
    }

    public void setScreenListener(ScreenListener listener)
    {
        this.listener = listener;
    }

    private void setSwipeListener()
    {
            imageView.setOnTouchListener(new OnSwipeTouchListener(activity) {
            public void onSwipeTop() {
                listener.playerMoving(Direction.Up);
            }
            public void onSwipeRight() {
                listener.playerMoving(Direction.Right);
            }
            public void onSwipeLeft() {
                listener.playerMoving(Direction.Left);
            }
            public void onSwipeBottom() {
                listener.playerMoving(Direction.Down);
            }
        });
    }

    public void draw(GameElement gameElement){

        if (!gameElement.isVisible()){
            return;
        }

        Bitmap bm = BitmapFactory.decodeResource(this.activity.getResources(), gameElement.getRes());
        Rect srcRect =  new Rect(0, 0, bm.getWidth(), bm.getHeight());
        Rect dstRect = new Rect((int)gameElement.getScreenX(), (int)gameElement.getScreenY(), (int) (gameElement.getScreenX()+gameElement.getSize()), (int) (gameElement.getScreenY()+gameElement.getSize()));
        this.canvas.drawBitmap(bm, srcRect, dstRect,null);
        imageView.invalidate();
    }

    public void drawEmptyGamefield(){
            for(int i = 0; i < horizontalFieldsCount; i++){
                for(int j = 0; j < verticalFieldsCount; j++){
                    if(i == 0 || i == horizontalFieldsCount - 1 || j == 0 || j == verticalFieldsCount - 1){
                        draw(new Wall(i, j, elementSize));
                    }else {
                        draw(new Floor(i, j, elementSize));
                    }
                }
            }
    }

    public void clear()   {
        this.canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
    }
}

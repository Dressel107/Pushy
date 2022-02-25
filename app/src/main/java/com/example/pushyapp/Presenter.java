package com.example.pushyapp;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
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

    private Bitmap bitmap;
    private Canvas canvas;
    public ImageView imageView;
    private Paint paint;

    private int screenWidth;
    private int screenHeight;
    private ArrayList<GameElement> gameElements;
    private int horizontalFieldsCount;
    private int verticalFieldsCount;
    private float elementSize;

    /**Initialisiert für eine Activity eine Bitmap, Canvas, Imageview und eine Farbe
     * zeichnet das Spielfeld und die übergebenen Spielelemnte.
     * @param activity übergibt die Activity, auf die der Presenter zeichen und Gesten erkennen soll
     * @param elements übergibt die darzustellenden Elemente
     * @param horizontalFieldsCount Anzahl der Zeilen des Spielfeldes
     * @param verticalFieldsCount Anzahl der Spalten des Spielfeldes
     * @author Dirk Dresselhaus
     */
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

    /**
     * Setzt den SwipeListener für die jeweiligen Methoden
     * onSwipeTop(), onSwipeRight(), onSwipeTop(), onSwipeBottom().
     * @author Dirk Dresselhaus
     */
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

    /**
     * Zeichnet ein GameElement auf dem Screen.
     * Das komplette Bitmap des GameElements wird auf die Size des GameElements skaliert und dargestellt.
     * @param gameElement das zu zeichnende GameElement
     * @author Dirk Dresselhaus
     */
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

    /**
     * Zeichen eine Spielfeld ohne GameElements anhand der Anzahl der Zeilen und Spalten
     * @author Dirk Dresselhaus
     */
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

    public void setScreenListener(ScreenListener listener)
    {
        this.listener = listener;
    }

}

package com.example.pushyapp.Activities;

import androidx.appcompat.app.AppCompatActivity;


import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.pushyapp.Models.GameElements.GameElement;
import com.example.pushyapp.Models.GameElements.Goal;
import com.example.pushyapp.Models.GameElements.Key;
import com.example.pushyapp.Models.GameElements.Wall;
import com.example.pushyapp.Models.GameElements.WoodenBox;
import com.example.pushyapp.Presenter;


public class LevelOneActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Presenter p = new Presenter(this);

        Wall w = new Wall();
        p.draw(w,0,200);

        Goal g = new Goal();
        p.draw(g,100, 200);

        Key k = new Key();
        p.draw(k, 200, 200);

        WoodenBox wb = new WoodenBox();
        p.draw(wb,300,200);







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
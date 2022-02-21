package com.example.pushyapp.Activities;

import androidx.appcompat.app.AppCompatActivity;


import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.pushyapp.Models.GameElements.ColorArea;
import com.example.pushyapp.Models.GameElements.ColorSphere;
import com.example.pushyapp.Models.GameElements.ColorSplash;
import com.example.pushyapp.Models.GameElements.Floor;
import com.example.pushyapp.Models.GameElements.GameElement;
import com.example.pushyapp.Models.GameElements.Gate;
import com.example.pushyapp.Models.GameElements.Goal;
import com.example.pushyapp.Models.GameElements.Key;
import com.example.pushyapp.Models.GameElements.Player;
import com.example.pushyapp.Models.GameElements.Wall;
import com.example.pushyapp.Models.GameElements.WoodenBox;
import com.example.pushyapp.Presenter;
import com.example.pushyapp.R;

import java.util.Timer;
import java.util.TimerTask;


public class LevelOneActivity extends AppCompatActivity {

    private Presenter p;
    private Gate gate;

    private int velocity = 5;
    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       this.p = new Presenter(this);



        Wall w = new Wall();
        p.draw(w,0,200);

        Goal g = new Goal();
        p.draw(g,100, 200);

        Key k = new Key();
        p.draw(k, 200, 200);


        WoodenBox wb = new WoodenBox();
        p.draw(wb,300,200);

        this.gate = new Gate();
        p.draw(gate, 400, 200);

        ColorSplash colorsplash = new ColorSplash();
        p.draw(colorsplash, 500, 200);

        ColorArea colorArea = new ColorArea();
        p.draw(colorArea, 600, 200);

        ColorSphere colorSphere = new ColorSphere();
        p.draw(colorSphere,700,200);

        Player player = new Player();
        p.draw(player, 800, 200);

        Floor floor = new Floor();
        p.draw(floor, 900, 200);
        p.draw(floor, 0, 400);
        p.draw(floor, 0, 500);
        p.draw(floor, 0, 600);
        p.draw(floor, 100, 600);
        p.draw(floor, 100, 600);



//Paar Sachen ausprobiert für Animation
//        Timer timer = new Timer();
//        timer.schedule(new TimerTask() {
//                                @Override
//                                public void run() {
//                                    testani(p);
//                                }
//                            }
//                ,0,50);


    }

//    private void testani(Presenter p){
//
//
//            p.clear();
//            p.draw(gate, 400,this.i );
//
//            this.i+= this.velocity;
//            if(this.i > 600) this.i = 0;
//    }


}
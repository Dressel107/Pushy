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
import com.example.pushyapp.Models.Gamefield;
import com.example.pushyapp.Presenter;
import com.example.pushyapp.R;

import java.util.Timer;
import java.util.TimerTask;


public class LevelOneActivity extends AppCompatActivity {

    private Presenter p;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.p = new Presenter(this);
        GameElement [][][]test =
                {{{new Wall(0,0),  new Wall(100,0)},
                        {new Wall(0,100),new Wall(100,100)},
                        {new Wall(0,200),  new Wall(100,200)},},


                        {{new Player(0,0), null},
                                {null, null}}};





        GameElement [][][]test2 =
                {{
                {new Wall(0,0), new Wall(100,0), new Wall(200,0), new Wall(300,0), new Wall(400,0), new Wall(500,0), new Wall(600,0), new Wall(700,0), new Wall(800,0), new Wall(900,0 )},
                {new Wall(0,100), new Floor(100,100), new Floor(200,100), new Floor(300,100), new Floor(400,100), new Floor(500,100), new Floor(600,100), new Floor(700,100), new Floor(800,100), new Wall(900,100)},
                {new Wall(0,200), new Floor(100,200), new Floor(200,200), new Floor(300,200), new Floor(400,200), new Floor(500,200), new Floor(600,200), new Floor(700,200), new Floor(800,200), new Wall(900,200)},
                {new Wall(0,300), new Floor(100,300), new Floor(200,300), new Floor(300,300), new Floor(400,300), new Floor(500,300), new Floor(600,300), new Floor(700,300), new Floor(800,300), new Wall(900,300)},
                {new Wall(0,400), new Floor(100,400), new Floor(200,400), new Floor(300,400), new Floor(400,400), new Floor(500,400), new Floor(600,400), new Floor(700,400), new Floor(800,400), new Wall(900,400)},
                {new Wall(0,500), new Floor(100,500), new Floor(200,500), new Floor(300,500), new Floor(400,500), new Floor(500,500), new Floor(600,500), new Floor(700,500), new Floor(800,500), new Wall(900,500)},
                {new Wall(0,600), new Floor(100,600), new Floor(200,600), new Floor(300,600), new Floor(400,600), new Floor(500,600), new Floor(600,600), new Floor(700,600), new Floor(800,600), new Wall(900,600)},
                {new Wall(0,700), new Floor(100,700), new Floor(200,700), new Floor(300,700), new Floor(400,700), new Floor(500,700), new Floor(600,700), new Floor(700,700), new Floor(800,700), new Wall(900,700)},
                {new Wall(0,800), new Floor(100,800), new Floor(200,800), new Floor(300,800), new Floor(400,800), new Floor(500,800), new Floor(600,800), new Floor(700,800), new Floor(800,800), new Wall(900,800)},
                {new Wall(0,900), new Floor(100,900), new Floor(200,900), new Floor(300,900), new Floor(400,900), new Floor(500,900), new Floor(600,900), new Floor(700,900), new Floor(800,900), new Wall(900,900)},
                {new Wall(0,1000), new Floor(100,1000), new Floor(200,1000), new Floor(300,1000), new Floor(400,1000), new Floor(500,1000), new Floor(600,1000), new Floor(700,1000), new Floor(800,1000), new Wall(900,1000)},
                {new Wall(0,1100), new Floor(100,1100), new Floor(200,1100), new Floor(300,1100), new Floor(400,1100), new Floor(500,1100), new Floor(600,1100), new Floor(700,1100), new Floor(800,1100), new Wall(900,1100)},
                {new Wall(0,1200), new Floor(100,1200), new Floor(200,1200), new Floor(300,1200), new Floor(400,1200), new Floor(500,1200), new Floor(600,1200), new Floor(700,1200), new Floor(800,1200), new Wall(900,1200)},
                {new Wall(0,1300), new Floor(100,1300), new Floor(200,1300), new Floor(300,1300), new Floor(400,1300), new Floor(500,1300), new Floor(600,1300), new Floor(700,1300), new Floor(800,1300), new Wall(900,1300)},
                {new Wall(0,1400), new Floor(100,1400), new Floor(200,1400), new Floor(300,1400), new Floor(400,1400), new Floor(500,1400), new Floor(600,1400), new Floor(700,1400), new Floor(800,1400), new Wall(900,1400)},
                {new Wall(0,1500), new Wall(100,1500), new Wall(200,1500), new Wall(300,1500), new Wall(400,1500), new Wall(500,1500), new Wall(600,1500), new Wall(700,1500), new Wall(800,1500), new Wall(900,1500)},
                },


                {{null, null},
                {null, new Player(800,1400)}}};

        Gamefield gamefield = new Gamefield(test2);
        p.draw(gamefield);
//
//
//        Wall w = new Wall();
//        p.draw(w,0,200);
//
//        Goal g = new Goal();
//        p.draw(g,100, 200);
//
//        Key k = new Key();
//        p.draw(k, 200, 200);
//
//        WoodenBox wb = new WoodenBox();
//        p.draw(wb,300,200);
//
//        Gate gate = new Gate();
//        p.draw(gate, 400, 200);
//
//        ColorSplash colorsplash = new ColorSplash();
//        p.draw(colorsplash, 500, 200);
//
//        ColorArea colorArea = new ColorArea();
//        p.draw(colorArea, 600, 200);
//
//        ColorSphere colorSphere = new ColorSphere();
//        p.draw(colorSphere,700,200);
//
//        Player player = new Player();
//        p.draw(player, 800, 200);
//
//        Floor floor = new Floor();
//        p.draw(floor, 900, 200);




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
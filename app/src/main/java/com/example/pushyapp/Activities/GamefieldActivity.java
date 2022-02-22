package com.example.pushyapp.Activities;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.pushyapp.Models.GameController;

import com.example.pushyapp.Models.GameElements.GameElement;

import com.example.pushyapp.Models.Level;
import com.example.pushyapp.Presenter;
import com.example.pushyapp.Services.OnSwipeTouchListener;

import java.util.ArrayList;


public class GamefieldActivity extends AppCompatActivity {

    private GameController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // TODO: Id aus Intent holen
        Level level = new Level(0, 0);
        this.controller = new GameController(this, level);

        //tests
        ArrayList<GameElement> testElements = new ArrayList<GameElement>();
        //Presenter p = new Presenter(this, testElements, 15, 10);
        //p.drawEmptyGamefield();

//        p.imageView.setOnTouchListener(new OnSwipeTouchListener(this) {
//            public void onSwipeTop() {
//                Toast.makeText(GamefieldActivity.this, "top", Toast.LENGTH_SHORT).show();
//            }
//            public void onSwipeRight() {
//                Toast.makeText(GamefieldActivity.this, "right", Toast.LENGTH_SHORT).show();
//            }
//            public void onSwipeLeft() {
//                Toast.makeText(GamefieldActivity.this, "left", Toast.LENGTH_SHORT).show();
//            }
//            public void onSwipeBottom() {
//                Toast.makeText(GamefieldActivity.this, "bottom", Toast.LENGTH_SHORT).show();
//            }
//
//        });


    }
}
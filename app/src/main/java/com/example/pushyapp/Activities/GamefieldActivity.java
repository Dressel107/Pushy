package com.example.pushyapp.Activities;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;

import com.example.pushyapp.Models.GameController;
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
import com.example.pushyapp.Models.Level;
import com.example.pushyapp.Presenter;

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
        Presenter p = new Presenter(this, testElements, 15,10);
        p.drawEmptyGamefield();





}
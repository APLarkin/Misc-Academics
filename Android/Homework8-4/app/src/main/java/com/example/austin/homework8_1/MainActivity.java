package com.example.austin.homework8_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import android.content.*;
import android.view.View.*;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        class doThething extends TimerTask {
            public void run(){
                Random r = new Random();
                int randomno = r.nextInt(4);
                String Output = "";
                if(randomno == 0) {
                    String quote1 = "Today is a date which shall live in infamy";
                    Output = quote1;
                }
                if(randomno == 1) {
                    String quote2 = "The frog in the well was happy.\n" +
                            "It wasn't interested what was outside the well.\n" +
                            "\n" +
                            "The frog in the well was happy.\n" +
                            "It was recluse to anything that happened outside the well.\n" +
                            "\n" +
                            "And you were happy.\n" +
                            "Because you didn't know what occurred outside the well.";
                    Output = quote2;
                }
                if(randomno == 2) {
                    String quote3 = "These are my two brigade members. They'll do whatever I say so feel free to ask for anything!";
                    Output = quote3;
                }
                if(randomno == 3) {
                    String quote4 = "Gonna smack a merc in the mouth if he doesn't quit  running that lip off";
                }
                if(randomno == 4) {
                    String quote5 = "Please tell me what happened in this night.\n" +
                            "The cat in the box was dead.";
                    Output = quote5;
                }
                TextView output  = (TextView) findViewById(R.id.displaytext);
                output.setText(Output);
            }
        }



        Timer timer = new Timer();
        timer.schedule(new MainActivity.doTheThing(), 0 ,5000);
    }


}
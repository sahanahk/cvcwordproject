package com.example.android.cvcwordproject;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Word Quiz");
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        myToolbar.setTitleTextColor(Color.WHITE
        );
        setSupportActionBar(myToolbar);
        //set up listner for play image,if clicked start the quiz
        ImageView play_image = (ImageView) findViewById(R.id.play_image);
        play_image.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Questions.class);
                startActivity(intent);
            }
        });
        ImageView exit_image = (ImageView) findViewById(R.id.exit_image);
        exit_image.setOnClickListener(new View.OnClickListener() {
                                          public void onClick(View view) {
                                              finish();
                                              System.exit(0);
                                          }

                                      }
        );


    }
}
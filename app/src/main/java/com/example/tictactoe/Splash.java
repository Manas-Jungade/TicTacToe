package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Animation scale= AnimationUtils.loadAnimation(Splash.this,R.anim.scale);
        ImageView img=(ImageView)findViewById(R.id.imageView);
        img.setAnimation(scale);
        Animation visible=AnimationUtils.loadAnimation(Splash.this,R.anim.visible);
        TextView text=findViewById(R.id.textView);
        text.setAnimation(visible);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent home=new Intent(Splash.this, MainActivity.class);
                startActivity(home);
                Toast.makeText(Splash.this, "WELCOME TO THE GAME...", Toast.LENGTH_SHORT).show();
                finish();
            }
        },5000);


    }
}
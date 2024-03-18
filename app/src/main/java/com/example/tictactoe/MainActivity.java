package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button;
        TextView Player1,Player2;
        button=findViewById(R.id.button);
        Player1=findViewById(R.id.Player1);
        Player2=findViewById(R.id.Player2);





        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent game=new Intent(MainActivity.this, Game.class);
                game.putExtra("person1",Player1.getText().toString());
                game.putExtra("person2",Player2.getText().toString());
                startActivity(game);
            }
        });



    }
}
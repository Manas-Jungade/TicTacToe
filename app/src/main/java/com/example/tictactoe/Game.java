package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Game extends AppCompatActivity {
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9;
    String bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9;
    int count=0;
    int flag=0;
    String GAMER1,GAMER2,winner,looser;
    TextView Result;
    TextView win1,win2;
    int plwin=0;
    int p2win=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Intent fromact=getIntent();
        String Gone=fromact.getStringExtra("person1");
        String Gtwo=fromact.getStringExtra("person2");
        GAMER1=Gone;
        GAMER2=Gtwo;
        TextView gamer1,gamer2;
        gamer1=findViewById(R.id.textView3);
        gamer2=findViewById(R.id.textView4);
        gamer1.setText(Gone+"=X");
        gamer2.setText(Gtwo+"=O");

        win1=(TextView)findViewById(R.id.win1);
        win2=(TextView)findViewById(R.id.win2);
        win1.setText("No. of wins="+plwin);
        win2.setText("No. of Wins="+p2win);

        b1=findViewById(R.id.button1);
        b2=findViewById(R.id.button2);
        b3=findViewById(R.id.button3);
        b4=findViewById(R.id.button4);
        b5=findViewById(R.id.button5);
        b6=findViewById(R.id.button6);
        b7=findViewById(R.id.button7);
        b8=findViewById(R.id.button8);
        b9=findViewById(R.id.button9);




    }
    public void check(View view){
        Button currentbutton=(Button)view;

        if(currentbutton.getText().toString()=="") {
            count++;
            if (flag == 0) {
                flag = 1;
                currentbutton.setText("X");
                winner = GAMER1;
                looser=GAMER2;
            } else {
                flag = 0;
                currentbutton.setText("O");
                winner = GAMER2;
                looser=GAMER1;
            }

            if (count > 4) {
                bt1 = b1.getText().toString();
                bt2 = b2.getText().toString();
                bt3 = b3.getText().toString();
                bt4 = b4.getText().toString();
                bt5 = b5.getText().toString();
                bt6 = b6.getText().toString();
                bt7 = b7.getText().toString();
                bt8 = b8.getText().toString();
                bt9 = b9.getText().toString();

                if (bt1.equals(bt2) && bt2.equals(bt3) && !bt1.equals("")) {
                    displaywinner(b1,b2,b3);

                } else if (bt4.equals(bt5) && bt5.equals(bt6) && !bt4.equals("")) {

                    displaywinner(b4,b5,b6);
                } else if (bt7.equals(bt8) && bt8.equals(bt9) && !bt7.equals("")) {

                    displaywinner(b7,b8,b9);
                } else if (bt1.equals(bt4) && bt4.equals(bt7) && !bt1.equals("")) {

                    displaywinner(b1,b4,b7);
                } else if (bt2.equals(bt5) && bt5.equals(bt8) && !bt2.equals("")) {

                    displaywinner(b2,b5,b8);
                } else if (bt3.equals(bt6) && bt6.equals(bt9) && !bt3.equals("")) {

                    displaywinner(b3,b6,b9);
                } else if (bt1.equals(bt5) && bt5.equals(bt9) && !bt1.equals("")) {

                    displaywinner(b1,b5,b9);
                } else if (bt3.equals(bt5) && bt5.equals(bt7) && !bt3.equals("")) {

                    displaywinner(b3,b5,b7);
                }

            }
            if(count==9){
                Result=findViewById(R.id.Result);
                Result.setText("Match is Tie !! (Restarting again) ");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        b1.setText("");
                        b2.setText("");
                        b3.setText("");
                        b4.setText("");
                        b5.setText("");
                        b6.setText("");
                        b7.setText("");
                        b8.setText("");
                        b9.setText("");

                        count=0;
                        if(flag==0){

                            Toast.makeText(Game.this, "Now "+looser+" will start the game...", Toast.LENGTH_SHORT).show();
                        }
                        else{

                            Toast.makeText(Game.this, "Now "+looser+" will start the game...", Toast.LENGTH_SHORT).show();
                        }
                        Result.setText("");


                    }
                },3000);
            }
        }

    }

    public  void displaywinner(Button button1,Button button2,Button button3){
        b1.setEnabled(false);
        b2.setEnabled(false);
        b3.setEnabled(false);
        b4.setEnabled(false);
        b5.setEnabled(false);
        b6.setEnabled(false);
        b7.setEnabled(false);
        b8.setEnabled(false);
        b9.setEnabled(false);
        Result=findViewById(R.id.Result);
        Result.setText("Winner is "+winner);
        if(flag==1){
            plwin++;
            win1.setText("No. of Wins="+plwin);
            button1.setBackgroundColor(getResources().getColor(R.color.Red));
            button2.setBackgroundColor(getResources().getColor(R.color.Red));
            button3.setBackgroundColor(getResources().getColor(R.color.Red));
        }
        else{
            p2win++;
            win2.setText("No. of Wins="+p2win);
            button1.setBackgroundColor(getResources().getColor(R.color.Blue));
            button2.setBackgroundColor(getResources().getColor(R.color.Blue));
            button3.setBackgroundColor(getResources().getColor(R.color.Blue));

        }

        Toast.makeText(Game.this, "Congrulations !!", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                b1.setText("");
                b2.setText("");
                b3.setText("");
                b4.setText("");
                b5.setText("");
                b6.setText("");
                b7.setText("");
                b8.setText("");
                b9.setText("");
                b1.setEnabled(true);
                b2.setEnabled(true);
                b3.setEnabled(true);
                b4.setEnabled(true);
                b5.setEnabled(true);
                b6.setEnabled(true);
                b7.setEnabled(true);
                b8.setEnabled(true);
                b9.setEnabled(true);
                count=0;
                if(flag==0){
                    flag=1;
                    Toast.makeText(Game.this, "Now "+winner+" will start the game...", Toast.LENGTH_SHORT).show();
                }
                else{
                    flag=0;
                    Toast.makeText(Game.this, "Now "+winner+" will start the game...", Toast.LENGTH_SHORT).show();
                }
                button1.setBackgroundColor(getResources().getColor(R.color.setwhite));
                button2.setBackgroundColor(getResources().getColor(R.color.setwhite));
                button3.setBackgroundColor(getResources().getColor(R.color.setwhite));
                Result.setText("");


            }
        },5000);
    }
}
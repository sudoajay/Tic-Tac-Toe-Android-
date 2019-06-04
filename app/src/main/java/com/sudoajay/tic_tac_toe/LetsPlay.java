package com.sudoajay.tic_tac_toe;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sudoajay.tic_tac_toe.R;

public class LetsPlay extends AppCompatActivity implements View.OnClickListener {
    private ImageButton newGameButton , menuButton;
    private ImageView image_In_Toast;
    private TextView firstBox , secondBox , thirdBox, fouthBox,fithBox,sixthBox,seventhBox
            , eigthBox ,ninthBox,MainWindoInfo, value_Showing,player1_Score,player2_Score,draw_Score
            ,player1Name,player2Name,text_In_Toast;
    private boolean dont_Touch_The_Board= false,first_Move_First_Player=true,the_Game_Begins,sound_On;
    private int chance=1, which_Player_Chance=1 ,player1 , player2 , draw;
    private String firstPlayerName= "Player 1" , secondPlayerName="Player 2";
    private final Context context = this;
    private  View layout ;
    private Handler handler = new Handler();
    private DesginOfLetsPlayClass desginOfLetsPlayClass ;
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lets_play);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT);

        if(!getIntent().getExtras().getString("com.example.sudoajay.tic_tac_toe.FirstPlayerName").equals("")){
            firstPlayerName=getIntent().getExtras().getString("com.example.sudoajay.tic_tac_toe.FirstPlayerName");
        }else{
            firstPlayerName = "Player 1";
        }
        if(!getIntent().getExtras().getString("com.example.sudoajay.tic_tac_toe.SecondPlayerName").equals("")){
            secondPlayerName=getIntent().getExtras().getString("com.example.sudoajay.tic_tac_toe.SecondPlayerName");
        }else{
            secondPlayerName = "Player 2";
        }

        sound_On = getIntent().getBooleanExtra("Sound_Check_SecondPlayerName",true);


        refrence();

        mediaPlayer= MediaPlayer.create(this,R.raw.sound);


    }
    public void refrence(){
        menuButton = (ImageButton) findViewById(R.id.menuButton);
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(the_Game_Begins  || player1 != 0 || player2 != 0 || draw !=0){
                    AlertDialog.Builder alert = new AlertDialog.Builder(context);
                    alert.setTitle("Game Restart ?");
                    alert.setCancelable(false);
                    alert.setMessage("Are You Sure To Leave");
                    alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(getApplicationContext(),TicTacToeLauncher.class);
                            startActivity(intent);
                        }
                    });
                    alert.setNegativeButton("No", null);
                    alert.show();
                }else {
                    Intent intent = new Intent(getApplicationContext(),TicTacToeLauncher.class);
                    startActivity(intent);
                }

            }
        });
        newGameButton = (ImageButton) findViewById(R.id.newGameButton);
        newGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(the_Game_Begins || player1 != 0 || player2 != 0 || draw !=0){
                    AlertDialog.Builder alert = new AlertDialog.Builder(context);
                    alert.setTitle("Game Restart ?");
                    alert.setCancelable(false);
                    alert.setMessage("Are You Sure To Leave");
                    alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(getApplicationContext(),TwoPlayerInfo.class);
                            startActivity(intent);
                        }
                    });
                    alert.setNegativeButton("No", null);
                    alert.show();
                }else {
                    Intent intent = new Intent(getApplicationContext(),TwoPlayerInfo.class);
                    startActivity(intent);
                }
            }

        });


        firstBox = (TextView) findViewById(R.id.firstBox);
        firstBox.setOnClickListener(this);
        secondBox = (TextView) findViewById(R.id.secondBox);
        secondBox.setOnClickListener(this);
        thirdBox = (TextView) findViewById(R.id.thirdBox);
        thirdBox.setOnClickListener(this);
        fouthBox = (TextView) findViewById(R.id.fouthBox);
        fouthBox.setOnClickListener(this);
        fithBox = (TextView) findViewById(R.id.fithBox);
        fithBox.setOnClickListener(this);
        sixthBox = (TextView) findViewById(R.id.sixthBox);
        sixthBox.setOnClickListener(this);
        seventhBox = (TextView) findViewById(R.id.seventhBox);
        seventhBox.setOnClickListener(this);
        eigthBox = (TextView) findViewById(R.id.eigthBox);
        eigthBox.setOnClickListener(this);
        ninthBox = (TextView) findViewById(R.id.ninthBox);
        ninthBox.setOnClickListener(this);

        MainWindoInfo= (TextView) findViewById(R.id.MainWindoInfo);
        MainWindoInfo.setText(firstPlayerName+" Chance");
        value_Showing = (TextView) findViewById(R.id.value_Showing);
        value_Showing.setTextColor(Color.parseColor("#e8001c"));
        player1_Score =(TextView) findViewById(R.id.player1_Score);
        player2_Score =(TextView) findViewById(R.id.player2_Score);
        draw_Score =(TextView) findViewById(R.id.draw_Score);
        player1Name=(TextView)findViewById(R.id.player1Name);
        player1Name.setText(firstPlayerName);
        player2Name=(TextView)findViewById(R.id.player2Name);
        player2Name.setText(secondPlayerName);

        LayoutInflater inflater = getLayoutInflater();
        layout = inflater.inflate(R.layout.activity_custom_toast,
                (ViewGroup) findViewById(R.id.toastcustom));


        image_In_Toast = (ImageView) layout.findViewById(R.id.image);
        text_In_Toast = (TextView) layout.findViewById(R.id.text);

        desginOfLetsPlayClass = (DesginOfLetsPlayClass) findViewById(R.id.desginOfLetsPlayClass2);
    }


    @Override
    public void onClick(View view) {
       if(!dont_Touch_The_Board) {
           the_Game_Begins =true;
           switch (view.getId()) {
               case R.id.firstBox:
                   if (firstBox.getText().equals(""))
                       makeNumberLine(firstBox);
                   break;
               case R.id.secondBox:
                   if (secondBox.getText().equals(""))
                       makeNumberLine(secondBox);
                   break;
               case R.id.thirdBox:
                   if (thirdBox.getText().equals(""))
                       makeNumberLine(thirdBox);
                   break;
               case R.id.fouthBox:
                   if (fouthBox.getText().equals(""))
                       makeNumberLine(fouthBox);
                   break;
               case R.id.fithBox:
                   if (fithBox.getText().equals(""))
                       makeNumberLine(fithBox);
                   break;
               case R.id.sixthBox:
                   if (sixthBox.getText().equals(""))
                       makeNumberLine(sixthBox);
                   break;
               case R.id.seventhBox:
                   if (seventhBox.getText().equals(""))
                       makeNumberLine(seventhBox);
                   break;
               case R.id.eigthBox:
                   if (eigthBox.getText().equals(""))
                       makeNumberLine(eigthBox);
                   break;
               case R.id.ninthBox:
                   if (ninthBox.getText().equals(""))
                       makeNumberLine(ninthBox);
                   break;
           }
       }
    }
    public void makeNumberLine( TextView v){

            if (which_Player_Chance == 1) {
                MainWindoInfo.setText(secondPlayerName+" Chance");
                which_Player_Chance = 2;
                value_Showing.setTextColor(Color.parseColor("#0881d8"));
                value_Showing.setText("( O )");
                v.setTextColor(Color.parseColor("#e8001c"));
                v.setText(" X");
            } else {
                MainWindoInfo.setText(firstPlayerName+" Chance ");
                which_Player_Chance = 1;
                value_Showing.setTextColor(Color.parseColor("#e8001c"));
                value_Showing.setText("( X )");
                v.setTextColor(Color.parseColor("#0881d8"));
                v.setText(" O");
            }
        if(CheckForWin()) {
            dont_Touch_The_Board = true;
            if (which_Player_Chance == 1) {
                player2++;
                player2_Score.setText(player2+"");
                new_Thread_For_Toast( R.drawable.won, secondPlayerName+" Won The Match ");

            } else if(which_Player_Chance==2) {
                player1++;
                player1_Score.setText(player1+"");
                new_Thread_For_Toast( R.drawable.won,firstPlayerName+" Won The Match ");

            }else{
                draw++;
                draw_Score.setText(draw+"");
                new_Thread_For_Toast( R.drawable.draw,"The Match is Draw ");
            }
        }

    }
    public boolean CheckForWin(){

        if(firstBox.getText().equals(secondBox.getText())  && secondBox.getText().equals(thirdBox.getText()) && !thirdBox.getText().equals("")) {
            desginOfLetsPlayClass.get_Game_Ends(4);
            return true;
        }
        if(fouthBox.getText().equals(fithBox.getText()) && fithBox.getText().equals(sixthBox.getText())&& !sixthBox.getText().equals("")){
            desginOfLetsPlayClass.get_Game_Ends(5);
        return true;
            }
        if(seventhBox.getText().equals(eigthBox.getText()) && eigthBox.getText().equals(ninthBox.getText())&& !ninthBox.getText().equals("")){
            desginOfLetsPlayClass.get_Game_Ends(6);
            return true;
         }
        if(firstBox.getText().equals(fouthBox.getText()) && fouthBox.getText().equals(seventhBox.getText())&& !seventhBox.getText().equals("")){
                desginOfLetsPlayClass.get_Game_Ends(1);
                return true;
                }
        if(secondBox.getText().equals(fithBox.getText()) && fithBox.getText().equals(eigthBox.getText())&& !eigthBox.getText().equals("")){
                desginOfLetsPlayClass.get_Game_Ends(2);
                return true;
                }
        if(thirdBox.getText().equals(sixthBox.getText()) && sixthBox.getText().equals(ninthBox.getText())&& !ninthBox.getText().equals("")){
                desginOfLetsPlayClass.get_Game_Ends(3);
                return true;
                }
        if(firstBox.getText().equals(fithBox.getText()) && fithBox.getText().equals(ninthBox.getText())&& !ninthBox.getText().equals("")){
                desginOfLetsPlayClass.get_Game_Ends(7);
                return true;
                }
        if(thirdBox.getText().equals(fithBox.getText()) && fithBox.getText().equals(seventhBox.getText())&& !seventhBox.getText().equals("")){
                desginOfLetsPlayClass.get_Game_Ends(8);
                return true;
                }
        if(!firstBox.getText().equals("") && !secondBox.getText().equals("")&& !thirdBox.getText().equals("")&& !fouthBox.getText().equals("")
                && !fithBox.getText().equals("")&& !sixthBox.getText().equals("")&& !seventhBox.getText().equals("")&& !eigthBox.getText().equals("")
                && !ninthBox.getText().equals("")) {
                chance = 0;
            which_Player_Chance=0;
                return true;

        }
        return false;
    }
    public void ContinueGame(){
        firstBox.setText("");
        secondBox.setText("");
        thirdBox.setText("");
        fouthBox.setText("");
        fithBox.setText("");
        sixthBox.setText("");
        seventhBox.setText("");
        eigthBox.setText("");
        ninthBox.setText("");

        desginOfLetsPlayClass.setGame_End(false);
        desginOfLetsPlayClass.invalidate();

        the_Game_Begins = false;
        Whose_Chance_Come_First();
        Get_To_Know_Whose_Chance_First();
        dont_Touch_The_Board=false;
    }
    public void Get_To_Know_Whose_Chance_First()
    {
        if (which_Player_Chance == 1) {
            MainWindoInfo.setText(firstPlayerName+" Chance");
            which_Player_Chance = 1;
            value_Showing.setTextColor(Color.parseColor("#e8001c"));
            value_Showing.setText("( X )");
        } else {
            MainWindoInfo.setText(secondPlayerName+" Chance");
            which_Player_Chance = 2;
            value_Showing.setTextColor(Color.parseColor("#0881d8"));
            value_Showing.setText("( O )");
        }
            chance=1;

    }
    public void Whose_Chance_Come_First(){
        if(first_Move_First_Player) {
            first_Move_First_Player = false;
            which_Player_Chance = 2;
        }
        else{
            first_Move_First_Player=true;
            which_Player_Chance=1;
        }
    }
    public void Toast_It(int resource , String text){

        image_In_Toast.setImageResource(resource);
        text_In_Toast.setText(text);
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }
    public void new_Thread_For_Toast(final int resource, final String message ){
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(sound_On)
                mediaPlayer.start();
                Toast_It(resource , message);
                new_Thread_For_Continue();
            }
        },1300);
    }
    public void new_Thread_For_Continue( ){
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                ContinueGame();
            }
        },1800);
    }
}

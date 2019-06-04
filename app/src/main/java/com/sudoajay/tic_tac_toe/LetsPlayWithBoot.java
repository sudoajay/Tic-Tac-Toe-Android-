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

import java.util.Random;

public class LetsPlayWithBoot extends AppCompatActivity  implements View.OnClickListener  {
    private ImageButton newGameButton , menuButton;
    private ImageView image_In_Toast;
    private TextView firstBox , secondBox , thirdBox, fouthBox,fithBox,sixthBox,seventhBox
            , eigthBox ,ninthBox,MainWindoInfo,player1Score,player2Score,drawScore,text_In_Toast,
            player_Name_Set;
    private boolean player_Turn= true,firstWay=true , boot_Turn, chance_Left = true
            ,game_End,the_Game_Begins,sound_On; ;
    private int player1 , player2 , draw ;
    private Random random = new Random();
    private String player_Name  , whose_Chance;
    private View layout ;
    private final Handler handler = new Handler();
    private DesginOfLetsPlayClass desginOfLetsPlayClass;
    private final Context context = this;
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lets_play_with_boot);
          refrence();
        if(!getIntent().getExtras().getString("com.example.sudoajay.tic_tac_toe.SinglePlayerName").toString()
                .equals("")){
            player_Name = getIntent().getExtras().getString("com.example.sudoajay.tic_tac_toe.SinglePlayerName").toString();
        }
        else{
            player_Name = "Human";
        }
        sound_On = getIntent().getBooleanExtra("Sound_Check_firstPlayerName",true);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT);

        player_Name_Set.setText(player_Name);
        whose_Chance = player_Name+" Chance";
        MainWindoInfo.setText(whose_Chance);

        LayoutInflater inflater = getLayoutInflater();
         layout = inflater.inflate(R.layout.activity_custom_toast,
                (ViewGroup) findViewById(R.id.toastcustom));

        image_In_Toast = (ImageView) layout.findViewById(R.id.image);
        text_In_Toast = (TextView) layout.findViewById(R.id.text);

        desginOfLetsPlayClass = (DesginOfLetsPlayClass) findViewById(R.id.desginOfLetsPlayClass);

        mediaPlayer= MediaPlayer.create(this,R.raw.sound);


    }
    public void refrence(){
        menuButton = (ImageButton) findViewById(R.id.menuButton);
        menuButton.setOnClickListener(new View.OnClickListener() {
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
                            Intent intent = new Intent(getApplicationContext(),TicTacToeLauncher.class);
                            startActivity(intent);
                        }
                    });
                    alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
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
                if(the_Game_Begins  || player1 != 0 || player2 != 0 || draw !=0 ){
                    AlertDialog.Builder alert = new AlertDialog.Builder(context);
                    alert.setTitle("Game Restart ?");
                    alert.setCancelable(false);
                    alert.setMessage("Are You Sure To Leave");
                    alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(getApplicationContext(),singlePlayerInfo.class);
                            startActivity(intent);
                        }
                    });
                    alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    alert.show();
                }else {
                    Intent intent = new Intent(getApplicationContext(),singlePlayerInfo.class);
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

        player_Name_Set = (TextView) findViewById(R.id.player_Name);
        player1Score =(TextView) findViewById(R.id.player1Score);
        player2Score =(TextView) findViewById(R.id.player2Score);
        drawScore =(TextView) findViewById(R.id.drawScore);



    }


    @Override
    public void onClick(View view) {
        if(player_Turn) {
            
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
            if(!player_Turn && !game_End ){
                the_Game_Begins  = true;
                whose_Chance = "Boot Chance";
                MainWindoInfo.setText(whose_Chance);
            }
        }
    }
    public void makeNumberLine( TextView v){

            v.setTextColor(Color.parseColor("#e8001c"));
            v.setText(" X");
            player_Turn = false;


        // check for  Human won
        if(CheckForWin()) {
            game_End = true;
            player_Turn = false;
            if(!chance_Left){
                draw++;
                drawScore.setText(""+draw);
                new_Thread_For_Toast(R.drawable.draw ," The Match is Draw" );
            }else{
                new_Thread_For_Toast(R.drawable.won ,player_Name+ " Won the Match" );
                player1++;
                player1Score.setText(""+player1);
            }
        }

        Boot_Move_Call();


    }
    public boolean CheckForWin() {

        if (firstBox.getText().equals(secondBox.getText()) && secondBox.getText().equals(thirdBox.getText()) && !thirdBox.getText().equals("")) {
            desginOfLetsPlayClass.get_Game_Ends(4);
            return true;
        }
        if (fouthBox.getText().equals(fithBox.getText()) && fithBox.getText().equals(sixthBox.getText()) && !sixthBox.getText().equals("")) {
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
            chance_Left = false;
            return true;

        }
        return false;
    }
    public void ContinueGame(){
        
        game_End = false;
        chance_Left = true;
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

        the_Game_Begins  = false;
        if(firstWay){
            Boot_Move_Call();
            firstWay=false;
        }
        else {
            whose_Chance = player_Name+" Chance";
            MainWindoInfo.setText(whose_Chance);
            player_Turn=true;
            firstWay=true;
        }

    }

    public void Boot_Move_Call(){
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Do something after 1000ms
                if(!player_Turn && !game_End) {
                    boot_Turn =true;
                    Boot_Move();
                    whose_Chance = player_Name+" Chance";
                    MainWindoInfo.setText(whose_Chance);
                    player_Turn = true;
                    if (CheckForWin()) {
                        game_End = true;
                        player_Turn = false;
                        boot_Turn = false;
                        if (!chance_Left) {
                            new_Thread_For_Toast(R.drawable.draw ," The Match is Draw" );
                            draw++;
                            drawScore.setText("" + draw);
                        } else {
                            new_Thread_For_Toast(R.drawable.lose ," Boot Won The Match" );
                            player2++;
                            player2Score.setText("" + player2);
                        }
                    }
                }

            }
        }, 1000);



    }

    void  Boot_Move() {
        // case 1: if there is a chance to win
        if (firstBox.getText().toString().equals("") &&
                ((secondBox.getText().toString().equals(" O")&& thirdBox.getText().toString().equals(" O")) ||
                (fouthBox.getText().toString().equals(" O") && seventhBox.getText().toString().equals(" O")) ||
                (fithBox.getText().toString().equals(" O") && ninthBox.getText().toString().equals(" O")))) {
            getOutput(firstBox);
           
        }
        else if (secondBox.getText().toString().equals("") &&
                ((firstBox.getText().toString().equals(" O")&& thirdBox.getText().toString().equals(" O")) ||
                        (fithBox.getText().toString().equals(" O") && eigthBox.getText().toString().equals(" O")))) {
            getOutput(secondBox);
            
        }
        else if (thirdBox.getText().toString().equals("")  &&
                ((firstBox.getText().toString().equals(" O") && secondBox.getText().toString().equals(" O")) ||
                        (sixthBox.getText().toString().equals(" O") && ninthBox.getText().toString().equals(" O")) ||
                        (fithBox.getText().toString().equals(" O") && seventhBox.getText().toString().equals(" O")))) {
            getOutput(thirdBox);
            
        }
        else if (fouthBox.getText().toString().equals("") &&
                ((firstBox.getText().toString().equals(" O") && seventhBox.getText().toString().equals(" O")) ||
                        (fithBox.getText().toString().equals(" O") && sixthBox.getText().toString().equals(" O")))) {
            getOutput(fouthBox);
            
        }
        else if (fithBox.getText().toString().equals("") &&
                ((fouthBox.getText().toString().equals(" O")  && sixthBox.getText().toString().equals(" O")) ||
                        (firstBox.getText().toString().equals(" O") && ninthBox.getText().toString().equals(" O")) ||
                        (thirdBox.getText().toString().equals(" O") && seventhBox.getText().toString().equals(" O")))) {
            getOutput(fithBox);
            
        }
        else if (sixthBox.getText().toString().equals("") &&
                ((fouthBox.getText().toString().equals(" O")  && fithBox.getText().toString().equals(" O")) ||
                        (thirdBox.getText().toString().equals(" O") && ninthBox.getText().toString().equals(" O")))) {
            getOutput(sixthBox);
          
        }
        else if (seventhBox.getText().toString().equals("") &&
                ((eigthBox.getText().toString().equals(" O") && ninthBox.getText().toString().equals(" O")) ||
                        (firstBox.getText().toString().equals(" O") && fouthBox.getText().toString().equals(" O")) ||
                        (thirdBox.getText().toString().equals(" O") && fithBox.getText().toString().equals(" O")))) {
            getOutput(seventhBox);
            
        }
        else if (eigthBox.getText().toString().equals("")&&
                ((seventhBox.getText().toString().equals(" O") && ninthBox.getText().toString().equals(" O")) ||
                        (secondBox.getText().toString().equals(" O") && fithBox.getText().toString().equals(" O")))) {
            getOutput(eigthBox);
            
        }
        else if (ninthBox.getText().toString().equals("")&&
                ((seventhBox.getText().toString().equals(" O") && eigthBox.getText().toString().equals(" O")) ||
                        (thirdBox.getText().toString().equals(" O") && sixthBox.getText().toString().equals(" O")) ||
                        (firstBox.getText().toString().equals(" O") && fithBox.getText().toString().equals(" O")))) {
            getOutput(ninthBox);
            
        }
        // case 2: if there is a chance to block
       else if (firstBox.getText().toString().equals("") &&
                ((secondBox.getText().toString().equals(" X")&& thirdBox.getText().toString().equals(" X")) ||
                        (fouthBox.getText().toString().equals(" X") && seventhBox.getText().toString().equals(" X")) ||
                        (fithBox.getText().toString().equals(" X") && ninthBox.getText().toString().equals(" X")))) {
            getOutput(firstBox);

        }
        else if (secondBox.getText().toString().equals("") &&
                ((firstBox.getText().toString().equals(" X")&& thirdBox.getText().toString().equals(" X")) ||
                        (fithBox.getText().toString().equals(" X") && eigthBox.getText().toString().equals(" X")))) {
            getOutput(secondBox);

        }
        else if (thirdBox.getText().toString().equals("")  &&
                ((firstBox.getText().toString().equals(" X") && secondBox.getText().toString().equals(" X")) ||
                        (sixthBox.getText().toString().equals(" X") && ninthBox.getText().toString().equals(" X")) ||
                        (fithBox.getText().toString().equals(" X") && seventhBox.getText().toString().equals(" X")))) {
            getOutput(thirdBox);
        }
        else if (fouthBox.getText().toString().equals("") &&
                ((firstBox.getText().toString().equals(" X") && seventhBox.getText().toString().equals(" X")) ||
                        (fithBox.getText().toString().equals(" X") && sixthBox.getText().toString().equals(" X")))) {
            getOutput(fouthBox);
        }
        else if (fithBox.getText().toString().equals("") &&
                ((fouthBox.getText().toString().equals(" X")  && sixthBox.getText().toString().equals(" X")) ||
                        (firstBox.getText().toString().equals(" X") && ninthBox.getText().toString().equals(" X")) ||
                        (thirdBox.getText().toString().equals(" X") && seventhBox.getText().toString().equals(" X")))) {
            getOutput(fithBox);
        }
        else if (sixthBox.getText().toString().equals("") &&
                ((fouthBox.getText().toString().equals(" X")  && fithBox.getText().toString().equals(" X")) ||
                        (thirdBox.getText().toString().equals(" X") && ninthBox.getText().toString().equals(" X")))) {
            getOutput(sixthBox);
        }
        else if (seventhBox.getText().toString().equals("") &&
                ((eigthBox.getText().toString().equals(" X") && ninthBox.getText().toString().equals(" X")) ||
                        (firstBox.getText().toString().equals(" X") && fouthBox.getText().toString().equals(" X")) ||
                        (thirdBox.getText().toString().equals(" X") && fithBox.getText().toString().equals(" X")))) {
            getOutput(seventhBox);
        }
        else if (eigthBox.getText().toString().equals("")&&
                ((seventhBox.getText().toString().equals(" X") && ninthBox.getText().toString().equals(" X")) ||
                        (secondBox.getText().toString().equals(" X") && fithBox.getText().toString().equals(" X")))) {
            getOutput(eigthBox);
        }
        else if (ninthBox.getText().toString().equals("")&&
                ((seventhBox.getText().toString().equals(" X") && eigthBox.getText().toString().equals(" X")) ||
                        (thirdBox.getText().toString().equals(" X") && sixthBox.getText().toString().equals(" X")) ||
                        (firstBox.getText().toString().equals(" X") && fithBox.getText().toString().equals(" X")))) {
            getOutput(ninthBox);
        }
        else{
            while(boot_Turn){
                switch (random.nextInt(15)+1){
                    // case 4: opposite corner
                    case 1 :
                          if (firstBox.getText().toString().equals("") &&
                            (seventhBox.getText().toString().equals(" X")  || thirdBox.getText().toString().equals(" X"))) {
                              getOutput(firstBox);
                    }
                        break;
                    case 2 :
                        if (thirdBox.getText().toString().equals("")&&
                                (firstBox.getText().toString().equals(" X")  || ninthBox.getText().toString().equals(" X"))) {
                            getOutput(thirdBox);
                        }
                        break;
                    case 3 :
                        if (ninthBox.getText().toString().equals("") &&
                                (thirdBox.getText().toString().equals(" X")  ||seventhBox.getText().toString().equals(" X"))) {
                            getOutput(ninthBox);
                        }
                        break;
                    case 4 :
                        if (seventhBox.getText().toString().equals("") &&
                                (firstBox.getText().toString().equals(" X") || ninthBox.getText().toString().equals(" X"))) {
                            getOutput(seventhBox);
                        }
                        break;
                    case 5 :
                        // case 5: corner
                        if (firstBox.getText().toString().equals("")) {
                            getOutput(firstBox);
                        }
                        break;
                    case 6 :
                        if (thirdBox.getText().toString().equals("")) {
                            getOutput(thirdBox);
                        }
                        break;
                    case 7 :
                        if (seventhBox.getText().toString().equals("")) {
                            getOutput(seventhBox);
                        }
                        break;
                    case 8 :
                        if (ninthBox.getText().toString().equals("")) {
                            getOutput(ninthBox);
                        }
                        break;
                    case 9 :
                        // case 6: non-Opposite side
                        if (secondBox.getText().toString().equals("")) {
                            getOutput(secondBox);
                        }
                        break;
                    case 10 :
                        if (fouthBox.getText().toString().equals("")) {
                            getOutput(fouthBox);
                        }
                        break;
                    case 11 :
                        if (sixthBox.getText().toString().equals("")) {
                            getOutput(sixthBox);
                        }
                        break;
                    case 12 :
                        if (eigthBox.getText().toString().equals("")) {
                            getOutput(eigthBox);
                        }
                        break;
                    default:
                        // case 3: center
                            if (fithBox.getText().toString().equals("")) {
                            getOutput(fithBox);
                    }
                        break;
                }
            }
        }
    }
    public void getOutput(TextView v){
            boot_Turn = false;
            v.setTextColor(Color.parseColor("#0881d8"));
            v.setText(" O");


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


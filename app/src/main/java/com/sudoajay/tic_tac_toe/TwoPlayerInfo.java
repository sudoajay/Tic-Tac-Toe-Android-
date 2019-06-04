package com.sudoajay.tic_tac_toe;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.sudoajay.tic_tac_toe.R;

public class TwoPlayerInfo extends AppCompatActivity {
    private Double_Data_Base double_data_base;
    private ImageButton backButton , readyButton;
    private EditText firstPlayerName,secondPlayerName;
    private String get_First_Player_Name,get_Second_Player_Name;
    private MediaPlayer mediaPlayer;
    private  boolean sound_On=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        double_data_base = new Double_Data_Base(this);
        if(double_data_base.check_For_Empty()){
            double_data_base.Fill_It("Human-1","Human-2");
        }
        Cursor res = double_data_base.Get_All_Data();
        res.moveToNext();
        get_First_Player_Name = res.getString(1);
        get_Second_Player_Name = res.getString(2);

        setContentView(R.layout.activity_two_player_info);

        sound_On = getIntent().getBooleanExtra("Sound_Info_TwoPlayerInfo",true);
        mediaPlayer= MediaPlayer.create(this,R.raw.sound);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT);

        firstPlayerName =(EditText) findViewById(R.id.firstPlayerName);
        secondPlayerName =(EditText)findViewById(R.id.secondPlayerName);

        firstPlayerName.setText(get_First_Player_Name);
        secondPlayerName.setText(get_Second_Player_Name);
        backButton = (ImageButton) findViewById(R.id.back_Button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sound_On)
                mediaPlayer.start();
                Intent PlayGameOptionintent = new Intent(getApplicationContext(),TicTacToeLauncher.class);
                startActivity(PlayGameOptionintent);
            }
        });
        readyButton = (ImageButton) findViewById(R.id.go_Button);
        readyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sound_On)
                mediaPlayer.start();
                Intent intent = new Intent(getApplicationContext(),LetsPlay.class);
                intent.putExtra("com.example.sudoajay.tic_tac_toe.FirstPlayerName" ,firstPlayerName.getText().toString() );
                intent.putExtra("com.example.sudoajay.tic_tac_toe.SecondPlayerName" ,secondPlayerName.getText().toString() );
                intent.putExtra("Sound_Check_SecondPlayerName",sound_On);
                double_data_base.Update_The_Table("1",firstPlayerName.getText().toString() , secondPlayerName.getText().toString());
                startActivity(intent);
            }
        });

    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), TicTacToeLauncher.class);
        startActivity(intent);
    }
}

package com.sudoajay.tic_tac_toe;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.sudoajay.tic_tac_toe.R;

public class singlePlayerInfo extends AppCompatActivity {

    private ImageButton backButton , go_Button;
    private EditText firstPlayerName;
    private Single_Data_Base single_data_base;
    private String get_Save_Name;
    private MediaPlayer mediaPlayer;
    private boolean sound_On = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        single_data_base = new Single_Data_Base(this);
        if(single_data_base.check_For_Empty()){
            single_data_base.Fill_It("Human","Boot");
        }
        Cursor res = single_data_base.Get_All_Data();
        res.moveToNext();
        get_Save_Name = res.getString(1);

        setContentView(R.layout.activity_single_player_info);

        sound_On = getIntent().getBooleanExtra("Sound_Info_singlePlayerInfo",true);
        mediaPlayer= MediaPlayer.create(this,R.raw.sound);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT);

        firstPlayerName =(EditText) findViewById(R.id.firstPlayerName);
        backButton = (ImageButton) findViewById(R.id.backButton);

        firstPlayerName.setText(get_Save_Name);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sound_On)
                mediaPlayer.start();
                Intent PlayGameOptionintent = new Intent(getApplicationContext(),TicTacToeLauncher.class);
                startActivity(PlayGameOptionintent);
            }
        });
        go_Button = (ImageButton) findViewById(R.id.go_Button);
        go_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sound_On)
                mediaPlayer.start();
                Intent intent = new Intent(getApplicationContext(),LetsPlayWithBoot.class);
                intent.putExtra("com.example.sudoajay.tic_tac_toe.SinglePlayerName" ,firstPlayerName.getText().toString() );
                intent.putExtra("Sound_Check_firstPlayerName",sound_On);
                single_data_base.Update_The_Table("1",firstPlayerName.getText().toString() , "Boot");
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

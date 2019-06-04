package com.sudoajay.tic_tac_toe;


import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class TicTacToeLauncher extends AppCompatActivity {
    private TextView playOption,howToPlayOption,aboutButton ,single_Player,two_Player;
    private ImageButton rating_Image_Button;
    private float place_To_Move = 1000f;
    private long timing = 800l;
    private int height , width;
    private boolean doubleBackToExitPressedOnce , sound_On,one_Time = true;
    private MediaPlayer on_Click_Sound;
    private Switch sound_Switch;
    private sound_On_Database sound_on_database ;
    private final String link = "https://play.google.com/store/apps/details?id=com.sudoajay.tic_tac_toe&hl=en";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        sound_on_database = new sound_On_Database(this);
        if(sound_on_database.check_For_Empty()){
            Log.i("Check", " -- pass");
            sound_on_database.Fill_It("On");

            sound_On = true;
        }
            Cursor cursor = sound_on_database.Get_All_Data();
            cursor.moveToNext();
            if(cursor.getString(1).equalsIgnoreCase("on")){
                sound_On = true;
            }else {
                sound_On = false;
            }


        setContentView(R.layout.activity_tic_tac_toe_launcher);
        get_Values();
        single_Player = (TextView) findViewById(R.id.single_Player);
        two_Player = (TextView) findViewById(R.id.two_Player);
        playOption = (TextView) findViewById(R.id.playButton);
        howToPlayOption = (TextView) findViewById(R.id.howToPlayOption);
        aboutButton =(TextView) findViewById(R.id.aboutButton);
        rating_Image_Button = (ImageButton) findViewById(R.id.rating_Image_Button);

        single_Player.animate().translationXBy(width+800f);
        two_Player.animate().translationXBy(width+800f);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT);



        on_Click_Sound = MediaPlayer.create(this,R.raw.sound);
    }

    public void Clicking_Method (View view){
        if(sound_On)
        on_Click_Sound.start();
    if(one_Time) {
        int myColor = getResources().getColor(R.color.text_Color);
        single_Player.setTextColor(myColor);
        two_Player.setTextColor(myColor);
        one_Time = false;
    }
        switch (view.getId()){
            case R.id.playButton :
                if (playOption.getAlpha() == 1f) {
                    playOption.animate().alpha(0f).setDuration(1500l);
                    howToPlayOption.animate().translationXBy(-place_To_Move).setDuration(timing);
                    aboutButton.animate().translationXBy(-place_To_Move).setDuration(timing);
                    single_Player.animate().alpha(1f);
                    two_Player.animate().alpha(1f);
                    single_Player.animate().translationXBy(-(width + 680f)).setDuration(timing + timing + 100);
                    two_Player.animate().translationXBy(-(width + 680f)).setDuration(timing + timing + 100);
            }else {
                    Intent intent_Single_Player = new Intent(getApplicationContext() ,singlePlayerInfo.class);
                    intent_Single_Player.putExtra("Sound_Info_singlePlayerInfo",sound_On);
                    startActivity(intent_Single_Player);
                }
                break;
            case R.id.howToPlayOption :
                    Intent howToPlayIntent = new Intent(getApplicationContext() , HowToPlay.class);
                    startActivity(howToPlayIntent);
                break;
            case R.id.aboutButton :
                    Intent intent = new Intent(getApplicationContext() , AboutIt.class);
                    startActivity(intent);
                break;
            case R.id.two_Player :
                    Intent intent_Two_Player = new Intent(getApplicationContext(), TwoPlayerInfo.class);
                    intent_Two_Player.putExtra("Sound_Info_TwoPlayerInfo",sound_On);
                    startActivity(intent_Two_Player);
                break;
            case R.id.rating_Image_Button:
                Uri address = Uri.parse(link);
                Intent intent_address = new Intent(Intent.ACTION_VIEW,address);
                startActivity(intent_address);

                break;
            case R.id.setting_Buttons:
                Call_Custom_Dailog();
                break;

            case R.id.share_Button:
                Intent i=new Intent(android.content.Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(android.content.Intent.EXTRA_SUBJECT,"Link-Share");
                i.putExtra(android.content.Intent.EXTRA_TEXT, "Hey Check This Tic-Tac-Toe - " + link);
                startActivity(Intent.createChooser(i,"Share via"));
                break;

        }
    }
    public void get_Values(){
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
         height= displayMetrics.heightPixels;
         width = displayMetrics.widthPixels;
    }

    public void onBackPressed() {
        if( playOption.getAlpha() != 0f) {
            if (doubleBackToExitPressedOnce) {
                Finish();
                return;
            }

            this.doubleBackToExitPressedOnce = true;
            Toast.makeText(this, " Click Back Again To Exit", Toast.LENGTH_SHORT).show();

            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    doubleBackToExitPressedOnce = false;
                }
            }, 2000);
        }else {
         on_Back();
        }
    }
    public void Finish(){
        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
        homeIntent.addCategory( Intent.CATEGORY_HOME );
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(homeIntent);

    }
    public void on_Back(){
        single_Player.animate().translationXBy((width+680f)).setDuration(timing+200);
        two_Player.animate().translationXBy((width+680f)).setDuration(timing+200);
        playOption.animate().alpha(1f).setDuration(1500l);
        howToPlayOption.animate().translationXBy(+place_To_Move).setDuration(timing+300);
        aboutButton.animate().translationXBy(+place_To_Move).setDuration(timing+300);

    }

    public void Call_Custom_Dailog() {
        final Dialog dialog = new Dialog(this);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.activity_custom_dialog);
        TextView dialogButton = (TextView) dialog.findViewById(R.id.done_Sound);
        sound_Switch = (Switch) dialog.findViewById(R.id.sound_Switch);
        if (sound_On) {
            sound_Switch.setChecked(true);
        } else {
            sound_Switch.setChecked(false);
        }
        sound_Switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                sound_On = isChecked;
                if (isChecked) {
                    sound_on_database.Update_The_Table("1", "on");
                } else {
                    sound_on_database.Update_The_Table("1", "off");
                }
            }
        });
        // if button is clicked, close the custom dialog
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Toast.makeText(getApplicationContext(), "Setting Saved", Toast.LENGTH_SHORT).show();
            }
        });
        dialog.show();
    }

}

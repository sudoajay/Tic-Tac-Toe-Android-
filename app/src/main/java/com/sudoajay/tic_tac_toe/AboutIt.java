package com.sudoajay.tic_tac_toe;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.sudoajay.tic_tac_toe.R;

public class AboutIt extends AppCompatActivity {
    private TextView click_On_Me;
    private final String link = "https://www.quora.com/What-is-the-name-of-the-person-who-invented-Tic-Tac-Toe";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_it);

        click_On_Me = (TextView) findViewById(R.id.click_On_Me);
        click_On_Me.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT);

                Uri address = Uri.parse(link);
                Intent intent = new Intent(Intent.ACTION_VIEW,address);
                startActivity(intent);
            }
        });
    }
}

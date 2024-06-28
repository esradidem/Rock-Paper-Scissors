package com.example.gameproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity
{

    SharedPreferences sharedPreferences;
    String SHARED_PREFS_NAME = "my_shared_Pref";
    String userKey = "userKey";
    TextView textUsername;
    Button buttonStart;
    TextView textGameInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        sharedPreferences = getSharedPreferences(SHARED_PREFS_NAME, MODE_PRIVATE);

        textUsername = findViewById(R.id.textUsername);
        buttonStart = findViewById(R.id.buttonStart);
        textGameInfo = findViewById(R.id.textGameInfo);

        buttonStart.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity2.this, GameActivity.class);
                startActivity(intent);
            }
        });

        textUsername.setText(getResources().getString(R.string.welcomeUser) + " "+ getData(sharedPreferences) + " !" + " :)");
    }


    // Shared Preferences veriyi geri alma işlemi
    public String getData(SharedPreferences sharedPreferences1)
    {
        return sharedPreferences1.getString(userKey, "");
    }
}
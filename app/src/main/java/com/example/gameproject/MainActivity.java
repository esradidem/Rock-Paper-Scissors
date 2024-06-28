package com.example.gameproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    Button buttonNext;
    SharedPreferences sharedPreferences;
    String SHARED_PREFS_NAME = "my_shared_Pref";

    String userKey = "userKey";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonNext = findViewById(R.id.buttonNextXml);

        buttonNext.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                ControlUsername();
            }
        });
    }

    public void ControlUsername()
    {
        // Shared Preferences İşlemleri
        sharedPreferences = getSharedPreferences(SHARED_PREFS_NAME, MODE_PRIVATE);

        String username = sharedPreferences.getString(userKey, "");

        if (username.equals(""))
        {
            Intent intent = new Intent(MainActivity.this, SavingUserNameActivity.class);
            startActivity(intent);
        }
        else
        {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(intent);
        }

        //saveData(sharedPreferences, "Esra Didem"); // Bir defa kayıt etmiş olmak yeterli

        //String username = getData(sharedPreferences);
        //Toast.makeText(getApplicationContext(), username, Toast.LENGTH_LONG).show();
    }


}
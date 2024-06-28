package com.example.gameproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SavingUserNameActivity extends AppCompatActivity
{
    EditText editUsername;
    Button buttonSave;
    SharedPreferences sharedPreferences;
    String SHARED_PREFS_NAME = "my_shared_Pref";

    String userKey = "userKey";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saving_user_name);

        sharedPreferences = getSharedPreferences(SHARED_PREFS_NAME, MODE_PRIVATE);

        editUsername = findViewById(R.id.editUserName);
        buttonSave = findViewById(R.id.buttonSave);

        buttonSave.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (editUsername.getText().toString().equals(""))
                {
                    Toast.makeText(SavingUserNameActivity.this,
                            getResources().getString(R.string.fillUsername),
                            Toast.LENGTH_LONG).show();
                }
                else
                {
                    saveData(sharedPreferences, editUsername.getText().toString());

                    Intent intent = new Intent(SavingUserNameActivity.this, MainActivity2.class);
                    startActivity(intent);
                }
            }
        });
    }

    // Shared Preferences kayıt işlemi
    public void saveData(SharedPreferences sharedPreferences1, String userName)
    {
        SharedPreferences.Editor editor = sharedPreferences1.edit();
        editor.putString(userKey, userName);
        editor.apply();
    }
}
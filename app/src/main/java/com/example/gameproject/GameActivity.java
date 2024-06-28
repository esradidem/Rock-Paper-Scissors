package com.example.gameproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class GameActivity extends AppCompatActivity
{

    ImageView imageMrComputer;
    ImageView imageRock;
    ImageView imagePaper;
    ImageView imageScissors;

    View viewRock;
    View viewPaper;
    View viewScissors;

    private int[] images = {R.drawable.paper, R.drawable.rock, R.drawable.scissors};


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        imageMrComputer = findViewById(R.id.imageMrComputer);
        imageRock = findViewById(R.id.imageRock);
        imagePaper = findViewById(R.id.imagePaper);
        imageScissors = findViewById(R.id.imageScissors);
        viewRock = findViewById(R.id.viewRock);
        viewPaper = findViewById(R.id.viewPaper);
        viewScissors = findViewById(R.id.viewScissors);


        imageRock.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                viewRock.setVisibility(View.VISIBLE);
                viewPaper.setVisibility(View.GONE);
                viewScissors.setVisibility(View.GONE);

                showRandomImage();
            }
        });

        imagePaper.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                viewRock.setVisibility(View.GONE);
                viewPaper.setVisibility(View.VISIBLE);
                viewScissors.setVisibility(View.GONE);

                showRandomImage();
            }
        });

        imageScissors.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                viewRock.setVisibility(View.GONE);
                viewPaper.setVisibility(View.GONE);
                viewScissors.setVisibility(View.VISIBLE);

                showRandomImage();
            }
        });

    }

    private void showRandomImage()
    {
        Random randomImage = new Random();
        int randomImageIndex = randomImage.nextInt(images.length);
        imageMrComputer.setImageResource(images[randomImageIndex]);

    }
}
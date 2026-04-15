package com.example.progressbartypes;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ProgressBar horizontalProgress;
        Button btnIncrease;
        int progress = 0;
        horizontalProgress = findViewById(R.id.horizontalProgress);
        btnIncrease = findViewById(R.id.btnIncrease);

        btnIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progress += 10;
                if (progress > 100) progress = 100;
                horizontalProgress.setProgress(progress);
            }
        });
    }
}
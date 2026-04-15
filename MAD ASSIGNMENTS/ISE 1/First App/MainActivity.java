package com.example.madise1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText name, roll, phone, dept;
        Button submit, view;
        ArrayList<String> records = new ArrayList<>();

        name = findViewById(R.id.name);
        roll = findViewById(R.id.roll);
        phone = findViewById(R.id.phone);
        dept = findViewById(R.id.dept);
        submit = findViewById(R.id.submit);
        view = findViewById(R.id.view);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = name.getText().toString() + "-" + phone.getText().toString();
                records.add(data);
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putStringArrayListExtra("records", records);
                i.setClassName("com.example.madisedisplay", "com.example.madisedisplay.MainActivity");
                startActivity(i);
            }
        });
    }
}
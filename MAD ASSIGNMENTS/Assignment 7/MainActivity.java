package com.example.inputcontrols;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RadioGroup genderGroup;
        CheckBox java, kotlin, cpp;
        Switch status;
        Spinner spinner;
        Button submit;
        TextView result;
        genderGroup = findViewById(R.id.genderGroup);
        java = findViewById(R.id.java);
        kotlin = findViewById(R.id.kotlin);
        cpp = findViewById(R.id.cpp);
        status = findViewById(R.id.status);
        spinner = findViewById(R.id.spinner);
        submit = findViewById(R.id.submit);
        result = findViewById(R.id.result);

        String[] sports = {"Cricket", "Football", "Hockey"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, sports);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String gender = "";
                int id = genderGroup.getCheckedRadioButtonId();
                if(id != -1){
                    RadioButton rb = findViewById(id);
                    gender = rb.getText().toString();
                }

                String courses = "";
                if(java.isChecked()) 
                    courses += "Java ";
                if(kotlin.isChecked()) 
                    courses += "Kotlin ";
                if(cpp.isChecked()) 
                    courses += "C++ ";

                String sport = spinner.getSelectedItem().toString();

                String accStatus = status.isChecked() ? "Active" : "Inactive";

                result.setText("Selected Choices : " + sport + ", " + gender + ", " + courses + "\nAccount Status : " + accStatus);
            }
        });
    }
}
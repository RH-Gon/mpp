package com.example.mpp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnList = (Button) findViewById(R.id.btnList);
        Button btnMonthly = (Button) findViewById(R.id.btnMonthly);
        Button btnWeekly = (Button) findViewById(R.id.btnWeekly);

        btnList.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intentList = new Intent(getApplicationContext(), List.class);
                startActivity(intentList);
                finish();
            }
        });

        btnMonthly.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intentMonthly = new Intent(getApplicationContext(), Monthly.class);
                startActivity(intentMonthly);
                finish();
            }
        });

        btnWeekly.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intentWeekly = new Intent(getApplicationContext(), Weekly.class);
                startActivity(intentWeekly);
                finish();
            }
        });

    }
}



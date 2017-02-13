package com.example.austin.homework8_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class part2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part2);
        Bundle bundle = getIntent().getExtras();
        String name = getIntent().getStringExtra("name");
        TextView Day = (TextView) findViewById(R.id.name);
        String DayOut = String.valueOf(name);
        Day.setText(DayOut);
    }
}

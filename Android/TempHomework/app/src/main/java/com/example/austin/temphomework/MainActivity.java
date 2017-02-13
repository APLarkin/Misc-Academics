package com.example.austin.temphomework;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //Radios
                RadioButton button1 = (RadioButton) findViewById(R.id.celsius);
                RadioButton button2 = (RadioButton) findViewById(R.id.fahrenheit);
                //User input
                EditText temp1 = (EditText) findViewById(R.id.startTemp);
                double temp2 = Double.valueOf(temp1.getText().toString());
                BigDecimal temp3 = BigDecimal.valueOf(temp2);
                //Celsius -> Fahrenheit
                int signum = 0;
                if(button1.isChecked())
                {
                    temp3 = temp3.multiply(BigDecimal.valueOf(9));
                    temp3 = temp3.divide(BigDecimal.valueOf(5),2, RoundingMode.HALF_UP);
                    temp3 = temp3.add(BigDecimal.valueOf(32));
                    signum = temp3.signum();

                }
                if(button2.isChecked())
                {
                    temp3 = ((temp3.subtract(BigDecimal.valueOf(32))).multiply(BigDecimal.valueOf(5))).divide(BigDecimal.valueOf(9),2, RoundingMode.HALF_UP);
                    signum = temp3.signum();
                }
                if(signum >= 0) {
                    String temp4 = String.valueOf(temp3);
                    Context context = getApplicationContext();
                    Toast toast = Toast.makeText(context, temp4, Toast.LENGTH_LONG);
                    toast.show();
                }
                if(signum == -1) {
                    temp3 = temp3.abs();
                    String temp4 = "-"+String.valueOf(temp3);
                    Context context = getApplicationContext();
                    Toast toast = Toast.makeText(context, temp4, Toast.LENGTH_LONG);
                    toast.show();
                }
            }

        });
    }
}

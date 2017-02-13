package com.example.austin.lemonadestand;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class NewDay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_day);

        //Get vars from previous day
        final Bundle bundle = getIntent().getExtras();

        //day
        final int day = bundle.getInt("Day");
        //Budget
        final double budget = bundle.getDouble("NewBudget");

        //Weeathers
        ArrayList<String> Weathers = new ArrayList<String>();
        Weathers.add("Sunny");
        Weathers.add("Sweltering");
        Weathers.add("Rainy");
        Weathers.add("Freezing");
        Weathers.add("Snowing");
        Weathers.add("Overcast");

        double WeatherEffect = 1;
        //Get weather
        int randomNo = (int) (Math.random() * (6));
        if (Weathers.get(randomNo).equals("Sunny")) {
            WeatherEffect = 1.0;
        }
        if (Weathers.get(randomNo).equals("Sweltering")) {
            WeatherEffect = 2.0;
        }
        if (Weathers.get(randomNo).equals("Rainy")) {
            WeatherEffect = 0.75;
        }
        if (Weathers.get(randomNo).equals("Freezing")) {
            WeatherEffect = 0.25;
        }
        if (Weathers.get(randomNo).equals("Snowing")) {
            WeatherEffect = 0.1;
        }
        if (Weathers.get(randomNo).equals("Overcast")) {
            WeatherEffect = 0.85;
        }
        final double WeatherEffectFinal = WeatherEffect;
        //Add weather to screen
        TextView weather = (TextView) findViewById(R.id.weatherOut);
        weather.setText(Weathers.get(randomNo));

        //Add budget to screen
        TextView Budget = (TextView) findViewById(R.id.budget);
        String budgetOut = String.valueOf(budget);
        Budget.setText(budgetOut);

        //Add day to screen

        TextView Day = (TextView) findViewById(R.id.day);
        String dayOut = String.valueOf(day);
        Day.setText(dayOut);

        //Get button
        Button newDay = (Button) findViewById(R.id.startDay);
        newDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Get # of glasses
                EditText numGlasses1 = (EditText) findViewById(R.id.numGlasses);
                String numGlasses2 = numGlasses1.getText().toString();
                int numGlasses3;
                if(!numGlasses2.equals("")) {
                    numGlasses3 = new Integer(numGlasses2).intValue();
                }
                else
                {
                    numGlasses3 = 0;
                }
                //Cost of glasses
                double cost = (double) numGlasses3 * 0.5;
                //Get # of ads
                EditText numAds1 = (EditText) findViewById(R.id.numAds);
                String numAds2 = numAds1.getText().toString();
                int numAds3;
                if(!numAds2.equals("")) {
                    numAds3 = new Integer(numAds2).intValue();
                }
                else{
                    numAds3 = 0;
                }
                //Effect of ads
                int randomNo = (int) (1 + Math.random() * (5 - 1) + 1);
                int adEffects = 1 + (numAds3 * randomNo);
                //Cost of ads
                cost = cost + ((double) numAds3 * 5);
                //Net loss
                double spent = budget - cost;
                //Get price
                EditText glassPrice1 = (EditText) findViewById(R.id.glassPrice);
                double glassPrice2;
                if(!glassPrice1.equals("")) {
                    glassPrice2 = Double.valueOf(glassPrice1.getText().toString());
                }
                else{
                    glassPrice2 = 0;
                }
                //price effect
                double priceEffect = 1 / glassPrice2;
                int randomSales = (int) (Math.random() * (numGlasses3));
                double finalSales0 = Math.pow((double) randomSales, priceEffect);
                //Calc effects on sales
                double finalSales1 = finalSales0 * adEffects * WeatherEffectFinal;
                double finalSales2 = Math.floor(finalSales1);
                int finalSales = (int) finalSales2;
                if(finalSales > randomSales) {
                    finalSales = randomSales;
                }
                //Calculate sales
                double sumSales = (double) finalSales * glassPrice2;
                //Set up intent
                Intent intent = new Intent(NewDay.this, EndDay.class);
                //Send stuff
                intent.putExtra("weatherEffects", WeatherEffectFinal);
                intent.putExtra("numberOfGlasses", numGlasses3);
                intent.putExtra("priceOfGlass", glassPrice2);
                intent.putExtra("AmountSpent", spent);
                intent.putExtra("FinalSales", finalSales);
                intent.putExtra("SalesAmt", sumSales);
                startActivity(intent);
            }
        });
        //Get mainmenu
        Button mainmenu = (Button) findViewById(R.id.main);
        mainmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Set up intent
                Intent intent = new Intent(NewDay.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
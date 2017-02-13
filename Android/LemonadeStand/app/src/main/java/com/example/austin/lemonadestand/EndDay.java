package com.example.austin.lemonadestand;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EndDay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_day);

        //Get vars
        Bundle bundle = getIntent().getExtras();
        double remainingBudget = bundle.getDouble("AmountSpent");
        final double cashIn = bundle.getDouble("SalesAmt");
        final double cashOut = bundle.getDouble("loss");
        int glassesSold = bundle.getInt("FinalSales");
        int newDay = bundle.getInt("day");

        //Get new budget
        final double newBudget = remainingBudget + cashIn;

        //Get profit
        double profit = cashIn - cashOut;

        //Show day
        TextView Day = (TextView) findViewById(R.id.day);
        String DayOut = String.valueOf(newDay);
        Day.setText(DayOut);

        //Iterate day
        final int newDay2 = newDay + 1;

        //Show glasses sold
        TextView Sold = (TextView) findViewById(R.id.sold);
        String SoldOut = String.valueOf(glassesSold);
        Sold.setText(SoldOut);
        //Show profit
        TextView Profit = (TextView) findViewById(R.id.profit);
        String ProfitOut = String.valueOf(profit);
        Profit.setText(ProfitOut);
        //Show new budget
        TextView Budget = (TextView) findViewById(R.id.newbudget);
        String BudgetOut = String.valueOf(newBudget);
        Budget.setText(BudgetOut);

        //Get button
        Button nextDay = (Button) findViewById(R.id.button);
        nextDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Set up intent
                if(newBudget>5) {
                    Intent intent = new Intent(EndDay.this, NewDay.class);
                    //Add vars needed
                    intent.putExtra("Day", newDay2);
                    intent.putExtra("NewBudget", newBudget);
                    startActivity(intent);
                }
                else{
                    Intent intent = new Intent(EndDay.this, fail.class);
                    startActivity(intent);
                }
            }
        });
        //Get mainmenu
        Button mainmenu = (Button) findViewById(R.id.main);
        mainmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Set up intent
                Intent intent = new Intent(EndDay.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}

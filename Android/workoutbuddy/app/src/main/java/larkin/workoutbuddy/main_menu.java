package larkin.workoutbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class main_menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }
    //Go to BMR calculator
    public void bmr_go(View view)
    {
        Intent intent = new Intent(main_menu.this, bmr_calculator.class);
        startActivity(intent);
    }
    //Go to stopwatch
    //public void stopwatch_go(View view)
    //{
    //    Intent intent = new Intent(main_menu.this, bmr_calculator.class);
    //    startActivity(intent);
    //}
    //Go to workout burn rate
    public void workout_go(View view)
    {
        Intent intent = new Intent(main_menu.this, bmr_calculator.class);
        startActivity(intent);
    }

    //Options
   // public void options(View view)
    //{
    //    Intent intent = new Intent(main_menu.this,option_menu.class);
    //    startActivity(intent);
    //}

}

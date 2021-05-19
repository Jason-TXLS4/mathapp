package ca.echocreativeworks.mathapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    Button btn_select_addition, btn_select_subtraction, btn_select_division, btn_select_multiplication;
    Context context;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    TextView tv_date_time;
    Calendar cal;
    String date;
    SimpleDateFormat dateFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = getApplicationContext();
        sharedPref = getSharedPreferences("mathApp", Context.MODE_PRIVATE);

        btn_select_addition = findViewById(R.id.btn_select_addition);
        btn_select_subtraction = findViewById(R.id.btn_select_subtraction);
        btn_select_division = findViewById(R.id.btn_select_division);
        btn_select_multiplication = findViewById(R.id.btn_select_multiplication);
        tv_date_time = findViewById(R.id.tv_date_time);
        cal = Calendar.getInstance();
        dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        date = dateFormat.format(cal.getTime());
        tv_date_time.setText(date);


    }

    public void selectActivity(View view){
        // instantiate an editor
        editor = sharedPref.edit();
        if (btn_select_addition.equals(view)) {
            editor.putString("activitySelection", "add"); // set the key/value
            editor.commit();  // save the key/value
        } else if (btn_select_subtraction.equals(view)) {
            editor.putString("activitySelection", "sub"); // set the key/value
            editor.commit();  // save the key/value
        } else if (btn_select_division.equals(view)) {
            editor.putString("activitySelection", "div"); // set the key/value
            editor.commit();  // save the key/value
        } else if (btn_select_multiplication.equals(view)) {
            editor.putString("activitySelection", "mult"); // set the key/value
            editor.commit();  // save the key/value
        }
        Intent intent = new Intent(this, levelActivity.class);
        startActivity(intent);
    }


}
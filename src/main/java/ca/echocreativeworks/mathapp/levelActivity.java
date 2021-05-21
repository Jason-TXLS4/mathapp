package ca.echocreativeworks.mathapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class levelActivity extends AppCompatActivity {

    Context context;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    Button btn_level_1;
    Button btn_level_2;
    Button btn_level_3;
    Button btn_level_4;
    Button btn_level_5;
    Button btn_level_6;
    Button btn_level_7;
    Button btn_level_8;
    Button btn_level_9;
    Button btn_level_10;
    Button btn_level_11;
    Button btn_level_12;
    String text;
    TextView tv_date_time;
    Calendar cal;
    String date;
    SimpleDateFormat dateFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        context = getApplicationContext();
        sharedPref = getSharedPreferences("mathApp", Context.MODE_PRIVATE);

        btn_level_1 = findViewById(R.id.btn_level_1);
        btn_level_2 = findViewById(R.id.btn_num_2);
        btn_level_3 = findViewById(R.id.btn_decimal);
        btn_level_4 = findViewById(R.id.btn_num_4);
        btn_level_5 = findViewById(R.id.btn_num_5);
        btn_level_6 = findViewById(R.id.btn_num_6);
        btn_level_7 = findViewById(R.id.btn_num_7);
        btn_level_8 = findViewById(R.id.btn_num_8);
        btn_level_9 = findViewById(R.id.btn_num_9);
        btn_level_10 = findViewById(R.id.btn_num_10);
        btn_level_11 = findViewById(R.id.btn_num_11);
        btn_level_12 = findViewById(R.id.btn_num_12);
        tv_date_time = findViewById(R.id.tv_date_time);
        cal = Calendar.getInstance();
        dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        date = dateFormat.format(cal.getTime());
        tv_date_time.setText(date);

    }

    public void selectLevel(View view) {
        // instantiate an editor
        editor = sharedPref.edit();

        if (btn_level_1.equals(view)) {
            editor.putString("level", "1"); // set the key/value
            editor.commit();  // save the key/value
        } else if (btn_level_2.equals(view)) {
            editor.putString("level", "2"); // set the key/value
            editor.commit();  // save the key/value
        } else if (btn_level_3.equals(view)) {
            editor.putString("level", "3"); // set the key/value
            editor.commit();  // save the key/value
        } else if (btn_level_4.equals(view)) {
            editor.putString("level", "4"); // set the key/value
            editor.commit();  // save the key/value
        } else if (btn_level_5.equals(view)) {
            editor.putString("level", "5"); // set the key/value
            editor.commit();  // save the key/value
        } else if (btn_level_6.equals(view)) {
            editor.putString("level", "6"); // set the key/value
            editor.commit();  // save the key/value
        } else if (btn_level_7.equals(view)) {
            editor.putString("level", "7"); // set the key/value
            editor.commit();  // save the key/value
        } else if (btn_level_8.equals(view)) {
            editor.putString("level", "8"); // set the key/value
            editor.commit();  // save the key/value
        } else if (btn_level_9.equals(view)) {
            editor.putString("level", "9"); // set the key/value
            editor.commit();  // save the key/value
        } else if (btn_level_10.equals(view)) {
            editor.putString("level", "10"); // set the key/value
            editor.commit();  // save the key/value
        } else if (btn_level_11.equals(view)) {
            editor.putString("level", "11"); // set the key/value
            editor.commit();  // save the key/value
        } else if (btn_level_12.equals(view)) {
            editor.putString("level", "12"); // set the key/value
            editor.commit();  // save the key/value
        }
//        text = sharedPref.getString("activitySelection", "fail") + " " + sharedPref.getString("level", "fail");
//        Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
//        toast.show();

        Intent intent = new Intent(this, equationsActivity.class);
        startActivity(intent);
    }
}
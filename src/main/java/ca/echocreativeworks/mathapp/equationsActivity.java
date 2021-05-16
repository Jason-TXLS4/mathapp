package ca.echocreativeworks.mathapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;

public class equationsActivity extends AppCompatActivity {


    Context context;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    Button btn_num_0;
    Button btn_num_1;
    Button btn_num_2;
    Button btn_num_3;
    Button btn_num_4;
    Button btn_num_5;
    Button btn_num_6;
    Button btn_num_7;
    Button btn_num_8;
    Button btn_num_9;
    Button btn_num_point;
    int high;
    int low;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equations);

        context = getApplicationContext();
        sharedPref = getSharedPreferences("mathApp", Context.MODE_PRIVATE);

    }
}
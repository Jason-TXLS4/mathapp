package ca.echocreativeworks.mathapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_select_addition, btn_select_subtraction, btn_select_division, btn_select_multiplication;
    Context context;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;

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
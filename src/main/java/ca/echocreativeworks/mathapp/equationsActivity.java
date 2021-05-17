package ca.echocreativeworks.mathapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class equationsActivity extends AppCompatActivity {

    Random rand;
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
    int a;
    int b;
    double result;
    double response;
    TextView tv_eq;
    EditText et_response;
    int inputBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equations);

        inputBuilder = 0;
        rand = new Random();
        tv_eq = findViewById(R.id.tv_equation);
        et_response = findViewById(R.id.et_response);
        context = getApplicationContext();
        sharedPref = getSharedPreferences("mathApp", Context.MODE_PRIVATE);
        editor = sharedPref.edit();
        low = 0;

        if (sharedPref.getString("activitySelection", "0").equals("div")) {
            switch (Integer.parseInt(sharedPref.getString("level", "0"))) {
                case 1:
                    high = 10;
                    break;
                case 2:
                    high = 30;
                    break;
                case 3:
                    high = 60;
                    break;
                case 4:
                    high = 90;
                    break;
                case 5:
                    high = 120;
                    break;
                case 6:
                    high = 150;
                    break;
                case 7:
                    high = 180;
                    break;
                case 8:
                    high = 210;
                    break;
                case 9:
                    high = 240;
                    break;

            }
        } else {
            switch (Integer.parseInt(sharedPref.getString("level", "0"))){
                case 1:
                    high = 1;
                    break;
                case 2:
                    high = 2;
                    break;
                case 3:
                    high = 3;
                    break;
                case 4:
                    high = 4;
                    break;
                case 5:
                    high = 5;
                    break;
                case 6:
                    high = 6;
                    break;
                case 7:
                    high = 7;
                    break;
                case 8:
                    high = 8;
                    break;
                case 9:
                    high = 9;
                    break;
            }//end swtich
        }//end if
        makeAddition();
    }//end onCreate

    private void etBuild(EditText e, CharSequence c){
        e.append(c);
    }
    private void etClear(EditText e){
        e.setText("");
    }
    public void input_9 (View view){
        etBuild(et_response, "9");
    }
    public void input_8 (View view){
        etBuild(et_response, "8");
    }
    public void input_7 (View view){
        etBuild(et_response, "7");
    }
    public void input_6 (View view){
        etBuild(et_response, "6");
    }
    public void input_5 (View view){
        etBuild(et_response, "5");
    }
    public void input_4 (View view){
        etBuild(et_response, "4");
    }
    public void input_3 (View view){
        etBuild(et_response, "3");
    }
    public void input_2 (View view){
        etBuild(et_response, "2");
    }
    public void input_1 (View view){
        etBuild(et_response, "1");
    }
    public void input_0 (View view){
        etBuild(et_response, "0");
    }
    public void input_decimal (View view){
        etBuild(et_response, ".");
    }
    public void input_enter (View view){
        checkResponse();
    }
    public void input_clear (View view){
        etClear(et_response);
    }


    private void makeAddition() {

        a = rand.nextInt(high + 1);
        b = rand.nextInt(high + 1);
        result = a + b;
        tv_eq.setText(String.valueOf(a) + " + " + String.valueOf(b));
    }

    private void checkResponse(){
        //turn string into num
        response = Double.valueOf(et_response.getText().toString());
        //compare response to stored answer
        if(result == response){
            makeAddition();
            et_response.setText("");
        }else{
            etClear(et_response);
        }
    }

}
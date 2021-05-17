package ca.echocreativeworks.mathapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
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
    int correctCount;
    int incorrectCount;
    int high;
    int low;
    int a;
    int b;
    int c;
    double result;
    double response;
    TextView tv_eq;
    TextView tv_status;
    TextView tv_correctCount;
    TextView tv_incorrectCount;
    EditText et_response;
    int activityType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equations);

        rand = new Random();
        tv_eq = findViewById(R.id.tv_equation);
        tv_status = findViewById(R.id.tv_status);
        et_response = findViewById(R.id.et_response);
        context = getApplicationContext();
        sharedPref = getSharedPreferences("mathApp", Context.MODE_PRIVATE);
        editor = sharedPref.edit();
        low = 0;
        correctCount = 0;
        incorrectCount = 0;
        tv_correctCount = findViewById(R.id.tv_correctCount);
        tv_incorrectCount = findViewById(R.id.tv_incorrectCount);

        if(sharedPref.getString("activitySelection", "0").equals("add"))
            activityType = 1;
        else if(sharedPref.getString("activitySelection", "0").equals("sub"))
            activityType = 2;
        else if(sharedPref.getString("activitySelection", "0").equals("div"))
            activityType = 3;
        else if(sharedPref.getString("activitySelection", "0").equals("mult"))
            activityType = 4;

        if (sharedPref.getString("activitySelection", "0").equals("div")) {
            switch (Integer.parseInt(sharedPref.getString("level", "0"))) {
                case 1:
                    high = 2;
                    break;
                case 2:
                    high = 4;
                    break;
                case 3:
                    high = 6;
                    break;
                case 4:
                    high = 8;
                    break;
                case 5:
                    high = 10;
                    break;
                case 6:
                    high = 12;
                    break;
                case 7:
                    high = 13;
                    break;
                case 8:
                    high = 14;
                    break;
                case 9:
                    high = 15;
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
        makeEquation();
    }//end onCreate



    public void input_9 (View view){
        et_response.append("9");
    }
    public void input_8 (View view){
        et_response.append("8");
    }
    public void input_7 (View view){
        et_response.append("7");
    }
    public void input_6 (View view){
        et_response.append("6");
    }
    public void input_5 (View view){
        et_response.append("5");
    }
    public void input_4 (View view){
        et_response.append("4");
    }
    public void input_3 (View view){
        et_response.append("3");
    }
    public void input_2 (View view){
        et_response.append("2");
    }
    public void input_1 (View view){
        et_response.append("1");
    }
    public void input_0 (View view){
        et_response.append("0");
    }
    public void input_decimal (View view){
        if(et_response.getText().toString().equals(""))
            et_response.append("0.");
        else
            et_response.append(".");
    }
    public void input_enter (View view){
        if(!et_response.getText().toString().equals(""))
        checkResponse();
    }
    public void input_clear (View view){
        et_response.setText("");;
    }
    public void input_negative(View view){
        if(et_response.getText().toString().equals(""))
           et_response.setText("-");
    }


    private void makeEquation(){
          switch(activityType){
              case 1:
                  makeAddition();
                  break;
              case 2:
                  makeSubtraction();
                  break;
              case 3:
                  makeDivision();
                  break;
              case 4:
                  makeMultiplication();
                  break;
        }
    }

    private void makeAddition() {
        a = rand.nextInt(high + 1);
        b = rand.nextInt(high + 1);
        result = a + b;
        tv_eq.setText(String.valueOf(a) + " + " + String.valueOf(b));
    }
    private void makeSubtraction(){
        a = rand.nextInt(high + 1);
        b = rand.nextInt(high + 1);
        result = a - b;
        tv_eq.setText(String.valueOf(a) + " - " + String.valueOf(b));
        }
    private void makeMultiplication(){
        a = rand.nextInt(high + 1);
        b = rand.nextInt(high + 1);
        result = a * b;
        tv_eq.setText(String.valueOf(a) + " x " + String.valueOf(b));
    }
    private void makeDivision(){
        a = rand.nextInt(high) + 1;
        b = rand.nextInt(high) + 1;
        c = a * b;
        result = a ;
        tv_eq.setText(String.valueOf(c) + " / " + String.valueOf(b));
    }

    private void checkResponse(){
        //turn string into num
        response = Double.valueOf(et_response.getText().toString());
        //compare response to stored answer
        if(result == response){
            correctCount++;
            tv_correctCount.setText(String.valueOf(correctCount));
            tv_status.setTextColor(Color.GREEN);
            tv_status.setText("Correct");
            tv_status.setVisibility(View.VISIBLE);
            tv_status.postDelayed(new Runnable() {
                    public void run() {
                        tv_status.setVisibility(View.INVISIBLE);
                    }
                }, 1200);
            makeEquation();
            et_response.setText("");
        }else{
            incorrectCount++;
            tv_incorrectCount.setText(String.valueOf(incorrectCount));
            et_response.setText("");
            tv_status.setTextColor(Color.RED);
            tv_status.setText("Incorrect. Try again.");
            tv_status.setVisibility(View.VISIBLE);
            tv_status.postDelayed(new Runnable() {
                 public void run() {
                    tv_status.setVisibility(View.INVISIBLE);
            }
        }, 1200);

        }
    }

}
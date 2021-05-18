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
import ca.echocreativeworks.mathapp.Equation;
import java.util.Collections;
import java.util.ArrayList;
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
    String symbol;
    EditText et_response;
    int activityType;
    ArrayList<Equation> list;

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
        low = 1;
        correctCount = 0;
        incorrectCount = 0;
        tv_correctCount = findViewById(R.id.tv_correctCount);
        tv_incorrectCount = findViewById(R.id.tv_incorrectCount);
        list = new ArrayList();


        if (sharedPref.getString("activitySelection", "0").equals("add")) {
            activityType = 1;
            symbol = " + ";
        } else if (sharedPref.getString("activitySelection", "0").equals("sub")) {
            activityType = 2;
            symbol = " - ";
        } else if (sharedPref.getString("activitySelection", "0").equals("div")){
            activityType = 3;
            symbol = " / ";
        }else if(sharedPref.getString("activitySelection", "0").equals("mult")) {
            activityType = 4;
            symbol = " x ";
        }

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
        fillList(activityType);
        presentEquation();
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


    private void fillList(int t) {
        //takes in the activity type
        switch (t) {
            case 1:
                for (int i = 1; i < high + 1; i++) {
                    for (int j = 1; j < high + 1; j++) {
                        Equation e = new Equation(i, j, i + j);
                        list.add(e);
                    }
                }
                break;
            case 2:
                for (int i = 1; i < high + 1; i++) {
                    for (int j = 1; j < high + 1; j++) {
                        Equation e = new Equation(i, j, i - j);
                        list.add(e);
                    }
                }
                break;
            case 3:
                int temp;
                for (int i = 1; i < high + 1; i++) {
                    for (int j = 1; j < high + 1; j++) {
                        if(i<j){
                            temp = i;
                            i = j;
                            j = temp;
                        }
                        Equation e = new Equation(i*j, i, j);
                        list.add(e);
                    }
                }
                break;
            case 4:
                for (int i = 2; i < 12 + 1; i++) {
                        Equation e = new Equation(high, i, i * high);
                        list.add(e);
                        list.add(e);
                }
                break;
        }//end switch
        Collections.shuffle(list);
    }//end fillList

    private void presentEquation(){
        if(list.size() != 0) {
            tv_eq.setText(String.valueOf(list.get(0).getA()) + symbol + String.valueOf(list.get(0).getB()));
            result = list.get(0).getR();
        }
    }

    private void checkResponse(){
        //turn string into num
        response = Double.valueOf(et_response.getText().toString());
        //compare response to stored answer
        if(result == response){
            list.remove(0);
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
            if(list.size() != 0) {
                presentEquation();
            }else{
                tv_eq.setText("Level Complete.");
            }
            et_response.setText("");
        }else{
            //iff wrong, add equation twice, preferably spaced
            if(list.size() > 3)
                list.add( 2, list.get(0));
            else
                list.add(list.get(0));
            if(list.size() > 5)
                list.add(4, list.get(0));
            else
                list.get(0);

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
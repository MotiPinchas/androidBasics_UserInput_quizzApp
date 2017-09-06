package com.example.android.quizzapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submit_quiz(View view) {
        double gradeResult_d = 0;
        int gradeResult = 0;

        // Calculate the result from all the questions
        gradeResult_d = 20 * question1Result();
        gradeResult_d += 20 * question2Result();
        gradeResult_d += 20 * question3Result();
        gradeResult_d += 20 * question4Result();
        gradeResult_d += 20 * question5Result();
        gradeResult = (int) gradeResult_d;
        showResult(gradeResult);

    }


    /*
    * ***** Check the result for question 1: ******
    * "Which of the following is Iraqi food? "
    * 1. Gren.., 2. Kuba.., 3. Rice.., 4. Pizza..
    *
    * @return result can be 1 for correct answer,0.5 or 0
    *
    * */

    private double question1Result() {

        CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        CheckBox checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
        CheckBox checkBox4 = (CheckBox) findViewById(R.id.checkBox4);

        if ((checkBox1.isChecked() == true) && (checkBox2.isChecked() == true) && (checkBox3.isChecked() == false) && (checkBox4.isChecked() == false)) {
            return 1.0;
        } else if ((checkBox1.isChecked() == true) && (checkBox2.isChecked() == false) && (checkBox3.isChecked() == false) && (checkBox4.isChecked() == false)) {
            return 0.5;
        } else if ((checkBox1.isChecked() == false) && (checkBox2.isChecked() == true) && (checkBox3.isChecked() == false) && (checkBox4.isChecked() == false)) {
            return 0.5;
        } else {
            return 0;
        }
    }

    /*
    * Question 2
    *
    * */

    private double question2Result() {

        // Create the object for every box. (In this case I dont have to check boxes 2,3)
        RadioButton radioBox1 = (RadioButton) findViewById(R.id.radio_box_1);
        RadioButton radioBox2 = (RadioButton) findViewById(R.id.radio_box_2);
        RadioButton radioBox3 = (RadioButton) findViewById(R.id.radio_box_3);

        if (radioBox1.isChecked()) {
            return 1;
        } else
            return 0;
    }

    /*
    * Question 3
    *
    * */

    private double question3Result() {
        String cityName;
        EditText cityResult = (EditText) findViewById(R.id.city_name_text);
        cityName = cityResult.getText().toString();
        if (cityName.equals("Ramat gan")) {
            return 1.0;
        } else {
            return 0;
        }
    }

        /*
    * Question 4
    *
    * */

    private double question4Result() {
        String hummusPrice;
        EditText hummusPriceResult = (EditText) findViewById(R.id.hummus_price);
        hummusPrice = hummusPriceResult.getText().toString();
        if (hummusPrice.equals("30")) {
            return 1.0;
        } else {
            return 0;
        }
    }


     /*
    * Question 5
    *
    * */

    private double question5Result() {
        String cityName;
        EditText cityResult = (EditText) findViewById(R.id.macdonalds_city_name);
        cityName = cityResult.getText().toString();
        if (cityName.equals("Ramat gan")) {
            return 1.0;
        } else {
            return 0;
        }
    }

        /*
    * Show the grade on the screen
    *In this section we will add the Toast view.
    *
    * */


    private void showResult(int grade) {
        TextView gradeResult = (TextView) findViewById(R.id.grade_result_text);
        gradeResult.setText("Your grade is: " + grade);
        // Toast - show the grade result in toast mode
        Toast.makeText(this, "Grade: " + grade,Toast.LENGTH_LONG ).show();
    }
}

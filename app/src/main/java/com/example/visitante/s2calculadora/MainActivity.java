package com.example.visitante.s2calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView resultados;
    private EditText pseudoinput;

    private String result = "";
    private String operand = "";
    private String operation;
    private String storedNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultados = findViewById(R.id.results);
        pseudoinput = findViewById(R.id.pseudoinput);

        resultados.setText(result);
        pseudoinput.setText(operand);
    }

    public void onClickNine(View view) {
        operand += '9';
        pseudoinput.setText(operand);
    }

    public void onClickEight(View view) {
        operand += '8';
        pseudoinput.setText(operand);
    }

    public void onClickSeven(View view) {
        operand += '7';
        pseudoinput.setText(operand);
    }

    public void onClickSix(View view) {
        operand += '6';
        pseudoinput.setText(operand);
    }

    public void onClickFive(View view) {
        operand += '5';
        pseudoinput.setText(operand);
    }

    public void onClickFour(View view) {
        operand += '4';
        pseudoinput.setText(operand);
    }

    public void onClickThree(View view) {
        operand += '3';
        pseudoinput.setText(operand);
    }

    public void onClickTwo(View view) {
        operand += '2';
        pseudoinput.setText(operand);
    }

    public void onClickOne(View view) {
        operand += '1';
        pseudoinput.setText(operand);
    }

    public void onClickCero(View view) {
        if(!operand.isEmpty()){
            operand += '0';
        }
        else {
            operand = "0";
        }
        pseudoinput.setText(operand);
    }

    public void onClickDot(View view) {
        operand += '.';
        pseudoinput.setText(operand);
    }

    public void onClickEquals(View view) {
        double a, b, c = 0;
        a = Double.parseDouble(storedNumber);
        b = Double.parseDouble(operand);
        switch (operation) {
            case "+":
                c = a + b;
                break;
            case "-":
                c = a - b;
                break;
            case "*":
                c = a * b;
                break;
            case "/":
                c = a / b;
                break;
        }
        result = String.valueOf(c);
        storedNumber = "";
        operand = "";
        pseudoinput.setText("");
        resultados.setText(result);
    }

    public void onClickMinus(View view) {
        storedNumber = operand;
        operand = "";
        operation = "-";
        pseudoinput.setText("");
    }

    public void onClickPlus(View view) {
        storedNumber = operand;
        operand = "";
        operation = "+";
        pseudoinput.setText("");
    }

    public void onClickDiv(View view) {
        storedNumber = operand;
        operand = "";
        operation = "/";
        pseudoinput.setText("");
    }

    public void onClickDel(View view) {
        operand = "";
        storedNumber = "";
        pseudoinput.setText("");
        resultados.setText("");
    }

    public void onClickBy(View view) {
        storedNumber = operand;
        operand = "";
        operation = "*";
        pseudoinput.setText("");
    }
}

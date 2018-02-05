package com.example.visitante.s2calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView resultados;
    private EditText pseudoinput;

    private String result = "";
    private String toShow = "";
    private String operation;
    private String storedNumber;
    int index;
    
    private ArrayList<String> numbersNoperations;
    
    public int operator(ArrayList<String> operations) {
        int acum = 0;
        int flag = 1;  // if flag = 1, add, else subtract
        for (String op: operations) {
            switch (op) {
                case "+":
                    flag = 1;
                    break;
                case "-":
                    flag = 0;
                    break;
                default:
                    if(flag == 1) {
                        acum += Integer.valueOf(op);
                    }
                    else {
                        acum -= Integer.valueOf(op);
                    }
                    break;
            }
        }
        return acum;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultados = findViewById(R.id.results);
        pseudoinput = findViewById(R.id.pseudoinput);

        resultados.setText(result);
        pseudoinput.setText(toShow);
        
        numbersNoperations = new ArrayList<>();
        numbersNoperations.add("");
        index = 0;
    }

    public void onClickNine(View view) {
        String currentNumber = numbersNoperations.remove(index);
        currentNumber += '9';
        numbersNoperations.add(index, currentNumber);
        toShow += '9';
        pseudoinput.setText(toShow);
    }

    public void onClickEight(View view) {
        String currentNumber = numbersNoperations.remove(index);
        currentNumber += '8';
        numbersNoperations.add(index, currentNumber);
        toShow += '8';
        pseudoinput.setText(toShow);
    }

    public void onClickSeven(View view) {
        String currentNumber = numbersNoperations.remove(index);
        currentNumber += '7';
        numbersNoperations.add(index, currentNumber);
        toShow += '7';
        pseudoinput.setText(toShow);
    }

    public void onClickSix(View view) {
        String currentNumber = numbersNoperations.remove(index);
        currentNumber += '6';
        numbersNoperations.add(index, currentNumber);
        toShow += '6';
        pseudoinput.setText(toShow);
    }

    public void onClickFive(View view) {
        String currentNumber = numbersNoperations.remove(index);
        currentNumber += '5';
        numbersNoperations.add(index, currentNumber);
        toShow += '5';
        pseudoinput.setText(toShow);
    }

    public void onClickFour(View view) {
        String currentNumber = numbersNoperations.remove(index);
        currentNumber += '4';
        numbersNoperations.add(index, currentNumber);
        toShow += '4';
        pseudoinput.setText(toShow);
    }

    public void onClickThree(View view) {
        String currentNumber = numbersNoperations.remove(index);
        currentNumber += '3';
        numbersNoperations.add(index, currentNumber);
        toShow += '3';
        pseudoinput.setText(toShow);
    }

    public void onClickTwo(View view) {
        String currentNumber = numbersNoperations.remove(index);
        currentNumber += '2';
        numbersNoperations.add(index, currentNumber);
        toShow += '2';
        pseudoinput.setText(toShow);
    }

    public void onClickOne(View view) {
        String currentNumber = numbersNoperations.remove(index);
        currentNumber += '1';
        numbersNoperations.add(index, currentNumber);
        toShow += '1';
        pseudoinput.setText(toShow);
    }

    public void onClickCero(View view) {
        if(!toShow.isEmpty()){
            String currentNumber = numbersNoperations.remove(index);
            currentNumber += '0';
            numbersNoperations.add(index, currentNumber);
            toShow += '0';
        }
        else {
            toShow = "0";
        }
        pseudoinput.setText(toShow);
    }

    public void onClickDot(View view) {
        toShow += '.';
        pseudoinput.setText(toShow);
    }

    public void onClickEquals(View view) {
        for (String op: numbersNoperations) {
            Log.d("TAGASO", op);
        }
        resultados.setText(operator(numbersNoperations) + "");
    }

    public void onClickMinus(View view) {
        numbersNoperations.add("-");
        index += 2;
        numbersNoperations.add("");
        toShow = toShow + "-";
        pseudoinput.setText(toShow);
    }

    public void onClickPlus(View view) {
        numbersNoperations.add("+");
        index += 2;
        toShow = toShow + "+";
        numbersNoperations.add("");
        pseudoinput.setText(toShow);
    }

    public void onClickDiv(View view) {
        storedNumber = toShow;
        toShow = "";
        operation = "/";
        pseudoinput.setText("");
    }

    public void onClickDel(View view) {
        numbersNoperations = new ArrayList<>();
        numbersNoperations.add("");
        index = 0;
        toShow = "";
        storedNumber = "";
        pseudoinput.setText("");
        resultados.setText("");
    }

    public void onClickBy(View view) {
        storedNumber = toShow;
        toShow = "";
        operation = "*";
        pseudoinput.setText("");
    }
}

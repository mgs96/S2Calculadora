package com.example.visitante.s2calculadora;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    private ArrayList<String> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        main = (LinearLayout) findViewById(R.id.main);
        count = 0;
        lista = getIntent().getStringArrayListExtra("param");
        generateLayout(lista);

        for (String element: lista) {
            Log.d("LayoutGeneratorLog",element);
        }

    }

    LinearLayout main;
    int count;

    private void generateLayout(final ArrayList<String> lista) {
        // creacion del layout
        LinearLayout newLayout = new LinearLayout(this);
        newLayout.setOrientation(LinearLayout.VERTICAL);
        for (String element: lista) {

            // creación y configuracion de filas
            LinearLayout row = new LinearLayout(this);
            row.setOrientation(LinearLayout.HORIZONTAL);
            int width = LinearLayout.LayoutParams.MATCH_PARENT;
            int height = LinearLayout.LayoutParams.WRAP_CONTENT;
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(width, height);

            // creación y configuración de los elementos
            final TextView tv = new TextView(this);
            tv.setTextSize(48);
            int elementWidth = 0;
            int elementHeight = LinearLayout.LayoutParams.WRAP_CONTENT;
            float elementWeight = 0.5f;
            LinearLayout.LayoutParams elementParams = new LinearLayout.LayoutParams(elementWidth, elementHeight, elementWeight);
            tv.setLayoutParams(elementParams);
            tv.setId(count);
            tv.setGravity(Gravity.CENTER);
            row.addView(tv);


            final Button bt = new Button(this);
            bt.setText("Editar");
            bt.setLayoutParams(elementParams);
            bt.setBackgroundResource(R.drawable.button_theme);
            bt.setTextColor(getResources().getColor(R.color.white, null));
            bt.setTag(count);
            row.addView(bt);

            // creación de los listeners
            bt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(view.getContext());
                    builder1.setTitle("Editar este elemento");
                    builder1.setCancelable(true);

                    final EditText input = new EditText(view.getContext());
                    int inputWidth = LinearLayout.LayoutParams.MATCH_PARENT;
                    int inputHeight = LinearLayout.LayoutParams.MATCH_PARENT;
                    LinearLayout.LayoutParams inputLayout = new LinearLayout.LayoutParams(inputWidth, inputHeight);
                    inputLayout.gravity = Gravity.CENTER_HORIZONTAL;
                    input.setLayoutParams(inputLayout);
                    input.setTextSize(TypedValue.COMPLEX_UNIT_SP, 48);
                    input.setText(lista.get((int) bt.getTag()));
                    input.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL | InputType.TYPE_NUMBER_FLAG_DECIMAL | InputType.TYPE_NUMBER_FLAG_SIGNED);
                    input.setSelection(input.getText().length());
                    builder1.setView(input);
                    builder1.setPositiveButton(
                            "Si",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    lista.remove((int) bt.getTag());
                                    lista.add((int) bt.getTag(), input.getText().toString());
                                    tv.setText(input.getText().toString());
                                    dialog.cancel();
                                }
                            });

                    builder1.setNegativeButton(
                            "No",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });

                    final AlertDialog alert11 = builder1.create();
                    alert11.setOnShowListener(new DialogInterface.OnShowListener() {
                        @Override
                        public void onShow(DialogInterface dialogInterface) {
                            //alert11.getButton(AlertDialog.BUTTON_POSITIVE).setBackgroundColor(getResources().getColor(R.color.colorPrimary, null));
                            alert11.getButton(AlertDialog.BUTTON_POSITIVE).setBackgroundResource(R.drawable.button_ok);
                            alert11.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(getResources().getColor(R.color.white, null));
                            alert11.getButton(AlertDialog.BUTTON_NEGATIVE).setBackgroundResource(R.drawable.button_cancel);
                            alert11.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(getResources().getColor(R.color.white, null));
                        }
                    });
                    alert11.show();
                }
            });

            tv.setText(element);

            newLayout.addView(row);
            count++;
        }
        LinearLayout row2 = new LinearLayout(this);

        Button bt2 = new Button(this);
        bt2.setText("Go Back");
        bt2.setBackgroundResource(R.drawable.button_theme);
        bt2.setTextColor(getResources().getColor(R.color.white, null));
        LinearLayout.LayoutParams lp2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        lp2.setMargins(8, 8, 8, 8);
        bt2.setLayoutParams(lp2);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = getIntent();
                i.putStringArrayListExtra("lista", lista);
                setResult(Activity.RESULT_OK, i);
                finish();
            }
        });

        row2.setOrientation(LinearLayout.HORIZONTAL);
        row2.addView(bt2);
        main.addView(newLayout);
        main.addView(row2);
    }

}

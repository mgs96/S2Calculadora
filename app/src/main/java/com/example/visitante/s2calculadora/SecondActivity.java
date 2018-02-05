package com.example.visitante.s2calculadora;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
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
        LinearLayout newLayout = new LinearLayout(this);
        newLayout.setOrientation(LinearLayout.VERTICAL);
        for (String element: lista) {
            LinearLayout row = new LinearLayout(this);
            row.setOrientation(LinearLayout.HORIZONTAL);

            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            final TextView tv = new TextView(this);
            tv.setTextSize(32);
            tv.setLayoutParams(lp);
            tv.setId(count);

            final Button bt = new Button(this);
            bt.setText("Editar");
            bt.setLayoutParams(lp);
            bt.setTag(count);

            bt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(view.getContext());
                    builder1.setMessage("Desea editar?");
                    builder1.setCancelable(true);

                    final EditText input = new EditText(view.getContext());
                    LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
                    input.setLayoutParams(lp);
                    input.setText(lista.get((int) bt.getTag()));
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

                    AlertDialog alert11 = builder1.create();
                    alert11.show();
                }
            });

            tv.setText(element);
            row.addView(tv);
            row.addView(bt);
            newLayout.addView(row);
            count++;
        }
        LinearLayout row2 = new LinearLayout(this);

        Button bt2 = new Button(this);
        bt2.setText("Go Back");
        LinearLayout.LayoutParams lp2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
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

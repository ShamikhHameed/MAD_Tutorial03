package com.example.intentsproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        final TextView num1Out = (TextView) findViewById(R.id.editTextNum1Out);
        final TextView num2Out = (TextView) findViewById(R.id.editTextNum2Out);
        final TextView output = (TextView) findViewById(R.id.textView);
        Button add = (Button) findViewById(R.id.btnAddition);
        Button sub = (Button) findViewById(R.id.btnSubtraction);
        Button mul = (Button) findViewById(R.id.btnMultiplication);
        Button div = (Button) findViewById(R.id.btnDivision);

        Intent intentOut = getIntent();

        final String str1Out = intentOut.getStringExtra("num1");
        final String str2Out = intentOut.getStringExtra("num2");

        final Integer outOne = Integer.parseInt(str1Out);
        final Integer outTwo = Integer.parseInt(str2Out);

        num1Out.setText(str1Out);
        num2Out.setText(str2Out);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String add = outOne + " + " + outTwo + " = " + (outOne+outTwo);
                output.setText(add);
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mul = outOne + " * " + outTwo + " = " + (outOne*outTwo);
                output.setText(mul);
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String div = outOne + " / " + outTwo + " = " + (outOne/outTwo);
                output.setText(div);
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sub = outOne + "- " + outTwo + " = " + (outOne-outTwo);
                output.setText(sub);
            }
        });
    }
}
package com.example.intentsproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button ok = (Button) findViewById(R.id.okButton);
        final EditText num1 = (EditText) findViewById(R.id.editTextNum1);
        final EditText num2 = (EditText) findViewById(R.id.editTextNum2);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toastOk = Toast.makeText(getApplicationContext(), "You clicked the OK button", Toast.LENGTH_SHORT);
                toastOk.setGravity(Gravity.TOP|Gravity.RIGHT,0,0);
                toastOk.show();

                String str1 = num1.getText().toString();
                String str2 = num2.getText().toString();

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("num1", str1);
                intent.putExtra("num2", str2);
                startActivity(intent);

                //custom toast
                //Creating the LayoutInflater instance
                LayoutInflater li = getLayoutInflater();
                //Getting the View object as defined in the customtoast.xml file
                View layout = li.inflate(R.layout.custom_toast, (ViewGroup)
                        findViewById(R.id.custom_toast_layout));
                //Creating the Toast object
                Toast toast = new Toast(getApplicationContext());
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast.setView(layout);//setting the view of custom toast layout
                toast.show();
            }
        });
    }
}
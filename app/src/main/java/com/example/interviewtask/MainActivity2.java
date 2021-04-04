package com.example.interviewtask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private TextView tvFinal;
    private Button btnIncrement;
    private Button btnDecrement;
    private Button done;


    private SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME="myPref";
    private static final String KEY_NAME="value";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



        tvFinal = (TextView) findViewById(R.id.tvFinal);
        btnIncrement = (Button) findViewById(R.id.btnIncrement);
        btnDecrement = (Button) findViewById(R.id.btnDecrement);
        done = (Button) findViewById(R.id.done);

        sharedPreferences=getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();


        btnIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data=sharedPreferences.getString(KEY_NAME,null);
                int data1=Integer.parseInt(data);
                data1+=1;
                editor.putString(KEY_NAME,Integer.toString(data1));
                editor.apply();
                tvFinal.setText(sharedPreferences.getString(KEY_NAME,null));
            }
        });

        btnDecrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data=sharedPreferences.getString(KEY_NAME,null);
                int data1=Integer.parseInt(data);
                data1-=1;
                editor.putString(KEY_NAME,Integer.toString(data1));
                editor.apply();
                tvFinal.setText(sharedPreferences.getString(KEY_NAME,null));
            }
        });

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        tvFinal.setText(sharedPreferences.getString(KEY_NAME,null));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
package com.example.interviewtask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  {

    private TextView tvDisplay;
    private Button nextActivity;


    private SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME="myPref";
    private static final String KEY_NAME="value";

    private String data="0";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDisplay = findViewById(R.id.tvDisplay);
        nextActivity =findViewById(R.id.nextActivity);



        nextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity2.class));
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onStart() {
        super.onStart();
        sharedPreferences= getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
        data=sharedPreferences.getString(KEY_NAME,null);
        tvDisplay.setText(data);

    }
}
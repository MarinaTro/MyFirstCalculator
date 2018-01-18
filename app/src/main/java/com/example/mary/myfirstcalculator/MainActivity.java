package com.example.mary.myfirstcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);



    }

    private void getNumSum(){
        int numOne = 1;
        int numTwo = 2;
        int numResult = numOne + numTwo;
    }
}

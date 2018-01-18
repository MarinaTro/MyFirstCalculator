package com.example.mary.myfirstcalculator;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editTextNumFirst, editTextNumSecond;
    Button btnPlus, btnMinus, btnMultiplication, btnDivision, btnRemove;
    TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        editTextNumFirst = (EditText) findViewById(R.id.editTextNumFirst);
        editTextNumSecond = (EditText) findViewById(R.id.editTextNumSecond);

        btnPlus = (Button) findViewById(R.id.btnPlus);
        btnMinus = (Button) findViewById(R.id.btnMinus);
        btnMultiplication = (Button) findViewById(R.id.btnMultiplication);
        btnDivision = (Button) findViewById(R.id.btnDivision);
        btnRemove = (Button) findViewById(R.id.btnRemoveAllData);
        textResult = (TextView) findViewById(R.id.textResults);

        btnPlus.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnMultiplication.setOnClickListener(this);
        btnDivision.setOnClickListener(this);
        btnRemove.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        float numResult = 0;

        if (TextUtils.isEmpty(editTextNumFirst.getText().toString())
                || (TextUtils.isEmpty(editTextNumSecond.getText().toString()))) {
            return;
        }

        float numFirst = Float.parseFloat(editTextNumFirst.getText().toString());
        float numSecond = Float.parseFloat(editTextNumSecond.getText().toString());

        switch (v.getId()) {
            case R.id.btnPlus:
                numResult = numFirst + numSecond;
                break;

            case R.id.btnMinus:
                numResult = numFirst - numSecond;
                break;

            case R.id.btnMultiplication:
                numResult = numFirst * numSecond;
                break;

            case R.id.btnDivision:
                numResult = numFirst / numSecond;
                if (numFirst == 0 || numSecond == 0) {
                    textResult.setText("На ноль делить нельзя!");
                    Toast.makeText(MainActivity.this, "На ноль делить нельзя!", Toast.LENGTH_SHORT).show();
                }
                break;
        }

        String numMessage = Float.toString(numResult);
        textResult.setText(numMessage);

        /*
         Handling the button actions to remove
         */

        switch (v.getId()) {
            case R.id.btnRemoveAllData:
                editTextNumFirst.setText("");
                editTextNumSecond.setText("");
                textResult.setText("");
                break;
        }

    }
}

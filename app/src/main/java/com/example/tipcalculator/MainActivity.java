package com.example.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText totalInputNum;
    EditText peopleNum;

    private double totalNum;
    private double total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        totalInputNum = findViewById(R.id.totalInputNum);
        peopleNum  = findViewById(R.id.peopleNum);


    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.tipAmount1:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.tipAmount2:
                if (checked)
                    // Ninjas rule
                    break;
            case R.id.tipAmount3:
                if (checked)
                    // Ninjas rule
                    break;
            case R.id.customTipAmount:
                if (checked)
                    // Ninjas rule
                    break;
        }
    }
}

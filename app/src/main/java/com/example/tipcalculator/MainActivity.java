package com.example.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText totalNumInput, peopleNumInput, customTipInput;

    TextView totalAmountText, totalTipAmountText, tipPerPersonText;

    boolean custom = false;
    double tip, totalNum, peopleNum, customTip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        totalNumInput = findViewById(R.id.totalInputNum);
        peopleNumInput = findViewById(R.id.peopleNum);
        customTipInput = findViewById(R.id.customTipNum);
        customTipInput.setEnabled(false);

        totalAmountText = findViewById(R.id.totalAmount);
        totalTipAmountText = findViewById(R.id.totalTipAmount);
        tipPerPersonText = findViewById(R.id.tipPerPerson);

        Button reset = findViewById(R.id.resetButton);
        Button calc = findViewById(R.id.calcButton);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetValues(v);
            }
        });


        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalNum = Double.parseDouble(totalNumInput.getText().toString());
                peopleNum = Double.parseDouble(peopleNumInput.getText().toString());
                if (custom) {
                    customTip = Double.parseDouble(customTipInput.getText().toString());
                    tip = customTip / 100.00;
                }
                calculate(totalNum, peopleNum, tip);
            }
        });

    }

    public void resetValues(View view) {
        totalNumInput.setText("");
        peopleNumInput.setText("");
        customTipInput.setText("");
        totalAmountText.setText(getResources().getString(R.string.total_amount));
        totalTipAmountText.setText(getResources().getString(R.string.total_tip_amount));
        tipPerPersonText.setText(getResources().getString(R.string.tip_per_person));
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.tipAmount1:
                if (checked)
                    tip = 0.10;
                customTipInput.setEnabled(false);
                break;
            case R.id.tipAmount2:
                if (checked)
                    tip = 0.15;
                customTipInput.setEnabled(false);
                break;
            case R.id.tipAmount3:
                if (checked)
                    tip = 0.20;
                customTipInput.setEnabled(false);
                break;
            case R.id.customTipText:
                if (checked)
                    custom = true;
                customTipInput.setEnabled(true);
                break;
        }
    }

    public void calculate(double totalNum, double peopleNum, double tip) {
        DecimalFormat df = new DecimalFormat("#.##");

        double totalAmount = totalNum + (totalNum * tip);
        double tipAmount = totalNum * tip;
        double tipPerPerson = (totalNum * tip) / peopleNum;

        String sdTotalAmount = getResources().getString(R.string.total_amount)
                + " $" + df.format(totalAmount);
        String sdTipAmount = getResources().getString(R.string.total_tip_amount)
                + " $" + df.format(tipAmount);
        String sdTipPerPerson = getResources().getString(R.string.tip_per_person)
                + " $" + df.format(tipPerPerson);

        totalAmountText.setText(sdTotalAmount);
        totalTipAmountText.setText(sdTipAmount);
        tipPerPersonText.setText(sdTipPerPerson);

    }
}


package com.example.sourabh.currencyconverterapp;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.convertButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText inputArea = (EditText) findViewById(R.id.inputArea);
                TextView resultArea = (TextView) findViewById(R.id.answerTextView);
                double resultCurrency = 0;
                String resultDenomination = "";
                RadioGroup initialCurrency = (RadioGroup)findViewById(R.id.radioGroup);
                RadioGroup finalCurrency = (RadioGroup)findViewById(R.id.radioGroup2);

                switch(initialCurrency.getCheckedRadioButtonId()){
                    case R.id.audRadio:
                        if(finalCurrency.getCheckedRadioButtonId()==R.id.usdRadio){
                            if(!inputArea.getText().toString().isEmpty())
                                resultCurrency = Double.parseDouble(inputArea.getText().toString())*0.746;//convert to usd
                            resultDenomination = "USD";
                        }else if(finalCurrency.getCheckedRadioButtonId()==R.id.gbpRadio){
                            if(!inputArea.getText().toString().isEmpty())
                                resultCurrency = Double.parseDouble(inputArea.getText().toString())*0.619;
                            resultDenomination = "GBP";//convert to gbp
                        }
                    break;
                    case R.id.cadRadio:
                        if(finalCurrency.getCheckedRadioButtonId()==R.id.usdRadio){
                            if(!inputArea.getText().toString().isEmpty())
                                resultCurrency = Double.parseDouble(inputArea.getText().toString())*0.757;//convert to usd
                            resultDenomination = "USD";
                        }else if(finalCurrency.getCheckedRadioButtonId()==R.id.gbpRadio){
                            if(!inputArea.getText().toString().isEmpty())
                                resultCurrency = Double.parseDouble(inputArea.getText().toString())*0.628;
                            resultDenomination = "GBP";//convert to gbp
                        }
                    break;
                    case R.id.inrRadio:
                        if(finalCurrency.getCheckedRadioButtonId()==R.id.usdRadio){
                            if(!inputArea.getText().toString().isEmpty())
                                resultCurrency = Double.parseDouble(inputArea.getText().toString())*0.0146;//convert to usd
                            resultDenomination = "USD";
                        }else if(finalCurrency.getCheckedRadioButtonId()==R.id.gbpRadio){
                            if(!inputArea.getText().toString().isEmpty())
                                resultCurrency = Double.parseDouble(inputArea.getText().toString())*0.0121;
                            resultDenomination = "GBP";//convert to gbp
                        }
                    break;
                }
                if(resultCurrency>0)
                    resultArea.setText(String.valueOf(resultCurrency)+" "+resultDenomination);
            }
        });

        findViewById(R.id.clearButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView resultArea = (TextView)findViewById(R.id.answerTextView);
                resultArea.setText("");
                EditText inputArea = (EditText)findViewById(R.id.inputArea);
                inputArea.setText("");
            }
        });

    }
}

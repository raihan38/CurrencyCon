package com.tofa.practice.currencycon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.layout.simple_spinner_item;

public class MainActivity extends AppCompatActivity implements
         AdapterView.OnItemSelectedListener {

    EditText amount;
    TextView result;
    Button convert,clear;
    Spinner fromSpinner,toSpinner;
    String fromCurrency, toCurrency;
    String stringAmount,stringResult;
    double Amount,Result;
    double aAmount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



            // The following two sentences for the ActionBar if the topic is the use of NoActionBar, use the following is a null pointer exception will be reported

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_main);

        amount = findViewById(R.id.amount);

        amount.setInputType(InputType.TYPE_CLASS_NUMBER);
        result = findViewById(R.id.result);
        convert = findViewById(R.id.convert);
        fromSpinner =findViewById(R.id.fromspinner);
        toSpinner =findViewById(R.id.tospinner);
        clear=findViewById(R.id.clear);



        fromCurrency="";
        toCurrency="";

        ArrayAdapter<CharSequence> fromadapter = ArrayAdapter.createFromResource(this,
                R.array.fromtocurrency, simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        fromadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        fromSpinner.setAdapter(fromadapter);
        fromSpinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);


        ArrayAdapter<CharSequence> toadapter = ArrayAdapter.createFromResource(this,
                R.array.fromtocurrency, simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        toadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        toSpinner.setAdapter(toadapter);
        toSpinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);


        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fromCurrency = fromSpinner.getSelectedItem().toString();
                toCurrency = toSpinner.getSelectedItem().toString();
                stringAmount = amount.getText().toString();


                if(fromCurrency.isEmpty()==false){
                    Log.e("fromC",fromCurrency+"value");

                }
                if(toCurrency.isEmpty()==false){
                    Log.e("fromC",toCurrency+"value");

                }
                if(stringAmount.isEmpty()==false){
                    Log.e("fromC",stringAmount+"value");

                }

               // Amount = ParseDouble(stringAmount);
                if (stringAmount.isEmpty()==false) {
                    try {

                        Amount = Double.parseDouble(stringAmount);
                        Log.e("fromC",Amount+"value");
                    } catch(Exception e) {
                        Log.e("fromC","error");


                    }
                }

                if (fromCurrency.equals("Bangladesh") && toCurrency.equals("China")) {
                    Result = Amount * 0.076;
                    amount.setText(stringAmount+" "+"BDT");
                    result.setText(Result + " "+"RMB");
                }
                else if(fromCurrency.equals("Bangladesh") && toCurrency.equals("Bangladesh")){
                    Result = Amount * 1;
                    amount.setText(stringAmount+" "+"BDT");
                    result.setText(Result + " BDT");
                }
                else if(fromCurrency.equals("Bangladesh") && toCurrency.equals("India")){
                    Result = Amount * 0.86;
                    amount.setText(stringAmount+" "+"BDT");
                    result.setText(Result + " INR");
                }
                else if(fromCurrency.equals("Bangladesh") && toCurrency.equals("England")){
                    Result = Amount * 0.0097;
                    amount.setText(stringAmount+" "+"BDT");
                    result.setText(Result + " EUR");
                }
                else if(fromCurrency.equals("Bangladesh") && toCurrency.equals("Japan")){
                    Result = Amount * 1.24;
                    amount.setText(stringAmount+" "+"BDT");
                    result.setText(Result + " YEN");
                }
                else if(fromCurrency.equals("Bangladesh") && toCurrency.equals("Australia")){
                    Result = Amount * 0.015;
                    amount.setText(stringAmount+" "+"BDT");
                    result.setText(Result + " AUD");
                }
                else if(fromCurrency.equals("Bangladesh") && toCurrency.equals("Canada")){
                    Result = Amount * 0.015;
                    amount.setText(stringAmount+" "+"BDT");
                    result.setText(Result + " CAD");
                }
                else if(fromCurrency.equals("Bangladesh") && toCurrency.equals("Serbia")){
                    Result = Amount * 1.14;
                    amount.setText(stringAmount+" "+"BDT");
                    result.setText(Result + " RSD");
                }

                //from RMB to all
                if (fromCurrency.equals("China") && toCurrency.equals("China")) {
                    Result = Amount * 1;
                    amount.setText(stringAmount+" "+"RMB");
                    result.setText(Result + " RMB");
                }
                else if(fromCurrency.equals("China") && toCurrency.equals("Bangladesh")){
                    Result = Amount * 13.13;
                    amount.setText(stringAmount+" "+"RMB");
                    result.setText(Result + " BDT");
                }
                else if(fromCurrency.equals("China") && toCurrency.equals("India")){
                    Result = Amount * 11.26;
                    amount.setText(stringAmount+" "+"RMB");
                    result.setText(Result + " INR");
                }
                else if(fromCurrency.equals("China") && toCurrency.equals("England")){
                    Result = Amount * 0.13;
                    amount.setText(stringAmount+" "+"RMB");
                    result.setText(Result + " EUR");
                }
                else if(fromCurrency.equals("China") && toCurrency.equals("Japan")){
                    Result = Amount * 16.22;
                    amount.setText(stringAmount+" "+"RMB");
                    result.setText(Result + " YEN");
                }
                else if(fromCurrency.equals("China") && toCurrency.equals("Australia")){
                    Result = Amount * 0.20;
                    amount.setText(stringAmount+" "+"RMB");
                    result.setText(Result + " AUD");
                }
                else if(fromCurrency.equals("China") && toCurrency.equals("Canada")){
                    Result = Amount * 0.20;
                    amount.setText(stringAmount+" "+"RMB");
                    result.setText(Result + " CAD");
                }
                else if(fromCurrency.equals("China") && toCurrency.equals("Serbia")){
                    Result = Amount * 15.01;
                    amount.setText(stringAmount+" "+"RMB");
                    result.setText(Result + " RSD");
                }

                //from inr to all
                if (fromCurrency.equals("India") && toCurrency.equals("China")) {
                    Result = Amount * 0.089;
                    amount.setText(stringAmount+" "+"INR");
                    result.setText(Result + " RMB");
                }
                else if(fromCurrency.equals("India") && toCurrency.equals("Bangladesh")){
                    Result = Amount * 1.17;
                    amount.setText(stringAmount+" "+"INR");
                    result.setText(Result + " BDT");
                }
                else if(fromCurrency.equals("India") && toCurrency.equals("India")){
                    Result = Amount * 1;
                    amount.setText(stringAmount+" "+"INR");
                    result.setText(Result + " INR");
                }
                else if(fromCurrency.equals("India") && toCurrency.equals("England")){
                    Result = Amount * 0.011;
                    amount.setText(stringAmount+" "+"INR");
                    result.setText(Result + " EUR");
                }
                else if(fromCurrency.equals("India") && toCurrency.equals("Japan")){
                    Result = Amount * 1.44;
                    amount.setText(stringAmount+" "+"INR");
                    result.setText(Result + " YEN");
                }
                else if(fromCurrency.equals("India") && toCurrency.equals("Australia")){
                    Result = Amount * 0.018;
                    amount.setText(stringAmount+" "+"INR");
                    result.setText(Result + " AUD");
                }
                else if(fromCurrency.equals("India") && toCurrency.equals("Canada")){
                    Result = Amount * 0.018;
                    amount.setText(stringAmount+" "+"INR");
                    result.setText(Result + " CAD");
                }
                else if(fromCurrency.equals("India") && toCurrency.equals("Serbia")){
                    Result = Amount * 1.33;
                    amount.setText(stringAmount+" "+"INR");
                    result.setText(Result + " RSD");
                }

                //from euro to all
                if (fromCurrency.equals("England") && toCurrency.equals("China")) {
                    Result = Amount * 7.84;
                    amount.setText(stringAmount+" "+"EUR");
                    result.setText(Result + " RMB");
                }
                else if(fromCurrency.equals("England") && toCurrency.equals("Bangladesh")){
                    Result = Amount * 102.86;
                    amount.setText(stringAmount+" "+"EUR");
                    result.setText(Result + " BDT");
                }
                else if(fromCurrency.equals("England") && toCurrency.equals("India")){
                    Result = Amount * 88.21;
                    amount.setText(stringAmount+" "+"EUR");
                    result.setText(Result + " INR");
                }
                else if(fromCurrency.equals("England") && toCurrency.equals("England")){
                    Result = Amount * 1;
                    amount.setText(stringAmount+" "+"EUR");
                    result.setText(Result + " EUR");
                }
                else if(fromCurrency.equals("England") && toCurrency.equals("Japan")){
                    Result = Amount * 127.07;
                    amount.setText(stringAmount+" "+"EUR");
                    result.setText(Result + " YEN");
                }
                else if(fromCurrency.equals("England") && toCurrency.equals("Australia")){
                    Result = Amount * 1.56;
                    amount.setText(stringAmount+" "+"EUR");
                    result.setText(Result + " AUD");
                }
                else if(fromCurrency.equals("England") && toCurrency.equals("Canada")){
                    Result = Amount * 1.54;
                    amount.setText(stringAmount+" "+"EUR");
                    result.setText(Result + " CAD");
                }
                else if(fromCurrency.equals("England") && toCurrency.equals("Serbia")){
                    Result = Amount * 117.59;
                    amount.setText(stringAmount+" "+"EUR");
                    result.setText(Result + " RSD");
                }


                //from yen to all
                if (fromCurrency.equals("Japan") && toCurrency.equals("China")) {
                    Result = Amount * 0.062;
                    amount.setText(stringAmount+" "+"YEN");
                    result.setText(Result + " RMB");
                }
                else if(fromCurrency.equals("Japan") && toCurrency.equals("Bangladesh")){
                    Result = Amount * 0.81;
                    amount.setText(stringAmount+" "+"YEN");
                    result.setText(Result + " BDT");
                }
                else if(fromCurrency.equals("Japan") && toCurrency.equals("India")){
                    Result = Amount * 0.69;
                    amount.setText(stringAmount+" "+"YEN");
                    result.setText(Result + " INR");
                }
                else if(fromCurrency.equals("Japan") && toCurrency.equals("England")){
                    Result = Amount * 0.0079;
                    amount.setText(stringAmount+" "+"YEN");
                    result.setText(Result + " EUR");
                }
                else if(fromCurrency.equals("Japan") && toCurrency.equals("Japan")){
                    Result = Amount * 1;
                    amount.setText(stringAmount+" "+"YEN");
                    result.setText(Result + " YEN");
                }
                else if(fromCurrency.equals("Japan") && toCurrency.equals("Australia")){
                    Result = Amount * 0.012;
                    amount.setText(stringAmount+" "+"YEN");
                    result.setText(Result + " AUD");
                }
                else if(fromCurrency.equals("Japan") && toCurrency.equals("Canada")){
                    Result = Amount * 0.012;

                    amount.setText(stringAmount+" "+"YEN");
                    result.setText(Result + " CAD");
                }
                else if(fromCurrency.equals("Japan") && toCurrency.equals("Serbia")){
                    Result = Amount * 0.93;
                    amount.setText(stringAmount+" "+"YEN");
                    result.setText(Result + " RSD");
                }
                //from aud to all
                if (fromCurrency.equals("Australia") && toCurrency.equals("China")) {
                    Result = Amount * 5.01;
                    amount.setText(stringAmount+" "+"AUD");
                    result.setText(Result + " RMB");
                }
                else if(fromCurrency.equals("Australia") && toCurrency.equals("Bangladesh")){
                    Result = Amount * 65.72;
                    amount.setText(stringAmount+" "+"AUD");
                    result.setText(Result + " BDT");
                }
                else if(fromCurrency.equals("Australia") && toCurrency.equals("India")){
                    Result = Amount * 56.40;
                    amount.setText(stringAmount+" "+"AUD");
                    result.setText(Result + " INR");
                }
                else if(fromCurrency.equals("Australia") && toCurrency.equals("England")){
                    Result = Amount * 0.64;
                    amount.setText(stringAmount+" "+"AUD");
                    result.setText(Result + " EUR");
                }
                else if(fromCurrency.equals("Australia") && toCurrency.equals("Japan")){
                    Result = Amount * 81.19;
                    amount.setText(stringAmount+" "+"AUD");
                    result.setText(Result + " YEN");
                }
                else if(fromCurrency.equals("Australia") && toCurrency.equals("Australia")){
                    Result = Amount * 1;
                    amount.setText(stringAmount+" "+"AUD");
                    result.setText(Result + " AUD");
                }
                else if(fromCurrency.equals("Australia") && toCurrency.equals("Canada")){
                    Result = Amount * 0.98;

                    amount.setText(stringAmount+" "+"AUD");
                    result.setText(Result + " CAD");
                }
                else if(fromCurrency.equals("Australia") && toCurrency.equals("Serbia")){
                    Result = Amount * 75.15;
                    amount.setText(stringAmount+" "+"AUD");
                    result.setText(Result + " RSD");
                }

                //from aud to all
                if (fromCurrency.equals("Canada") && toCurrency.equals("China")) {
                    Result = Amount * 5.08;
                    amount.setText(stringAmount+" "+"CAD");
                    result.setText(Result + " RMB");
                }
                else if(fromCurrency.equals("Canada") && toCurrency.equals("Bangladesh")){
                    Result = Amount * 66.76;
                    amount.setText(stringAmount+" "+"CAD");
                    result.setText(Result + " BDT");
                }
                else if(fromCurrency.equals("Canada") && toCurrency.equals("India")){
                    Result = Amount * 57.25;
                    amount.setText(stringAmount+" "+"CAD");
                    result.setText(Result + " INR");
                }
                else if(fromCurrency.equals("Canada") && toCurrency.equals("England")){
                    Result = Amount * 0.65;
                    amount.setText(stringAmount+" "+"CAD");
                    result.setText(Result + " EUR");
                }
                else if(fromCurrency.equals("Canada") && toCurrency.equals("Japan")){
                    Result = Amount * 82.48;
                    amount.setText(stringAmount+" "+"CAD");
                    result.setText(Result + " YEN");
                }
                else if(fromCurrency.equals("Canada") && toCurrency.equals("Australia")){
                    Result = Amount * 1.01;
                    amount.setText(stringAmount+" "+"CAD");
                    result.setText(Result + " AUD");
                }
                else if(fromCurrency.equals("Canada") && toCurrency.equals("Canada")){
                    Result = Amount * 1;

                    amount.setText(stringAmount+" "+"CAD");
                    result.setText(Result + " CAD");
                }
                else if(fromCurrency.equals("Canada") && toCurrency.equals("Serbia")){
                    Result = Amount * 76.32;
                    amount.setText(stringAmount+" "+"CAD");
                    result.setText(Result + " RSD");
                }
                //from rsd to all
                if (fromCurrency.equals("Serbia") && toCurrency.equals("China")) {
                    Result = Amount * 0.067;
                    amount.setText(stringAmount+" "+"RSD");
                    result.setText(Result + " RMB");
                }
                else if(fromCurrency.equals("Serbia") && toCurrency.equals("Bangladesh")){
                    Result = Amount * 0.87;
                    amount.setText(stringAmount+" "+"RSD");
                    result.setText(Result + " BDT");
                }
                else if(fromCurrency.equals("Serbia") && toCurrency.equals("India")){
                    Result = Amount * 0.75;
                    amount.setText(stringAmount+" "+"RSD");
                    result.setText(Result + " INR");
                }
                else if(fromCurrency.equals("Serbia") && toCurrency.equals("England")){
                    Result = Amount * 0.0085;
                    amount.setText(stringAmount+" "+"RSD");
                    result.setText(Result + " EUR");
                }
                else if(fromCurrency.equals("Serbia") && toCurrency.equals("Japan")){
                    Result = Amount * 1.08;
                    amount.setText(stringAmount+" "+"RSD");
                    result.setText(Result + " YEN");
                }
                else if(fromCurrency.equals("Serbia") && toCurrency.equals("Australia")){
                    Result = Amount * 0.013;
                    amount.setText(stringAmount+" "+"RSD");
                    result.setText(Result + " AUD");
                }
                else if(fromCurrency.equals("Serbia") && toCurrency.equals("Canada")){
                    Result = Amount * 0.013;

                    amount.setText(stringAmount+" "+"RSD");
                    result.setText(Result + " CAD");
                }
                else if(fromCurrency.equals("Serbia") && toCurrency.equals("Serbia")){
                    Result = Amount * 1;
                    amount.setText(stringAmount+" "+"RSD");
                    result.setText(Result + " RSD");
                }







            }
        });




        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


               stringAmount = amount.getText().toString();
               stringResult = result.getText().toString();
               if(stringAmount.isEmpty()==false){

                   try {

                       amount.setText(" ");
                       amount.setHint("Amount");



                   } catch(Exception e) {
                       Log.e("fromC","error");


                   }

               }
                if(stringResult.isEmpty()==false){

                    try {

                        result.setText(" ");
                        result.setHint("Result");


                    } catch(Exception e) {
                        Log.e("fromC","error");


                    }


                }
            }
        });




    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
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

import com.tofa.practice.currencycon.Retrofit.RetrofitBuilder;
import com.tofa.practice.currencycon.Retrofit.RetrofitInterface;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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



                RetrofitInterface retrofitInterface = RetrofitBuilder.getRetrofitInstance().create(RetrofitInterface.class);
                Call<JSONObject> call = retrofitInterface.getExchangeCurrency(fromCurrency);
                call.enqueue(new Callback<JSONObject>() {
                    @Override
                    public void onResponse(Call<JSONObject> call, Response<JSONObject> response) {

                        JSONObject res = response.body();
                        try {

                            if(res !=null){
                                JSONObject rates= res.getJSONObject("conversion_rates");
                                Amount = Double.valueOf(stringAmount);
                                double Multiplier = Double.valueOf(rates.get(toCurrency).toString());
                                Result = Amount * Multiplier;
                                result.setText(String.valueOf(Result));
                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        Log.e("response",String.valueOf(res));






                    }

                    @Override
                    public void onFailure(Call<JSONObject> call, Throwable t) {

                    }
                });














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
                       Amount=0;



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
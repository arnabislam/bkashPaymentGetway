package com.example.bkash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btncheckout;
    private EditText et_ammount;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_ammount=findViewById(R.id.et_ammount);
        btncheckout=findViewById(R.id.btn_checkout);
        btncheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkInputs();
            }
        });
    }


    private void checkInputs(){

        String amountInString = et_ammount.getText().toString().trim();
        //to check ammount validity

        double amount = 0.0;
        try {
            amount = Double.parseDouble(amountInString);//use try catch so that ,if input is stop taking payment here


        }catch(Exception e){
            amount=0.0;

        }
        if (amount<1){
            et_ammount.setError("You have to pay atleast BDT 1");
            et_ammount.requestFocus();
            return;
        }//here you need to check internet connection on another condition like if is online
        else{
            Intent intent = new Intent(MainActivity.this, BkashActivity.class);
            intent.putExtra("AMOUNT", String.valueOf(amount));  //sent amount to bkash activity
            startActivity(intent);

        }



    }
}
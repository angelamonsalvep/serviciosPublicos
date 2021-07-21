package com.example.serviciospublicos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.serviciospublicos.models.GlobalInfo;

public class PaysActivity extends AppCompatActivity {


    Button btnPay;
    EditText etNumberInvoice, etAmount, etConfirmAmount;
    String numberInvoice;
    int amount, confirmAmount;
    String amountStr, confirmAmountStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pays);


        btnPay = findViewById(R.id.pay_submit);


        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etNumberInvoice = findViewById(R.id.pay_number_invoice);
                etAmount = findViewById(R.id.pay_amount);
                etConfirmAmount = findViewById(R.id.pay_confirm_amount);

                amountStr= etAmount.getText().toString();
                confirmAmountStr=etConfirmAmount.getText().toString();

                numberInvoice=etNumberInvoice.getText().toString();


                if(numberInvoice.isEmpty() || amountStr.isEmpty() || confirmAmountStr.isEmpty()) {
                    Toast.makeText(PaysActivity.this, R.string.login_register_empty, Toast.LENGTH_SHORT).show();
                } else {
                    amount= Integer.parseInt(etAmount.getText().toString());
                    confirmAmount = Integer.parseInt(etConfirmAmount.getText().toString());

                    if(numberInvoice.length()==10) {
                        if(GlobalInfo.compareStrings(amountStr, confirmAmountStr) == true) {
                            if(amount>=1000) {

                                if(validateBalance()==true) {

                                } else {
                                    goToPopCancelPayment();

                                }



                            } else {
                                Toast.makeText(PaysActivity.this, R.string.amountmin, Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(PaysActivity.this, R.string.amountsnotmatches, Toast.LENGTH_SHORT).show();
                        }


                    } else {
                        Toast.makeText(PaysActivity.this, R.string.messageNumberInvoiceMin, Toast.LENGTH_SHORT).show();
                    }
                }




            }
        });


    }

    private boolean validateBalance() {
        if(GlobalInfo.listUsers.get(GlobalInfo.poss).balance<amount) {
            return false;
        }

        return true;
    }
    private void goToPopCancelPayment() {
        Intent intent = new Intent(PaysActivity.this, PopCancelPayment.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {


    }




}
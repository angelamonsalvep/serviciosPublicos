package com.example.serviciospublicos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.serviciospublicos.models.GlobalInfo;
import com.example.serviciospublicos.models.User;

public class DepositsActivity extends AppCompatActivity {

    EditText etAmount;
    EditText etConfirmAmount;
    Button btnDeposit;
    String amountStr, confirmAmountStr;
    int amount, confirmAmount;

    int balance;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposits);

        etAmount= (EditText) findViewById(R.id.deposit_amount);
        etConfirmAmount= (EditText) findViewById(R.id.deposit_confirm_amount);
        btnDeposit= (Button)  findViewById(R.id.deposit_submit);







        btnDeposit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amountStr= etAmount.getText().toString();
                confirmAmountStr=etConfirmAmount.getText().toString();

                if(amountStr.isEmpty() || confirmAmountStr.isEmpty()) {
                    Toast.makeText(DepositsActivity.this, R.string.login_register_empty, Toast.LENGTH_SHORT).show();

                } else {

                    amount= Integer.parseInt(etAmount.getText().toString());
                    confirmAmount = Integer.parseInt(etConfirmAmount.getText().toString());

                    if(GlobalInfo.compareStrings(amountStr, confirmAmountStr) == true) {
                        if(amount>=1000) {
                            saveBalance(amount);
                            GlobalInfo.flagDeposit=true;
                            Toast.makeText(DepositsActivity.this, R.string.depositSuccesfull, Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            Toast.makeText(DepositsActivity.this, R.string.amountmin, Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(DepositsActivity.this, R.string.amountsnotmatches, Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }

    @Override
    public void onBackPressed() {


    }

    private void saveBalance(int balance)
    {
        GlobalInfo.globalAmountDeposit= balance;

    }



}
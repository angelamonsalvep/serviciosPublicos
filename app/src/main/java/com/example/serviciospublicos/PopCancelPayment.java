package com.example.serviciospublicos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.serviciospublicos.models.GlobalInfo;

public class PopCancelPayment extends AppCompatActivity {

    Button btnDeposit, btnExit;
    TextView tvBalance;
    private boolean onCreateRunned= false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_cancel_payment);

        onCreateRunned = true;

        DisplayMetrics medidaVentana= new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(medidaVentana);

        int width = medidaVentana.widthPixels;
        int height = medidaVentana.heightPixels;

        getWindow().setLayout((int) (width * 0.85), (int) (height * 0.5));


        btnDeposit= (Button) findViewById( R.id.popCancelPay_submitDeposit );
        btnExit= (Button) findViewById( R.id.popCancelPay_submitCancel );
        tvBalance= (TextView) findViewById(R.id.tvpopCancelPaymentBalance);

        tvBalance.setText("     $ " + Integer.toString(GlobalInfo.listUsers.get(GlobalInfo.poss).balance));

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToHome();
                finish();
            }
        });

        btnDeposit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToDeposit();

            }
        });
    }

    @Override
    public void onBackPressed() {


    }

    @Override
    protected void onResume() {
        super.onResume();
        if(onCreateRunned){
            onCreateRunned = false;

        } else {
            addAmounttoBalance();
            finish();
        }
    }

    private void addAmounttoBalance() {
        int currentBalance= GlobalInfo.listUsers.get(GlobalInfo.poss).balance;
        int amountDeposit= GlobalInfo.globalAmountDeposit;
        int newBalance= currentBalance+amountDeposit;
        GlobalInfo.listUsers.get(GlobalInfo.poss).balance=newBalance;
    }


    private void goToDeposit() {
        Intent intent = new Intent(PopCancelPayment.this, DepositsActivity.class);
        startActivity(intent);
    }

    private void goToHome() {
        Intent intent = new Intent(PopCancelPayment.this, HomeActivity.class);
        startActivity(intent);
    }


}
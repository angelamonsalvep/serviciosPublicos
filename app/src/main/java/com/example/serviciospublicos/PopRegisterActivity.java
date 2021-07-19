package com.example.serviciospublicos;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

public class PopRegisterActivity extends AppCompatActivity {

    Button btnDeposit;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_register);

        DisplayMetrics medidaVentana= new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(medidaVentana);


        int width = medidaVentana.widthPixels;
        int height = medidaVentana.heightPixels;


        getWindow().setLayout((int) (width * 0.85), (int) (height * 0.5));


        btnDeposit= (Button) findViewById( R.id.pop_submitDeposit );

        btnDeposit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToDeposit();
                finish();
            }
        });


    }

    @Override
    public void onBackPressed() {


    }

    private void goToDeposit() {
        Intent intent = new Intent(PopRegisterActivity.this, DepositsActivity.class);
        startActivity(intent);
    }

}
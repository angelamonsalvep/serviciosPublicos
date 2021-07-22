package com.example.serviciospublicos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.serviciospublicos.models.GlobalInfo;

public class PopDetails extends AppCompatActivity {

    TextView tvNumberInvoice, tvTypeInvoice, tvPaidValue, tvBalance;
    Button btnPopDetailsSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_details);

        DisplayMetrics medidaVentana= new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(medidaVentana);

        int width = medidaVentana.widthPixels;
        int height = medidaVentana.heightPixels;

        getWindow().setLayout((int) (width * 0.85), (int) (height * 0.5));


        btnPopDetailsSubmit = findViewById(R.id.pop_details_submit);
        tvTypeInvoice = (TextView) findViewById(R.id.tvpopDetailstypeinvoice);
        tvNumberInvoice = (TextView) findViewById(R.id.tvpopDetailsnumberinvoice);
        tvPaidValue = (TextView) findViewById(R.id.tvpopDetailspaidValue);
        tvBalance = (TextView) findViewById(R.id.tvpopdetailsBalance);

        tvTypeInvoice.setText("  " + GlobalInfo.payGlobal.getTypeInvoice());
        tvNumberInvoice.setText("  " + GlobalInfo.payGlobal.getNumberInvoice());
        tvPaidValue.setText("$ " + GlobalInfo.payGlobal.getPaidValue());
        tvBalance.setText("$ " + Integer.toString(GlobalInfo.listUsers.get(GlobalInfo.poss).balance));

        btnPopDetailsSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GlobalInfo.flagPopDetails=true;
                GlobalInfo.flagDeposit=false;
                finish();
            }
        });



    }
}
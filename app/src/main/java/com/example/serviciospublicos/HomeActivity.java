package com.example.serviciospublicos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.serviciospublicos.models.GlobalInfo;

import java.sql.Time;
import java.text.DateFormat;
import java.util.Date;

public class HomeActivity extends AppCompatActivity {

    TextView tvDate, tvHour, tvNameUser, tvBalance;
    Button btnPay, btnDeposit;

    private final int TIME = 1000;

    Handler handler= new Handler();

    String currentDateTString;
    String currentHourString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tvDate = findViewById(R.id.tvHomeDate);
        tvHour = findViewById(R.id.tvHomeHour);
        btnPay = findViewById(R.id.home_pay_submit);
        btnDeposit = findViewById(R.id.home_deposit_submit);
        tvBalance = findViewById(R.id.tvHomeBalance);
        tvNameUser = findViewById(R.id.tvHomeNameUser);

        String currentDateTString= DateFormat.getDateInstance().format(new Date());
        String currentHourString= DateFormat.getTimeInstance().format(new Date());


        tvHour.setText(" " + currentHourString);
        tvDate.setText(" " + currentDateTString);
        showDateHour();

    }

    @Override
    protected void onResume() {
        super.onResume();
        showDateHour();

    }


    private void showDateHour(){
        final Handler handler= new Handler();


        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                currentHourString= DateFormat.getTimeInstance().format(new Date());
                tvHour.setText(" " + currentHourString);
                handler.postDelayed(this,1000);//se ejecutara cada segundo
            }
        },1000);//empezara a ejecutarse después de 1 segundo
    }
}
package com.example.serviciospublicos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
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
    String nameUser;
    int balance;


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


        //se obtiene la fecha y la hora del sistema
        String currentDateTString= DateFormat.getDateInstance().format(new Date());
        String currentHourString= DateFormat.getTimeInstance().format(new Date());

        tvHour.setText(" " + currentHourString);
        tvDate.setText(" " + currentDateTString);
        //metodo para actualizar la hora del sistema
        showDateHour();

        //se obtienen los datos del usuario actual
        nameUser=GlobalInfo.listUsers.get(GlobalInfo.poss).nameUser;
        balance=GlobalInfo.listUsers.get(GlobalInfo.poss).balance;

        //aqui se muestran los datos del usuario actual
        tvNameUser.setText("  " + nameUser);
        tvBalance.setText("   $ " + Integer.toString(balance));


        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToPays();
                finish();
            }
        });


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

    private void goToPays() {
        Intent intent = new Intent(HomeActivity.this, PaysActivity.class);
        startActivity(intent);
    }


}
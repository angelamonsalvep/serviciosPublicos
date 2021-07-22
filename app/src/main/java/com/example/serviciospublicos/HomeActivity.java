package com.example.serviciospublicos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.serviciospublicos.models.GlobalInfo;

import java.sql.Time;
import java.text.DateFormat;
import java.util.Date;

public class HomeActivity extends AppCompatActivity {

    TextView tvDate, tvHour, tvNameUser, tvBalance;
    Button btnPay, btnDeposit;
    ImageView ivIconExit;

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

        GlobalInfo.flagDeposit=false;


        ivIconExit = findViewById(R.id.ivHomeIconExit);
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

                GlobalInfo.flagDeposit=false;

                if(GlobalInfo.listUsers.get(GlobalInfo.poss).balance<1000) {
                    Toast.makeText(HomeActivity.this, R.string.homewithoutbalance, Toast.LENGTH_SHORT).show();
                } else {
                    goToPays();
                }

            }
        });

        btnDeposit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToDeposit();
            }
        });

        ivIconExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GlobalInfo.flagHome=true;
                finish();
            }
        });


    }

    @Override
    public void onBackPressed() {


    }

    @Override
    protected void onResume() {
        super.onResume();
        showDateHour();


        if(GlobalInfo.flagDeposit==true) {
            addAmounttoBalance();
        }

        if(GlobalInfo.flagPay==true) {
            tvBalance.setText("  $ " + Integer.toString(GlobalInfo.listUsers.get(GlobalInfo.poss).balance));
        }

        if(GlobalInfo.flagPopDetails==true) {
            tvBalance.setText("  $ " + Integer.toString(GlobalInfo.listUsers.get(GlobalInfo.poss).balance));
        }


    }

    private void addAmounttoBalance() {
        int currentBalance= GlobalInfo.listUsers.get(GlobalInfo.poss).balance;
        int amountDeposit= GlobalInfo.globalAmountDeposit;
        int newBalance= currentBalance+amountDeposit;
        GlobalInfo.listUsers.get(GlobalInfo.poss).balance=newBalance;
        tvBalance.setText("  $ " + Integer.toString(GlobalInfo.listUsers.get(GlobalInfo.poss).balance));
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

    private void goToDeposit() {
        Intent intent = new Intent(HomeActivity.this, DepositsActivity.class);
        startActivity(intent);
    }


}
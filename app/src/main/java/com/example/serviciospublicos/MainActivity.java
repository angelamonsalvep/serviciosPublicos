package com.example.serviciospublicos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.serviciospublicos.models.GlobalInfo;
import com.example.serviciospublicos.models.User;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etIdCard;
    EditText etPassword;
    Button btnLogin;
    TextView registrationLink;
    int poss;
    ArrayList<User> listUsers = new ArrayList<>();
    String data_id_Card;
    String data_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // iniciacion de elementos de android
        etIdCard = findViewById(R.id.login_idcard);
        etPassword = findViewById(R.id.login_password);
        btnLogin = findViewById(R.id.login_submit);
        registrationLink = findViewById(R.id.login_register_link);

        registrationLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToRegister();
            }
        });



        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(GlobalInfo.listUsers.size()>0) {
                    data_id_Card = etIdCard.getText().toString();
                    data_password = etPassword.getText().toString();

                    if (data_id_Card.length() != 0 && data_password.length() != 0) {

                        if(data_id_Card.length()==10) {
                            if(data_password.length()>=8) {
                                if(searchString(data_id_Card)==true) {
                                    if(GlobalInfo.compareStrings(GlobalInfo.listUsers.get(GlobalInfo.poss).passUser, data_password)==true) {
                                        Toast.makeText(MainActivity.this, R.string.success_login, Toast.LENGTH_SHORT).show();
                                        goTohome();




                                    } else {
                                        Toast.makeText(MainActivity.this, R.string.message_pass_incorrect, Toast.LENGTH_SHORT).show();
                                    }
                                } else {
                                    Toast.makeText(MainActivity.this, R.string.message_idCard_no_exist, Toast.LENGTH_SHORT).show();

                                }


                            } else {
                                Toast.makeText(MainActivity.this, R.string.pass_min, Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(MainActivity.this, R.string.messageIdCardMin, Toast.LENGTH_SHORT).show();
                        }



                    } else {
                        Toast.makeText(MainActivity.this, R.string.login_register_empty, Toast.LENGTH_SHORT).show();
                    }


                } else {
                    Toast.makeText(MainActivity.this, R.string.message_no_users, Toast.LENGTH_SHORT).show();
                }

            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();

        if(GlobalInfo.flagHome==true) {
            etIdCard.setText("");
            etPassword.setText("");
        }

    }

    @Override
    public void onBackPressed() {


    }

    private void goToRegister() {
        Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

    private void goTohome() {
        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
        startActivity(intent);
    }

    private boolean searchString(String idCardReceive) {
        int i=0;
        boolean result;
        int countFound=0;
        while(i<GlobalInfo.listUsers.size()) {
            result= GlobalInfo.compareStrings(GlobalInfo.listUsers.get(i).idCardUser,idCardReceive);
            if(result==true)
            {
                GlobalInfo.poss=i;
                countFound++;
                break;
            } else {
                i++;
            }
        }

        if(countFound==0){
            return false;
        }

        return true;
    }
}
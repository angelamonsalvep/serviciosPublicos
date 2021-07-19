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

public class RegisterActivity extends AppCompatActivity {

    EditText etIdCard;
    EditText etNameUser;
    EditText etPassword;
    Button btnRegister;
    User user = new User();
    String idCard, nameUser, passUser;
    private boolean onCreateRunned= false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        onCreateRunned = true;

        // iniciacion de elementos de android

        etIdCard = findViewById(R.id.register_idCard);
        etNameUser = findViewById(R.id.register_nameUser);
        etPassword = findViewById(R.id.register_password);
        btnRegister = findViewById(R.id.register_submit);




        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                idCard= etIdCard.getText().toString();
                nameUser= etNameUser.getText().toString();
                passUser= etPassword.getText().toString();

                if(idCard.isEmpty() || nameUser.isEmpty() || passUser.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, R.string.login_register_empty, Toast.LENGTH_SHORT).show();

                } else {
                    if(idCard.length()<10) {
                        Toast.makeText(RegisterActivity.this, R.string.messageIdCardMin, Toast.LENGTH_SHORT).show();
                    } else {
                        if(nameUser.length()<6) {
                            Toast.makeText(RegisterActivity.this, R.string.messageNameMin, Toast.LENGTH_SHORT).show();
                        } else {
                            if(passUser.length()<8) {
                                Toast.makeText(RegisterActivity.this, R.string.pass_min, Toast.LENGTH_SHORT).show();
                            } else {
                                saveUser();
                                goToPop();
                            }
                        }
                    }

                }

            }
        });




    }

    @Override
    protected void onResume() {
        super.onResume();
        if(onCreateRunned){
            onCreateRunned = false;

            } else {
            GlobalInfo.listUsers.add(GlobalInfo.userGlobal);
            Toast.makeText(RegisterActivity.this, R.string.registerSuccesfull, Toast.LENGTH_SHORT).show();
            finish();
        }
    }



    @Override
    public void onBackPressed() {


    }

    private void saveUser() {
        GlobalInfo.userGlobal.idCardUser= idCard;
        GlobalInfo.userGlobal.nameUser= nameUser;
        GlobalInfo.userGlobal.passUser=passUser;
    }

    private void goToPop() {
        Intent intent = new Intent(RegisterActivity.this, PopRegisterActivity.class);
        startActivity(intent);
    }
}
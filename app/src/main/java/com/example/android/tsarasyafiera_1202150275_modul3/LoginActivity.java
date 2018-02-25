package com.example.android.tsarasyafiera_1202150275_modul3;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.editText_username);
        password = findViewById(R.id.editText_password);

    }

    public void showLogin(View view) {
        AlertDialog.Builder myAlert = new AlertDialog.Builder(LoginActivity.this);
        String u1 = "EAD";
        String p1 = "MOBILE";

        if (username.getText().toString().equalsIgnoreCase(u1) && password.getText().toString().equalsIgnoreCase(p1)) {
            myAlert.setTitle("Welcome");
            myAlert.setMessage("Login Sukses");
            myAlert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    String username1 = username.getText().toString();
                    intent.putExtra("username1", username1);

                    String password1 = password.getText().toString();
                    intent.putExtra("password1", password1);
                    startActivity(intent);
                }
            });

            myAlert.show();
        } else {
            myAlert.setTitle("AlertDialog");
            myAlert.setMessage("Login Gagal");
            myAlert.setPositiveButton("Coba Lagi", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getApplicationContext(), "username atau password salah", Toast.LENGTH_LONG).show();
                }
            });
            myAlert.show();
        }
    }
}


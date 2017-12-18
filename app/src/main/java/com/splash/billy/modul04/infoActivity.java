package com.splash.billy.modul04;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class infoActivity extends AppCompatActivity {

    EditText etEmail, etPassword;
    TextView tvinfo;
    Button btLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btLogin = (Button) findViewById(R.id.btLogin);
        tvinfo = (TextView) findViewById(R.id.tvinfo);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Members members = new Members(etEmail.getText().toString());
                Log.d(">>>>>> CHECK 1 >>>>>>", members.getEmail());
                if (members.getIdmember() != null && members.getPassword().equals(
                        etPassword.getText().toString())) {
                    Log.d(">>>>>> CHECK 2 >>>>>>", members.getIdmember());
                    Toast.makeText(getApplicationContext(), "Login Sukses", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(infoActivity.this, MainActivity.class);
                    intent.putExtra("members", members);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                } else {
                    tvinfo.setVisibility(View.VISIBLE);
                    Toast.makeText(getApplicationContext(), "Login Gagal /Username Password Salah", Toast.LENGTH_SHORT).show();
                    etEmail.setText("");
                    etPassword.setText("");
                    etEmail.requestFocus();
                }
            }
        });
    }
}
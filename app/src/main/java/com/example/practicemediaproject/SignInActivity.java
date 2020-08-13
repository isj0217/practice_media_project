package com.example.practicemediaproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SignInActivity extends AppCompatActivity {

    private EditText et_sign_in_id;
    private EditText et_sign_in_pw;
    private Button btn_sign_in_sign_in;
    private Button btn_sign_in_find_id_or_pw;
    private Button btn_sign_in_sign_up;

    private Intent intent;

    public void bindViews() {
        et_sign_in_id = findViewById(R.id.et_sign_in_id);
        et_sign_in_pw = findViewById(R.id.et_sign_in_pw);
        btn_sign_in_sign_in = findViewById(R.id.btn_sign_in_sign_in);
        btn_sign_in_find_id_or_pw = findViewById(R.id.btn_sign_in_find_id_or_pw);
        btn_sign_in_sign_up = findViewById(R.id.btn_sign_in_sign_up);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        bindViews();

        btn_sign_in_sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(SignInActivity.this, SignUpActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        });
    }

}
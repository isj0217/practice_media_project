package com.example.practicemediaproject;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.practicemediaproject.main.MainActivity;

public class SignUpActivity extends AppCompatActivity {

    private EditText et_sign_up_id;
    private EditText et_sign_up_pw;
    private EditText et_sign_up_pw_again;
    private EditText et_sign_up_email;
    private EditText et_sign_up_nickname;
    private Button btn_sign_up_sign_up;

    private ImageView iv_sign_up_check_id;
    private ImageView iv_sign_up_check_pw;
    private ImageView iv_sign_up_check_pw_again;
    private ImageView iv_sign_up_check_email;
    private ImageView iv_sign_up_check_nickname;

    private Intent intent;

    private String email_pattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    public void bindViews() {
        et_sign_up_id = findViewById(R.id.et_sign_up_id);
        et_sign_up_pw = findViewById(R.id.et_sign_up_pw);
        et_sign_up_pw_again = findViewById(R.id.et_sign_up_pw_again);
        et_sign_up_email = findViewById(R.id.et_sign_up_email);
        et_sign_up_nickname = findViewById(R.id.et_sign_up_nickname);
        btn_sign_up_sign_up = findViewById(R.id.btn_sign_up_sign_up);

        iv_sign_up_check_id = findViewById(R.id.iv_sign_up_check_id);
        iv_sign_up_check_pw = findViewById(R.id.iv_sign_up_check_pw);
        iv_sign_up_check_pw_again = findViewById(R.id.iv_sign_up_check_pw_again);
        iv_sign_up_check_email = findViewById(R.id.iv_sign_up_check_email);
        iv_sign_up_check_nickname = findViewById(R.id.iv_sign_up_check_nickname);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        bindViews();
        setTextChangedListeners();

    }

    public void setTextChangedListeners() {
        et_sign_up_id.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() >= 4 && editable.length() <= 20){
                    iv_sign_up_check_id.setImageResource(R.drawable.ic_baseline_check_circle_outline_24_green);
                }else{
                    iv_sign_up_check_id.setImageResource(R.drawable.ic_baseline_check_circle_outline_24_red);
                }
            }
        });

        et_sign_up_pw.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() >= 4 && editable.length() <= 20){
                    iv_sign_up_check_pw.setImageResource(R.drawable.ic_baseline_check_circle_outline_24_green);
                }else{
                    iv_sign_up_check_pw.setImageResource(R.drawable.ic_baseline_check_circle_outline_24_red);
                }
            }
        });

        et_sign_up_pw_again.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() >= 4 && editable.length() <= 20 && editable.toString().equals(et_sign_up_pw.getText().toString())){
                    iv_sign_up_check_pw_again.setImageResource(R.drawable.ic_baseline_check_circle_outline_24_green);
                }else{
                    iv_sign_up_check_pw_again.setImageResource(R.drawable.ic_baseline_check_circle_outline_24_red);
                }
            }
        });

        et_sign_up_email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.toString().matches(email_pattern) && editable.length() > 0){
                    iv_sign_up_check_email.setImageResource(R.drawable.ic_baseline_check_circle_outline_24_green);
                }else{
                    iv_sign_up_check_email.setImageResource(R.drawable.ic_baseline_check_circle_outline_24_red);
                }
            }
        });

        et_sign_up_nickname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() >= 4){
                    iv_sign_up_check_nickname.setImageResource(R.drawable.ic_baseline_check_circle_outline_24_green);
                }else{
                    iv_sign_up_check_nickname.setImageResource(R.drawable.ic_baseline_check_circle_outline_24_red);
                }
            }
        });
    }

    public void customOnClick(View view) {
        switch (view.getId()){
            case R.id.iv_sign_up_go_back:
                intent = new Intent(SignUpActivity.this, SignInActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
                break;

            case R.id.btn_sign_up_sign_up:
                intent = new Intent(SignUpActivity.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        intent = new Intent(SignUpActivity.this, SignInActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        finish();
    }
}
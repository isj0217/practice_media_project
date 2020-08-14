package com.example.practicemediaproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
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

    private boolean is_suitable_id;
    private boolean is_suitable_pw;
    private boolean is_suitable_pw_again;
    private boolean is_suitable_email;
    private boolean is_suitable_nickname;

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
                if (editable.length() >= 4 && editable.length() <= 20) {
                    iv_sign_up_check_id.setImageResource(R.drawable.ic_baseline_check_circle_outline_24_green);
                    is_suitable_id = true;
                } else {
                    iv_sign_up_check_id.setImageResource(R.drawable.ic_baseline_check_circle_outline_24_red);
                    is_suitable_id = false;
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
                if (editable.length() >= 4 && editable.length() <= 20) {
                    iv_sign_up_check_pw.setImageResource(R.drawable.ic_baseline_check_circle_outline_24_green);
                    is_suitable_pw = true;
                } else {
                    iv_sign_up_check_pw.setImageResource(R.drawable.ic_baseline_check_circle_outline_24_red);
                    is_suitable_pw = false;
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
                if (editable.length() >= 4 && editable.length() <= 20 && editable.toString().equals(et_sign_up_pw.getText().toString())) {
                    iv_sign_up_check_pw_again.setImageResource(R.drawable.ic_baseline_check_circle_outline_24_green);
                    is_suitable_pw_again = true;
                } else {
                    iv_sign_up_check_pw_again.setImageResource(R.drawable.ic_baseline_check_circle_outline_24_red);
                    is_suitable_pw_again = false;
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
                if (editable.toString().matches(email_pattern) && editable.length() > 0) {
                    iv_sign_up_check_email.setImageResource(R.drawable.ic_baseline_check_circle_outline_24_green);
                    is_suitable_email = true;
                } else {
                    iv_sign_up_check_email.setImageResource(R.drawable.ic_baseline_check_circle_outline_24_red);
                    is_suitable_email = false;
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
                if (editable.length() >= 4) {
                    iv_sign_up_check_nickname.setImageResource(R.drawable.ic_baseline_check_circle_outline_24_green);
                    is_suitable_nickname = true;
                } else {
                    iv_sign_up_check_nickname.setImageResource(R.drawable.ic_baseline_check_circle_outline_24_red);
                    is_suitable_nickname = false;
                }
            }
        });
    }

    public void customOnClick(View view) {
        switch (view.getId()) {
            case R.id.iv_sign_up_go_back:
                intent = new Intent(SignUpActivity.this, SignInActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
                break;

            case R.id.btn_sign_up_sign_up:
                if (is_suitable_id && is_suitable_pw && is_suitable_pw_again && is_suitable_email && is_suitable_nickname) {
                    // todo before server connection
                    // 모든 입력창을 적절하게 채워넣었으므로
                    // 1. 회원가입이 완료되었다는 알림창 띄우고
                    // 2. 확인버튼 누르면 SignInActivity로 돌려보내기

                    new AlertDialog.Builder(SignUpActivity.this) // TestActivity 부분에는 현재 Activity의 이름 입력.
                            .setTitle("Sign Up Completed")
                            .setMessage("Thank you for joining our community")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    intent = new Intent(SignUpActivity.this, SignInActivity.class);
                                    startActivity(intent);
                                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                                    finish();
                                }
                            }).setCancelable(false)
                            .show();

                    // todo after server connection
                    // 서버 연결 후에는 서버로부터 잘못된 정보 없는지 응답 받은 후에 그에 상응하게 조치하기!!
                    // ex) 아이디 중복, 닉네임 중복 등 -> 회원정보 수정 요구
                } else {
                    Toast.makeText(this, "Please fill out every form properly", Toast.LENGTH_SHORT).show();
                }
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
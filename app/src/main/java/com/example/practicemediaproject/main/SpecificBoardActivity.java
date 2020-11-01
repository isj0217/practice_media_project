package com.example.practicemediaproject.main;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.practicemediaproject.R;
public class SpecificBoardActivity extends AppCompatActivity {


    private String department_name;
    private TextView tv_specific_board_department_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_board);

        tv_specific_board_department_name = findViewById(R.id.tv_specific_board_department_name);

        Intent intent = getIntent();
        department_name = intent.getExtras().getString("department_name");
        tv_specific_board_department_name.setText(department_name);
//        tv_specific_board_department_name.setText(intent.getExtras().getString("department_name"));

    }

    public void customOnClick(View view) {
        switch (view.getId()){
            case R.id.iv_specific_board_go_back:
                onBackPressed();
                break;
            case R.id.iv_specific_board_sync:
                break;
            case R.id.iv_specific_board_search:
                break;
            case R.id.iv_specific_board_more:
                break;
        }

    }

}
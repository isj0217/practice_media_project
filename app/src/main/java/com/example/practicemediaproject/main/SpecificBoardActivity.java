package com.example.practicemediaproject.main;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.practicemediaproject.R;

public class SpecificBoardActivity extends AppCompatActivity {


    private String section_in_agora;
    private String category_name;

    private String department_name;
    private String used_product_category_name;

    private TextView tv_specific_board_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_board);

        tv_specific_board_name = findViewById(R.id.tv_specific_board_name);

//        Bundle bundle = getIntent().getExtras();
//        if (bundle != null) {
//            section_in_agora = bundle.getString("section_in_agora");
//            category_name = bundle.getString("category_name");
//            tv_specific_board_name.setText(category_name);
//        }

        loadRecentSectionAndCategory();

        tv_specific_board_name.setText(category_name);


//        SharedPreferences sharedPreferences = getSharedPreferences("recent_section_and_category", MODE_PRIVATE);
//        section_in_agora = sharedPreferences.getString("section_in_agora", "SECTION");
//        category_name = sharedPreferences.getString("category_name", "CATEGORY");




    }

    public void customOnClick(View view) {
        switch (view.getId()) {
            case R.id.iv_specific_board_go_back:
                onBackPressed();
                break;
            case R.id.iv_specific_board_sync:
                break;
            case R.id.iv_specific_board_search:
                break;
            case R.id.iv_specific_board_write:
                Intent intent = new Intent(SpecificBoardActivity.this, WritingActivity.class);
//                intent.putExtra("section_in_agora", section_in_agora);
//                intent.putExtra("category_name", used_product_category_name);
                startActivity(intent);
                finish();
                break;
        }

    }

    public void loadRecentSectionAndCategory(){
        SharedPreferences sharedPreferences = getSharedPreferences("recent_section_and_category", MODE_PRIVATE);
        section_in_agora = sharedPreferences.getString("section_in_agora", "SECTION 불러오기 실패");
        category_name = sharedPreferences.getString("category_name", "CATEGORY 불러오기 실패");
    }

}
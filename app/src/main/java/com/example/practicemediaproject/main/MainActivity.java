package com.example.practicemediaproject.main;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.practicemediaproject.R;
import com.example.practicemediaproject.main.fragments.FragmentBoard;
import com.example.practicemediaproject.main.fragments.FragmentCardNews;
import com.example.practicemediaproject.main.fragments.FragmentChat;
import com.example.practicemediaproject.main.fragments.FragmentSettings;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottom_navigation_view_main;

    FragmentChat fragmentChat;
    FragmentBoard fragmentBoard;
    FragmentCardNews fragmentCardNews;
    FragmentSettings fragmentSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottom_navigation_view_main = findViewById(R.id.bottom_navigation_view_main);

        // 4개의 프래그먼트 생성
        fragmentChat = new FragmentChat();
        fragmentBoard = new FragmentBoard();
        fragmentCardNews = new FragmentCardNews();
        fragmentSettings = new FragmentSettings();

        // 제일 처음 띄워줄 뷰를 세팅함
        // commitAllowingStateLoss();까지 해야함을 주의!
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout_main, fragmentChat).commitAllowingStateLoss();

        // bottomNavigationView의 아이콘을 선택 했을때 원하는 프래그먼트가 띄워질 수 있도록 리스너를 추가
        bottom_navigation_view_main.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) { //menu_bottom.xml에서 지정해줬던 아이디 값을 받아와서 각 아이디값마다 다른 이벤트를 발생시킵니다.
                    case R.id.item_chat_main: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout_main, fragmentChat).commitAllowingStateLoss();
                        return true;
                    }
                    case R.id.item_board_main: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout_main, fragmentBoard).commitAllowingStateLoss();
                        return true;
                    }
                    case R.id.item_card_news_main: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout_main, fragmentCardNews).commitAllowingStateLoss();
                        return true;
                    }
                    case R.id.item_settings_main: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout_main, fragmentSettings).commitAllowingStateLoss();
                        return true;
                    }
                    default:
                        return false;
                }
            }
        });


    }

}
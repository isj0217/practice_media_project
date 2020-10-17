package com.example.practicemediaproject.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.practicemediaproject.R;

public class FragAgoraDepartment extends Fragment {

    private View view;

    public static FragAgoraDepartment newInstance() {
        FragAgoraDepartment fragAgoraDepartment = new FragAgoraDepartment();
        return fragAgoraDepartment;
    }

    @Nullable
    @Override
    public android.view.View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_agora_department, container, false);

        return view;
    }

}

package com.example.practicemediaproject.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.practicemediaproject.R;

public class FragAgoraUsedProduct extends Fragment {

    private View view;

    public static FragAgoraUsedProduct newInstance() {
        FragAgoraUsedProduct fragAgoraUsedProduct = new FragAgoraUsedProduct();
        return fragAgoraUsedProduct;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_agora_used_product, container, false);

        return view;
    }
    
}

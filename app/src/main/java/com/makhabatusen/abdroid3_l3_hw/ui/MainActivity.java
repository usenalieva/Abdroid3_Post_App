package com.makhabatusen.abdroid3_l3_hw.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.makhabatusen.abdroid3_l3_hw.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }
}
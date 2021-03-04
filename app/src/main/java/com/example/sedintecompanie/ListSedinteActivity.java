package com.example.sedintecompanie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.sedintecompanie.model.Sedinta;

public class ListSedinteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        Sedinta sedinta=(Sedinta) getIntent().getSerializableExtra("sedinta");

    }
}
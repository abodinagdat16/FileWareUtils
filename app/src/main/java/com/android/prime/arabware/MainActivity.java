package com.android.prime.arabware;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import arabware.forfree.FileWareUtils;

public class MainActivity extends AppCompatActivity {
    FileWareUtils fwu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
    }
}
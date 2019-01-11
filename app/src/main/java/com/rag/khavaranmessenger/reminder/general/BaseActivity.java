package com.rag.khavaranmessenger.reminder.general;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

public abstract class BaseActivity extends AppCompatActivity {

    protected View view;
    protected Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getBaseContext();
    }



    protected void setLayout(int layoutID) {
        LayoutInflater inflater = (LayoutInflater) getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layoutID, null);
        setContentView(view);
    }


}

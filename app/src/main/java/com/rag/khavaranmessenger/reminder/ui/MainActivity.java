package com.rag.khavaranmessenger.reminder.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.rag.khavaranmessenger.reminder.R;
import com.rag.khavaranmessenger.reminder.general.baseclass.BaseActivity;
import com.rag.khavaranmessenger.reminder.main.model.MainModel;
import com.rag.khavaranmessenger.reminder.main.view.MainFragment;
import com.rag.khavaranmessenger.reminder.main.view.MainView;

public class MainActivity extends BaseActivity implements SwitchFragment {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLayout(R.layout.activity_main);
        setupPresenter();
        showFragment(MainFragment.newInstance());
    }

    private void setupPresenter() {
        MainView mainView = new MainView();
        MainModel mainModel = new MainModel();

//        MainPresenter mainPresenter = new MainPresenter();
//        mainPresenter.onCreate(mainModel, mainView);
    }


    private void showFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(view.getId(), fragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();
    }

    @Override
    public void switchFragment(Fragment fragment) {
        showFragment(fragment);
    }
}

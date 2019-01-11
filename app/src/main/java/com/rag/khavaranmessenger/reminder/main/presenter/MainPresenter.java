package com.rag.khavaranmessenger.reminder.main.presenter;

import com.rag.khavaranmessenger.reminder.general.BasePresenter;
import com.rag.khavaranmessenger.reminder.main.model.MainModel;
import com.rag.khavaranmessenger.reminder.main.view.MainView;

public class MainPresenter extends BasePresenter<MainModel, MainView>  {


    private MainModel mainModel;
    private MainView mainView;


    @Override
    protected void onUpdate() {

    }

    @Override
    public void onCreate() {
        setModel(mainModel);
        bindView(mainView);
        super.onCreate();
    }
}

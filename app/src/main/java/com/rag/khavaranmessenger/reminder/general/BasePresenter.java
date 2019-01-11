package com.rag.khavaranmessenger.reminder.general;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<Model, View> implements BasePresenterHandler{

    protected Model model;
    private WeakReference<View> view;

    @Override
    public void onCreate() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onBackPress() {

    }

    public void setModel(Model model) {
        this.model = model;
        if (setupBase()) {
            onUpdate();
        }
    }


    public void bindView(View view) {
        this.view = new WeakReference<View>(view);
        if (setupBase())
            onUpdate();
    }

    public View getView() {
        if (view != null) {
            return view.get();
        } else {
            return null;
        }
    }

    private boolean setupBase() {
        return model != null & getView() != null;
    }

    protected abstract void onUpdate();


}

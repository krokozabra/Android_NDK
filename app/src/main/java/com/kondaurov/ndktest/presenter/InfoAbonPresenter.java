package com.kondaurov.ndktest.presenter;

import com.kondaurov.ndktest.common.AbonData;
import com.kondaurov.ndktest.interfaces.InfoAbonInterface;
import com.kondaurov.ndktest.model.ReadWriteModel;

public class InfoAbonPresenter {

    private InfoAbonInterface view;
    private final ReadWriteModel model;

    public InfoAbonPresenter(ReadWriteModel model) {
        this.model = model;
    }

    public void attachView(InfoAbonInterface view) {
        this.view = view;
    }

    public void detachView()
    {
        view = null;
    }

    public void viewIsReady(AbonData abonData)
    {
        showAbon(abonData);
    }

    public void showAbon(AbonData abonData) {
        view.showAbon(abonData);
    }
}

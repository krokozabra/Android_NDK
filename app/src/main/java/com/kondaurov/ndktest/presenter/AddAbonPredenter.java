package com.kondaurov.ndktest.presenter;

import com.kondaurov.ndktest.common.AbonData;
import com.kondaurov.ndktest.interfaces.AddAbonInterface;
import com.kondaurov.ndktest.model.ReadWriteModel;
import com.kondaurov.ndktest.view.MainActivity;

public class AddAbonPredenter {
    private AddAbonInterface view;
    private final ReadWriteModel model;

    public AddAbonPredenter(ReadWriteModel model) {
        this.model = model;
    }

    public void attachView(AddAbonInterface view) {
        this.view = view;
    }

    public void detachView()
    {
        view = null;
    }

    public void viewIsReady()
    {

    }

    public void addNewAbon(AbonData newAbon)
    {
        //работа с можелью данных
        model.AddNewAbon(newAbon);//либо так, либо через Rx
        view.startOtherScreen(MainActivity.class);
    }

}

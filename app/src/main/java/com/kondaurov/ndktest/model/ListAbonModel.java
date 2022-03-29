package com.kondaurov.ndktest.model;

import com.kondaurov.ndktest.common.AbonData;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.schedulers.Schedulers;

public class ListAbonModel {

    public ListAbonModel() {
    }

    public void loadAbon(Observer<ArrayList<AbonData>> observer)
    {
        Observable.fromArray(getAbonList())
                .subscribeOn(Schedulers.newThread())
                .subscribe(observer);
    }

    private ArrayList<AbonData> getAbonList() {

        ArrayList<AbonData> abonList = new ArrayList<>();

        abonList.add(new AbonData(0,"Михаил","Михаилов","88005553535"));
        abonList.add(new AbonData(0,"Александр","Грезинов","88005553"));
        abonList.add(new AbonData(0,"Евгений","Дятлов","88553535"));
        abonList.add(new AbonData(0,"Иван","Рогов","880055535"));
        //реализовать получение данных с сервера
        return abonList;
    }

}

package com.kondaurov.ndktest.model;

import android.content.res.Resources;

import com.kondaurov.ndktest.R;
import com.kondaurov.ndktest.common.AbonData;
import com.kondaurov.ndktest.common.NetWork;

import org.reactivestreams.Subscription;

import java.io.IOException;
import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;

public class ListAbonModel {

    public ListAbonModel() {
    }

    public void loadAbon(Observer<String> observer)
    {
        Observable.just(getAbonList())
                .subscribeOn(Schedulers.newThread())
                .subscribe(observer);
    }

    public String getAbonList() {

        String json ="";
        try {

            json = NetWork.GET("http://zarubl.ru/ndktest/select_num.php");
            System.out.println("Ответ с сервера: \n"+ json);
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*ArrayList<AbonData> abonList = new ArrayList<>();

        abonList.add(new AbonData(0,"Михаил","Михаилов","88005553535"));
        abonList.add(new AbonData(0,"Александр","Грезинов","88005553"));
        abonList.add(new AbonData(0,"Евгений","Дятлов","88553535"));
        abonList.add(new AbonData(0,"Иван","Рогов","880055535"));
        //реализовать получение данных с сервера
        return abonList;*/
        return json;
    }

}

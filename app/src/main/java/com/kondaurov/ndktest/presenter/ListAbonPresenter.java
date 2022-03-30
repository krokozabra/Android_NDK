package com.kondaurov.ndktest.presenter;

import com.kondaurov.ndktest.common.AbonData;
import com.kondaurov.ndktest.interfaces.ListInterface;
import com.kondaurov.ndktest.model.ListAbonModel;

import java.util.ArrayList;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class ListAbonPresenter {

    private ListInterface view;
    private final ListAbonModel model;

    public ListAbonPresenter(ListAbonModel model) {
        this.model = model;
    }

    public void attachView(ListInterface view) {
        this.view = view;
    }

    public void detachView()
    {
        view = null;
    }

    public void viewIsReady()
    {
        loadList();
    }

    public void loadList() {
        //RxJava
        model.loadAbon(observer);

    }

    public void startAddAbon(Class activity){
        view.startOtherScreen(activity);
    }

    Observer<String> observer = new Observer<String>() {

        @Override
        public void onSubscribe(Disposable d) {
            System.out.println("onSubscribe: ");

        }

        @Override
        public void onNext(String toDoData) {
//параллель тут
            toDoData = model.getAbonList();
            System.out.println("Ответ с сервера: "+toDoData);
//            view.showList(toDoData);

        }

        @Override
        public void onError(Throwable e) {
            System.out.println("onError: ");
        }

        @Override
        public void onComplete() {
            System.out.println("onComplete: All Done!");
        }
    };
}

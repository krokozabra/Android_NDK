package com.kondaurov.ndktest.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.kondaurov.ndktest.common.AbonData;
import com.kondaurov.ndktest.databinding.ActivityAddAbonBinding;
import com.kondaurov.ndktest.interfaces.AddAbonInterface;
import com.kondaurov.ndktest.model.ReadWriteModel;
import com.kondaurov.ndktest.presenter.AddAbonPredenter;

public class AddAbonActivity extends AppCompatActivity implements AddAbonInterface {


    private ActivityAddAbonBinding binding;
    private AddAbonPredenter presenter;

    public static void start(@NonNull Activity activity) {
        Intent intent = new Intent(activity, AddAbonActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityAddAbonBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        init();
    }

    private void init()
    {
        setTitle("Добавление нового абонента");

        Button addAbon = binding.aaaAddBtn;
        
        AbonData abonData = new AbonData();
        abonData.setName(binding.aaaNameEt.getText().toString());
        abonData.setLast_name(binding.aaaLastNameEt.getText().toString());
        abonData.setNumber(binding.aaaNumberEt.getText().toString());

        addAbon.setOnClickListener(v ->
        {
            presenter.addNewAbon(abonData);
        });

        ReadWriteModel toDoModel = new ReadWriteModel();
        presenter = new AddAbonPredenter(toDoModel);
        presenter.attachView(this);
        presenter.viewIsReady();
    }

    @Override
    public AbonData getNewAbon() {
        return null;
    }

    @Override
    public void startOtherScreen(Class activity) {
        if (activity == MainActivity.class)
            MainActivity.start(this);
        finish();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}
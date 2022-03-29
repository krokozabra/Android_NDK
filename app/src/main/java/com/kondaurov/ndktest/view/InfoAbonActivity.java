package com.kondaurov.ndktest.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.kondaurov.ndktest.common.AbonData;
import com.kondaurov.ndktest.databinding.ActivityInfoAbonBinding;
import com.kondaurov.ndktest.interfaces.InfoAbonInterface;
import com.kondaurov.ndktest.model.ReadWriteModel;
import com.kondaurov.ndktest.presenter.InfoAbonPresenter;

public class InfoAbonActivity extends AppCompatActivity implements InfoAbonInterface {


    private ActivityInfoAbonBinding binding;
    private AbonData abonData;
    private InfoAbonPresenter presenter;

    public static final String ABONENT="abonent";

    public static void start(@NonNull Activity activity) {
        Intent intent = new Intent(activity, InfoAbonActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityInfoAbonBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

       init();
    }

    private void init()
    {
        setTitle("Информация Абонента");

        Bundle arguments = getIntent().getExtras();
        abonData = arguments.getParcelable(ABONENT);


        ReadWriteModel toDoModel = new ReadWriteModel();
        presenter = new InfoAbonPresenter(toDoModel);
        presenter.attachView(this);
        presenter.viewIsReady(abonData);
    }

    @Override
    public void showAbon(AbonData abonData) {
        TextView name = binding.aiaNameTv;
        name.setText(abonData.getName());
        TextView lastName = binding.aiaLastNameTv;
        lastName.setText(abonData.getLast_name());
        TextView number = binding.aiaNumberTv;
        number.setText(abonData.getNumber());
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}
package com.kondaurov.ndktest.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.kondaurov.ndktest.R;
import com.kondaurov.ndktest.common.AbonAdapter;
import com.kondaurov.ndktest.common.AbonData;
import com.kondaurov.ndktest.databinding.ActivityMainBinding;
import com.kondaurov.ndktest.interfaces.ListInterface;
import com.kondaurov.ndktest.model.ListAbonModel;
import com.kondaurov.ndktest.presenter.ListAbonPresenter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ListInterface,SwipeRefreshLayout.OnRefreshListener {


    private ActivityMainBinding binding;
    private ListAbonPresenter presenter;

    ListView list;

    ArrayList<AbonData> abonList = new ArrayList<>();
    AbonAdapter abonAdapter;

    SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    public void onRefresh() {
        abonList.clear();
        list.setAdapter(null);
        //засунуть метод опроса библии через презентера
        presenter.loadList();
        mSwipeRefreshLayout.setRefreshing(false); // останавливает анимацию загрузки

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.dots_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.action_add: {
                presenter.startAddAbon(AddAbonActivity.class);
                break;
            }
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        init();

    }
    private void init()
    {
        setTitle("Список Абонентов");

        list = binding.amList;
        abonAdapter = new AbonAdapter(this, abonList);

        ListAbonModel toDoModel = new ListAbonModel();
        presenter = new ListAbonPresenter(toDoModel);
        presenter.attachView(this);
        presenter.viewIsReady();
    }

    @Override
    public void showList(List<AbonData> listToDo) {
        abonList.clear();
        abonList.addAll(listToDo);
        list.setAdapter(abonAdapter);
    }

    @Override
    public void startOtherScreen(Class activity) {
        if (activity == AddAbonActivity.class)
            AddAbonActivity.start(this);
        finish();
    }

    public static void start(@NonNull Activity activity) {
        Intent intent = new Intent(activity, MainActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

}
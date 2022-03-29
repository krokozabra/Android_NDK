package com.kondaurov.ndktest.common;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kondaurov.ndktest.R;
import com.kondaurov.ndktest.view.InfoAbonActivity;

import java.util.ArrayList;

public class AbonAdapter extends BaseAdapter {
    Context ctx;
    LayoutInflater lInflater;
    ArrayList<AbonData> objects;
    TextView name, number;
    LinearLayout spase;

    public AbonAdapter(Context context, ArrayList<AbonData> todos) {
        ctx = context;
        objects = todos;
        lInflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    // кол-во элементов
    @Override
    public int getCount() {
        return objects.size();
    }

    // элемент по позиции
    @Override
    public Object getItem(int position) {
        return objects.get(position);
    }

    // id по позиции
    @Override
    public long getItemId(int position) {
        return position;
    }

    // пункт списка
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.item_abon, parent, false);
        }

        AbonData p = getAbonData(position);
        name = view.findViewById(R.id.ia_name);
        name.setText(p.getName());
        number = view.findViewById(R.id.ia_number);
        number.setText(p.getNumber());
        spase = view.findViewById(R.id.ia_space);
        spase.setOnClickListener(v -> {
            System.out.println("название " + p.getName());
            Intent intent = new Intent(ctx, InfoAbonActivity.class);
            intent.putExtra(InfoAbonActivity.ABONENT, p);
            ctx.startActivity(intent);
        });

        return view;
    }

    AbonData getAbonData(int position) {
        return ((AbonData) getItem(position));
    }

}

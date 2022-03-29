package com.kondaurov.ndktest.interfaces;

import com.kondaurov.ndktest.common.AbonData;

import java.util.List;

public interface ListInterface {

    void showList(List<AbonData> listToDo);

    void startOtherScreen(Class activity);
}

package com.kondaurov.ndktest.common;

import android.os.Parcel;
import android.os.Parcelable;

public class AbonData implements Parcelable {

    private int id;
    private String name;
    private String last_name;
    private String number;

    protected AbonData(Parcel in) {
        id = in.readInt();
        name = in.readString();
        last_name = in.readString();
        number = in.readString();
    }

    public static final Creator<AbonData> CREATOR = new Creator<AbonData>() {
        @Override
        public AbonData createFromParcel(Parcel in) {
            return new AbonData(in);
        }

        @Override
        public AbonData[] newArray(int size) {
            return new AbonData[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public AbonData() {
        id = 0;
        name = "";
        last_name = "";
        number = "";
    }

    public AbonData(int id, String name, String last_name, String number) {
        this.id = id;
        this.name = name;
        this.last_name = last_name;
        this.number = number;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeString(last_name);
        parcel.writeString(number);
    }
}

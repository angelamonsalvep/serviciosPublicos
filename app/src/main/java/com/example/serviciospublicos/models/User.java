package com.example.serviciospublicos.models;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {

    public String idCardUser;
    public String nameUser;
    public String passUser;
    public int balance;

    public User(Parcel in) {
        idCardUser = in.readString();
        nameUser = in.readString();
        passUser = in.readString();
        balance = in.readInt();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public User() {

    }

    public String getIdCardUser() {
        return idCardUser;
    }

    public void setIdCardUser(String idCardUser) {
        this.idCardUser = idCardUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getPassUser() {
        return passUser;
    }

    public void setPassUser(String passUser) {
        this.passUser = passUser;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(idCardUser);
        dest.writeString(nameUser);
        dest.writeString(passUser);
        dest.writeInt(balance);
    }
}

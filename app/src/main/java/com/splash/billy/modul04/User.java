package com.splash.billy.modul04;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Billy on 16/12/2017.
 */

public class User implements Parcelable {
    private String email;
    private String password;
    private String namalengkap;
    private String telepon;
    protected String[][] data = new String[][]{
            {"ivan@gmail.com","ivan","Ivan Darmawan","0011","041174686"},
            {"billy@kharisma.ac.id","billy","Billy","0012","08535363"},
            {"anto@kharisma.ac.id","anto","Aprianto","0013","08535363"},
            {"calvin@kharisma.ac.id","calvin","Calvin Thow","0014","0864777889"}
    };

    public User() {

    }


    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNamalengkap() {
        return namalengkap;
    }

    public void setNamalengkap(String namalengkap) {
        this.namalengkap = namalengkap;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.email);
        dest.writeString(this.password);
        dest.writeString(this.namalengkap);
        dest.writeString(this.telepon);
    }

    protected User(Parcel in) {
        this.email = in.readString();
        this.password = in.readString();
        this.namalengkap = in.readString();
        this.telepon = in.readString();
    }

}


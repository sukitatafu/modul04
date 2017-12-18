package com.splash.billy.modul04;

import android.os.Parcel;

/**
 * Created by Billy on 16/12/2017.
 */

public class Members extends User {
    private String idmember;
    private Pinjaman pinjaman;

    public Members(String email) {
        this.setEmail(email);
        this.caridata();
    }
    private void caridata() {
        for(int i=0; i<this.data.length; i++){
            if( this.getEmail().equals( this.data[i][0] ) ){
                this.setIdmember( this.data[i][3] );
                this.setPassword( this.data[i][1] );
                this.setNamalengkap( this.data[i][2] );
                this.setTelepon( this.data[i][4] );
                this.pinjaman = new Pinjaman( this.idmember );
            }
        }
    }

    public Pinjaman getPinjaman() {
        return pinjaman;
    }
    public void setPinjaman(Pinjaman pinjaman) {
        this.pinjaman = pinjaman;
    }
    public String getIdmember() {
        return idmember;
    }

    public void setIdmember(String idmember) {
        this.idmember = idmember;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(this.idmember);
        dest.writeParcelable(this.pinjaman, flags);
    }

    protected Members(Parcel in) {
        super(in);
        this.idmember = in.readString();
        this.pinjaman = in.readParcelable(Pinjaman.class.getClassLoader());
    }

    public static final Creator<Members> CREATOR = new Creator<Members>() {
        @Override
        public Members createFromParcel(Parcel source) {
            return new Members(source);
        }

        @Override
        public Members[] newArray(int size) {
            return new Members[size];
        }
    };
}
package com.splash.billy.modul04;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Billy on 16/12/2017.
 */
public class Pinjaman implements Parcelable {
    private String tanggalPinjam;
    private String tanggalkembali;
    private String id_member;
    private int status = 0;
    private Buku buku;

    private String[][] data = new String[][]{
            {"0011","02 December 2017","10 December 2017","0001"},
            {"0012","01 December 2017","03 December 2017","0002"},
            {"0013","04 December 2017","10 December 2017","0003"}
    };

    public Pinjaman(String idmember){
        this.id_member=idmember;
        this.caripinjaman();
    }

    private void caripinjaman() {
        for (int i=0;i<this.data.length;i++){
            if (this.id_member.equals(this.data[i][0])) {
                this.tanggalPinjam = this.data[i][1];
                this.tanggalkembali = this.data[i][2];
                this.buku = new Buku(data[i][3]);
                this.status=1;}
        }
    }

    public String getTanggalPinjam() {
        return tanggalPinjam;
    }

    public void setTanggalPinjam(String tanggalPinjam) {
        this.tanggalPinjam = tanggalPinjam;
    }

    public String getTanggalkembali() {
        return tanggalkembali;
    }

    public void setTanggalkembali(String tanggalkembali) {
        this.tanggalkembali = tanggalkembali;
    }

    public String getId_member() {
        return id_member;
    }

    public void setId_member(String id_member) {
        this.id_member = id_member;
    }

    public Buku getBuku() {
        return buku;
    }

    public void setBuku(Buku buku) {
        this.buku = buku;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.tanggalPinjam);
        dest.writeString(this.tanggalkembali);
        dest.writeString(this.id_member);
        dest.writeInt(this.status);
        dest.writeParcelable(this.buku, flags);
    }

    protected Pinjaman(Parcel in) {
        this.tanggalPinjam = in.readString();
        this.tanggalkembali = in.readString();
        this.id_member = in.readString();
        this.status = in.readInt();
        this.buku = in.readParcelable(Buku.class.getClassLoader());
    }

    public static final Parcelable.Creator<Pinjaman> CREATOR = new Parcelable.Creator<Pinjaman>() {
        @Override
        public Pinjaman createFromParcel(Parcel source) {
            return new Pinjaman(source);
        }

        @Override
        public Pinjaman[] newArray(int size) {
            return new Pinjaman[size];
        }
    };


}

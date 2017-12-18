package com.splash.billy.modul04;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Billy on 18/12/2017.
 */

public class Buku implements Parcelable {
    private String id_buku;
    private String judul;
    private String author;
    private String publisher;
    private String tahun;


    private String[][] data = new String[][]{
            {"0001","mind control","billy","Rockmaster"},
            {"0002","Resep tempe","ivan","uenak"},
            {"0003","Belajar Vegetarian","billy","Helth"}
    };

    public Buku (String id_buku){
        this.id_buku = id_buku;
        this.caribuku();
    }

    protected Buku(Parcel in) {
        id_buku = in.readString();
        judul = in.readString();
        author = in.readString();
        publisher = in.readString();
        tahun = in.readString();
    }

    public static final Creator<Buku> CREATOR = new Creator<Buku>() {
        @Override
        public Buku createFromParcel(Parcel in) {
            return new Buku(in);
        }

        @Override
        public Buku[] newArray(int size) {
            return new Buku[size];
        }
    };

    private void caribuku() {
        for (int i=0;i<this.data.length;i++){
            if (this.id_buku.equals(this.data[i][0])){
                this.judul = this.data[i][1];
                this.author = this.data[i][2];
                this.publisher = this.data[i][3];
            }
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id_buku);
        parcel.writeString(judul);
        parcel.writeString(author);
        parcel.writeString(publisher);
        parcel.writeString(tahun);
    }
    public String getId_buku() {
        return id_buku;
    }

    public void setId_buku(String id_buku) {
        this.id_buku = id_buku;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getTahun() {
        return tahun;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }
}

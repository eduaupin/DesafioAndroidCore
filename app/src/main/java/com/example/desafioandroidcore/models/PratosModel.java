package com.example.desafioandroidcore.models;


import android.os.Parcel;
import android.os.Parcelable;

public class PratosModel implements Parcelable {
    private int imagemPrato;
    private String nomePrato;
    private String descPrato;

    //Construtores

    public PratosModel(int imagemPrato, String nomePrato, String descPrato) {
        this.imagemPrato = imagemPrato;
        this.nomePrato = nomePrato;
        this.descPrato = descPrato;
    }

    public PratosModel() {
    }

    //Getters and Setters


    protected PratosModel(Parcel in) {
        imagemPrato = in.readInt();
        nomePrato = in.readString();
        descPrato = in.readString();
    }

    public static final Creator<PratosModel> CREATOR = new Creator<PratosModel>() {
        @Override
        public PratosModel createFromParcel(Parcel in) {
            return new PratosModel(in);
        }

        @Override
        public PratosModel[] newArray(int size) {
            return new PratosModel[size];
        }
    };

    public int getImagemPrato() {
        return imagemPrato;
    }

    public void setImagemPrato(int imagemPrato) {
        this.imagemPrato = imagemPrato;
    }

    public String getNomePrato() {
        return nomePrato;
    }

    public void setNomePrato(String nomePrato) {
        this.nomePrato = nomePrato;
    }

    public String getDescPrato() {
        return descPrato;
    }

    public void setDescPrato(String descPrato) {
        this.descPrato = descPrato;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(imagemPrato);
        dest.writeString(nomePrato);
        dest.writeString(descPrato);
    }
}

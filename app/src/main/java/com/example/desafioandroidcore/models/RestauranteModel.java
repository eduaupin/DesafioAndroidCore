package com.example.desafioandroidcore.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;


public class RestauranteModel implements Parcelable {
    private int imagemRestaurante;
    private String nomeRestaurante;
    private String enderecoRestaurante;
    private String horarioFechamento;
    private List<PratosModel> listaDePratos;

    //Construtores


    public RestauranteModel(int imagemRestaurante, String nomeRestaurante, String enderecoRestaurante, String horarioFechamento, List<PratosModel> listaDePratos) {
        this.imagemRestaurante = imagemRestaurante;
        this.nomeRestaurante = nomeRestaurante;
        this.enderecoRestaurante = enderecoRestaurante;
        this.horarioFechamento = horarioFechamento;
        this.listaDePratos = listaDePratos;
    }

    public RestauranteModel() {
    }

    //Getters and Setters

    protected RestauranteModel(Parcel in) {
        imagemRestaurante = in.readInt();
        nomeRestaurante = in.readString();
        enderecoRestaurante = in.readString();
        horarioFechamento = in.readString();
        listaDePratos = in.createTypedArrayList(PratosModel.CREATOR);
    }

    public static final Creator<RestauranteModel> CREATOR = new Creator<RestauranteModel>() {
        @Override
        public RestauranteModel createFromParcel(Parcel in) {
            return new RestauranteModel(in);
        }

        @Override
        public RestauranteModel[] newArray(int size) {
            return new RestauranteModel[size];
        }
    };

    public int getImagemRestaurante() {
        return imagemRestaurante;
    }

    public void setImagemRestaurante(int imagemRestaurante) {
        this.imagemRestaurante = imagemRestaurante;
    }

    public String getNomeRestaurante() {
        return nomeRestaurante;
    }

    public void setNomeRestaurante(String nomeRestaurante) {
        this.nomeRestaurante = nomeRestaurante;
    }

    public String getEnderecoRestaurante() {
        return enderecoRestaurante;
    }

    public void setEnderecoRestaurante(String enderecoRestaurante) {
        this.enderecoRestaurante = enderecoRestaurante;
    }

    public String getHorarioFechamento() {
        return horarioFechamento;
    }

    public void setHorarioFechamento(String horarioFechamento) {
        this.horarioFechamento = horarioFechamento;
    }

    public List<PratosModel> getListaDePratos() {
        return listaDePratos;
    }

    public void setListaDePratos(List<PratosModel> listaDePratos) {
        this.listaDePratos = listaDePratos;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(imagemRestaurante);
        dest.writeString(nomeRestaurante);
        dest.writeString(enderecoRestaurante);
        dest.writeString(horarioFechamento);
        dest.writeTypedList(listaDePratos);
    }
}

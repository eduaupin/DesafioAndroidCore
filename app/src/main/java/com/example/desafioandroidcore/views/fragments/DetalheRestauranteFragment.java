package com.example.desafioandroidcore.views.fragments;


import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.desafioandroidcore.R;
import com.example.desafioandroidcore.models.PratosModel;
import com.example.desafioandroidcore.models.RestauranteModel;

import java.util.List;

import static com.example.desafioandroidcore.views.activities.HomeActivity.RESTAURANTE_KEY;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetalheRestauranteFragment extends Fragment {
    private ImageView imagemRestaurante;
    private TextView nomeRestaurante;
    private List<PratosModel> listaDePratos;
    private RecyclerView recyclerPratos;

    public DetalheRestauranteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detalhe_restaurante, container, false);
        initViews(view);

        if(!getArguments().isEmpty()){
            RestauranteModel  restauranteModel = getArguments().getParcelable(RESTAURANTE_KEY);
            if (restauranteModel != null){
                Drawable drawable = getResources().getDrawable(restauranteModel.getImagemRestaurante());
                imagemRestaurante.setImageDrawable(drawable);
                nomeRestaurante.setText(restauranteModel.getNomeRestaurante());
                listaDePratos = restauranteModel.getListaDePratos();

            }
        }


        return view;
    }
    public void initViews(View view){
        imagemRestaurante = view.findViewById(R.id.imagemRestaurante);
        nomeRestaurante = view.findViewById(R.id.nomeRestaurante);
        recyclerPratos = view.findViewById(R.id.recyclerPratos);
    }
}

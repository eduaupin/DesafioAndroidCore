package com.example.desafioandroidcore.views.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.desafioandroidcore.R;
import com.example.desafioandroidcore.adapters.PratosAdapter;
import com.example.desafioandroidcore.models.PratosModel;
import com.example.desafioandroidcore.models.RestauranteModel;

import java.util.ArrayList;
import java.util.List;

import static com.example.desafioandroidcore.views.activities.HomeActivity.RESTAURANTE_KEY;

public class DetalheRestauranteActivity extends AppCompatActivity {
    private ImageView imagemRestaurante;
    private TextView nomeRestaurante;
    private List<PratosModel> listaDePratos = new ArrayList<>();
    private RecyclerView recyclerPratos;
    private PratosAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_restaurante);
        initViews();

        if (getIntent() != null) {
            RestauranteModel restauranteModel = getIntent().getParcelableExtra(RESTAURANTE_KEY);
            if (restauranteModel != null){

            }
            Drawable drawable = getResources().getDrawable(restauranteModel.getImagemRestaurante());

            imagemRestaurante.setImageDrawable(drawable);
            nomeRestaurante.setText(restauranteModel.getNomeRestaurante());

            listaDePratos = restauranteModel.getListaDePratos();

            adapter = new PratosAdapter(listaDePratos);

            LinearLayoutManager linearLayout = new LinearLayoutManager(this);
            recyclerPratos.setAdapter(adapter);
            recyclerPratos.setLayoutManager(linearLayout);


        }
    }
    public void initViews () {
        imagemRestaurante = findViewById(R.id.imagemRestaurante);
        nomeRestaurante = findViewById(R.id.nomeRestaurante);
        recyclerPratos = findViewById(R.id.recyclerPratos);
    }
}

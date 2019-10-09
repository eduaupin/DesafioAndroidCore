package com.example.desafioandroidcore.views.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.desafioandroidcore.R;
import com.example.desafioandroidcore.adapters.PratosAdapter;
import com.example.desafioandroidcore.interfaces.RecyclerViewOnClickPratos;
import com.example.desafioandroidcore.models.PratosModel;
import com.example.desafioandroidcore.models.RestauranteModel;

import java.util.ArrayList;
import java.util.List;

import static com.example.desafioandroidcore.views.activities.HomeActivity.RESTAURANTE_KEY;

public class DetalheRestauranteActivity extends AppCompatActivity implements RecyclerViewOnClickPratos {
    private ImageView imagemRestaurante;
    private TextView nomeRestaurante;
    private List<PratosModel> listaDePratos = new ArrayList<>();
    private RecyclerView recyclerPratos;
    private PratosAdapter adapter;

    public static final String PRATOS_KEY = "pratos";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_restaurante);
        initViews();

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.icon_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        if (getIntent() != null) {
            RestauranteModel restauranteModel = getIntent().getExtras().getParcelable(RESTAURANTE_KEY);

            if (restauranteModel != null){

                Drawable drawable = getResources().getDrawable(restauranteModel.getImagemRestaurante());
                imagemRestaurante.setImageDrawable(drawable);

                nomeRestaurante.setText(restauranteModel.getNomeRestaurante());

                listaDePratos = restauranteModel.getListaDePratos();

                adapter = new PratosAdapter(listaDePratos, this);

                GridLayoutManager linearLayout = new GridLayoutManager(this, 2);

                recyclerPratos.setAdapter(adapter);

                recyclerPratos.setLayoutManager(linearLayout);
            }
        }
    }

    public void initViews () {
        imagemRestaurante = findViewById(R.id.imagemRestaurante);
        nomeRestaurante = findViewById(R.id.nomeRestaurante);
        recyclerPratos = findViewById(R.id.recyclerPratos);
    }

    @Override
    public void onClick(PratosModel pratosModel) {
        Intent intent = new Intent(this, DetalhePratoActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(PRATOS_KEY, pratosModel);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}

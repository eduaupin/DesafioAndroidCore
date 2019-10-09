package com.example.desafioandroidcore.views.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.desafioandroidcore.R;
import com.example.desafioandroidcore.models.PratosModel;
import com.example.desafioandroidcore.models.RestauranteModel;

import static com.example.desafioandroidcore.views.activities.DetalheRestauranteActivity.PRATOS_KEY;
import static com.example.desafioandroidcore.views.activities.HomeActivity.RESTAURANTE_KEY;

public class DetalhePratoActivity extends AppCompatActivity {
    private ImageView imagemPrato;
    private TextView nomePrato;
    private TextView descPrato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_prato);
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

            PratosModel pratosModel = getIntent().getExtras().getParcelable(PRATOS_KEY);

            if (pratosModel != null) {

                Drawable drawable = getResources().getDrawable(pratosModel.getImagemPrato());

                imagemPrato.setImageDrawable(drawable);

                nomePrato.setText(pratosModel.getNomePrato());

                descPrato.setText(pratosModel.getDescPrato());

            }

        }
    }
    public void initViews(){
        imagemPrato = findViewById(R.id.imagemPrato);
        nomePrato = findViewById(R.id.nomePrato);
        descPrato = findViewById(R.id.descPrato);

    }

}

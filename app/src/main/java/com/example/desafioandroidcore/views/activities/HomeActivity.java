package com.example.desafioandroidcore.views.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.desafioandroidcore.R;
import com.example.desafioandroidcore.adapters.RestauranteAdapter;
import com.example.desafioandroidcore.interfaces.RecyclerViewOnClick;
import com.example.desafioandroidcore.models.PratosModel;
import com.example.desafioandroidcore.models.RestauranteModel;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements RecyclerViewOnClick {
    private RecyclerView recyclerHome;
    private List<RestauranteModel> listaDeRestaurantes;
    private List<PratosModel> listaDePratos;
    private RestauranteAdapter restauranteAdapter;
    public static final String RESTAURANTE_KEY = "restaurante";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        initViews();

        restauranteAdapter = new RestauranteAdapter(popularRestaurantes(), this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerHome.setAdapter(restauranteAdapter);
        recyclerHome.setLayoutManager(linearLayoutManager);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        //Criação de uma variavel que vai receber o id do item selecionado
        int id = item.getItemId();

        //Verifica se o id recebido é igual ao do layout e realiza uma ação
        if (id == R.id.action_settings) {
//            Intent intent = new Intent(HomeActivity.this, ProfileActivity.class);
//            startActivity(intent);
            Toast.makeText(this, "Settings", Toast.LENGTH_LONG).show();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public List<RestauranteModel> popularRestaurantes(){
        listaDeRestaurantes = new ArrayList<>();
        listaDeRestaurantes.add(new RestauranteModel(R.drawable.restaurante1, "Tony Roma's", "Av. Lavandisca, 717 - Indianópolis, São Paulo", "Fecha às 22:00", popularListaPratos()));
        listaDeRestaurantes.add(new RestauranteModel(R.drawable.restaurante2, "Aoyama - Moema", "Alameda dos Arapanés, 532 - Moema", "Fecha às 00:00", popularListaPratos()));
        listaDeRestaurantes.add(new RestauranteModel(R.drawable.restaurante3, "Outback - Moema", "Av. Moaci, 187, 187 - Moema, São Paulo", "Fecha às 00:00", popularListaPratos()));
        listaDeRestaurantes.add(new RestauranteModel(R.drawable.restaurante4, "Sí Señor!", "Alameda Jauaperi, 626 - Moema", "Fecha às 01:00", popularListaPratos()));

        return listaDeRestaurantes;
    }

    public List<PratosModel> popularListaPratos(){
        listaDePratos = new ArrayList<>();
        listaDePratos.add(new PratosModel(R.drawable.prato1, "Salada com molho Gengibre", "Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis."));
        listaDePratos.add(new PratosModel(R.drawable.prato1, "Salada com molho Gengibre", "Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis."));
        listaDePratos.add(new PratosModel(R.drawable.prato1, "Salada com molho Gengibre", "Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis."));
        listaDePratos.add(new PratosModel(R.drawable.prato1, "Salada com molho Gengibre", "Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis."));
        return listaDePratos;
    }
    private void initViews(){
        recyclerHome = findViewById(R.id.recyclerHome);
    }

    @Override
    public void onClick(RestauranteModel restauranteModel) {
        Intent intent = new Intent(HomeActivity.this, DetalheRestauranteActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(RESTAURANTE_KEY, restauranteModel);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}

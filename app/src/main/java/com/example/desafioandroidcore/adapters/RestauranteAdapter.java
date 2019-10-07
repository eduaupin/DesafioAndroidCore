package com.example.desafioandroidcore.adapters;


import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.desafioandroidcore.R;
import com.example.desafioandroidcore.interfaces.RecyclerViewOnClick;
import com.example.desafioandroidcore.models.RestauranteModel;

import java.util.List;


public class RestauranteAdapter extends RecyclerView.Adapter<RestauranteAdapter.ViewHolder> {
    private List<RestauranteModel> listaDeRestaurantes;
    private RecyclerViewOnClick listener;

    public RestauranteAdapter(List<RestauranteModel> listaDeRestaurantes, RecyclerViewOnClick listener) {
        this.listaDeRestaurantes = listaDeRestaurantes;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final RestauranteModel restauranteModel = listaDeRestaurantes.get(position);
        holder.bind(restauranteModel);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(restauranteModel);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listaDeRestaurantes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imagemRestaurante;
        private TextView nomeRestaurante;
        private TextView enderecoRestaurante;
        private TextView horarioFuncionamento;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imagemRestaurante = itemView.findViewById(R.id.imagemRestaurante);
            nomeRestaurante = itemView.findViewById(R.id.nomeRestaurante);
            enderecoRestaurante = itemView.findViewById(R.id.enderecoRestaurante);
            horarioFuncionamento = itemView.findViewById(R.id.horarioFechamento);

        }
        public void bind(RestauranteModel restauranteModel){
            Drawable drawable = itemView.getResources().getDrawable(restauranteModel.getImagemRestaurante());
            imagemRestaurante.setImageDrawable(drawable);
            nomeRestaurante.setText(restauranteModel.getNomeRestaurante());
            enderecoRestaurante.setText(restauranteModel.getEnderecoRestaurante());
            horarioFuncionamento.setText(restauranteModel.getHorarioFechamento());
        }
    }
}

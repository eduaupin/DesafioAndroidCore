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
import com.example.desafioandroidcore.models.PratosModel;

import java.util.List;

public class PratosAdapter extends RecyclerView.Adapter<PratosAdapter.ViewHolder> {
    private List<PratosModel> listaDePratos;

    public PratosAdapter(List<PratosModel> listaDePratos) {
        this.listaDePratos = listaDePratos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pratos, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PratosModel pratosModel = listaDePratos.get(position);
        holder.bind(pratosModel);
    }

    @Override
    public int getItemCount() {
        return listaDePratos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView nomePrato;
        private ImageView imagemPrato;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imagemPrato = itemView.findViewById(R.id.imagemPrato);
            nomePrato = itemView.findViewById(R.id.nomeDoPrato);

        }
        public void bind(PratosModel pratosModel){

            Drawable drawable = itemView.getResources().getDrawable(pratosModel.getImagemPrato());
            imagemPrato.setImageDrawable(drawable);
            nomePrato.setText(pratosModel.getNomePrato());

        }
    }
}
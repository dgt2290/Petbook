package com.example.petbook.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.petbook.pojo.Publicacion;
import com.example.petbook.R;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

public class PublicacionAdapter extends RecyclerView.Adapter<PublicacionAdapter.PublicacionViewHolder> {

    ArrayList<Publicacion> publicaciones;

    public PublicacionAdapter(ArrayList<Publicacion> publicaciones) {
        this.publicaciones = publicaciones;
    }

    @NonNull
    @Override
    public PublicacionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_publicacion , parent, false);
        return new PublicacionViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PublicacionViewHolder holder, int position) {
        Publicacion publicacion = publicaciones.get(position);
        holder.fotoPublicacion.setImageResource(publicacion.getFoto());
        holder.huesosPublicacion.setText(String.valueOf(publicacion.getHuesos()));
    }

    @Override
    public int getItemCount() {
        return publicaciones.size();
    }

    public static class PublicacionViewHolder extends RecyclerView.ViewHolder {
        private ImageView fotoPublicacion;
        private TextView huesosPublicacion;

        public PublicacionViewHolder(@NonNull View itemView) {
            super(itemView);
            fotoPublicacion = (ImageView) itemView.findViewById(R.id.fotoPublicacion);
            huesosPublicacion = (TextView) itemView.findViewById(R.id.huesosPublicacion);
        }
    }
}

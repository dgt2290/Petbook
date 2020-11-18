package com.example.petbook.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.petbook.db.InteractorMascotas;
import com.example.petbook.pojo.Mascota;
import com.example.petbook.R;

import java.util.ArrayList;

public class MascotaAdapter extends RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder> {

    private ArrayList<Mascota> mascotas;
    private ArrayList<Mascota> favoritos;

    public MascotaAdapter(ArrayList<Mascota> mascotas, ArrayList<Mascota> favoritos) {
        this.mascotas = mascotas;
        this.favoritos = favoritos;
    }

    public ArrayList<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    public ArrayList<Mascota> getFavoritos() {
        return favoritos;
    }

    public void setFavoritos(ArrayList<Mascota> favoritos) {
        this.favoritos = favoritos;
    }

    @NonNull
    @Override
    // Crea una vista (View v) y la "infla" con el layout configurado
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    // Recibe la vista generada y modifica sus atributos
    public void onBindViewHolder(@NonNull MascotaViewHolder holder, int position) {

        Mascota mascota = mascotas.get(position);
        holder.foto.setImageResource(mascota.getFoto());
        holder.nombre.setText(mascota.getNombre());
        holder.huesos.setText(String.valueOf(mascota.getHuesos()));
        holder.btnHueso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mascota.darHueso();
                holder.huesos.setText(String.valueOf(mascota.getHuesos()));

                if (favoritos != null) {
                    if (!(estaEnFavoritos(mascota))) {
                        agregarFavoritos(mascota);
                    }
                }

                InteractorMascotas interactorMascotas = new InteractorMascotas(v.getContext());
                interactorMascotas.darHueso(mascota);
            }
        });
    }

    @Override
    public int getItemCount() { // Devuelve la cantidad de elementos de mi lista
        return mascotas.size();
    }

    // Comprueba si un objeto Mascota se encuentra en el ArrayList favoritos
    public boolean estaEnFavoritos(Mascota mascota) {
        if (!(favoritos.isEmpty())) {
            for (Mascota f : favoritos) {
                if (f.equals(mascota)) {
                    f.setHuesos(mascota.getHuesos());
                    return true;
                }
            }
        }
        return false;
    }

    // Agrega un nuevo objeto Mascota al ArrayList favoritos
    public void agregarFavoritos(Mascota mascota) {
        getFavoritos().add(mascota);
    }



    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView foto;
        private TextView nombre;
        private TextView huesos;
        private Button btnHueso;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            foto = (ImageView) itemView.findViewById(R.id.foto);
            nombre = (TextView) itemView.findViewById(R.id.nombre);
            huesos = (TextView) itemView.findViewById(R.id.huesos);
            btnHueso = (Button) itemView.findViewById(R.id.btnHueso);
        }

    }
}
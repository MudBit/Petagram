package mx.mudbit.petagram.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import mx.mudbit.petagram.R;
import mx.mudbit.petagram.models.Mascota;

public class MascotaAdapter extends RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;

    public MascotaAdapter(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position);
        holder.ivMascota.setImageResource(mascota.getFoto());
        holder.tvNombre.setText(mascota.getNombre());
        holder.tvPopularidad.setText(mascota.getPopularidad());
        holder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int raiting = 0;
                raiting = Integer.parseInt(mascota.getPopularidad()) + 1;
                mascota.setPopularidad(String.valueOf(raiting));
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{
        private ImageView ivMascota;
        private TextView tvNombre;
        private TextView tvPopularidad;
        private ImageButton btnLike;


        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            ivMascota = (ImageView) itemView.findViewById(R.id.ivMascotaImage);
            tvNombre = (TextView) itemView.findViewById(R.id.tvMascotaName);
            tvPopularidad = (TextView) itemView.findViewById(R.id.tvMascotaPopularidad);
            btnLike = (ImageButton) itemView.findViewById(R.id.ibHuesoWhite);
        }
    }
}

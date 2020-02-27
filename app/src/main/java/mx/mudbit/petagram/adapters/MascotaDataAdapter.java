package mx.mudbit.petagram.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import mx.mudbit.petagram.R;
import mx.mudbit.petagram.models.MascotaData;

public class MascotaDataAdapter extends RecyclerView.Adapter<MascotaDataAdapter.MascotaDataViewHolder> {

    ArrayList<MascotaData> mascotaData;

    public MascotaDataAdapter(ArrayList<MascotaData> mascotaData){
        this.mascotaData = mascotaData;
    }

    @NonNull
    @Override
    public MascotaDataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota_data, parent, false);
        return new MascotaDataAdapter.MascotaDataViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotaDataViewHolder holder, int position) {
        MascotaData mascota = mascotaData.get(position);
        holder.ivFoto.setImageResource(mascota.getFoto());
        holder.tvRating.setText(mascota.getRaiting());
    }

    @Override
    public int getItemCount() {
        return mascotaData.size();
    }

    public static class MascotaDataViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivFoto;
        private TextView tvRating;

        public MascotaDataViewHolder(@NonNull View itemView){
            super(itemView);
            ivFoto = (ImageView) itemView.findViewById(R.id.ivMascotaFoto);
            tvRating = (TextView) itemView.findViewById(R.id.tvRaiting);
        }
    }
}

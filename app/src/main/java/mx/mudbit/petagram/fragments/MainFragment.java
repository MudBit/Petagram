package mx.mudbit.petagram.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import mx.mudbit.petagram.R;
import mx.mudbit.petagram.adapters.MascotaAdapter;
import mx.mudbit.petagram.models.Mascota;

public class MainFragment extends Fragment {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vFragment = inflater.inflate(R.layout.fragment_main, container, false);
        listaMascotas = (RecyclerView) vFragment.findViewById(R.id.rvMascotas);

        LinearLayoutManager linearLManager = new LinearLayoutManager(getActivity());
        linearLManager.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(linearLManager);

        initializeListaMascotas();
        initializeMascotasAdapter();

        return vFragment;
    }

    public void initializeMascotasAdapter(){
        MascotaAdapter mascotaAdapter = new MascotaAdapter(mascotas);
        listaMascotas.setAdapter(mascotaAdapter);
    }

    public void initializeListaMascotas(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.dog1, "Perro 1", "4"));
        mascotas.add(new Mascota(R.drawable.dog2, "Perro 2", "8"));
        mascotas.add(new Mascota(R.drawable.dog3, "Perro 3", "12"));
        mascotas.add(new Mascota(R.drawable.dog2, "Perro 4", "34"));
        mascotas.add(new Mascota(R.drawable.dog3, "Perro 5", "5"));
        mascotas.add(new Mascota(R.drawable.dog1, "Perro 6", "10"));
    }

}

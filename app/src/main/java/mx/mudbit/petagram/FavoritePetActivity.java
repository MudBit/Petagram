package mx.mudbit.petagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import mx.mudbit.petagram.adapters.MascotaAdapter;
import mx.mudbit.petagram.models.Mascota;

public class FavoritePetActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_pet);

        Toolbar actionBarFavoritePets = (Toolbar) findViewById(R.id.miFavActionBar);
        setSupportActionBar(actionBarFavoritePets);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listMascotas = (RecyclerView) findViewById(R.id.rvMascotasFav);

        LinearLayoutManager linearLManager = new LinearLayoutManager(this);
        linearLManager.setOrientation(LinearLayoutManager.VERTICAL);

        listMascotas.setLayoutManager(linearLManager);

        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.dog1,"Perrito dos","2"));
        mascotas.add(new Mascota(R.drawable.dog2,"Gato cuatro","3"));
        mascotas.add(new Mascota(R.drawable.dog3,"Perrito tres","1"));

        MascotaAdapter adapterPet = new MascotaAdapter(mascotas);
        listMascotas.setAdapter(adapterPet);
    }


}

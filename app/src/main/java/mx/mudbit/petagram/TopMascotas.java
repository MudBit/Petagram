package mx.mudbit.petagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageButton;

import java.util.ArrayList;

public class TopMascotas extends AppCompatActivity {


    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_mascotas);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Fancy", R.drawable.dog3));
        mascotas.add(new Mascota("Letto", R.drawable.dog4));
        mascotas.add(new Mascota("Gary", R.drawable.dog5));
        mascotas.add(new Mascota("Kinky", R.drawable.dog1));
        mascotas.add(new Mascota("Naty", R.drawable.dog2));

        listaMascotas = (RecyclerView) findViewById(R.id.rvTopMascotas);

        // GridLayoutManager glm = new GridLayoutManager(this, 2);


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);


        listaMascotas.setLayoutManager(layoutManager);
        inicializarAdaptador();
    }


    public void inicializarAdaptador(){
        MascotaAdapter adapter = new MascotaAdapter(mascotas, this);
        listaMascotas.setAdapter(adapter);
    }
}

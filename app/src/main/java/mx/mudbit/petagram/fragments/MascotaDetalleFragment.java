package mx.mudbit.petagram.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

import mx.mudbit.petagram.R;
import mx.mudbit.petagram.adapters.MascotaAdapter;
import mx.mudbit.petagram.adapters.MascotaDataAdapter;
import mx.mudbit.petagram.models.MascotaData;

public class MascotaDetalleFragment extends Fragment {

    ArrayList<MascotaData> mascotaData;
    private RecyclerView listMascotaData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View vFragmentDetalle = inflater.inflate(R.layout.fragment_mascota_detalle, container, false);

        CircularImageView circularImageView = (CircularImageView) vFragmentDetalle.findViewById(R.id.cImagePet);
        circularImageView.setCircleColor(R.color.circuler_color);
        circularImageView.setBorderWidth(10f);
        circularImageView.setBorderColor(R.color.circuler_boder);
        circularImageView.setShadowEnable(true);

        listMascotaData = (RecyclerView) vFragmentDetalle.findViewById(R.id.rvMascotaDetalle);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);

        listMascotaData.setLayoutManager(gridLayoutManager);

        initializeMascotaDataList();
        initializeMascotaAdapter();

        return vFragmentDetalle;

    }

    public void initializeMascotaAdapter(){
        MascotaDataAdapter mascotaAdapter = new MascotaDataAdapter(mascotaData);
        listMascotaData.setAdapter(mascotaAdapter);
    }

    public void initializeMascotaDataList(){
        mascotaData = new ArrayList<MascotaData>();
        mascotaData.add(new MascotaData(R.drawable.dog1, "8"));
        mascotaData.add(new MascotaData(R.drawable.dog2, "5"));
        mascotaData.add(new MascotaData(R.drawable.dog3, "6"));
        mascotaData.add(new MascotaData(R.drawable.dog2, "2"));
        mascotaData.add(new MascotaData(R.drawable.dog3, "5"));
        mascotaData.add(new MascotaData(R.drawable.dog2, "6"));
        mascotaData.add(new MascotaData(R.drawable.dog1, "7"));
    }


}

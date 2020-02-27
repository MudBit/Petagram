package mx.mudbit.petagram.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class PageAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> fragmentArray;

    public PageAdapter(@NonNull FragmentManager fm, int behavior, ArrayList<Fragment> fragmentArray) {
        super(fm, behavior);
        this.fragmentArray = fragmentArray;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentArray.get(position);
    }

    @Override
    public int getCount() {
        return fragmentArray.size();
    }
}

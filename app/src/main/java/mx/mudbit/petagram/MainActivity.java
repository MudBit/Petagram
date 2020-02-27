package mx.mudbit.petagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import mx.mudbit.petagram.adapters.PageAdapter;
import mx.mudbit.petagram.fragments.MainFragment;
import mx.mudbit.petagram.fragments.MascotaDetalleFragment;

public class MainActivity extends AppCompatActivity {
    Toolbar actionbBar;
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actionbBar = (Toolbar) findViewById(R.id.miActionBar);
        agregarFAB();

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        setUpViewPager();

        if(actionbBar != null){
            setSupportActionBar(actionbBar);
            actionbBar.setNavigationIcon(R.drawable.pawprint);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        switch (item.getItemId()){
            case R.id.favoritePets:
                Intent intent = new Intent(MainActivity.this, FavoritePetActivity.class);
                startActivity(intent);
                break;
            case R.id.mContact:
                Intent intentContact = new Intent(this, ContactActivity.class);
                startActivity(intentContact);
                break;
            case R.id.mAbout:
                Intent intentAbout = new Intent(this, AboutActivity.class);
                startActivity(intentAbout);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void agregarFAB(){
        FloatingActionButton flBtn = (FloatingActionButton) findViewById(R.id.btnFloatMain);
        flBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private ArrayList<Fragment> addFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new MainFragment());
        fragments.add(new MascotaDetalleFragment());
        return fragments;
    }

    public void setUpViewPager() {
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), 0, addFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_launcher_background);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_launcher_foreground);
    }

}

package mx.mudbit.petagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Toolbar actionBarAbout = (Toolbar) findViewById(R.id.actionBarAbout);
        setSupportActionBar(actionBarAbout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}

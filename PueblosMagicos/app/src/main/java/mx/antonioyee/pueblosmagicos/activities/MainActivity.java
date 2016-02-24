package mx.antonioyee.pueblosmagicos.activities;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import mx.antonioyee.pueblosmagicos.R;
import mx.antonioyee.pueblosmagicos.fragments.ListMagicTownFragment;
import mx.antonioyee.pueblosmagicos.fragments.ListNewsFragment;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fm = getSupportFragmentManager();

        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.content, new ListMagicTownFragment());
        ft.commit();
    }
}

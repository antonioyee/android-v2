package mx.antonioyee.pueblosmagicos.activities;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import mx.antonioyee.pueblosmagicos.R;
import mx.antonioyee.pueblosmagicos.fragments.ImagesTownFragment;
import mx.antonioyee.pueblosmagicos.fragments.ListMagicTownFragment;
import mx.antonioyee.pueblosmagicos.fragments.ListNewsFragment;
import mx.antonioyee.pueblosmagicos.fragments.LocationFragment;
import mx.antonioyee.pueblosmagicos.fragments.NavigationFragment;
import mx.antonioyee.pueblosmagicos.models.MagicTown;

public class MainActivity extends AppCompatActivity implements ListMagicTownFragment.CallBacks {

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

    @Override
    public void onTownSelected(MagicTown magicTown) {
        fm = getSupportFragmentManager();

        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.content, new LocationFragment().newInstance(magicTown.getName() + "," + magicTown.getState()));
        ft.addToBackStack(LocationFragment.TAG);
        ft.commit();
    }
}

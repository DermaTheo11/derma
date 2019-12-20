package polinema.ac.id.UTS.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import polinema.ac.id.UTS.R;
import polinema.ac.id.UTS.fragments.LocFragment;
import polinema.ac.id.UTS.fragments.MinumFragment;
import polinema.ac.id.UTS.fragments.HomeFragment;
import polinema.ac.id.UTS.fragments.PizzaFragment;
import polinema.ac.id.UTS.fragments.UserFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadFragment (new HomeFragment());
        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .addToBackStack(null)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        switch (menuItem.getItemId()) {
            case R.id.home:
                fragment = new HomeFragment();
                break;
            case R.id.pizza:
                fragment = new PizzaFragment();
                break;
            case R.id.minum:
                fragment = new MinumFragment();
                break;

            case R.id.loc:
                fragment = new LocFragment();
                break;
            case R.id.user:
                fragment = new UserFragment();
                break;
        }
        return loadFragment(fragment);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }


}

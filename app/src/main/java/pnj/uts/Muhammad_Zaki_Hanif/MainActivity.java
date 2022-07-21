package pnj.uts.Muhammad_Zaki_Hanif;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import pnj.uts.Muhammad_Zaki_Hanif.Fragment.Home;
import pnj.uts.Muhammad_Zaki_Hanif.Fragment.ItemFragment;
import pnj.uts.Muhammad_Zaki_Hanif.Fragment.ProfileFragment;
import pnj.uts.Muhammad_Zaki_Hanif.databinding.ActivityMainBinding;
import pnj.uts.Muhammad_Zaki_Hanif.sharedPreference.Preferences;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        openFragment(new Home());

    }
    public void openFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_menu_item, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.navigation_tambah_data:
                this.startActivity(new Intent(MainActivity.this,AddActivity.class));

                break;
            case R.id.navigation_data_penduduk:
                this.startActivity(new Intent(MainActivity.this, ListActivity.class));

                break;
            case R.id.navigation_logout:
                Preferences.clearDataUser(this);
                this.startActivity(new Intent(MainActivity.this, Login.class));
                finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
    item -> {
        switch (item.getItemId()){
            case R.id.navigation_home:
            openFragment(new Home());
            return true;

            case R.id.navigation_berita:
                openFragment(new ItemFragment());
                return true;
            case R.id.navigation_profile:
                openFragment(new ProfileFragment());
                return true;
            default:
                return false;
        }
    };

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
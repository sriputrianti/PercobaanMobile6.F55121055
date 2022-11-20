package com.sriputriantimateka_f55121055.percobaanmobile6f55121055;

import static com.google.android.material.bottomnavigation.BottomNavigationView.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.sriputriantimateka_f55121055.percobaanmobile6f55121055.databinding.ActivityContentBinding;

public class ContentActivity extends AppCompatActivity {
    private ActivityContentBinding binding;
    private BottomNavigationView.OnNavigationItemSelectedListener
    mOnNavigationItemSelectionListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment = new HomeFragment();
                    switchFragment (fragment);
                    return true;
                case R.id.navigation_dashboard:
                    fragment = new DashboardFragment();
                    switchFragment (fragment);
                    return true;
                case R.id.navigation_account:
                    fragment = new AccountFragment();
                    switchFragment (fragment);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        binding = ActivityContentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectionListener);

        if (savedInstanceState == null) {
            binding.navigation.setSelectedItemId(R.id.navigation_home);
        }
    }
    private void switchFragment (Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.container_layout, fragment,
                fragment.getClass().getSimpleName()).commit();
    }
}
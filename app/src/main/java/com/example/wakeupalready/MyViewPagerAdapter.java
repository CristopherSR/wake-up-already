package com.example.wakeupalready;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.example.wakeupalready.fragments.Destinos;
import com.example.wakeupalready.fragments.Favoritos;
import com.example.wakeupalready.fragments.SettingsFragment;
import org.jetbrains.annotations.NotNull;

public class MyViewPagerAdapter extends FragmentStateAdapter {
    public MyViewPagerAdapter(@NonNull @NotNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @NotNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new Favoritos();
            case 1:
                return new Destinos();
            case 2:
                return new SettingsFragment();
            default:
                return new Favoritos();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}

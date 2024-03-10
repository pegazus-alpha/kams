package com.example.flag;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;


public class MonFragmentPagerAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> fragments=new ArrayList<>();
    private List<Integer> titres=new ArrayList<>();
    private final int[] iconeIds={R.drawable.maison,R.drawable.ampoule,R.drawable.cours,R.drawable.exercices};

    public MonFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }
    public void ajouterFragment(Fragment fragment,int titre) {
        fragments.add(fragment);
        titres.add(titre);
    }


    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return fragments.get(0);
            case 1:
                return fragments.get(1);
            case 2:
                return fragments.get(2);
            case 3:
                return fragments.get(3);
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            default:
                return null;

        }

    }
}



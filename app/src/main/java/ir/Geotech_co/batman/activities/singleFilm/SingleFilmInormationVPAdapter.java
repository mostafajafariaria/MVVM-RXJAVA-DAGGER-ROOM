package ir.Geotech_co.batman.activities.singleFilm;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import javax.inject.Inject;

import ir.Geotech_co.batman.fragments.InformationSingleFilmFragment;


public class SingleFilmInormationVPAdapter extends FragmentPagerAdapter {

    private Bundle bundle;

    @Inject
    public SingleFilmInormationVPAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setBundle(Bundle bundle) {
        this.bundle = bundle;
    }

    @Override
    public Fragment getItem(int position) {

        return InformationSingleFilmFragment.newInstance(bundle);


    }

    @Override
    public int getCount() {
        return 3;
    }


}
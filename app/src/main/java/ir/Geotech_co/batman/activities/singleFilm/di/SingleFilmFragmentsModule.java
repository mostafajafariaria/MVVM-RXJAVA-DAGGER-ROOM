package ir.Geotech_co.batman.activities.singleFilm.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import ir.Geotech_co.batman.fragments.InformationSingleFilmFragment;
import ir.Geotech_co.batman.fragments.di.InformationSingleFragmentModule;

@SuppressWarnings("unused")
@Module
public abstract class SingleFilmFragmentsModule {

    @ContributesAndroidInjector(modules = InformationSingleFragmentModule.class)
    public abstract InformationSingleFilmFragment bindInformationSingleCouponFragment();
}

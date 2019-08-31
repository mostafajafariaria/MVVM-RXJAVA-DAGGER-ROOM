package ir.Geotech_co.batman.activities.singleFilm.di;

import android.arch.lifecycle.ViewModelProviders;

import dagger.Module;
import dagger.Provides;
import ir.Geotech_co.batman.activities.singleFilm.SingleFilmActivity;
import ir.Geotech_co.batman.activities.singleFilm.SingleFilmInormationVPAdapter;
import ir.Geotech_co.batman.activities.singleFilm.SingleFilmViewModel;
import ir.Geotech_co.batman.activities.singleFilm.SingleFilmViewModelFactory;

@Module
public abstract class SingleFilmActivityModule {

    @Provides
    static SingleFilmViewModel provideViewModel(SingleFilmActivity activity, SingleFilmViewModelFactory factory) {
        return ViewModelProviders.of(activity, factory).get(SingleFilmViewModel.class);
    }

    @Provides
    static SingleFilmInormationVPAdapter provideFilmVPAdapter(SingleFilmActivity activity) {
        return new SingleFilmInormationVPAdapter(activity.getSupportFragmentManager());
    }

}

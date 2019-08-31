package ir.Geotech_co.batman.fragments.di;

import android.arch.lifecycle.ViewModelProviders;

import dagger.Module;
import dagger.Provides;
import ir.Geotech_co.batman.fragments.InformationSingleFilmFragment;
import ir.Geotech_co.batman.fragments.InformationSingleFilmViewModel;
import ir.Geotech_co.batman.fragments.InformationSingleViewModelFactory;

@Module
public abstract class InformationSingleFragmentModule {

    @Provides
    static InformationSingleFilmViewModel provideViewModel(InformationSingleFilmFragment fragment, InformationSingleViewModelFactory factory) {
        return ViewModelProviders.of(fragment, factory).get(InformationSingleFilmViewModel.class);
    }
}

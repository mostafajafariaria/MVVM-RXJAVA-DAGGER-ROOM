package ir.Geotech_co.batman.activities.main.di;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.widget.LinearLayoutManager;

import dagger.Module;
import dagger.Provides;
import ir.Geotech_co.batman.activities.main.MainActivity;
import ir.Geotech_co.batman.activities.main.MainViewModel;
import ir.Geotech_co.batman.activities.main.MainViewModelFactory;
import ir.Geotech_co.batman.appAnnotations.VerticalOrientationRV;

@Module
public abstract class MainActivityModule {

    @Provides
    static MainViewModel provideViewModel(MainActivity activity, MainViewModelFactory factory) {
        return ViewModelProviders.of(activity, factory).get(MainViewModel.class);
    }

    @VerticalOrientationRV
    @Provides
    static LinearLayoutManager provideVerticalLinearLayoutManager(MainActivity activity) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        return linearLayoutManager;
    }

}

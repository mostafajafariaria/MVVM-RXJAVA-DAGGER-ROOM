package ir.Geotech_co.batman.app;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import ir.Geotech_co.batman.activities.main.MainActivity;
import ir.Geotech_co.batman.activities.main.di.MainActivityModule;
import ir.Geotech_co.batman.activities.singleFilm.SingleFilmActivity;
import ir.Geotech_co.batman.activities.singleFilm.di.SingleFilmActivityModule;
import ir.Geotech_co.batman.activities.singleFilm.di.SingleFilmFragmentsModule;

@SuppressWarnings("unused")
@Module
public abstract class BuilderModule {

    @ContributesAndroidInjector(modules = MainActivityModule.class)
    public abstract MainActivity bindMainActivity();

    @ContributesAndroidInjector(modules = {SingleFilmActivityModule.class, SingleFilmFragmentsModule.class})
    public abstract SingleFilmActivity bindFilmActivity();


}

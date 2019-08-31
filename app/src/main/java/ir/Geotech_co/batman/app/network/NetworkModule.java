package ir.Geotech_co.batman.app.network;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ir.Geotech_co.batman.app.manager.rest.MyClubApi;
import ir.Geotech_co.batman.utils.SchedulersFacade;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = {OkHttpModule.class})
public class NetworkModule {

    @Provides
    static Retrofit provideRestHelper(OkHttpClient client,  SchedulersFacade scheduler) {
        return new Retrofit.Builder()
                .baseUrl(EndPoint.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(scheduler.io()))
                .build();
    }

    @Provides
    @Singleton
    static MyClubApi provideApi(Retrofit retrofit){
        return retrofit.create(MyClubApi.class);
    }


}

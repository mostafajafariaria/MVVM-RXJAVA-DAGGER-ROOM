package ir.Geotech_co.batman.activities.main;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Provider;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import ir.Geotech_co.batman.R;
import ir.Geotech_co.batman.activities.main.rv.MainCategoryRvAdapter;
import ir.Geotech_co.batman.appAnnotations.VerticalOrientationRV;
import ir.Geotech_co.batman.base.BaseDaggerCompatActivity;
import ir.Geotech_co.batman.model.FilmModel;

@SuppressWarnings("unused")
public final class MainActivity extends BaseDaggerCompatActivity {

    Unbinder unbinder;

    @Inject
    Provider<MainCategoryRvAdapter> mAdapterProvider;

    @VerticalOrientationRV
    @Inject
    Provider<LinearLayoutManager> linearLayoutManagerProvider;

    @Inject
    Provider<MainViewModel> viewModelProvider;
    @BindView(R.id.rvFilmsList)
    RecyclerView rvFilmsList;
    @BindView(R.id.progressAllFilms)
    RelativeLayout progressAllFilms;

    private MainViewModel viewModel;

    @Inject
    MainCategoryRvAdapter rvAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);

        if (savedInstanceState == null)
            viewModel = viewModelProvider.get();

        showProgress();
        viewModel.requestAllFilms(viewModel.getApiKey(), viewModel.getAppName());
        viewModel.getAllFilms().observe(this, this::receivedAllFilms);

        initRv();

    }

    private void receivedAllFilms(List<FilmModel> filmModels) {
        hideProgress();
        viewModel.insertLocationsToDB(filmModels);
        rvAdapter.submitList(filmModels);
    }

    private void showProgress() {
        if (progressAllFilms.getVisibility() == View.GONE) {
            progressAllFilms.setVisibility(View.VISIBLE);
            if (getBaseContext() != null)
                getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        }

    }

    private void hideProgress() {
        if (progressAllFilms.getVisibility() == View.VISIBLE) {
            progressAllFilms.setVisibility(View.GONE);
            if (getBaseContext() != null)
                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        }
    }


    private void initRv() {
        LinearLayoutManager linearLayoutManager = linearLayoutManagerProvider.get();
        rvFilmsList.setLayoutManager(linearLayoutManager);
        rvFilmsList.setAdapter(rvAdapter);
    }


    @Override
    protected void onDestroy() {
        unbinder.unbind();
        super.onDestroy();
    }

}

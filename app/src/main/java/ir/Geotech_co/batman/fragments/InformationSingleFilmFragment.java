package ir.Geotech_co.batman.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.mikhaellopez.circularprogressbar.CircularProgressBar;

import javax.inject.Inject;
import javax.inject.Provider;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import ir.Geotech_co.batman.R;
import ir.Geotech_co.batman.base.BaseDaggerFragment;
import ir.Geotech_co.batman.model.FilmModel;
import me.zhanghai.android.materialratingbar.MaterialRatingBar;

public final class InformationSingleFilmFragment extends BaseDaggerFragment {

    @BindView(R.id.tvRuntime)
    AppCompatTextView tvRuntime;
    @BindView(R.id.tvCountry)
    AppCompatTextView tvCountry;
    @BindView(R.id.tvReleased)
    AppCompatTextView tvReleased;
    @BindView(R.id.tvDirector)
    AppCompatTextView tvDirector;
    @BindView(R.id.tvWriter)
    AppCompatTextView tvWriter;
    @BindView(R.id.tvActors)
    AppCompatTextView tvActors;
    @BindView(R.id.ratingInternet)
    MaterialRatingBar ratingInternet;
    @BindView(R.id.tvRotten)
    AppCompatTextView tvRotten;
    @BindView(R.id.txtFavorite)
    AppCompatTextView txtFavorite;
    @BindView(R.id.llRatingBar)
    LinearLayout llRatingBar;
    @BindView(R.id.ratingTomatoes)
    AppCompatTextView ratingTomatoes;
    @BindView(R.id.tvGenre)
    AppCompatTextView tvGenre;
    @BindView(R.id.tvRated)
    AppCompatTextView tvRated;
    @BindView(R.id.tvPlot)
    AppCompatTextView tvPlot;
    @BindView(R.id.llSingleFilm)
    LinearLayout llSingleFilm;
    @BindView(R.id.metacriticProgress)
    CircularProgressBar metacriticProgress;
    @BindView(R.id.nV)
    NestedScrollView nV;
    private Unbinder unbinder;

    @Inject
    Provider<InformationSingleFilmViewModel> viewModelProvider;

    private InformationSingleFilmViewModel viewModel;

    public static InformationSingleFilmFragment newInstance(Bundle bundle) {

        InformationSingleFilmFragment fragment = new InformationSingleFilmFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_film_inormation, container, false);
        unbinder = ButterKnife.bind(this, view);
        nV.setFillViewport (true);

        if (savedInstanceState == null)
            viewModel = viewModelProvider.get();
        setLocationInformation();

        if (getArguments() != null) {
            String imdbi = getArguments().getString("imdbId");
            viewModel.setImbdbId(imdbi);
            viewModel.getFilmInformation(viewModel.getApiKey(), imdbi);
            viewModel.getFilmModelMutableLiveData().observe(this, this::reveivedData);

        }

        return view;
    }

    private void reveivedData(FilmModel filmModel) {
        if (filmModel != null) {

            viewModel.updateDbInformaion(filmModel);

            if (filmModel.getRuntime() != null)
                tvRuntime.setText(filmModel.getRuntime());
            if (filmModel.getCountry() != null)
                tvCountry.setText(filmModel.getCountry());

            if (filmModel.getReleased() != null)
                tvReleased.setText(filmModel.getReleased());

            if (filmModel.getDirector() != null)
                tvDirector.setText("Director : " + filmModel.getDirector());

            if (filmModel.getWriter() != null)
                tvWriter.setText("Writers : " + filmModel.getWriter());

            if (filmModel.getActors() != null)
                tvActors.setText("Actors : " + filmModel.getActors());

            if (filmModel.getRatingModels() != null && filmModel.getRatingModels().size() > 2) {
                if (filmModel.getRatingModels().get(2) != null)
                    metacriticProgress.setProgressWithAnimation
                            (Float.valueOf(
                                    filmModel.getRatingModels().get(0).getValue().split("/")[1]),
                                    2000);
                if (filmModel.getRatingModels().get(0) != null) {
                    ratingInternet.setRating(Float.valueOf(filmModel.getRatingModels().get(0).getValue().split("/")[0]));
                }
                if (filmModel.getRatingModels().get(1) != null) {
                    tvRotten.setText(filmModel.getRatingModels().get(1).getValue());
                }
            }

            if (filmModel.getGenre() != null) {
                tvGenre.setText(filmModel.getGenre());
            }

            if (filmModel.getRated() != null) {
                tvRated.setText(filmModel.getRated());
            }

            if (filmModel.getPlot() != null) {
                tvPlot.setText(filmModel.getPlot());
            }

        }
    }


    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }

    private void setLocationInformation() {
        if (getArguments() != null) {


        }

    }


    private void receivedData(String data) {
        if (getContext() != null) {

        }

    }

}

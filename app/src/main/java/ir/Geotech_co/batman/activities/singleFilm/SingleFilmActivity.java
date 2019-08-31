package ir.Geotech_co.batman.activities.singleFilm;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;

import com.facebook.drawee.view.SimpleDraweeView;

import javax.inject.Inject;
import javax.inject.Provider;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import ir.Geotech_co.batman.R;
import ir.Geotech_co.batman.base.BaseDaggerCompatActivity;

public final class SingleFilmActivity extends BaseDaggerCompatActivity {

    Unbinder unbinder;

    @Inject
    Provider<SingleFilmViewModel> viewModelProvider;
    @BindView(R.id.sdSingleFilm)
    SimpleDraweeView sdSingleFilm;
    @BindView(R.id.bg)
    AppCompatImageView bg;
    @BindView(R.id.txtSingleFilmTitle)
    AppCompatTextView txtSingleFilmTitle;
//    @BindView(R.id.toolbar)
//    Toolbar toolbar;
    @BindView(R.id.collapseSingleFilm)
    CollapsingToolbarLayout collapseSingleFilm;
    @BindView(R.id.appbarSingleFilm)
    AppBarLayout appbarSingleFilm;
    @BindView(R.id.vpSingleFilmLocation)
    android.support.v4.view.ViewPager vpSingleFilmLocation;
    @BindView(R.id.clSingleFilm)
    CoordinatorLayout clSingleFilm;

    @SuppressWarnings("FieldCanBeLocal")
    private SingleFilmViewModel viewModel;

    @Inject
    SingleFilmInormationVPAdapter singleFilmInormationVPAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_film);
        unbinder = ButterKnife.bind(this);

        if (savedInstanceState == null)
            viewModel = viewModelProvider.get();

        initializeViewPager();


    }

    private void initializeViewPager() {
        vpSingleFilmLocation.setAdapter(singleFilmInormationVPAdapter);
        Bundle bundle;
        if (getIntent() != null && getIntent().getExtras() != null) {
            bundle = getIntent().getExtras();
            sdSingleFilm.setImageURI(getIntent().getExtras().getString("poster"));
            txtSingleFilmTitle.setText(getIntent().getExtras().getString("title"));
            singleFilmInormationVPAdapter.setBundle(bundle);
        }
    }


    @Override
    protected void onDestroy() {
        unbinder.unbind();
        super.onDestroy();
    }

}

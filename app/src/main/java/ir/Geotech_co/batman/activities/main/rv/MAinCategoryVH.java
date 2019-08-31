package ir.Geotech_co.batman.activities.main.rv;

import android.content.Intent;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import ir.Geotech_co.batman.R;
import ir.Geotech_co.batman.activities.singleFilm.SingleFilmActivity;

class MAinCategoryVH extends RecyclerView.ViewHolder {


    @BindView(R.id.sdFilmPoster)
    SimpleDraweeView sdFilmPoster;
    @BindView(R.id.txtFilmName)
    AppCompatTextView txtFilmName;
    @BindView(R.id.txtFilmTitle)
    AppCompatTextView txtFilmTitle;
    @BindView(R.id.cvBgFilmRows)
    CardView cvBgFilmRows;


    private MainRvViewModel mainRvViewModel;

    MAinCategoryVH(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        mainRvViewModel = new MainRvViewModel();
    }

    MainRvViewModel getMainRvViewModel() {
        return mainRvViewModel;
    }

    void bind() {

        if (itemView != null && itemView.getContext() != null && mainRvViewModel != null) {

            if (mainRvViewModel.getModel() != null) {
                if (mainRvViewModel.getModel().getTitle() != null)
                    txtFilmName.setText(mainRvViewModel.getModel().getTitle());

                if (mainRvViewModel.getModel().getYear() != null)
                    txtFilmTitle.setText("YEAR : " + mainRvViewModel.getModel().getYear());

                if (mainRvViewModel.getModel().getPoster() != null)
                    sdFilmPoster.setImageURI(mainRvViewModel.getModel().getPoster());

            }

            cvBgFilmRows.setOnClickListener(view -> {
                Intent intent = new Intent(itemView.getContext(), SingleFilmActivity.class);
                intent.putExtra("title", mainRvViewModel.getModel().getTitle());
                intent.putExtra("poster", mainRvViewModel.getModel().getPoster());
                intent.putExtra("imdbId", mainRvViewModel.getModel().getImdbID());
                itemView.getContext().startActivity(intent);
            });

        }


    }


}

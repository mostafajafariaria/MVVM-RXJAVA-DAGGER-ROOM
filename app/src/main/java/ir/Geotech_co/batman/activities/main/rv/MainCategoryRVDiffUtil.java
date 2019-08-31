package ir.Geotech_co.batman.activities.main.rv;

import android.support.v7.util.DiffUtil;

import javax.inject.Inject;

import ir.Geotech_co.batman.model.FilmModel;

public class MainCategoryRVDiffUtil extends DiffUtil.ItemCallback<FilmModel> {

    @Inject
    MainCategoryRVDiffUtil() {
    }

    @Override
    public boolean areItemsTheSame(FilmModel oldItem, FilmModel newItem) {
        return false;
    }

    @Override
    public boolean areContentsTheSame(FilmModel oldItem, FilmModel newItem) {
        return false;
    }
}

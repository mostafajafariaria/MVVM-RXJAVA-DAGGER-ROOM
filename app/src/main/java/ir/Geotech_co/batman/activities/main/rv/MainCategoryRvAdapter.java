package ir.Geotech_co.batman.activities.main.rv;

import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import ir.Geotech_co.batman.R;
import ir.Geotech_co.batman.model.FilmModel;


public class MainCategoryRvAdapter extends ListAdapter<FilmModel, MAinCategoryVH> {

    @Inject
    MainCategoryRvAdapter(@NonNull MainCategoryRVDiffUtil diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public MAinCategoryVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_films, parent, false);
        return new MAinCategoryVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MAinCategoryVH holder, int position) {

        holder.getMainRvViewModel().setModel(getItem(position));
        holder.bind();
    }
}

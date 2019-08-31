package ir.Geotech_co.batman.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class ListFilmModel implements Parcelable {

    protected ListFilmModel(Parcel in) {
        filmModels = in.createTypedArrayList(FilmModel.CREATOR);
        totalResults = in.readString();
        Response = in.readString();
    }

    public static final Creator<ListFilmModel> CREATOR = new Creator<ListFilmModel>() {
        @Override
        public ListFilmModel createFromParcel(Parcel in) {
            return new ListFilmModel(in);
        }

        @Override
        public ListFilmModel[] newArray(int size) {
            return new ListFilmModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(filmModels);
        parcel.writeString(totalResults);
        parcel.writeString(Response);
    }

    @SerializedName("Search")
    private List<FilmModel> filmModels;

    @SerializedName("totalResults")
    private String totalResults;

    @SerializedName("Response")
    private String Response;

    public List<FilmModel> getFilmModels() {
        return filmModels;
    }

    public void setFilmModels(List<FilmModel> filmModels) {
        this.filmModels = filmModels;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public String getResponse() {
        return Response;
    }

    public void setResponse(String response) {
        Response = response;
    }
}

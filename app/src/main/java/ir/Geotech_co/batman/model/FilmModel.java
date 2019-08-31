package ir.Geotech_co.batman.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.Nullable;


public class FilmModel implements Parcelable {


    @SerializedName("Title")
    @Nullable
    private String title;

    @SerializedName("Year")
    @Nullable
    private String year;

    @SerializedName("Rated")
    @Nullable
    private String rated;

    @SerializedName("Released")
    @Nullable
    private String released;

    @SerializedName("Runtime")
    @Nullable
    private String runtime;

    @SerializedName("Genre")
    @Nullable
    private String genre;

    @SerializedName("Director")
    @Nullable
    private String director;

    @SerializedName("Writer")
    @Nullable
    private String writer;

    @SerializedName("Actors")
    @Nullable
    private String actors;

    @SerializedName("Plot")
    @Nullable
    private String plot;

    @SerializedName("Language")
    @Nullable
    private String language;

    @SerializedName("Country")
    @Nullable
    private String country;

    @SerializedName("Awards")
    @Nullable
    private String awards;

    @SerializedName("Poster")
    @Nullable
    private String poster;

    @SerializedName("RatingModel")
    @Nullable
    private List<RatingModel> ratingModels;

    @SerializedName("Metascore")
    @Nullable
    private String metascore;

    @SerializedName("imdbRating")
    @Nullable
    private String imdbRating;

    @SerializedName("imdbVotes")
    @Nullable
    private String imdbVotes;

    @SerializedName("imdbID")
    @Nullable
    private String imdbID;

    @SerializedName("Type")
    @Nullable
    private String type;

    @SerializedName("DVD")
    @Nullable
    private String dvd;

    @SerializedName("BoxOffice")
    @Nullable
    private String boxOffice;

    @SerializedName("Website")
    @Nullable
    private String website;

    @SerializedName("Production")
    @Nullable
    private String production;

    @SerializedName("Response")
    @Nullable
    private String Response;

    public FilmModel() {
    }

    protected FilmModel(Parcel in) {
        title = in.readString();
        year = in.readString();
        rated = in.readString();
        released = in.readString();
        runtime = in.readString();
        genre = in.readString();
        director = in.readString();
        writer = in.readString();
        actors = in.readString();
        plot = in.readString();
        language = in.readString();
        country = in.readString();
        awards = in.readString();
        poster = in.readString();
        ratingModels = in.createTypedArrayList(RatingModel.CREATOR);
        metascore = in.readString();
        imdbRating = in.readString();
        imdbVotes = in.readString();
        imdbID = in.readString();
        type = in.readString();
        dvd = in.readString();
        boxOffice = in.readString();
        website = in.readString();
        production = in.readString();
        Response = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(year);
        dest.writeString(rated);
        dest.writeString(released);
        dest.writeString(runtime);
        dest.writeString(genre);
        dest.writeString(director);
        dest.writeString(writer);
        dest.writeString(actors);
        dest.writeString(plot);
        dest.writeString(language);
        dest.writeString(country);
        dest.writeString(awards);
        dest.writeString(poster);
        dest.writeTypedList(ratingModels);
        dest.writeString(metascore);
        dest.writeString(imdbRating);
        dest.writeString(imdbVotes);
        dest.writeString(imdbID);
        dest.writeString(type);
        dest.writeString(dvd);
        dest.writeString(boxOffice);
        dest.writeString(website);
        dest.writeString(production);
        dest.writeString(Response);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<FilmModel> CREATOR = new Creator<FilmModel>() {
        @Override
        public FilmModel createFromParcel(Parcel in) {
            return new FilmModel(in);
        }

        @Override
        public FilmModel[] newArray(int size) {
            return new FilmModel[size];
        }
    };

    @android.support.annotation.Nullable
    public String getTitle() {
        return title;
    }

    public void setTitle(@android.support.annotation.Nullable String title) {
        this.title = title;
    }

    @android.support.annotation.Nullable
    public String getYear() {
        return year;
    }

    public void setYear(@android.support.annotation.Nullable String year) {
        this.year = year;
    }

    @android.support.annotation.Nullable
    public String getRated() {
        return rated;
    }

    public void setRated(@android.support.annotation.Nullable String rated) {
        this.rated = rated;
    }

    @android.support.annotation.Nullable
    public String getReleased() {
        return released;
    }

    public void setReleased(@android.support.annotation.Nullable String released) {
        this.released = released;
    }

    @android.support.annotation.Nullable
    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(@android.support.annotation.Nullable String runtime) {
        this.runtime = runtime;
    }

    @android.support.annotation.Nullable
    public String getGenre() {
        return genre;
    }

    public void setGenre(@android.support.annotation.Nullable String genre) {
        this.genre = genre;
    }

    @android.support.annotation.Nullable
    public String getDirector() {
        return director;
    }

    public void setDirector(@android.support.annotation.Nullable String director) {
        this.director = director;
    }

    @android.support.annotation.Nullable
    public String getWriter() {
        return writer;
    }

    public void setWriter(@android.support.annotation.Nullable String writer) {
        this.writer = writer;
    }

    @android.support.annotation.Nullable
    public String getActors() {
        return actors;
    }

    public void setActors(@android.support.annotation.Nullable String actors) {
        this.actors = actors;
    }

    @android.support.annotation.Nullable
    public String getPlot() {
        return plot;
    }

    public void setPlot(@android.support.annotation.Nullable String plot) {
        this.plot = plot;
    }

    @android.support.annotation.Nullable
    public String getLanguage() {
        return language;
    }

    public void setLanguage(@android.support.annotation.Nullable String language) {
        this.language = language;
    }

    @android.support.annotation.Nullable
    public String getCountry() {
        return country;
    }

    public void setCountry(@android.support.annotation.Nullable String country) {
        this.country = country;
    }

    @android.support.annotation.Nullable
    public String getAwards() {
        return awards;
    }

    public void setAwards(@android.support.annotation.Nullable String awards) {
        this.awards = awards;
    }

    @android.support.annotation.Nullable
    public String getPoster() {
        return poster;
    }


    public void setPoster(@android.support.annotation.Nullable String poster) {
        this.poster = poster;
    }

    @android.support.annotation.Nullable
    public List<RatingModel> getRatingModels() {
        return ratingModels;
    }

    public void setRatingModels(@android.support.annotation.Nullable List<RatingModel> ratingModels) {
        this.ratingModels = ratingModels;
    }

    @android.support.annotation.Nullable
    public String getMetascore() {
        return metascore;
    }

    public void setMetascore(@android.support.annotation.Nullable String metascore) {
        this.metascore = metascore;
    }

    @android.support.annotation.Nullable
    public String getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(@android.support.annotation.Nullable String imdbRating) {
        this.imdbRating = imdbRating;
    }

    @android.support.annotation.Nullable
    public String getImdbVotes() {
        return imdbVotes;
    }

    public void setImdbVotes(@android.support.annotation.Nullable String imdbVotes) {
        this.imdbVotes = imdbVotes;
    }

    @android.support.annotation.Nullable
    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(@android.support.annotation.Nullable String imdbID) {
        this.imdbID = imdbID;
    }

    @android.support.annotation.Nullable
    public String getType() {
        return type;
    }

    public void setType(@android.support.annotation.Nullable String type) {
        this.type = type;
    }

    @android.support.annotation.Nullable
    public String getDvd() {
        return dvd;
    }

    public void setDvd(@android.support.annotation.Nullable String dvd) {
        this.dvd = dvd;
    }

    @android.support.annotation.Nullable
    public String getBoxOffice() {
        return boxOffice;
    }

    public void setBoxOffice(@android.support.annotation.Nullable String boxOffice) {
        this.boxOffice = boxOffice;
    }

    @android.support.annotation.Nullable
    public String getWebsite() {
        return website;
    }

    public void setWebsite(@android.support.annotation.Nullable String website) {
        this.website = website;
    }

    @android.support.annotation.Nullable
    public String getProduction() {
        return production;
    }

    public void setProduction(@android.support.annotation.Nullable String production) {
        this.production = production;
    }

    @android.support.annotation.Nullable
    public String getResponse() {
        return Response;
    }

    public void setResponse(@android.support.annotation.Nullable String response) {
        Response = response;
    }
}

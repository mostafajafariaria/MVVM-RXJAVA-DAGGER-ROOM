package ir.Geotech_co.batman.dbModels;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

@Entity(tableName = "films")
public class DbFilmModel implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "year")
    private String year;

    @ColumnInfo(name = "rated")
    private String rated;

    @ColumnInfo(name = "released")
    private String released;

    @ColumnInfo(name = "runtime")
    private String runtime;

    @ColumnInfo(name = "genre")
    private String genre;

    @ColumnInfo(name = "director")
    private String director;

    @ColumnInfo(name = "writer")
    private String writer;

    @ColumnInfo(name = "actors")
    private String actors;

    @ColumnInfo(name = "plot")
    private String plot;

    @ColumnInfo(name = "language")
    private String language;

    @ColumnInfo(name = "country")
    private String country;

    @ColumnInfo(name = "awards")
    private String awards;

    @ColumnInfo(name = "poster")
    private String poster;

    @ColumnInfo(name = "metascore")
    private String metascore;

    @ColumnInfo(name = "imdbRating")
    private String imdbRating;

    @ColumnInfo(name = "imdbVotes")
    private String imdbVotes;

    @ColumnInfo(name = "imdbID")
    private String imdbID;

    @ColumnInfo(name = "type")
    private String type;

    @ColumnInfo(name = "dvd")
    private String dvd;

    @ColumnInfo(name = "boxOffice")
    private String boxOffice;

    @ColumnInfo(name = "website")
    private String website;

    @ColumnInfo(name = "production")
    private String production;

    @ColumnInfo(name = "Response")
    private String Response;

    public DbFilmModel() {
    }

    public DbFilmModel(Parcel in) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static final Creator<DbFilmModel> CREATOR = new Creator<DbFilmModel>() {
        @Override
        public DbFilmModel createFromParcel(Parcel in) {
            return new DbFilmModel(in);
        }

        @Override
        public DbFilmModel[] newArray(int size) {
            return new DbFilmModel[size];
        }
    };

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


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getRated() {
        return rated;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    public String getPoster() {
        return poster;
    }


    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getMetascore() {
        return metascore;
    }

    public void setMetascore(String metascore) {
        this.metascore = metascore;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(String imdbRating) {
        this.imdbRating = imdbRating;
    }

    public String getImdbVotes() {
        return imdbVotes;
    }

    public void setImdbVotes(String imdbVotes) {
        this.imdbVotes = imdbVotes;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDvd() {
        return dvd;
    }

    public void setDvd(String dvd) {
        this.dvd = dvd;
    }

    public String getBoxOffice() {
        return boxOffice;
    }

    public void setBoxOffice(String boxOffice) {
        this.boxOffice = boxOffice;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public String getResponse() {
        return Response;
    }

    public void setResponse(String response) {
        Response = response;
    }


}

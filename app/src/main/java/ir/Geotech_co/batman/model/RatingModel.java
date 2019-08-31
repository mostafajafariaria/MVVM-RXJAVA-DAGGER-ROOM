package ir.Geotech_co.batman.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;


public class RatingModel implements Parcelable {


    @SerializedName("Source")
    private String source;

    @SerializedName("Value")
    private String value;

    protected RatingModel(Parcel in) {
        source = in.readString();
        value = in.readString();
    }

    public static final Creator<RatingModel> CREATOR = new Creator<RatingModel>() {
        @Override
        public RatingModel createFromParcel(Parcel in) {
            return new RatingModel(in);
        }

        @Override
        public RatingModel[] newArray(int size) {
            return new RatingModel[size];
        }
    };

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(source);
        parcel.writeString(value);
    }
}

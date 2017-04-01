package mx.udg.valles.veganet.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by veganet on 11/03/2017.
 */

public class Movie implements Parcelable {
    private int id;
    private String title;
    private String description;
    private String poster_path;

    public Movie(int id, String title, String description, String poster_path) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.poster_path = poster_path;
    }

    protected Movie(Parcel in) {
        id = in.readInt();
        title = in.readString();
        description = in.readString();
        poster_path = in.readString();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(description);
        dest.writeString(poster_path);
    }
}

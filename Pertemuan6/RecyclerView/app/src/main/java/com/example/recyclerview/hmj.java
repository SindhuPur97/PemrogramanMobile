package com.example.recyclerview;

import android.os.Parcel;
import android.os.Parcelable;

public class hmj implements Parcelable {
    private String Name;
    private String Description;
    private String Photo;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }
    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }


    public String getPhoto() {
        return Photo;
    }

    public void setPhoto(String photo) {
        this.Photo = photo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.Name);
        dest.writeString(this.Description);
        dest.writeString(this.Photo);
    }

        hmj(){

        }

    private hmj(Parcel in) {
            this.Name = in.readString();
            this.Description = in.readString();
            this.Photo = in.readString();
        }

        public static final Parcelable.Creator<hmj> CREATOR = new Parcelable.Creator<hmj>() {
            @Override
            public hmj createFromParcel(Parcel source) {
                return new hmj(source);
            }

            @Override
            public hmj[] newArray(int size) {
                return new hmj[size];
            }
    };


}

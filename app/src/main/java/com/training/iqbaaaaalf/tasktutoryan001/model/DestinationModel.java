package com.training.iqbaaaaalf.tasktutoryan001.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by iqbaaaaalf on 10/7/2017.
 */

public class DestinationModel implements Parcelable {
    @SerializedName("id_trip")
    private String idTrip;
    @SerializedName("trip_name")
    private String tripName;
    @SerializedName("location")
    private String location;
    @SerializedName("photo")
    private String photo;
    @SerializedName("description")
    private String description;
    @SerializedName("price")
    private String price;
    @SerializedName("hour_activity")
    private String hourActivity;
    @SerializedName("detail_activity")
    private String detailActivity;
    @SerializedName("id_type_trip")
    private String idTypeTrip;
    @SerializedName("name_type_trip")
    private String nameTypeTrip;
    @SerializedName("id_category_trip")
    private String idCategoryTrip;
    @SerializedName("name_category")
    private String nameCategory;
    @SerializedName("quota")
    private String quota;
    @SerializedName("start_date")
    private String startDate;
    @SerializedName("finish_date")
    private String finishDate;

    public DestinationModel(String idTrip, String tripName, String location, String photo, String description, String price, String hourActivity, String detailActivity, String idTypeTrip, String nameTypeTrip, String idCategoryTrip, String nameCategory, String quota, String startDate, String finishDate) {
        this.idTrip = idTrip;
        this.tripName = tripName;
        this.location = location;
        this.photo = photo;
        this.description = description;
        this.price = price;
        this.hourActivity = hourActivity;
        this.detailActivity = detailActivity;
        this.idTypeTrip = idTypeTrip;
        this.nameTypeTrip = nameTypeTrip;
        this.idCategoryTrip = idCategoryTrip;
        this.nameCategory = nameCategory;
        this.quota = quota;
        this.startDate = startDate;
        this.finishDate = finishDate;
    }

    protected DestinationModel(Parcel in) {
        this.idTrip = in.readString();
        this.tripName = in.readString();
        this.location = in.readString();
        this.photo = in.readString();
        this.description = in.readString();
        this.price = in.readString();
        this.hourActivity = in.readString();
        this.detailActivity = in.readString();
        this.idTypeTrip = in.readString();
        this.nameTypeTrip = in.readString();
        this.idCategoryTrip = in.readString();
        this.nameCategory = in.readString();
        this.quota = in.readString();
        this.startDate = in.readString();
        this.finishDate = in.readString();
    }

    public String getIdTrip() {
        return idTrip;
    }

    public void setIdTrip(String idTrip) {
        this.idTrip = idTrip;
    }

    public String getTripName() {
        return tripName;
    }

    public void setTripName(String tripName) {
        this.tripName = tripName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getHourActivity() {
        return hourActivity;
    }

    public void setHourActivity(String hourActivity) {
        this.hourActivity = hourActivity;
    }

    public String getDetailActivity() {
        return detailActivity;
    }

    public void setDetailActivity(String detailActivity) {
        this.detailActivity = detailActivity;
    }

    public String getIdTypeTrip() {
        return idTypeTrip;
    }

    public void setIdTypeTrip(String idTypeTrip) {
        this.idTypeTrip = idTypeTrip;
    }

    public String getNameTypeTrip() {
        return nameTypeTrip;
    }

    public void setNameTypeTrip(String nameTypeTrip) {
        this.nameTypeTrip = nameTypeTrip;
    }

    public String getIdCategoryTrip() {
        return idCategoryTrip;
    }

    public void setIdCategoryTrip(String idCategoryTrip) {
        this.idCategoryTrip = idCategoryTrip;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public String getQuota() {
        return quota;
    }

    public void setQuota(String quota) {
        this.quota = quota;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.idTrip);
        parcel.writeString(this.tripName);
        parcel.writeString(this.location);
        parcel.writeString(this.photo);
        parcel.writeString(this.description);
        parcel.writeString(this.price);
        parcel.writeString(this.hourActivity);
        parcel.writeString(this.detailActivity);
        parcel.writeString(this.idTypeTrip);
        parcel.writeString(this.nameTypeTrip);
        parcel.writeString(this.idCategoryTrip);
        parcel.writeString(this.nameCategory);
        parcel.writeString(this.quota);
        parcel.writeString(this.startDate);
        parcel.writeString(this.finishDate);
    }

    public static final Creator<DestinationModel> CREATOR = new Creator<DestinationModel>(){

        @Override
        public DestinationModel createFromParcel(Parcel parcel) {
            return new DestinationModel(parcel);
        }

        @Override
        public DestinationModel[] newArray(int i) {
            return new DestinationModel[i];
        }
    };
}


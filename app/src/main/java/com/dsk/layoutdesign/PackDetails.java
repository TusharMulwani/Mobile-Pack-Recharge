package com.dsk.layoutdesign;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class PackDetails implements Parcelable {
    private String heading;

    private String price;
    private String priceSubtitle;
    private String data;
    private String dataSubtitle;
    private String validity;
    private String validitySubtitle;
    private String sms;

    private String dataType;

    private String feature1;
    private String feature2;
    private String feature3;



    public PackDetails(String heading, String price, String priceSubtitle, String data,
                       String dataSubtitle, String validity, String validitySubtitle, String dataType,
                       String feature1, String feature2, String feature3) {
        this.heading = heading;
        this.price = price;
        this.priceSubtitle = priceSubtitle;
        this.data = data;
        this.dataSubtitle = dataSubtitle;
        this.validity = validity;
        this.validitySubtitle = validitySubtitle;
        this.dataType = dataType;
        sms = "100 SMS per day";

        this.feature1 = feature1;
        this.feature2 = feature2;
        this.feature3 = feature3;
    }


    public PackDetails(String heading, String price, String priceSubtitle, String data,
                       String dataSubtitle, String validity, String validitySubtitle, String dataType, String sms,
                       String feature1, String feature2, String feature3) {
        this.heading = heading;
        this.price = price;
        this.priceSubtitle = priceSubtitle;
        this.data = data;
        this.dataSubtitle = dataSubtitle;
        this.validity = validity;
        this.validitySubtitle = validitySubtitle;
        this.dataType = dataType;
        this.sms = sms;

        this.feature1 = feature1;
        this.feature2 = feature2;
        this.feature3 = feature3;
    }

    protected PackDetails(Parcel in) {
        heading = in.readString();
        price = in.readString();
        priceSubtitle = in.readString();
        data = in.readString();
        dataSubtitle = in.readString();
        validity = in.readString();
        validitySubtitle = in.readString();
        dataType = in.readString();
        sms = in.readString();

        feature1 = in.readString();
        feature2 = in.readString();
        feature3 = in.readString();
    }

    public String getFeature1() {
        return feature1;
    }

    public String getFeature2() {
        return feature2;
    }

    public String getFeature3() {
        return feature3;
    }

    public String getSms() {
        return sms;
    }

    public void setSms(String sms) {
        this.sms = sms;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPriceSubtitle() {
        return priceSubtitle;
    }

    public void setPriceSubtitle(String priceSubtitle) {
        this.priceSubtitle = priceSubtitle;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDataSubtitle() {
        return dataSubtitle;
    }

    public void setDataSubtitle(String dataSubtitle) {
        this.dataSubtitle = dataSubtitle;
    }

    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }

    public String getValiditySubtitle() {
        return validitySubtitle;
    }

    public void setValiditySubtitle(String validitySubtitle) {
        this.validitySubtitle = validitySubtitle;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(heading);
        parcel.writeString(price);
        parcel.writeString(priceSubtitle);
        parcel.writeString(data);
        parcel.writeString(dataSubtitle);
        parcel.writeString(validity);
        parcel.writeString(validitySubtitle);
        parcel.writeString(dataType);
        parcel.writeString(sms);

        parcel.writeString(feature1);
        parcel.writeString(feature2);
        parcel.writeString(feature3);
    }

    public static final Creator<PackDetails> CREATOR = new Creator<PackDetails>() {
        @Override
        public PackDetails createFromParcel(Parcel in) {
            return new PackDetails(in);
        }

        @Override
        public PackDetails[] newArray(int size) {
            return new PackDetails[size];
        }
    };
}

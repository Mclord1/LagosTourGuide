package com.example.android.tourguide;

public class CardItem {

    private String mName;
    private String mDescription;
    private String mAddress;
    private String mCity;
    private String mTime;
    private String mPhoneNumber;
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private final static int NO_IMAGE_PROVIDED = -1;

    public CardItem(String name, String city, String time, int ImageResourceId, String description, String address, String phoneNumber) {
        mName = name;
        mCity = city;
        mTime = time;
        mDescription = description;
        mAddress = address;
        mPhoneNumber = phoneNumber;
        this.mImageResourceId = ImageResourceId;
    }

    public String getName() {
        return mName;
    }

    public String getCity() {
        return mCity;
    }

    public String getTime() {
        return mTime;
    }

    public String getAddress() {
        return mAddress;
    }

    public String getPhoneNumber() {
        return mPhoneNumber;
    }

    public String getDescription() {
        return mDescription;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

}

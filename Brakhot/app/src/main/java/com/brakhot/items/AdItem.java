package com.brakhot.items;


public class AdItem {
    private String mAdUrl;
    private String mImageUrl;

    public AdItem(String adText, String url) {
        mAdUrl = adText;
        mImageUrl = url;
    }

    public void setUrl(String mUrl) {
        this.mImageUrl = mUrl;
    }

    public String getAdText() {
        return mAdUrl;
    }

    public void setAdText(String mAdText) {
        this.mAdUrl = mAdText;
    }

    public String getUrl() {
        return mImageUrl;
    }

}

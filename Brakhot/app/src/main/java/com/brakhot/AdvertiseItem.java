package com.brakhot;


public class AdvertiseItem {
    private String mAdText;
    private String mUrl;

    public AdvertiseItem(String adText, String url) {
        mAdText = adText;
        mUrl = url;
    }

    public void setUrl(String mUrl) {
        this.mUrl = mUrl;
    }

    public String getAdText() {
        return mAdText;
    }

    public void setAdText(String mAdText) {
        this.mAdText = mAdText;
    }

    public String getUrl() {
        return mUrl;
    }

}

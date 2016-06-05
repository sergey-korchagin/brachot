package com.brakhot.manager;

import com.brakhot.items.AdItem;

import java.util.ArrayList;
import java.util.List;

public class AdsDataManager {

    private List<AdItem> mAdItemsList;
    private static AdsDataManager ourInstance = new AdsDataManager();

    public static AdsDataManager getInstance() {
        return ourInstance;
    }

    private AdsDataManager() {
    }

    public void init() {
        mAdItemsList = new ArrayList<>();
    }

    public void addItemToList(String adText, String url) {
        AdItem adItem = new AdItem(adText, url);
        mAdItemsList.add(adItem);
    }

    public List<AdItem> getAdvertiseItemsList() {
        return mAdItemsList;
    }

}

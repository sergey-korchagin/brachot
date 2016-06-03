package com.brakhot.manager;

import com.brakhot.AdvertiseItem;

import java.util.ArrayList;
import java.util.List;

public class AdsDataManager {

    private List<AdvertiseItem> mAdvertiseItemsList;
    private static AdsDataManager ourInstance = new AdsDataManager();

    public static AdsDataManager getInstance() {
        return ourInstance;
    }

    private AdsDataManager() {


    }

    public void init() {
        mAdvertiseItemsList = new ArrayList<>();
    }

    public void addItemToList(String adText, String url) {
        AdvertiseItem advertiseItem = new AdvertiseItem(adText, url);
        mAdvertiseItemsList.add(advertiseItem);
    }

    public List<AdvertiseItem> getAdvertiseItemsList() {
        return mAdvertiseItemsList;
    }

}

package com.brakhot.dialog;

import android.support.annotation.Nullable;


public class DialogMenuItem {
    private String mTitle;
    private String mItemText;

    public DialogMenuItem(@Nullable String title, String item){
        mTitle = title;
        mItemText = item;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getItemText() {
        return mItemText;
    }

    public void setItemText(String mItemText) {
        this.mItemText = mItemText;
    }
}

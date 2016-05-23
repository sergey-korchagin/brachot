package com.brakhot.dialog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by serge_000 on 23/05/2016.
 */
public class DialogMenuFullList {


    public static List<DialogMenuItem> getMenuList() {
        List<DialogMenuItem> mMenuList = new ArrayList<>();
        mMenuList.add(new DialogMenuItem("Chapter 1", "Sub chapter 1"));
        mMenuList.add(new DialogMenuItem("","Sub chapter 2"));
        mMenuList.add(new DialogMenuItem("","Sub chapter 3"));
        mMenuList.add(new DialogMenuItem("Chapter 2", "Sub chapter 1"));
        mMenuList.add(new DialogMenuItem("","Sub chapter 2"));
        mMenuList.add(new DialogMenuItem("","Sub chapter 3"));
        mMenuList.add(new DialogMenuItem("","Sub chapter 4"));
        mMenuList.add(new DialogMenuItem("Chapter3", "Sub chapter 1"));
        mMenuList.add(new DialogMenuItem("","Sub chapter 2"));
        mMenuList.add(new DialogMenuItem("Chapter 4", "Sub chapter 1"));
        mMenuList.add(new DialogMenuItem("","Sub chapter 2"));
        mMenuList.add(new DialogMenuItem("","Sub chapter 3"));
        mMenuList.add(new DialogMenuItem("","Sub chapter 4"));
        mMenuList.add(new DialogMenuItem("","Sub chapter 5"));
        mMenuList.add(new DialogMenuItem("Chapter5", "Sub chapter 1"));
        return mMenuList;
    }
}

package com.brakhot.dialog;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.brakhot.R;
import com.brakhot.adapter.MenuDialogAdapter;

import java.util.ArrayList;
import java.util.List;


public class MenuDialog extends DialogFragment {

    private static final String TAG = MenuDialog.class.getSimpleName();
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mRecycleViewLayout;
    private MenuDialogAdapter mMenuDialogAdapter;
    List<String> mMenuItems = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        View view = inflater.inflate(R.layout.dialog_fragment_menu, null);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mRecycleViewLayout = new LinearLayoutManager(view.getContext());
        mRecyclerView.setLayoutManager(mRecycleViewLayout);
        mRecyclerView.setHasFixedSize(true);
        mMenuItems.add("Line 1");
        mMenuItems.add("Line 2");
        mMenuItems.add("Line 3");
        mMenuItems.add("Line 4");
        mMenuItems.add("Line 5");
        mMenuItems.add("Line 6");
        mMenuDialogAdapter = new MenuDialogAdapter(mMenuItems);
        mRecyclerView.setAdapter(mMenuDialogAdapter);

        return view;
    }
}

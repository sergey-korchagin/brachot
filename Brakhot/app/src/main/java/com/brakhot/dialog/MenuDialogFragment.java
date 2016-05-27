package com.brakhot.dialog;

import android.app.Dialog;
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
import com.brakhot.interfaces.MainActivityCallbackListener;
import com.brakhot.interfaces.MenuAdapterCallbackListener;


public class MenuDialogFragment extends DialogFragment implements MenuAdapterCallbackListener {

    private static final String TAG = MenuDialogFragment.class.getSimpleName();
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mRecycleViewLayout;
    private MenuDialogAdapter mMenuDialogAdapter;
    private MainActivityCallbackListener mMainActivityCallbackListener;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);


        View view = inflater.inflate(R.layout.dialog_fragment_menu, null);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mRecycleViewLayout = new LinearLayoutManager(view.getContext());
        mRecyclerView.setLayoutManager(mRecycleViewLayout);
        mRecyclerView.setHasFixedSize(true);

        mMenuDialogAdapter = new MenuDialogAdapter( this);
        mRecyclerView.setAdapter(mMenuDialogAdapter);

        return view;
    }

    @Override
    public void onDialogItemClick(int clickedItemNumber,String clickedItemName) {
        mMainActivityCallbackListener.dialogClickedItemData(clickedItemNumber, clickedItemName);
        getDialog().dismiss();
    }

    public void setMainActivityCallbackListener(MainActivityCallbackListener mainActivityCallbackListener) {
        mMainActivityCallbackListener = mainActivityCallbackListener;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        return dialog;

    }
}

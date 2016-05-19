package com.brakhot.dialog;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.brakhot.R;

/**
 * Created by serge_000 on 20/05/2016.
 */
public class MenuDialog extends DialogFragment {
    public static final String TAG = MenuDialog.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getDialog().setTitle("Title!");
        View v = inflater.inflate(R.layout.dialog_fragment_menu, null);
        return v;
    }
}

package com.brakhot.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.brakhot.R;

import java.util.List;

/**
 * Created by serge_000 on 20/05/2016.
 */
public class MenuDialogAdapter extends RecyclerView.Adapter<MenuDialogAdapter.ViewHolder> {

    private Context mContext;
    private List<String> mMenuRowNames;

    public MenuDialogAdapter(List<String> menuRowNames) {
        mMenuRowNames = menuRowNames;
    }

    @Override
    public MenuDialogAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.dialog_recycler_row, parent, false);
        mContext = parent.getContext();
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MenuDialogAdapter.ViewHolder holder, int i) {
        holder.mMenuItemName.setText(mMenuRowNames.get(i).toString());
    }

    @Override
    public int getItemCount() {
        return mMenuRowNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView mMenuItemName;

        ViewHolder(View itemView) {
            super(itemView);

            mMenuItemName = (TextView) itemView.findViewById(R.id.menuItemTextView);
        }

    }
}

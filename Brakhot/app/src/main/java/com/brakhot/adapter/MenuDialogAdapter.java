package com.brakhot.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.brakhot.R;
import com.brakhot.interfaces.MenuAdapterCallbackListener;

import java.util.ArrayList;
import java.util.List;

public class MenuDialogAdapter extends RecyclerView.Adapter<MenuDialogAdapter.ViewHolder> {

    private Context mContext;
    private List<String> mMenuRowNames = new ArrayList<>();
    private MenuAdapterCallbackListener mMenuAdapterCallbackListener;

    public MenuDialogAdapter( MenuAdapterCallbackListener menuAdapterCallbackListener) {

        mMenuAdapterCallbackListener = menuAdapterCallbackListener;
        initList();
    }
    private void initList(){
        mMenuRowNames.add("Item 1");
        mMenuRowNames.add("Item 2");
        mMenuRowNames.add("Item 3");
        mMenuRowNames.add("Item 4");
        mMenuRowNames.add("Item 5");
        mMenuRowNames.add("Item 6");
    }

    @Override
    public MenuDialogAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.dialog_recycler_row, parent, false);
        mContext = parent.getContext();
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MenuDialogAdapter.ViewHolder holder, int i) {
        holder.mMenuItemName.setText(mMenuRowNames.get(i));
    }

    @Override
    public int getItemCount() {
        return mMenuRowNames.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView mMenuItemName;

        ViewHolder(View itemView) {
            super(itemView);

            mMenuItemName = (TextView) itemView.findViewById(R.id.menuItemTextView);
            mMenuItemName.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (v.getId() == mMenuItemName.getId()) {
                mMenuAdapterCallbackListener.onDialogItemClick(getAdapterPosition());
            }
        }
    }
}

package com.brakhot.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.brakhot.R;
import com.brakhot.dialog.DialogMenuFullList;
import com.brakhot.dialog.DialogMenuItem;
import com.brakhot.interfaces.MenuAdapterCallbackListener;

import java.util.ArrayList;
import java.util.List;

public class MenuDialogAdapter extends RecyclerView.Adapter<MenuDialogAdapter.ViewHolder> {

    private Context mContext;
    private List<DialogMenuItem> mMenuRows = new ArrayList<>();
    private MenuAdapterCallbackListener mMenuAdapterCallbackListener;

    public MenuDialogAdapter( MenuAdapterCallbackListener menuAdapterCallbackListener) {

        mMenuAdapterCallbackListener = menuAdapterCallbackListener;
        initList();
    }
    private void initList(){
mMenuRows = DialogMenuFullList.getMenuList();
    }

    @Override
    public MenuDialogAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.dialog_recycler_row, parent, false);
        mContext = parent.getContext();
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MenuDialogAdapter.ViewHolder holder, int i) {
        if(!mMenuRows.get(i).getTitle().equals("")){
            holder.mMenuCategoryName.setText(mMenuRows.get(i).getTitle());
        }else {
            holder.mMenuCategoryName.setVisibility(View.GONE);
        }
        holder.mMenuItemName.setText(mMenuRows.get(i).getItemText());
    }

    @Override
    public int getItemCount() {
        return mMenuRows.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView mMenuItemName;
        TextView mMenuCategoryName;

        ViewHolder(View itemView) {
            super(itemView);

            mMenuItemName = (TextView) itemView.findViewById(R.id.menuItemTextView);
            mMenuItemName.setOnClickListener(this);

            mMenuCategoryName = (TextView)itemView.findViewById(R.id.menuItemTitle);
        }

        @Override
        public void onClick(View v) {
            if (v.getId() == mMenuItemName.getId()) {
                mMenuAdapterCallbackListener.onDialogItemClick(getAdapterPosition(),mMenuRows.get(getAdapterPosition()).getItemText());
            }
        }
    }
}

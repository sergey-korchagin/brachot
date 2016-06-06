package com.brakhot.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.brakhot.R;

import java.util.ArrayList;
import java.util.List;

public class BookmarksGridAdapter extends BaseAdapter {
    private Context context;
    private List<String> mGridItemsList = new ArrayList<>();

    public BookmarksGridAdapter(Context context) {
        this.context = context;
        for (int i = 1; i < 7; i++) {
            mGridItemsList.add("Item " + i);
        }
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View gridView;
        if (convertView == null) {
            gridView = inflater.inflate(R.layout.bookmarks_grid_item, null);
            TextView textView = (TextView) gridView
                    .findViewById(R.id.textV);
            textView.setText(mGridItemsList.get(position));
//            ImageView imageView = (ImageView) gridView
//                    .findViewById(R.id.grid_item_image);


        } else {
            gridView = convertView;
        }

        return gridView;
    }

    @Override
    public int getCount() {
        return mGridItemsList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
}

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
    private BookmarksGridAdapter mBookmarksGridAdapter = this;

    public BookmarksGridAdapter(Context context) {
        this.context = context;
        for (int i = 1; i < 7; i++) {
            mGridItemsList.add("Item " + i);
        }
    }


    public static class ViewHolder
    {
        TextView textView;
        ImageView close;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent)
    {
        ViewHolder holder;
        if(convertView==null)
        {
            convertView = LayoutInflater.from(context).inflate(R.layout.bookmarks_grid_item,null);

            holder = new ViewHolder();
            holder.textView = (TextView) convertView.findViewById(R.id.textV);
            holder.close = (ImageView) convertView.findViewById(R.id.buttonDelete);
            convertView.setTag(holder);
        }

        else{
            holder = (ViewHolder) convertView.getTag();
        }

        holder.textView.setText(mGridItemsList.get(position));
        holder.close.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View arg1)
            {
                mGridItemsList.remove(position);
                mBookmarksGridAdapter.notifyDataSetChanged();
            }
        });
        return convertView;

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

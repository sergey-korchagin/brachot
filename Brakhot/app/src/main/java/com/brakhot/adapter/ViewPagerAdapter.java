package com.brakhot.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.brakhot.R;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends PagerAdapter {

    List<String> mPages = new ArrayList<>();

    public ViewPagerAdapter() {
        for (int i = 1; i < 12; i++) {
            mPages.add("Page" + i);
        }
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        (container).removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) container.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View root = inflater.inflate(R.layout.page_fragment, container, false);
        (container).addView(root);

        final TextView textView = (TextView) root.findViewById(R.id.tmpText);
        textView.setText(mPages.get(position));
        return root;
    }


    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public int getCount() {
        return mPages.size();
    }
}

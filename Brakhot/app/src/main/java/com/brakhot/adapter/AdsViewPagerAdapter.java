package com.brakhot.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.brakhot.R;
import com.brakhot.items.AdItem;
import com.brakhot.manager.AdsDataManager;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AdsViewPagerAdapter extends PagerAdapter {
    private List<AdItem> mAdsItemsList = new ArrayList<>();
    private Context mContext;

    public AdsViewPagerAdapter(Context context) {
        mAdsItemsList = AdsDataManager.getInstance().getAdvertiseItemsList();
        mContext = context;
    }

    @Override
    public int getCount() {
        return mAdsItemsList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        (container).removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) container.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View root = inflater.inflate(R.layout.ads_item, container, false);
        (container).addView(root);
        ImageView imageView = (ImageView) root.findViewById(R.id.adsImageView);
        Picasso.with(mContext)
                .load(mAdsItemsList.get(position).getUrl())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "Clicked", Toast.LENGTH_SHORT).show();
            }
        });
        return root;
    }
}

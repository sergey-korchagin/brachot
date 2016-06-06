package com.brakhot.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.brakhot.R;
import com.brakhot.adapter.AdsViewPagerAdapter;
import com.brakhot.adapter.BookmarksGridAdapter;
import com.viewpagerindicator.LinePageIndicator;

public class ChoiceBookActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private static final String TAG = ChoiceBookActivity.class.getSimpleName();
    private GridView mGridView;
    private BookmarksGridAdapter mBookmarksGridAdapter;

    private ViewPager mPager;
    private AdsViewPagerAdapter mAdapter;
    private int mViewPagerCounter = 0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choice_book_activity);

        mGridView = (GridView) findViewById(R.id.gridViewBookmarks);
        mBookmarksGridAdapter = new BookmarksGridAdapter(this);
        mGridView.setAdapter(mBookmarksGridAdapter);
        mGridView.setOnItemClickListener(this);


        mPager = (ViewPager) findViewById(R.id.ads_pager);
        mAdapter = new AdsViewPagerAdapter(this);
        mPager.setAdapter(mAdapter);

        LinePageIndicator titleIndicator = (LinePageIndicator) findViewById(R.id.titles);
        titleIndicator.setLineWidth(30);
        titleIndicator.setViewPager(mPager);
        autoPlay(mPager);
    }



    private void autoPlay(final ViewPager viewPager) {

        viewPager.postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    if (mAdapter != null && viewPager.getAdapter().getCount() > 0) {
                        int position = mViewPagerCounter % mAdapter.getCount();
                        mViewPagerCounter++;
                        viewPager.setCurrentItem(position);
                        autoPlay(viewPager);

                    }
                } catch (Exception e) {
                    Log.e(TAG, "auto scroll pager error.", e);
                }
            }
        }, 5000);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(ChoiceBookActivity.this, BookPagerActivity.class);
        intent.putExtra("id", "book " + (position + 1));
        startActivity(intent);
//        overridePendingTransition(android.R.anim.fade_out, android.R.anim.fade_out);


    }

}

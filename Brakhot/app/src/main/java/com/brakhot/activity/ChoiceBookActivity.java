package com.brakhot.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.brakhot.R;
import com.brakhot.adapter.AdsViewPagerAdapter;
import com.brakhot.adapter.BookmarksGridAdapter;
import com.brakhot.adapter.ViewPagerAdapter;
import com.brakhot.manager.AdsDataManager;
import com.squareup.picasso.Picasso;
import com.viewpagerindicator.CirclePageIndicator;
import com.viewpagerindicator.LinePageIndicator;
import com.viewpagerindicator.TitlePageIndicator;

public class ChoiceBookActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {


    private GridView mGridView;
    private BookmarksGridAdapter mBookmarksGridAdapter;

    private ViewPager mPager;
    private AdsViewPagerAdapter mAdapter;

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

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(ChoiceBookActivity.this, BookPagerActivity.class);
        intent.putExtra("id", "book " + (position + 1));
        startActivity(intent);
//        overridePendingTransition(android.R.anim.fade_out, android.R.anim.fade_out);


    }

}

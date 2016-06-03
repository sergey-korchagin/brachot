package com.brakhot.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

import com.brakhot.R;
import com.brakhot.adapter.BookmarksGridAdapter;
import com.brakhot.manager.AdsDataManager;
import com.squareup.picasso.Picasso;

public class ChoiceBookActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {


    private GridView mGridView;
    private BookmarksGridAdapter mBookmarksGridAdapter;
    private ImageView tempIV;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choice_book_activity);

        mGridView = (GridView) findViewById(R.id.gridViewBookmarks);
        mBookmarksGridAdapter = new BookmarksGridAdapter(this);
        mGridView.setAdapter(mBookmarksGridAdapter);
        mGridView.setOnItemClickListener(this);

        tempIV = (ImageView)findViewById(R.id.imageView);
        String url = AdsDataManager.getInstance().getAdvertiseItemsList().get(1).getUrl();
        Picasso.with(this)
                .load(url)
                .resize(70,70)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(tempIV);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(ChoiceBookActivity.this, BookPagerActivity.class);
        intent.putExtra("id", "book " + (position+1));
        startActivity(intent);
//        overridePendingTransition(android.R.anim.fade_out, android.R.anim.fade_out);


    }

}

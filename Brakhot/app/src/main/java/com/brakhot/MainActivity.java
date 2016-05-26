package com.brakhot;

import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


import com.brakhot.adapter.ViewPagerAdapter;
import com.brakhot.dialog.MenuDialogFragment;
import com.brakhot.interfaces.MainActivityCallbackListener;

public class MainActivity extends AppCompatActivity implements MainActivityCallbackListener {
    private Toolbar mToolbar;
    private MenuDialogFragment mMenuDialogFragmentFragment;
    private ViewPager mPager;
    private ViewPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(mToolbar);
        try {
            if (getSupportActionBar() != null) {
                getSupportActionBar().setTitle(R.string.app_name);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        mToolbar.setBackgroundColor(Color.CYAN);

        mPager = (ViewPager) findViewById(R.id.pager);
        mAdapter = new ViewPagerAdapter();
        mPager.setAdapter(mAdapter);

        mMenuDialogFragmentFragment = new MenuDialogFragment();
        mMenuDialogFragmentFragment.setMainActivityCallbackListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
//            case R.id.action_settings: {
//                return true;
//            }
            case R.id.action_favorite: {
                mMenuDialogFragmentFragment.show(getFragmentManager(), "mMenuDialogFragmentFragment");
                return true;
            }
            default: {
                return super.onOptionsItemSelected(item);
            }
        }

    }

    @Override
    public void dialogClickedItemData(int clickedItemPosition, String clickedItemName) {
        mPager.setCurrentItem(clickedItemPosition);
    }

    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }

}
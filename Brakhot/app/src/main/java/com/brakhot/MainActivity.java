package com.brakhot;

import android.app.DialogFragment;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.brakhot.dialog.MenuDialog;
import com.brakhot.interfaces.MainActivityCallbackListener;

public class MainActivity extends AppCompatActivity implements MainActivityCallbackListener {
    private Toolbar mToolbar;
    private MenuDialog mMenuDialogFragment;
    private TextView tmpTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.my_toolbar);

        setSupportActionBar(mToolbar);
        try {
            getSupportActionBar().setTitle(R.string.app_name);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        mToolbar.setBackgroundColor(Color.CYAN);

        mMenuDialogFragment = new MenuDialog();
        mMenuDialogFragment.setMainActivityCallbackListener(this);

        tmpTv = (TextView) findViewById(R.id.textView);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        switch (id) {
//            case R.id.action_settings: {
//                return true;
//            }
            case R.id.action_favorite: {
                mMenuDialogFragment.show(getFragmentManager(), "mMenuDialogFragment");
                return true;
            }
            default: {
                return super.onOptionsItemSelected(item);

            }
        }

    }

    @Override
    public void dialogClickedItemData(int clickedItemPosition) {
        tmpTv.setText("Clicked: " + (clickedItemPosition+1));
    }
}

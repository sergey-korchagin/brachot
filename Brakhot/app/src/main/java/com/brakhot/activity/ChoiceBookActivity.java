package com.brakhot.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.brakhot.R;

public class ChoiceBookActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBook;
    private Button mBook2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choice_book_activity);
        mBook = (Button) findViewById(R.id.button);
        mBook.setOnClickListener(this);
        mBook2 = (Button)findViewById(R.id.button2);
        mBook2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(mBook.getId() == v.getId()){
            Intent intent = new Intent(ChoiceBookActivity.this, BookPagerActivity.class);
            intent.putExtra("id","book 1");
            startActivity(intent);
        }else if(mBook2.getId() == v.getId()){
            Intent intent = new Intent(ChoiceBookActivity.this, BookPagerActivity.class);
            intent.putExtra("id","book 2");
            startActivity(intent);
        }
    }
}

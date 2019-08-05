package com.androidnetworking.assandroidnetworking;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

import java.util.Objects;

public class ImageDetailActivity extends AppCompatActivity {

    FloatingActionMenu floatingActionMenu;
    FloatingActionButton fbtnSetAs, fbtnShare, fbtnSave, fbtnFavorites;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_detail);

        ActionBar actionBar = getSupportActionBar();
        Objects.requireNonNull(actionBar).setDisplayHomeAsUpEnabled(true);

        floatingActionMenu = findViewById(R.id.fab);
        fbtnFavorites = findViewById(R.id.fbtnFavorites);
        fbtnSave = findViewById(R.id.fbtnSaveImage);
        fbtnSetAs = findViewById(R.id.fbtnSetAs);
        fbtnShare = findViewById(R.id.fbtnShare);

        fbtnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ImageDetailActivity.this, "Share", Toast.LENGTH_SHORT).show();
            }
        });

        fbtnSetAs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ImageDetailActivity.this, "Set As Wallpaper", Toast.LENGTH_SHORT).show();
            }
        });

        fbtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ImageDetailActivity.this, "Save Image", Toast.LENGTH_SHORT).show();
            }
        });

        fbtnFavorites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ImageDetailActivity.this, "Favorites", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

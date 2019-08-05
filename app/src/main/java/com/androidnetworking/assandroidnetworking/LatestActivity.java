package com.androidnetworking.assandroidnetworking;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.androidnetworking.assandroidnetworking.adapter.PostAdapter;
import com.androidnetworking.assandroidnetworking.modelPost.Post;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class LatestActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private String srcJPG = "http://4.bp.blogspot.com/-pNnDdiFWhkA/UEqgqjUVKTI/AAAAAAAAACg/njNEANV3vEQ/s1600/1111.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latest);

        final RecyclerView recyclerView = findViewById(R.id.lvLatest);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);

        final ArrayList<Post> posts = new ArrayList<>();
        for (int i = 0; i <= 12; i++) {

            posts.add(new Post(R.drawable.anh9));
//            final Thread myThread = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    Bitmap bitmap = loadImageFromNetWork(srcJPG);
//                    posts.add(new Post(bitmap));
//                }
//            });
//            myThread.start();
        }

        PostAdapter postAdapter = new PostAdapter(posts, this);
        recyclerView.setAdapter(postAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getApplicationContext(), ImageDetailActivity.class);
                intent.putExtra("image", posts.get(position).getHinhAnh()); // put image data in Intent
                Toast.makeText(LatestActivity.this, "Go to ImageDetailActivity", Toast.LENGTH_SHORT).show();
                startActivity(intent); // start Intent
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    private Bitmap loadImageFromNetWork(String link) {
        URL url;
        Bitmap bitmap = null;
        try {
            url = new URL(link);
            bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_latest) {
            startActivity(new Intent(this, LatestActivity.class));
        } else if (id == R.id.nav_category) {
            startActivity(new Intent(this, CategoryActivity.class));
        } else if (id == R.id.nav_gifs) {

        } else if (id == R.id.nav_myFavorites) {
            startActivity(new Intent(this, FavoritesActivity.class));
        } else if (id == R.id.nav_rate_app) {

        } else if (id == R.id.nav_more_app) {

        } else if (id == R.id.nav_about_us) {
            startActivity(new Intent(this, AboutUsActivity.class));
        } else if (id == R.id.nav_setting) {

        } else if (id == R.id.nav_privacy_police) {

        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

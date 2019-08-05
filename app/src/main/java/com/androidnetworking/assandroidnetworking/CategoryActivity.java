package com.androidnetworking.assandroidnetworking;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;

import com.androidnetworking.assandroidnetworking.adapter.CategoryAdapter;
import com.androidnetworking.assandroidnetworking.adapter.FavoritesAdapter;
import com.androidnetworking.assandroidnetworking.modelPost.Category;
import com.androidnetworking.assandroidnetworking.modelPost.Post;

import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        final RecyclerView recyclerView = findViewById(R.id.lvCategory);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        final ArrayList<Category> categories = new ArrayList<>();
        for (int i = 0; i <= 13; i++) {

            categories.add(new Category(R.drawable.anh10, "Việt Nam", "0"));
//            final Thread myThread = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    Bitmap bitmap = loadImageFromNetWork(srcJPG);
//                    posts.add(new Post(bitmap));
//                }
//            });
//            myThread.start();
        }

        CategoryAdapter categoryAdapter = new CategoryAdapter(categories, this);
        recyclerView.setAdapter(categoryAdapter);

        categoryAdapter.setOnItemClickListener(new CategoryAdapter.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {
//                Intent intent = new Intent(getApplicationContext(), ImageDetailActivity.class);
//                intent.putExtra("image", categories.get(position).getHinhAnh()); // put image data in Intent
//                startActivity(intent); // start Intent
                Toast.makeText(CategoryActivity.this, categories.get(position).getNameCategory(), Toast.LENGTH_SHORT).show();
            }
        });

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);

        // Kết hợp cấu hình có thể tìm kiếm với SearchView
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.menu_search)
                .getActionView();
        searchView.setSearchableInfo(searchManager
                .getSearchableInfo(getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);

        searchView.setQueryHint(getString(R.string.search));

        // nghe thay đổi văn bản truy vấn tìm kiếm
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // chế độ xem bộ lọc của bộ lọc khi truy vấn được gửi
//                noteAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                // chế độ xem bộ lọc tái chế khi văn bản được thay đổi
//                noteAdapter.getFilter().filter(query);
                return false;
            }
        });
        return true;
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

    @SuppressWarnings("StatementWithEmptyBody")
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

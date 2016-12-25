package com.felpudo.bottomnav;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.toolbar_title);

        setSupportActionBar(toolbar);

        final FragmentManager fragmentManager = getSupportFragmentManager();

        final Fragment songsFragment  = new SongsFragment();
        final Fragment moviesFragment = new MoviesFragment();
        final Fragment booksFragment  = new BooksFragment();

        fragmentManager.beginTransaction().replace(R.id.container, songsFragment).commit();

        BottomNavigationView bottomNav = (BottomNavigationView) findViewById(R.id.bottomNav);

        bottomNav.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {

                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                        FragmentTransaction fragmentTransaction;

                        switch (item.getItemId()) {

                            case R.id.action_songs:

                                fragmentTransaction = fragmentManager.beginTransaction();
                                fragmentTransaction.replace(R.id.container, songsFragment).commit();
                                return true;

                            case R.id.action_movies:

                                fragmentTransaction = fragmentManager.beginTransaction();
                                fragmentTransaction.replace(R.id.container, moviesFragment).commit();
                                return true;

                            case R.id.action_books:

                                fragmentTransaction = fragmentManager.beginTransaction();
                                fragmentTransaction.replace(R.id.container, booksFragment).commit();
                                return true;

                            default:
                                return true;
                        }
                    }
                }
        );
    }
}
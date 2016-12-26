package com.felpudo.bottomnav;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        final Window window = getWindow();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = (TextView)findViewById(R.id.textView);

        final BottomNavigationView bottomNav = (BottomNavigationView) findViewById(R.id.bottomNav);

        bottomNav.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {

                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                        switch (item.getItemId()) {

                            case R.id.action_songs:

                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                                    window.setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));
                                }

                                textView.setText(R.string.menu_item_songs);
                                bottomNav.setItemBackgroundResource(R.color.colorPrimary);
                                return true;

                            case R.id.action_movies:

                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                                    window.setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.red));
                                }

                                textView.setText(R.string.menu_item_movies);
                                bottomNav.setItemBackgroundResource(R.color.red);
                                return true;

                            case R.id.action_books:

                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                                    window.setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.teal));
                                }

                                textView.setText(R.string.menu_item_books);
                                bottomNav.setItemBackgroundResource(R.color.teal);
                                return true;

                            case R.id.action_history:

                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                                    window.setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.brown));
                                }

                                textView.setText(R.string.menu_item_history);
                                bottomNav.setItemBackgroundResource(R.color.brown);
                                return true;

                            default:
                                return true;
                        }
                    }
                }
        );
    }
}
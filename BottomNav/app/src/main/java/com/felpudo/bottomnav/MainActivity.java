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

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = (TextView)findViewById(R.id.textView);

        final BottomNavigationView bottomNav = (BottomNavigationView) findViewById(R.id.bottomNav);

        bottomNav.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {

                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                        // Do something according to the selected item

                        switch (item.getItemId()) {

                            case R.id.action_songs:

                                textView.setText(R.string.menu_item_songs);
                                changeStatusBarColor(R.color.colorPrimary);
                                bottomNav.setItemBackgroundResource(R.color.colorPrimary);
                                return true;

                            case R.id.action_movies:

                                textView.setText(R.string.menu_item_movies);
                                changeStatusBarColor(R.color.red);
                                bottomNav.setItemBackgroundResource(R.color.red);
                                return true;

                            case R.id.action_books:

                                textView.setText(R.string.menu_item_books);
                                changeStatusBarColor(R.color.teal);
                                bottomNav.setItemBackgroundResource(R.color.teal);
                                return true;

                            case R.id.action_history:

                                textView.setText(R.string.menu_item_history);
                                changeStatusBarColor(R.color.brown);
                                bottomNav.setItemBackgroundResource(R.color.brown);
                                return true;

                            default:
                                return true;
                        }
                    }
                }
        );
    }

    private void  changeStatusBarColor(int res) {

        // Verify that the color of the status bar can be changed

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(ContextCompat.getColor(getApplicationContext(), res));
        }
    }
}
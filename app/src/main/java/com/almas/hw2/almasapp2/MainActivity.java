package com.almas.hw2.almasapp2;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;
import java.util.Map;


public class MainActivity extends ActionBarActivity {
    static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
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

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.action_about_me:
                Log.d(TAG, "action_about_me");

                ft.replace(R.id.container, new AboutMeFragment(), "about_me_fragment");
                ft.commit();

                return true;

            case R.id.action_linear_layout:
                Log.d(TAG, "action_linear_layout");

                ft.replace(R.id.container, new LinearLayoutFragment(), "linear_layout_fragment");
                ft.commit();

                return true;

            case R.id.action_relative_layout:
                Log.d(TAG, "action_relative_layout");

                ft.replace(R.id.container, new RelativeLayoutFragment(), "relative_layout_fragment");
                ft.commit();

                return true;

            case R.id.action_grid_layout:
                Log.d(TAG, "action_grid_layout");

                ft.replace(R.id.container, new GridLayoutFragment(), "grid_layout_fragment");
                ft.commit();

                return true;

            case R.id.action_movies_data:
                Log.d(TAG, "action_movies_data");

                ft.replace(R.id.container, new MoviesDataFragment(), "movies_data_fragment");
                ft.commit();

                return true;

            case R.id.action_seek_bar:
                Log.d(TAG, "action_seek_bar");

                ft.replace(R.id.container, new SeekBarFragment(), "seek_bar_fragment");
                ft.commit();

                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            return rootView;
        }
    }
}

package com.jesualex.postergallery.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jesualex.postergallery.R;
import com.jesualex.postergallery.database.utils.MovieUtils;
import com.jesualex.postergallery.fragmentsAndAdapters.PosterFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.mainFragment, new PosterFragment()).commit();

        MovieUtils.updateByPopular();
    }
}

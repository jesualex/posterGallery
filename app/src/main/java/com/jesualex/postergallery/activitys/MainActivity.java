package com.jesualex.postergallery.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.jesualex.postergallery.R;
import com.jesualex.postergallery.database.utils.MovieUtils;
import com.jesualex.postergallery.fragmentsAndAdapters.PosterFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.toolbar) Toolbar toolbar;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.mainFragment, new PosterFragment()).commit();
    }

    @Override public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);

        MenuItem item = menu.findItem(R.id.orderSpinner);
        Spinner spinner = (Spinner) item.getActionView();
        String[] orderArray = MovieUtils.getOrderByArray();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, R.layout.spinner_item, orderArray);

        adapter.setDropDownViewResource(R.layout.dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                MovieUtils.updateBy(orderArray[position]);
            }

            @Override public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return true;
    }
}

package com.example.mohanteja.vizagporttrust;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ElectronicsActivity extends AppCompatActivity{

    private static final String TAG = "ElectronicsActivity";
    private List<Cameras> mPhotoList = new ArrayList<Cameras>();
    private RecyclerView mRecyclerView;
    private ElectronicsAdapter electronicsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electronics);

//        activateToolbar();

        mRecyclerView = (RecyclerView) findViewById(R.id.electronicsRecyclerView1);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        electronicsAdapter = new ElectronicsAdapter(ElectronicsActivity.this,
                new ArrayList<Cameras>());

        mRecyclerView.setAdapter(electronicsAdapter);

//        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this,
//                mRecyclerView, new RecyclerItemClickListener.OnItemClickListener() {
//            @Override
//            public void onItemClick(View view, int position) {
//
//                Toast.makeText(MainActivity.this, "Normal tap", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onItemLongClick(View view, int position) {
//
////                Toast.makeText(MainActivity.this, "Long tap", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(MainActivity.this, ViewPhotoDetailsActivity.class);
//                intent.putExtra(PHOTO_TRANSFER, flickrRecyblerViewAdapter.getPhoto(position));
//                startActivity(intent);
//            }
//        }));
    }



    @Override
    protected void onResume() {
        super.onResume();

            String jsonPage ="video_surveillance_cameras.php";
            ProcessPhotos processPhotos = new ProcessPhotos(jsonPage, true);
            processPhotos.execute();

    }

    private String getSavedPreferenceData(String key) {

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        return sharedPref.getString(key, "");
    }

    public class ProcessPhotos extends GetElectronicsJson {

        public ProcessPhotos(String searchCriteria, boolean matchAll) {
            super(searchCriteria, matchAll);
        }

        public void execute() {
            super.execute();
            ProcessData processData = new ProcessData();
            processData.execute();

        }

        public class ProcessData extends DownloadJsonData {

            protected void onPostExecute(String webData) {
                super.onPostExecute(webData);
                electronicsAdapter.loadNewData(getPhotos());
            }

        }
    }

}

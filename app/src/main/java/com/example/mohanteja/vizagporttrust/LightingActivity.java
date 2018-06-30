package com.example.mohanteja.vizagporttrust;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class LightingActivity extends AppCompatActivity {

    private static final String TAG = "LightingActivity";
    private List<LightingItem> lightingItemList = new ArrayList<LightingItem>();
    private RecyclerView mRecyclerView;
    private LightingRecyclerAdapter lightingRecyclerAdapter;
    public String jsonPage ="lighting.php"; //default page
    private int pageIndex =23;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lighting);


        mRecyclerView = (RecyclerView) findViewById(R.id.lightingRecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        lightingRecyclerAdapter = new LightingRecyclerAdapter(LightingActivity.this,
                new ArrayList<LightingItem>());

        mRecyclerView.setAdapter(lightingRecyclerAdapter);

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

        LightingActivity.ProcessLightingItems processPhotos = new LightingActivity.ProcessLightingItems(jsonPage, pageIndex);
        processPhotos.execute();

    }

    private String getSavedPreferenceData(String key) {

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        return sharedPref.getString(key, "");
    }

    public class ProcessLightingItems extends GetElectronicsJson {

        public ProcessLightingItems(String searchCriteria, int pageIndex) {
            super(searchCriteria, pageIndex);
        }

        public void execute() {
            super.execute();
            LightingActivity.ProcessLightingItems.ProcessData processData = new LightingActivity.ProcessLightingItems.ProcessData();
            processData.execute();

        }

        public class ProcessData extends DownloadJsonData {

            protected void onPostExecute(String webData) {
                super.onPostExecute(webData);
                lightingRecyclerAdapter.loadNewData(getLightingItemList());
            }

        }
    }

}

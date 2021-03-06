package com.example.mohanteja.vizagporttrust;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CraneActivity extends AppCompatActivity {
    private static final String TAG = "CraneActivity";
    private List<CraneItem> craneItemList = new ArrayList<CraneItem>();
    private RecyclerView mRecyclerView;
    private CraneRecyclerAdapter craneRecyclerAdapter;
    public String jsonPage ="cranes.php"; //default page
    private int pageIndex =21;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crane);


        mRecyclerView = (RecyclerView) findViewById(R.id.craneRecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        craneRecyclerAdapter = new CraneRecyclerAdapter(CraneActivity.this,
                new ArrayList<CraneItem>());

        mRecyclerView.setAdapter(craneRecyclerAdapter);

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

        CraneActivity.ProcessCraneItem processPhotos = new CraneActivity.ProcessCraneItem(jsonPage, pageIndex);
        processPhotos.execute();

    }

    private String getSavedPreferenceData(String key) {

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        return sharedPref.getString(key, "");
    }

    public class ProcessCraneItem extends GetElectronicsJson {

        public ProcessCraneItem(String searchCriteria, int pageIndex) {
            super(searchCriteria, pageIndex);
        }

        public void execute() {
            super.execute();
            CraneActivity.ProcessCraneItem.ProcessData processData = new CraneActivity.ProcessCraneItem.ProcessData();
            processData.execute();

        }

        public class ProcessData extends DownloadJsonData {

            protected void onPostExecute(String webData) {
                super.onPostExecute(webData);
                craneRecyclerAdapter.loadNewData(getCraneItemList());
            }

        }
    }

}

package com.example.mohanteja.vizagporttrust;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ElectronicsActivity extends AppCompatActivity{

    private static final String TAG = "ElectronicsActivity";
    private List<Cameras> mPhotoList = new ArrayList<Cameras>();
    private RecyclerView mRecyclerView;
    private ElectronicsAdapter electronicsAdapter;
    private TextView menuOpt ;
    public String jsonPage ="video_surveillance_cameras.php"; //default page
    private int pageIndex =2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electronics);
        menuOpt = findViewById(R.id.electronicsMnuOpt);
        menuOpt.setText("detailed status");
//        activateToolbar();

        mRecyclerView = (RecyclerView) findViewById(R.id.electronicsRecyclerView1);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        electronicsAdapter = new ElectronicsAdapter(ElectronicsActivity.this,
                new ArrayList<Cameras>());

        mRecyclerView.setAdapter(electronicsAdapter);

        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        itemAnimator.setAddDuration(1000);
        itemAnimator.setRemoveDuration(1000);
        mRecyclerView.setItemAnimator(itemAnimator);



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
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.electronic_menu, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id= item.getItemId();
        switch (id){
            case R.id.detailedStatusMenuItem:
                jsonPage="video_surveillance_cameras.php";
                pageIndex=2;
                menuOpt.setText("detailed status");
                onResume();
                break;
            case R.id.railwayMenuItem:
                jsonPage="railway_weighbridges.php";
                pageIndex=3;
                menuOpt.setText("railway weighbridge");
                onResume();
                break;
            case R.id.truckMenuItem:
                jsonPage="truck_weighbridges.php";
                pageIndex=4;
                menuOpt.setText("truck_weighbridges");
                onResume();
                break;
            case R.id.radioNavigationMenuItem:
                jsonPage="radio_navigation_aids.php";
                menuOpt.setText("radio_navigation_aids");
                pageIndex=5;
                onResume();
                break;
            case R.id.rdeStationMenuItem:
                jsonPage="rde_station.php";
                pageIndex=6;
                menuOpt.setText("rde_station");

                onResume();
                break;
            case R.id.rfidMenuItem:
                jsonPage="rfid.php";
                pageIndex=7;
                menuOpt.setText("rfid");

                onResume();
                break;
             default:
                 jsonPage="video_surveillance_cameras.php";
                 pageIndex=2;
                 menuOpt.setText("detailed status");
                 onResume();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
            ProcessPhotos processPhotos = new ProcessPhotos(jsonPage, pageIndex);
            processPhotos.execute();

    }

    private String getSavedPreferenceData(String key) {

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        return sharedPref.getString(key, "");
    }

    public class ProcessPhotos extends GetElectronicsJson {

        public ProcessPhotos(String searchCriteria, int pageIndex) {
            super(searchCriteria, pageIndex);
        }

        public void execute() {
            super.execute();
            ProcessData processData = new ProcessData();
            processData.execute();

        }

        public class ProcessData extends DownloadJsonData {

            protected void onPostExecute(String webData) {
                super.onPostExecute(webData);
                electronicsAdapter.loadNewData(getmCameras());
            }

        }
    }

}

package com.example.mohanteja.vizagporttrust;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FCSActivity extends AppCompatActivity {
    private static final String TAG = "FCSActivity";
    private List<FcsEachCraftItem> fcsEachCraftItemList = new ArrayList<FcsEachCraftItem>();
    private RecyclerView mRecyclerView;
    private FcsRecyclerAdapter fcsRecyclerAdapter;
    public String jsonPage = "fcs_tugs_details.php"; //default page
    private int pageIndex = 9;
    private TextView mnuOpt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fcs);

        mnuOpt = findViewById(R.id.fcsMnuOpt);
//        activateToolbar();
        mnuOpt.setText("tugs");
        mRecyclerView = (RecyclerView) findViewById(R.id.fcsRecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.getRecycledViewPool().setMaxRecycledViews(0, 0);

        fcsRecyclerAdapter = new FcsRecyclerAdapter(FCSActivity.this,
                new ArrayList<FcsEachCraftItem>());

        mRecyclerView.setAdapter(fcsRecyclerAdapter);

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

        getMenuInflater().inflate(R.menu.fcs_menu, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.fcs_tugs:
                jsonPage = "fcs_tugs_details.php";
                pageIndex = 9;
                mnuOpt.setText("tugs");
                onResume();
                break;
            case R.id.fcs_floating_cranes:
                jsonPage = "fcs_floating_cranes.php";
                pageIndex = 10;
                mnuOpt.setText("floating cranes");
                onResume();
                break;
            case R.id.fcs_dredger:
                jsonPage = "fcs_dredger.php";
                pageIndex = 11;
                mnuOpt.setText("dredger ");
                onResume();
                break;
            case R.id.fcs_pilot_launches:
                jsonPage = "fcs_pilot_launches.php";
                pageIndex = 12;
                mnuOpt.setText("pilot launches");
                onResume();
                break;
            case R.id.fcs_mooringlaunches:
                jsonPage = "fcs_mooring_launches.php";
                pageIndex = 13;
                mnuOpt.setText("mooring launches");
                onResume();
                break;
            case R.id.fcs_vip:
                jsonPage = "fcs_vip_launch.php";
                pageIndex = 14;
                mnuOpt.setText("vip launch");
                onResume();
                break;
            case R.id.fcs_oil:
                jsonPage = "fcs_oil_barage.php";
                pageIndex = 15;
                mnuOpt.setText("oil barage");
                onResume();
                break;
            case R.id.fcs_survey:
                jsonPage = "fcs_survey_launch.php";
                pageIndex = 16;
                mnuOpt.setText("survey launch");
                onResume();
                break;
            case R.id.fcs_firefloat:
                jsonPage = "fcs_fire_float.php";
                pageIndex = 17;
                mnuOpt.setText("fire float");
                onResume();
                break;
            case R.id.fcs_pollution:
                jsonPage = "fcs_pollution_craft.php";
                pageIndex = 18;
                mnuOpt.setText("pollution craft");
                onResume();
                break;
            default:
                jsonPage = "fcs_tugs_details.php";
                pageIndex = 18;
                mnuOpt.setText("tugs");
                onResume();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        FCSActivity.ProcessFcsEcItem processPhotos = new FCSActivity.ProcessFcsEcItem(jsonPage, pageIndex);
        processPhotos.execute();

    }

    private String getSavedPreferenceData(String key) {

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        return sharedPref.getString(key, "");
    }

    public class ProcessFcsEcItem extends GetElectronicsJson {

        public ProcessFcsEcItem(String searchCriteria, int pageIndex) {
            super(searchCriteria, pageIndex);
        }

        public void execute() {
            super.execute();
            FCSActivity.ProcessFcsEcItem.ProcessData processData = new FCSActivity.ProcessFcsEcItem.ProcessData();
            processData.execute();

        }

        public class ProcessData extends DownloadJsonData {

            protected void onPostExecute(String webData) {
                super.onPostExecute(webData);
                fcsRecyclerAdapter.loadNewData(getFcsEachCraftItemList());
            }

        }
    }
}

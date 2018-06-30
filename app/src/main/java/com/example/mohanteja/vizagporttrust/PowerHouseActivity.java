package com.example.mohanteja.vizagporttrust;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class PowerHouseActivity extends AppCompatActivity {

    private static final String TAG = "PowerHouseActivity";
    private List<PowerDistributionItem> powerDistributionItemList = new ArrayList<PowerDistributionItem>();
    private RecyclerView mRecyclerView;
    private PowerHouseRecyclerViewAdapter powerHouseRecyclerViewAdapter;
    public String jsonPage ="power_distribution.php"; //default page
    private int pageIndex =22;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_power_house);


        mRecyclerView = (RecyclerView) findViewById(R.id.powerhouseRecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        powerHouseRecyclerViewAdapter = new PowerHouseRecyclerViewAdapter(PowerHouseActivity.this,
                new ArrayList<PowerDistributionItem>());

        mRecyclerView.setAdapter(powerHouseRecyclerViewAdapter);

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

        PowerHouseActivity.ProcessPowerDistributionItems processPhotos = new PowerHouseActivity.ProcessPowerDistributionItems(jsonPage, pageIndex);
        processPhotos.execute();

    }

    private String getSavedPreferenceData(String key) {

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        return sharedPref.getString(key, "");
    }

    public class ProcessPowerDistributionItems extends GetElectronicsJson {

        public ProcessPowerDistributionItems(String searchCriteria, int pageIndex) {
            super(searchCriteria, pageIndex);
        }

        public void execute() {
            super.execute();
            PowerHouseActivity.ProcessPowerDistributionItems.ProcessData processData = new PowerHouseActivity.ProcessPowerDistributionItems.ProcessData();
            processData.execute();

        }

        public class ProcessData extends DownloadJsonData {

            protected void onPostExecute(String webData) {
                super.onPostExecute(webData);
                powerHouseRecyclerViewAdapter.loadNewData(getPowerDistributionItemList());
            }

        }
    }


}

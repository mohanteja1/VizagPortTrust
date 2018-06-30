package com.example.mohanteja.vizagporttrust;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PumpHouseActivity extends AppCompatActivity {

    private static final String TAG = "PumpHouseActivity";
    private List<PumpHouseItem> pumpHouseItemList = new ArrayList<PumpHouseItem>();
    private RecyclerView mRecyclerView;
    private PumpHouseRecyclerAdapter pumpHouseRecyclerAdapter;
    public String jsonPage ="pump_houses.php"; //default page
    private int pageIndex =20;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pump_house);


        mRecyclerView = (RecyclerView) findViewById(R.id.pumpHouseRecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        pumpHouseRecyclerAdapter = new PumpHouseRecyclerAdapter(PumpHouseActivity.this,
                new ArrayList<PumpHouseItem>());

        mRecyclerView.setAdapter(pumpHouseRecyclerAdapter);

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

        PumpHouseActivity.ProcessPumpHouseItems processPhotos = new PumpHouseActivity.ProcessPumpHouseItems(jsonPage, pageIndex);
        processPhotos.execute();

    }

    private String getSavedPreferenceData(String key) {

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        return sharedPref.getString(key, "");
    }

    public class ProcessPumpHouseItems extends GetElectronicsJson {

        public ProcessPumpHouseItems(String searchCriteria, int pageIndex) {
            super(searchCriteria, pageIndex);
        }

        public void execute() {
            super.execute();
            PumpHouseActivity.ProcessPumpHouseItems.ProcessData processData = new PumpHouseActivity.ProcessPumpHouseItems.ProcessData();
            processData.execute();

        }

        public class ProcessData extends DownloadJsonData {

            protected void onPostExecute(String webData) {
                super.onPostExecute(webData);
                pumpHouseRecyclerAdapter.loadNewData(getPumpHouseItemList());
            }

        }
    }


}

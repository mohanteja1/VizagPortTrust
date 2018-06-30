package com.example.mohanteja.vizagporttrust;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class BGLocosActivity extends AppCompatActivity {

    private static final String TAG = "BGLocosActivity";
    private List<Cameras> mPhotoList = new ArrayList<Cameras>();
    private RecyclerView mRecyclerView;
    private BglocosAdapter bglocosAdapter;
    public String jsonPage ="bg_loco.php"; //default page
    private int pageIndex =19;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bglocos);

        mRecyclerView = (RecyclerView) findViewById(R.id.bglocosRecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        bglocosAdapter = new BglocosAdapter(BGLocosActivity.this,
                new ArrayList<BGLocoItem>());

        mRecyclerView.setAdapter(bglocosAdapter);

    }

    @Override
    protected void onResume() {
        super.onResume();


        ProcessBgLocos processBgLocos = new ProcessBgLocos(jsonPage, pageIndex);
        processBgLocos.execute();



    }
    public class ProcessBgLocos extends GetElectronicsJson {

        public ProcessBgLocos(String searchCriteria, int pageIndex) {
            super(searchCriteria, pageIndex);
        }

        public void execute() {
            super.execute();
            BGLocosActivity.ProcessBgLocos.ProcessData processData = new BGLocosActivity.ProcessBgLocos.ProcessData();
            processData.execute();

        }

        public class ProcessData extends DownloadJsonData {

            protected void onPostExecute(String webData) {
                super.onPostExecute(webData);
                bglocosAdapter.loadNewData(getBgLocoItemList());
            }

        }
    }








}

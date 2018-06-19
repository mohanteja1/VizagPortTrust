package com.example.mohanteja.vizagporttrust;

import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class GetElectronicsJson extends GetRawData {
    private static final String TAG = "GetElectronicsJson";
    private String LOG_TAG = GetElectronicsJson.class.getSimpleName();
    private List<Cameras> mCameras;
    private Uri mDestinationUri;

    public GetElectronicsJson(String searchCriteria, boolean matchAll) {

        super(null);
        createAndUpdateUri(searchCriteria, matchAll);
        mCameras = new ArrayList<Cameras>();
    }

    public void execute() {

        super.setmRawUrl(mDestinationUri.toString());
        DownloadJsonData downloadJsonData = new DownloadJsonData();
        Log.v(LOG_TAG, "Built URI = " + mDestinationUri.toString());
        downloadJsonData.execute(mDestinationUri.toString());
    }

    public boolean createAndUpdateUri(String jsonPage, boolean matchAll) {

        final String DATABASE_BASE_URL = "http://mohantejachitturi1.000webhostapp.com";


        mDestinationUri = Uri.parse(DATABASE_BASE_URL).buildUpon()
                .appendPath(jsonPage)
                .build();

        return  mDestinationUri != null;
    }

    public List<Cameras> getPhotos() {
        return mCameras;
    }

    public void processResult() {

        if(getmDownloadStatus() != DownloadStatus.OK) {
            Log.e(LOG_TAG, "Error downloading raw file");
            return;
        }


        try {

            JSONArray itemArray = new JSONArray(getmData());
            for(int i=0; i<itemArray.length(); i++) {
                JSONObject jsonObject1= itemArray.getJSONObject(i);
                String location =jsonObject1.getString("LOCATION");
                String status=jsonObject1.getString("STATUS");
                String remarks=jsonObject1.getString("REMARKS");
                Cameras cameras= new Cameras(location,status,remarks);

                this.mCameras.add(cameras);
            }

            for(Cameras singlePhoto: mCameras) {
                Log.v(LOG_TAG, singlePhoto.toString());
            }

        } catch (JSONException jsone) {
            jsone.printStackTrace();
            Log.e(LOG_TAG, "Error process Json data");
        }


    }

    public class DownloadJsonData extends DownloadRawData {

        protected void onPostExecute(String webData) {

            super.onPostExecute(webData);
            processResult();
        }

        protected String doInBackground(String... params) {

            String[] par = { mDestinationUri.toString()};
            return super.doInBackground(par);

        }


    }

}
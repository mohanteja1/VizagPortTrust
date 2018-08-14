package com.example.mohanteja.vizagporttrust;

import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Switch;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class GetElectronicsJson extends GetRawData {
    private static final String TAG = "GetElectronicsJson";
    private String LOG_TAG = GetElectronicsJson.class.getSimpleName();

    //total declaration of json types used in the app
    private List<TotalCameraItem> totalCameraItemList;
    private List<Cameras> mCameras;
    private List<BGLocoItem> bgLocoItemList;
    private List<CraneItem> craneItemList;
    private List<LightingItem> lightingItemList;
    private List<FcsDeploymentItems> fcsDeploymentItemsList;
    private List<FcsEachCraftItem> fcsEachCraftItemList;
    private List<PowerDistributionItem> powerDistributionItemList;
    private List<PumpHouseItem> pumpHouseItemList;



    private int pageIndex;

    /*--------------list of pages in database that send json items and their pageindex
  pageIndex page
         1. cameras_total


         2  video_surveillance_cameras
         3  railway_weighbridges
         4  truck_weighbridges
         5  radio_navigation_aids
         6  rde_station
         7  rfid

         8  floating_crafts_section

         9  fcs_tugs_details
        10  fcs_floating_cranes
        11  fcs_dredger
        12  fcs_pilot_launches
        13  fcs_mooring_launches
        14  fcs_vip_launch
        15  fcs_oil_barage
        16  fcs_survey_launch
        17  fcs_fire_float
        18  fcs_pollution_craft

        19  bg_loco

        20  pump_houses

        21  cranes

        22  power_distribution

        23  lighting

    * */


    //url
    private Uri mDestinationUri;

    //---------constructor-----------------------------just initializes the respective array
    public GetElectronicsJson(String jsonpage, int pageIndex) {

        super(null);
        createAndUpdateUri(jsonpage);

        this.pageIndex=pageIndex;

        switch (pageIndex) {

            case 1:
                totalCameraItemList = new ArrayList<TotalCameraItem>();
                break;
                //similar objects in database
            case 2: case 3: case 4: case 5: case 6:
            case 7:
                mCameras= new ArrayList<Cameras>();
                break;

            case 8:
                fcsDeploymentItemsList=new ArrayList<FcsDeploymentItems>();
                break;
           //similar objects
            case 9: case 10: case 11: case 12: case 13: case 14: case 15: case 16: case 17:
            case 18:
                fcsEachCraftItemList =new ArrayList<FcsEachCraftItem>();
                break;

            case 19:
                bgLocoItemList=new ArrayList<BGLocoItem>();
                break;
            case 20:
                pumpHouseItemList=new ArrayList<PumpHouseItem>();
                break;
            case 21:
                craneItemList=new ArrayList<CraneItem>();
                break;
            case 22:
                powerDistributionItemList=new ArrayList<PowerDistributionItem>();
                break;
            case 23:
                lightingItemList=new ArrayList<LightingItem>();
            default:
                Log.e(TAG, "GetElectronicsJson: illegal page index refer GetJsonData.java file for commentSection" );
                break;
        }
    }

    public void execute() {

        super.setmRawUrl(mDestinationUri.toString());
        DownloadJsonData downloadJsonData = new DownloadJsonData();
        Log.v(LOG_TAG, "Built URI = " + mDestinationUri.toString());
        downloadJsonData.execute(mDestinationUri.toString());
    }

    public boolean createAndUpdateUri(String jsonPage) {

        final String DATABASE_BASE_URL = "http://mohantejachitturi1.000webhostapp.com";


        mDestinationUri = Uri.parse(DATABASE_BASE_URL).buildUpon()
                .appendPath(jsonPage)
                .build();

        return  mDestinationUri != null;
    }

// ----------------getter functions--------------------------------------
    public List<TotalCameraItem> getTotalCameraItemList() {
        return totalCameraItemList;
    }

    public List<Cameras> getmCameras() {
        return mCameras;
    }

    public List<BGLocoItem> getBgLocoItemList() {
        return bgLocoItemList;
    }

    public List<CraneItem> getCraneItemList() {
        return craneItemList;
    }

    public List<LightingItem> getLightingItemList() {
        return lightingItemList;
    }

    public List<FcsDeploymentItems> getFcsDeploymentItemsList() {
        return fcsDeploymentItemsList;
    }

    public List<FcsEachCraftItem> getFcsEachCraftItemList() {
        return fcsEachCraftItemList;
    }

    public List<PowerDistributionItem> getPowerDistributionItemList() {
        return powerDistributionItemList;
    }

    public List<PumpHouseItem> getPumpHouseItemList() {
        return pumpHouseItemList;
    }


    public void clear(){

    }





//------------------json to object conversion--------------------------------------------
    public void processResult() {

        if(getmDownloadStatus() != DownloadStatus.OK) {
            Log.e(LOG_TAG, "Error downloading raw file");
            return;
        }


        try {

            //switch case for downloading only for the parsing required item---
            //difficult to understand but eliminates code duplication

            JSONArray itemArray = new JSONArray(getmData());


            switch (pageIndex) {

                case 1:
                    if(!totalCameraItemList.isEmpty())
                        totalCameraItemList.clear();

                    for(int i=0; i<itemArray.length(); i++) {

// total cameras table
                        JSONObject jsonObject1= itemArray.getJSONObject(i);
                        String type =jsonObject1.getString("type");
                        String working =jsonObject1.getString("WORKING");
                        String not_working=jsonObject1.getString("NOT_WORKING");
                        String remarks=jsonObject1.getString("REMARKS");
                        TotalCameraItem totalCameraItem =new TotalCameraItem(type,working,not_working,remarks);
                        this.totalCameraItemList.add(totalCameraItem);

                    }

                    for(TotalCameraItem singleTotalCameraItemList: totalCameraItemList) {
                        Log.v(LOG_TAG, singleTotalCameraItemList.toString());
                    }
                    break;


                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
// cameras
                    if(!mCameras.isEmpty())
                        mCameras.clear();

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
                    break;

                case 8:

                    if(!fcsDeploymentItemsList.isEmpty())
                        fcsDeploymentItemsList.clear();
//fcs craft items types
                    for(int i=0; i<itemArray.length(); i++) {
                        JSONObject jsonObject1= itemArray.getJSONObject(i);
                        String slno =jsonObject1.getString("SLNO");
                        String craftType=jsonObject1.getString("CRAFT_TYPE");
                        String totalCrafts=jsonObject1.getString("TOTAL_CRAFTS");
                        String availableCrafts=jsonObject1.getString("AVAILABLE_CRAFTS");
                        String shift1=jsonObject1.getString("1_SHIFT");
                        String shift2=jsonObject1.getString("2_SHIFT");
                        String shift3=jsonObject1.getString("3_SHIFT");
                        String shiftg=jsonObject1.getString("G/SHIFT");
                        FcsDeploymentItems fcsDeploymentItem= new FcsDeploymentItems(slno,craftType,totalCrafts,availableCrafts,shift1,shift2,shift3,shiftg);
                        this.fcsDeploymentItemsList.add(fcsDeploymentItem);
                    }

                    for(FcsDeploymentItems fcsDeploymentItem: fcsDeploymentItemsList) {
                        Log.v(LOG_TAG, fcsDeploymentItem.toString());
                    }
                    break;
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                case 17:
                case 18:
//fcs items of each type of craft

                    if(!fcsEachCraftItemList.isEmpty())
                        fcsEachCraftItemList.clear();

                    for(int i=0; i<itemArray.length(); i++) {
                        JSONObject jsonObject1= itemArray.getJSONObject(i);
                        String slno =jsonObject1.getString("SL.NO");
                        String name_of_the_craft =jsonObject1.getString("NAME_OF_THE_CRAFT");
                        String commission =jsonObject1.getString("COMMISSION");
                        String shutdown =jsonObject1.getString("SHUTDOWN");
                        String no_of_movements_shift_1 =jsonObject1.getString("NO_OF_MOVEMENTS_SHIFT_1");
                        String no_of_movements_shift_2 =jsonObject1.getString("NO_OF_MOVEMENTS_SHIFT_2");
                        String no_of_movements_shift_3 =jsonObject1.getString("NO_OF_MOVEMENTS_SHIFT_3");
                        String no_of_movements_shift_g=jsonObject1.getString("NO_OF_MOVEMENTS_SHIFT_G");
                        String total_no_of_movements=jsonObject1.getString("TOTAL_NO_OF_MOVEMENTS");
                        FcsEachCraftItem fcsEachCraftItem =new FcsEachCraftItem(slno,name_of_the_craft,commission,shutdown,no_of_movements_shift_1,no_of_movements_shift_2,no_of_movements_shift_3,no_of_movements_shift_g,total_no_of_movements);
                       this.fcsEachCraftItemList.add(fcsEachCraftItem);
                    }

                    for(FcsEachCraftItem singlePhoto: fcsEachCraftItemList) {
                        Log.v(LOG_TAG, singlePhoto.toString());
                    }                    break;
                case 19:
//bg locos table

                    if(!bgLocoItemList.isEmpty())
                        bgLocoItemList.clear();

                    for(int i=0; i<itemArray.length(); i++) {
                        JSONObject jsonObject1= itemArray.getJSONObject(i);

                        String no_l_oPorD =jsonObject1.getString("NO_L_OP/D");
                        String no_l_a_m =jsonObject1.getString("NO_L_A_M");
                        String no_l_poh =jsonObject1.getString("NO_L_POH");
                        String no_l_pm =jsonObject1.getString("NO_L_PM");
                        String no_l_bd =jsonObject1.getString("NO_L_BD");
                        String incoming_rakes =jsonObject1.getString("INCOMING_RAKES");
                        String outgoing_rakes=jsonObject1.getString("OUTGOING_RAKES");
                        String no_rorD=jsonObject1.getString("NO_R/D");


                        BGLocoItem bgLocoItem = new BGLocoItem(no_l_oPorD,no_l_a_m,no_l_poh,no_l_pm,no_l_bd,incoming_rakes,outgoing_rakes,no_rorD);
                        this.bgLocoItemList.add(bgLocoItem);

                    }

                    for(BGLocoItem bgLocoItem: bgLocoItemList) {
                        Log.v(LOG_TAG, bgLocoItem.toString());
                    }
                    break;


//      pump house
                case 20:
                    if(!pumpHouseItemList.isEmpty())
                        pumpHouseItemList.clear();
                    for(int i=0; i<itemArray.length(); i++) {
                        JSONObject jsonObject1= itemArray.getJSONObject(i);
                        String slno =jsonObject1.getString("SL.NO");
                        String pump_houses =jsonObject1.getString("PUMP_HOUSES");
                        String total_pumps_motors =jsonObject1.getString("TOTAL_PUMPS/MOTORS");
                        String shift_1 =jsonObject1.getString("SHIFT_1");
                        String shift_2 =jsonObject1.getString("SHIFT_2");
                        String shift_3=jsonObject1.getString("SHIFT_3");
                        String shift_g=jsonObject1.getString("SHIFT_G");


                        PumpHouseItem pumpHouseItem = new PumpHouseItem(slno,pump_houses,total_pumps_motors,shift_1,shift_2,shift_3,shift_g);
                        this.pumpHouseItemList.add(pumpHouseItem);


                    }

                    for(PumpHouseItem pumpHouseItem: pumpHouseItemList) {
                        Log.v(LOG_TAG, pumpHouseItem.toString());
                    }
                    break;

// cranes
                case 21:



                    if(!craneItemList.isEmpty())
                        craneItemList.clear();

                    for(int i=0; i<itemArray.length(); i++) {
                        JSONObject jsonObject1= itemArray.getJSONObject(i);

                        String slno =jsonObject1.getString("SL.NO");
                        String crane_type =jsonObject1.getString("CRANE_TYPE");
                        String total_cranes =jsonObject1.getString("TOTAL_CRANES");
                        String availability =jsonObject1.getString("AVAILABILITY");
                        String shift_1 =jsonObject1.getString("SHIFT_1");
                        String shift_2 =jsonObject1.getString("SHIFT_2");
                        String shift_3=jsonObject1.getString("SHIFT_3");
                        String shift_g=jsonObject1.getString("SHIFT_G");

                        CraneItem craneItem = new CraneItem(slno,crane_type,total_cranes,availability,shift_1,shift_2,shift_3,shift_g);
                        this.craneItemList.add(craneItem);



                    }

                    for(CraneItem singlePhoto: craneItemList) {
                        Log.v(LOG_TAG, singlePhoto.toString());
                    }
                    break;


//          power distribution
                case 22:

                    if(!powerDistributionItemList.isEmpty())
                        powerDistributionItemList.clear();

                    for(int i=0; i<itemArray.length(); i++) {
                        JSONObject jsonObject1= itemArray.getJSONObject(i);

                        String slno =jsonObject1.getString("SL.NO");
                        String parameters =jsonObject1.getString("PARAMETERS");
                        String shift_1 =jsonObject1.getString("SHIFT_1");
                        String shift_2 =jsonObject1.getString("SHIFT_2");
                        String shift_3=jsonObject1.getString("SHIFT_3");
                        String shift_g=jsonObject1.getString("SHIFT_G");

                        PowerDistributionItem powerDistributionItem = new PowerDistributionItem(slno,parameters,shift_1,shift_2,shift_3,shift_g);
                        this.powerDistributionItemList.add(powerDistributionItem);

                    }

                    for(PowerDistributionItem powerDistributionItem: powerDistributionItemList) {
                        Log.v(LOG_TAG, powerDistributionItem.toString());
                    }
                    break;

//          lighting
                case 23:
                    if(!lightingItemList.isEmpty())
                        lightingItemList.clear();

                    for(int i=0; i<itemArray.length(); i++) {
                        JSONObject jsonObject1= itemArray.getJSONObject(i);
                        String slno =jsonObject1.getString("S.NO");
                        String location =jsonObject1.getString("LOCATION");
                        String no_of_high_masts =jsonObject1.getString("NO_OF_HIGH_MASTS");
                        String fitting_x_h_m_a =jsonObject1.getString("FITTING_X_H/M:A");
                        String fitting_x_h_m_b =jsonObject1.getString("FITTING_X_H/M:B");
                        String fitting_x_h_m_c=jsonObject1.getString("FITTING_X_H/M:C");
                        String fitting_x_h_m_d=jsonObject1.getString("FITTING_X_H/M:D");
                        String total_fittings=jsonObject1.getString("TOTAL_FITTINGS");
                        String glowing=jsonObject1.getString("GLOWING");
                        String non_glowing=jsonObject1.getString("NON_GLOWING");

                        LightingItem lightingItem = new LightingItem(slno,location,no_of_high_masts,fitting_x_h_m_a,fitting_x_h_m_b,fitting_x_h_m_c,fitting_x_h_m_d,total_fittings,glowing,non_glowing);
                        this.lightingItemList.add(lightingItem);

                    }

                    for(LightingItem lightingItem: lightingItemList) {
                        Log.v(LOG_TAG, lightingItem.toString());
                    }
                    break;

                    default:
                    Log.e(TAG, "GetElectronicsJson: illegal page index refer GetJsonData.java file for commentSection" );
                    break;
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
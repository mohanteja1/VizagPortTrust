package com.example.mohanteja.vizagporttrust;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class PowerHouseRecyclerViewAdapter extends RecyclerView.Adapter<PowerHouseViewHolder> {
    private static final String TAG = "PowerHouseRecyclerViewA";
    private List<PowerDistributionItem> powerDistributionItemList;
    private Context mContext;
    private final String LOG_TAG = PowerHouseRecyclerViewAdapter.class.getSimpleName();

    public PowerHouseRecyclerViewAdapter(Context context, List<PowerDistributionItem> powerDistributionItemList) {

        mContext = context;
        this.powerDistributionItemList = powerDistributionItemList;
    }

    @NonNull
    @Override
    public PowerHouseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =LayoutInflater.from(parent.getContext()).inflate(R.layout.powerhouse_card, null);
        PowerHouseViewHolder powerHouseViewHolder=new PowerHouseViewHolder(view);
        return powerHouseViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PowerHouseViewHolder holder, int position) {
        PowerDistributionItem powerDistributionItem = powerDistributionItemList.get(position);
        Log.d(LOG_TAG,"Processing: " + powerDistributionItem.getPARAMETERS() + "==> " + Integer.toString(position));


        holder.slno.setText(powerDistributionItem.getSLNO());
        holder.parameters.setText(powerDistributionItem.getPARAMETERS());
        holder.shift1.setText(powerDistributionItem.getSHIFT_1());
        holder.shift2.setText(powerDistributionItem.getSHIFT_2());
        holder.shift3.setText(powerDistributionItem.getSHIFT_3());
        holder.shiftg.setText(powerDistributionItem.getSHIFT_G());


    }

    @Override
    public int getItemCount() {
        return (powerDistributionItemList != null)? powerDistributionItemList.size():0;
    }


    public  void loadNewData(List<PowerDistributionItem> powerDistributionItemList) {
        this.powerDistributionItemList = powerDistributionItemList;
        notifyDataSetChanged();
    }

    public PowerDistributionItem getPowerDistributionItem(int position) {
        return (null != powerDistributionItemList ? powerDistributionItemList.get(position) : null);
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


}

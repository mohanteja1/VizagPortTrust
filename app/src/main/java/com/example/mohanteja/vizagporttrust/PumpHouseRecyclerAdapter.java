package com.example.mohanteja.vizagporttrust;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class PumpHouseRecyclerAdapter extends RecyclerView.Adapter<PumpHouseItemViewHolder> {

    private static final String TAG = "PumpHouseRecyclerAdapte";
    private List<PumpHouseItem> pumpHouseItemList;
    private Context mContext;
    private final String LOG_TAG = PumpHouseRecyclerAdapter.class.getSimpleName();

    public PumpHouseRecyclerAdapter(Context context, List<PumpHouseItem> pumpHouseItemList) {

        mContext = context;
        this.pumpHouseItemList = pumpHouseItemList;
    }

    @NonNull
    @Override
    public PumpHouseItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pumphouse_card, null);
        PumpHouseItemViewHolder pumpHouseItemViewHolder=new PumpHouseItemViewHolder(view);
        return pumpHouseItemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PumpHouseItemViewHolder holder, int position) {
        PumpHouseItem pumpHouseItem = pumpHouseItemList.get(position);
        Log.d(TAG, "onBindViewHolder: ---------------------------------------------");
        Log.d(TAG, "onBindViewHolder: item at position" + position + "\n" +pumpHouseItem.toString());
        Log.d(LOG_TAG,"Processing: " + pumpHouseItem.getPUMP_HOUSES() + "==> " + Integer.toString(position));


        holder.SL_NO.setText(pumpHouseItem.getSLNO());
        holder.PUMP_HOUSES.setText(pumpHouseItem.getPUMP_HOUSES());
        holder.TOTAL_PUMPS_MOTORS.setText(pumpHouseItem.getTOTAL_PUMPS_MOTORS());
        holder.SHIFT_1.setText(pumpHouseItem.getSHIFT_1());
        holder.SHIFT_2.setText(pumpHouseItem.getSHIFT_2());
        holder.SHIFT_3.setText(pumpHouseItem.getSHIFT_3());
        holder.SHIFT_G.setText(pumpHouseItem.getSHIFT_G());


    }

    @Override
    public int getItemCount() {
        return (pumpHouseItemList != null)? pumpHouseItemList.size():0;
    }


    public  void loadNewData(List<PumpHouseItem> pumpHouseItemList) {
        this.pumpHouseItemList = pumpHouseItemList;
        notifyDataSetChanged();
    }

    public PumpHouseItem getPumpHouseItem(int position) {
        return (null != pumpHouseItemList ? pumpHouseItemList.get(position) : null);
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

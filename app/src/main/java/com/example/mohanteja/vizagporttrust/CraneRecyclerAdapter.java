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

public class CraneRecyclerAdapter extends RecyclerView.Adapter<CraneItemViewHolder> {
    private static final String TAG = "CraneRecyclerAdapter";

    private List<CraneItem> craneItemList;
    private Context mContext;
    private final String LOG_TAG = CraneRecyclerAdapter.class.getSimpleName();

    public CraneRecyclerAdapter(Context context, List<CraneItem> craneItemList) {

        mContext = context;
        this.craneItemList = craneItemList;
    }

    @NonNull
    @Override
    public CraneItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cranes_card, null);
        CraneItemViewHolder craneItemViewHolder=new CraneItemViewHolder(view);
        return craneItemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CraneItemViewHolder holder, int position) {
        CraneItem craneItem = craneItemList.get(position);
        Log.d(LOG_TAG,"Processing: " + craneItem.getSLNO() + "==> " + Integer.toString(position));





        holder.SL_NO.setText(craneItem.getSLNO());
        holder.CRANE_TYPE.setText(craneItem.getCRANE_TYPE());
        holder.TOTAL_CRANES.setText(craneItem.getTOTAL_CRANES());
        holder.AVAILABILITY.setText(craneItem.getAVAILABILITY());
        holder.SHIFT_1.setText(craneItem.getSHIFT_1());
        holder.SHIFT_2.setText(craneItem.getSHIFT_2());
        holder.SHIFT_3.setText(craneItem.getSHIFT_3());
        holder.SHIFT_G.setText(craneItem.getSHIFT_G());


    }

    @Override
    public int getItemCount() {
        return (craneItemList != null)? craneItemList.size():0;
    }


    public  void loadNewData(List<CraneItem> craneItemList) {
        this.craneItemList = craneItemList;
        notifyDataSetChanged();
    }

    public CraneItem getCraneItem(int position) {
        return (null != craneItemList ? craneItemList.get(position) : null);
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

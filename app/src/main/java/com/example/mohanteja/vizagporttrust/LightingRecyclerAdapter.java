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

public class LightingRecyclerAdapter extends RecyclerView.Adapter<LightingItemViewHolder> {

    private static final String TAG = "LightingRecyclerAdapter";
    private List<LightingItem> lightingItemList;
    private Context mContext;
    private final String LOG_TAG = LightingRecyclerAdapter.class.getSimpleName();

    public LightingRecyclerAdapter(Context context, List<LightingItem> lightingItemList) {

        mContext = context;
        this.lightingItemList = lightingItemList;
    }

    @NonNull
    @Override
    public LightingItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lighting_card, null);
        LightingItemViewHolder lightingItemViewHolder=new LightingItemViewHolder(view);
        return lightingItemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LightingItemViewHolder holder, int position) {
        LightingItem lightingItem = lightingItemList.get(position);
        Log.d(LOG_TAG,"Processing: " + lightingItem.getLOCATION() + "==> " + Integer.toString(position));


        holder.SL_NO.setText(lightingItem.getSLNO());
        holder.LOCATION.setText(lightingItem.getLOCATION());
        holder.NO_OF_HIGH_MASTS.setText(lightingItem.getNO_OF_HIGH_MASTS());
        holder.FITTING_X_H_M_A.setText(lightingItem.getFITTING_X_H_M_A());
        holder.FITTING_X_H_M_B.setText(lightingItem.getFITTING_X_H_M_B());
        holder.FITTING_X_H_M_C.setText(lightingItem.getFITTING_X_H_M_C());
        holder.FITTING_X_H_M_D.setText(lightingItem.getFITTING_X_H_M_D());
        holder.TOTAL_FITTINGS.setText(lightingItem.getTOTAL_FITTINGS());
        holder.GLOWING.setText(lightingItem.getGLOWING());
        holder.NON_GLOWING.setText(lightingItem.getNON_GLOWING());
    }

    @Override
    public int getItemCount() {
        return (lightingItemList != null)? lightingItemList.size():0;
    }


    public  void loadNewData(List<LightingItem> lightingItemList) {
        this.lightingItemList = lightingItemList;
        notifyDataSetChanged();
    }

    public LightingItem getPowerDistributionItem(int position) {
        return (null != lightingItemList ? lightingItemList.get(position) : null);
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

package com.example.mohanteja.vizagporttrust;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ElectronicsAdapter extends RecyclerView.Adapter<ElectronicsViewHolder> {
    private static final String TAG = "ElectronicsAdapter";
    private List<Cameras> mCameraList;
    private Context mContext;
    private final String LOG_TAG = ElectronicsAdapter.class.getSimpleName();

    public ElectronicsAdapter(Context context, List<Cameras> camerasList) {

        mContext = context;
        this.mCameraList = camerasList;
    }

    @Override
    public ElectronicsViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.electronics_card, null);
        ElectronicsViewHolder flickrImageViewHolder = new ElectronicsViewHolder(view);
        return flickrImageViewHolder;
    }

    @Override
    public void onBindViewHolder(ElectronicsViewHolder electronicsViewHolder, int i) {

        Cameras camerasItem = mCameraList.get(i);
        Log.d(LOG_TAG,"Processing: " + camerasItem.getLocation() + "==> " + Integer.toString(i));


        electronicsViewHolder.electronicsLocationTextView.setText(camerasItem.getLocation());
        electronicsViewHolder.electronicsRemarksTextView.setText("Remarks:" + camerasItem.getRemarks());
        if(Integer.parseInt(camerasItem.getStatus())== 1) {
            electronicsViewHolder.electronicsImageView.setImageResource(R.drawable.baseline_linked_camera_black_36);
        }
        else {
            electronicsViewHolder.electronicsImageView.setImageResource(R.drawable.baseline_report_black_36);
        }

    }

    @Override
    public int getItemCount() {
        return (null != mCameraList ? mCameraList.size() : 0);
    }

    public  void loadNewData(List<Cameras> newPhotos) {
      //  clear(newPhotos);
        mCameraList = newPhotos;
        notifyDataSetChanged();
    }

    public void clear(List<Cameras> newPhotos){
        Log.d(TAG, "clear: clearing list");
        final int size =mCameraList.size();

        if(size > 0){
            for (int i =0; i<size;i++)
            {
                mCameraList.remove(0);
            }
        }

        notifyItemRangeRemoved(0, size);
        Log.d(TAG, "clear: removed =" + mCameraList.isEmpty());

    }


    public Cameras getPhoto(int position) {
        return (null != mCameraList ? mCameraList.get(position) : null);
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

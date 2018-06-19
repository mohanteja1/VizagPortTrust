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
//        Picasso.with(mContext).load(photoItem.getImage())
//                .error(R.drawable.placeholder)
//                .placeholder(R.drawable.placeholder)
//                .into(flickrImageViewHolder.thumbnail);
//        flickrImageViewHolder.title.setText(photoItem.getTitle());

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
        mCameraList = newPhotos;
        notifyDataSetChanged();
    }

    public Cameras getPhoto(int position) {
        return (null != mCameraList ? mCameraList.get(position) : null);
    }



}

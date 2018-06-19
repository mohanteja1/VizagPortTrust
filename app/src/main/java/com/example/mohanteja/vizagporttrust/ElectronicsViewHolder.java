package com.example.mohanteja.vizagporttrust;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

public class ElectronicsViewHolder extends RecyclerView.ViewHolder {

    public ImageView electronicsImageView;
    public TextView electronicsLocationTextView;
    public TextView electronicsRemarksTextView;
   // public Switch statusSwitch;


    public ElectronicsViewHolder(View itemView) {
        super(itemView);
        electronicsLocationTextView = itemView.findViewById(R.id.location);
        electronicsImageView = itemView.findViewById(R.id.elecCameraIcon);
        electronicsRemarksTextView = itemView.findViewById(R.id.remarks);
     //   statusSwitch = itemView.findViewById(R.id.statusSwitch);

    }

}

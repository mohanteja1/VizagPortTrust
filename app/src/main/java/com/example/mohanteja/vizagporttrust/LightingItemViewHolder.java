package com.example.mohanteja.vizagporttrust;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class LightingItemViewHolder extends RecyclerView.ViewHolder {

    public TextView  SL_NO;
    public TextView  LOCATION;
    public TextView  NO_OF_HIGH_MASTS;
    public TextView  FITTING_X_H_M_A;
    public TextView  FITTING_X_H_M_B;
    public TextView  FITTING_X_H_M_C;
    public TextView  FITTING_X_H_M_D;
    public TextView  TOTAL_FITTINGS;
    public TextView  GLOWING;
    public TextView  NON_GLOWING;


    public  LightingItemViewHolder(View itemView) {
        super(itemView);
        SL_NO = itemView.findViewById(R.id.lght_slno);
        LOCATION = itemView.findViewById(R.id.lght_location);
        NO_OF_HIGH_MASTS = itemView.findViewById(R.id.lght_nhm);
        FITTING_X_H_M_A = itemView.findViewById(R.id.lght_afxhm);
        FITTING_X_H_M_B = itemView.findViewById(R.id.lght_bfxhm);
        FITTING_X_H_M_C = itemView.findViewById(R.id.lght_cfxhm);
        FITTING_X_H_M_D = itemView.findViewById(R.id.lght_cfxhm);
        TOTAL_FITTINGS = itemView.findViewById(R.id.lght_dfxhm);
        GLOWING = itemView.findViewById(R.id.lght_glow);
        NON_GLOWING = itemView.findViewById(R.id.lght_nglow);

    }



}

package com.example.mohanteja.vizagporttrust;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class PumpHouseItemViewHolder extends RecyclerView.ViewHolder {



    public TextView  SL_NO;
    public TextView  PUMP_HOUSES;
    public TextView  TOTAL_PUMPS_MOTORS;
    public TextView  SHIFT_1;
    public TextView  SHIFT_2;
    public TextView  SHIFT_3;
    public TextView  SHIFT_G;

    public PumpHouseItemViewHolder(View itemView) {
        super(itemView);
        SL_NO= itemView.findViewById(R.id.ph_slno);
        PUMP_HOUSES = itemView.findViewById(R.id.ph_ph);
        TOTAL_PUMPS_MOTORS= itemView.findViewById(R.id.ph_tpm);
        SHIFT_1= itemView.findViewById(R.id.ph_sh1);
        SHIFT_2= itemView.findViewById(R.id.ph_sh2);
        SHIFT_3= itemView.findViewById(R.id.ph_sh3);
        SHIFT_G= itemView.findViewById(R.id.ph_shg);

    }

}

package com.example.mohanteja.vizagporttrust;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class CraneItemViewHolder extends RecyclerView.ViewHolder {

    public TextView SL_NO;
    public TextView CRANE_TYPE;
    public TextView TOTAL_CRANES;
    public TextView AVAILABILITY;
    public TextView SHIFT_1;
    public TextView SHIFT_2;
    public TextView SHIFT_3;
    public TextView SHIFT_G;



    public CraneItemViewHolder(View itemView) {
        super(itemView);
        SL_NO= itemView.findViewById(R.id.crane_slno);
        CRANE_TYPE = itemView.findViewById(R.id.crane_type);
        TOTAL_CRANES= itemView.findViewById(R.id.cranes_tc);
        AVAILABILITY= itemView.findViewById(R.id.cranes_avail);
        SHIFT_1 = itemView.findViewById(R.id.cranes_sh1);
        SHIFT_2 = itemView.findViewById(R.id.cranes_sh2);
        SHIFT_3= itemView.findViewById(R.id.cranes_sh3);
        SHIFT_G = itemView.findViewById(R.id.cranes_shg);

    }




}

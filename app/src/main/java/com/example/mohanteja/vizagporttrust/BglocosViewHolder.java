package com.example.mohanteja.vizagporttrust;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class BglocosViewHolder extends RecyclerView.ViewHolder {


    public TextView NO_L_OPorD;
    public TextView NO_L_A_M;
    public TextView NO_L_POH;
    public TextView NO_L_PM;
    public TextView NO_L_BD;
    public TextView INCOMING_RAKES;
    public TextView OUTGOING_RAKES;
    public TextView NO_RorD;

    // public Switch statusSwitch;


    public BglocosViewHolder(View itemView) {
        super(itemView);
        NO_L_OPorD= itemView.findViewById(R.id.NO_L_OPorD);
        NO_L_A_M = itemView.findViewById(R.id.NO_L_A_M);
        NO_L_POH= itemView.findViewById(R.id.NO_L_POH);
        NO_L_PM= itemView.findViewById(R.id.NO_L_PM);
        NO_L_BD= itemView.findViewById(R.id.NO_L_BD);
        INCOMING_RAKES= itemView.findViewById(R.id.INCOMING_RAKES);
        OUTGOING_RAKES= itemView.findViewById(R.id.OUTGOING_RAKES);
        NO_RorD= itemView.findViewById(R.id.NO_RorD);

    }

}

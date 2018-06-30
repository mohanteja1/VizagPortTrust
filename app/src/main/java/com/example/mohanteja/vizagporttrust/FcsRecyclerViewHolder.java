package com.example.mohanteja.vizagporttrust;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class FcsRecyclerViewHolder extends RecyclerView.ViewHolder {


    public TextView SLNO;
    public TextView NAME_OF_THE_CRAFT;
    public TextView COMMISSION;
    public TextView SHUTDOWN;
    public TextView NO_OF_MOVEMENTS_SHIFT_1;
    public TextView NO_OF_MOVEMENTS_SHIFT_2;
    public TextView NO_OF_MOVEMENTS_SHIFT_3;
    public TextView NO_OF_MOVEMENTS_SHIFT_G;
    public TextView TOTAL_NO_OF_MOVEMENTS;


    public FcsRecyclerViewHolder(View itemView) {
        super(itemView);
        SLNO= itemView.findViewById(R.id.fcs_slno);
        NAME_OF_THE_CRAFT= itemView.findViewById(R.id.fcs_nott);
        COMMISSION= itemView.findViewById(R.id.fcs_comm);
        SHUTDOWN= itemView.findViewById(R.id.fcs_shutdown);
        NO_OF_MOVEMENTS_SHIFT_1= itemView.findViewById(R.id.fcs_nmis1);
        NO_OF_MOVEMENTS_SHIFT_2= itemView.findViewById(R.id.fcs_nmis2);
        NO_OF_MOVEMENTS_SHIFT_3= itemView.findViewById(R.id.fcs_nmis3);
        NO_OF_MOVEMENTS_SHIFT_G= itemView.findViewById(R.id.fcs_nminsg);
        TOTAL_NO_OF_MOVEMENTS= itemView.findViewById(R.id.fcs_tnmins);

    }

}

package com.example.mohanteja.vizagporttrust;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class PowerHouseViewHolder extends RecyclerView.ViewHolder {


    public TextView slno ;
    public TextView parameters;
    public TextView shift1;
    public TextView shift2;
    public TextView shift3;
    public TextView shiftg;


    public PowerHouseViewHolder(View itemView) {
        super(itemView);
      slno = itemView.findViewById(R.id.slno);
      parameters = itemView.findViewById(R.id.parameters);
      shift1 = itemView.findViewById(R.id.shift1);
      shift2 = itemView.findViewById(R.id.shift2);
      shift3 = itemView.findViewById(R.id.shift3);
      shiftg = itemView.findViewById(R.id.shiftg);
    }




}

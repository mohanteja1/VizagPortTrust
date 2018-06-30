package com.example.mohanteja.vizagporttrust;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class FcsRecyclerAdapter extends RecyclerView.Adapter<FcsRecyclerViewHolder> {


    private static final String TAG = "ElectronicsAdapter";
    private List<FcsEachCraftItem> fcsEachCraftItemList;
    private Context mContext;
    private final String LOG_TAG = FcsRecyclerAdapter.class.getSimpleName();

    public FcsRecyclerAdapter(Context context, List<FcsEachCraftItem> fcsEachCraftItemList) {
        mContext = context;
        this.fcsEachCraftItemList = fcsEachCraftItemList;
    }

    @Override
    public FcsRecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fcs_item_card, null);
        FcsRecyclerViewHolder fcsRecyclerViewHolder = new FcsRecyclerViewHolder(view);
        return fcsRecyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(FcsRecyclerViewHolder fcsRecyclerViewHolder, int i) {

        FcsEachCraftItem fcsEachCraftItem = fcsEachCraftItemList.get(i);
        Log.d(LOG_TAG,"Processing: " + fcsEachCraftItem.getNAME_OF_THE_CRAFT() + "==> " + Integer.toString(i));
//        Picasso.with(mContext).load(photoItem.getImage())
//                .error(R.drawable.placeholder)
//                .placeholder(R.drawable.placeholder)
//                .into(flickrImageViewHolder.thumbnail);
//        flickrImageViewHolder.title.setText(photoItem.getTitle());

        fcsRecyclerViewHolder.SLNO.setText(fcsEachCraftItem.getSLNO());
        fcsRecyclerViewHolder.NAME_OF_THE_CRAFT.setText(fcsEachCraftItem.getNAME_OF_THE_CRAFT());
        fcsRecyclerViewHolder.COMMISSION.setText(fcsEachCraftItem.getCOMMISSION());
        fcsRecyclerViewHolder.SHUTDOWN.setText(fcsEachCraftItem.getSHUTDOWN());
        fcsRecyclerViewHolder.NO_OF_MOVEMENTS_SHIFT_1.setText(fcsEachCraftItem.getNO_OF_MOVEMENTS_SHIFT_1());
        fcsRecyclerViewHolder.NO_OF_MOVEMENTS_SHIFT_2.setText(fcsEachCraftItem.getNO_OF_MOVEMENTS_SHIFT_2());
        fcsRecyclerViewHolder.NO_OF_MOVEMENTS_SHIFT_3.setText(fcsEachCraftItem.getNO_OF_MOVEMENTS_SHIFT_3());
        fcsRecyclerViewHolder.NO_OF_MOVEMENTS_SHIFT_G.setText(fcsEachCraftItem.getNO_OF_MOVEMENTS_SHIFT_G());
        fcsRecyclerViewHolder.TOTAL_NO_OF_MOVEMENTS.setText(fcsEachCraftItem.getTOTAL_NO_OF_MOVEMENTS());

    }

    @Override
    public int getItemCount() {
        return (null != fcsEachCraftItemList ? fcsEachCraftItemList.size() : 0);
    }

    public  void loadNewData(List<FcsEachCraftItem> fcsEachCraftItems) {
        fcsEachCraftItemList = fcsEachCraftItems;
        notifyDataSetChanged();
    }

    public FcsEachCraftItem getFcsEachCraftItem(int position) {
        return (null != fcsEachCraftItemList ? fcsEachCraftItemList.get(position) : null);
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

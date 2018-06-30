package com.example.mohanteja.vizagporttrust;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class BglocosAdapter extends RecyclerView.Adapter<BglocosViewHolder> {

    private static final String TAG = "BglocosAdapter";
    private List<BGLocoItem> bgLocoItemList;
    private Context mContext;
    private final String LOG_TAG = BglocosAdapter.class.getSimpleName();

    public BglocosAdapter(Context context, List<BGLocoItem> bgLocoItemList) {

        mContext = context;
        this.bgLocoItemList = bgLocoItemList;
    }

    @Override
    public BglocosViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bglocos_card, null);
        BglocosViewHolder bglocosViewHolder = new BglocosViewHolder(view);
        return bglocosViewHolder;
    }

    @Override
    public void onBindViewHolder(BglocosViewHolder bglocosViewHolder, int i) {

        BGLocoItem bgLocoItem = bgLocoItemList.get(i);

        bglocosViewHolder.NO_L_OPorD.setText(bgLocoItem.getNO_L_OPorD());
        bglocosViewHolder.NO_L_A_M.setText(bgLocoItem.getNO_L_A_M());
        bglocosViewHolder.NO_L_POH.setText(bgLocoItem.getNO_L_POH());
        bglocosViewHolder.NO_L_PM.setText(bgLocoItem.getNO_L_PM());
        bglocosViewHolder.INCOMING_RAKES.setText(bgLocoItem.getINCOMING_RAKES());
        bglocosViewHolder.OUTGOING_RAKES.setText(bgLocoItem.getOUTGOING_RAKES());
        bglocosViewHolder.NO_L_BD.setText(bgLocoItem.getNO_L_BD());
        bglocosViewHolder.NO_RorD.setText(bgLocoItem.getNO_RorD());


    }

    @Override
    public int getItemCount() {
        return (null != bgLocoItemList ? bgLocoItemList.size() : 0);
    }

    public  void loadNewData(List<BGLocoItem> bgLocoItemList) {
        this.bgLocoItemList = bgLocoItemList;
        notifyDataSetChanged();
    }

    public BGLocoItem getBgItem(int position) {
        return (null != bgLocoItemList ? bgLocoItemList.get(position) : null);
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

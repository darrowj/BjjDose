package com.jasondarrow.bjjdose;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by darrowj on 1/18/18.
 */

public class DoseRecyclerAdapter extends RecyclerView.Adapter<DoseRecyclerAdapter.ViewHolder> {

    private final Context mContent;
    private final List<Dose> mDoses;
    private final LayoutInflater mLayoutInflater;

    public DoseRecyclerAdapter(Context mContent, List<Dose> mDoses) {
        this.mContent = mContent;
        this.mDoses = mDoses;
        this.mLayoutInflater = LayoutInflater.from(mContent);
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.item_dose_list, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Dose dose = mDoses.get(position);
        holder.textTitle.setText(dose.getTitle());
        holder.textDescription.setText(dose.getDescription().substring(0, 20) + "... ");
        holder.currentPosition = position;
    }

    @Override
    public int getItemCount() {

        return mDoses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final TextView textTitle;
        public final TextView textDescription;
        public int currentPosition;

        public ViewHolder(View itemView) {
            super(itemView);
            textTitle = (TextView) itemView.findViewById(R.id.text_title);
            textDescription= (TextView) itemView.findViewById(R.id.text_description);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContent, DoseActivity.class);
                    intent.putExtra(DoseActivity.DOSE_POSITION, currentPosition);
                    mContent.startActivity(intent);
                }
            });
        }
    }
}

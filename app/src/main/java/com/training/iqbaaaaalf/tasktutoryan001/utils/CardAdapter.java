package com.training.iqbaaaaalf.tasktutoryan001.utils;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.training.iqbaaaaalf.tasktutoryan001.model.DestinationModel;
import com.training.iqbaaaaalf.tasktutoryan001.R;
import com.training.iqbaaaaalf.tasktutoryan001.view.DestinationDetailActivity;
import com.training.iqbaaaaalf.tasktutoryan001.view.MainActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iqbaaaaalf on 10/6/2017.
 */

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ItemHolder> implements Filterable {

    private static final String TAG = CardAdapter.class.getSimpleName();

    private DestinationFilter destinationFilter;

    public List<DestinationModel> destinationObj;
    public List<DestinationModel> destinationFiltered;
    public Context parentContext;

    public CardAdapter(List<DestinationModel> destObj){
        destinationObj = destObj;
        destinationFiltered = destObj;
        getFilter();
        Log.i("checking container ", String.valueOf(destinationFiltered.size()));
    }


    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        parentContext = parent.getContext();
        int layoutId = R.layout.rv_card;
        LayoutInflater inflater = LayoutInflater.from(parentContext);
        boolean attachRightAway = false;

        View view = inflater.inflate(layoutId,parent,attachRightAway);
        ItemHolder viewHolder = new ItemHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {
        holder.bind(position);
        holder.onClick(position);
    }

    @Override
    public int getItemCount() {
        return destinationFiltered.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder{
        ImageView ivPlace;
        TextView tvTitle;
        CardView card;

        public ItemHolder(View itemView) {
            super(itemView);

            ivPlace = (ImageView) itemView.findViewById(R.id.iv_picture);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            card = (CardView) itemView.findViewById(R.id.card);

        }

        public void onClick(final int position){
            card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent detailIntent = new Intent(parentContext, DestinationDetailActivity.class);
                    detailIntent.putExtra("destinationDetail", destinationFiltered.get(position));
                    parentContext.startActivity(detailIntent);

                }
            });

        }


        public void bind(int position){
            //for Image with picasso
            //Picasso.with(itemView.getContext()).load(destinationObj.get(position).getPhoto()).into(ivPlace);
            //for image with Glide
            Glide.with(itemView.getContext())
                    .load(destinationFiltered.get(position).getPhoto())
                    .placeholder(R.drawable.placeholder)
                    .error(R.drawable.placeholder_error)
                    .centerCrop()
                    .into(ivPlace);
            tvTitle.setText(destinationFiltered.get(position).getTripName());
        }
    }

    @Override
    public Filter getFilter() {
        if (destinationFilter == null) {
            destinationFilter = new DestinationFilter();
        }

        return destinationFilter;
    }

    private class DestinationFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults filterResults = new FilterResults();
            if (constraint!=null && constraint.length()>0) {
                List<DestinationModel> tempList = new ArrayList<DestinationModel>();

                for (DestinationModel dest : destinationObj) {
                    if (dest.getTripName().toLowerCase().contains(constraint.toString().toLowerCase())) {
                        tempList.add(dest);
                    }
                }

                Log.i("container after filter", String.valueOf(tempList.size()));

                filterResults.count = tempList.size();
                filterResults.values = tempList;
            } else {
                filterResults.count = destinationObj.size();
                filterResults.values = destinationObj;
                Log.i("container after filter", String.valueOf(destinationObj.size()));
            }

            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            destinationFiltered = (List<DestinationModel>) results.values;
            notifyDataSetChanged();
        }
    }
}

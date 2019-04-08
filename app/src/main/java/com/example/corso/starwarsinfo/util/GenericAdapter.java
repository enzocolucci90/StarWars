package com.example.corso.starwarsinfo.util;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.corso.starwarsinfo.R;
import com.example.corso.starwarsinfo.data.Person;
import com.example.corso.starwarsinfo.data.Planet;
import com.example.corso.starwarsinfo.data.Starship;

import java.util.List;

public class GenericAdapter<T extends GenericData> extends RecyclerView.Adapter<GenericAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView rowItemText;
        LinearLayout rigaPeople;
        public ViewHolder(View v) {
            super(v);
            rowItemText = (TextView) v.findViewById(R.id.text_riga_item);
            rigaPeople = (LinearLayout) v.findViewById(R.id.riga_item);
        }
    }

    ItemSelectedCallback mCallback;
    private List<T> dataSet;
    private Context mContext;

    public GenericAdapter(Context context, List<? extends GenericData> dataSet, ItemSelectedCallback mCallback) {
        this.mContext = context;
        this.dataSet = (List<T>) dataSet;
        this.mCallback=mCallback;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.riga_item, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        holder.rowItemText.setText(dataSet.get(position).getName());
        holder.rigaPeople.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("OnClickPlanets", "Sono dentro");
                if(dataSet.get(position) instanceof Person) {
                    mCallback.onPersonClicked(position, (Person) dataSet.get(position));
                }else if (dataSet.get(position) instanceof Planet) {
                    mCallback.onPlanetClicked(position, (Planet) dataSet.get(position));
                }else
                    mCallback.onStarshipClicked(position, (Starship) dataSet.get(position));
            }
        });




    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

}


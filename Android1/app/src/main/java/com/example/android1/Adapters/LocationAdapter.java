package com.example.android1.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android1.Interface.CustomAdapter;
import com.example.android1.Interface.EndScrollListener;
import com.example.android1.MainActivity;
import com.example.android1.Model.ApiResponse;
import com.example.android1.Model.Locations.ApiResponseLocation;
import com.example.android1.Model.Locations.RickMortyLocation;
import com.example.android1.R;

import java.util.List;

public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.LocationViewHolder> implements CustomAdapter {

    private List<RickMortyLocation> dataList;
    private EndScrollListener scrollEndListener;
    private MainActivity parent;

    /**
     * Constructor
     * @param response
     * @param parent
     */
    public LocationAdapter(ApiResponseLocation response, MainActivity parent){
        this.dataList = response.getResults();
        this.scrollEndListener = parent;
        this.parent = parent;
    }

    @Override
    public void clear() {
        dataList.clear();
    }

    //region ViewHolder Class
    public class LocationViewHolder extends RecyclerView.ViewHolder {
        private final View mView;

        ImageView favoriteIcon;
        TextView locationName;
        TextView locationType;
        TextView locationDimension;

        /**
         * Constructor
         * @param itemView
         */
        public LocationViewHolder(@NonNull View itemView) {
            super(itemView);
            this.mView = itemView;

            favoriteIcon = mView.findViewById(R.id.location_favorite_icon);
            locationName = mView.findViewById(R.id.location_name);
            locationType = mView.findViewById(R.id.location_type);
            locationDimension = mView.findViewById(R.id.location_dimension);
        }


    }

    //endregion

    /**
     * Create the ViewHolder of the RecyclerView
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public LocationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.rickmortylocation, parent, false);
        return new LocationViewHolder(view);
    }

    /**
     * Load the data of the visible items, verify if the last item visible is the last load to
     * launch the loading of the next page
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull LocationViewHolder holder, int position) {
        RickMortyLocation item = (RickMortyLocation) dataList.get(position);
        if (item.isFavorite()){
            holder.favoriteIcon.setVisibility(View.VISIBLE);
        }
        else {
            holder.favoriteIcon.setVisibility(View.INVISIBLE);
        }
        holder.locationName.setText(item.getName());
        holder.locationType.setText(item.getType());
        holder.locationDimension.setText(item.getDimension());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                parent.addPreferences(item);
            }
        });

        if (position == dataList.size() - 2){
            scrollEndListener.onScrollEnd(this);
        }
    }

    /**
     * @return the number of items loaded
     */
    @Override
    public int getItemCount() {
        return dataList.size();
    }

    /**
     * Add all the results of a ApiResponse
     * @param response
     */
    @Override
    public void addAll(ApiResponse response) {
        if (response instanceof ApiResponseLocation){
            ApiResponseLocation tmp = (ApiResponseLocation) response;
            dataList.addAll(tmp.getResults());
            this.notifyDataSetChanged();
        }
    }





}

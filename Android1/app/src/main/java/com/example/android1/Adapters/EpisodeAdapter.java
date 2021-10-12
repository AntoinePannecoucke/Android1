package com.example.android1.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.android1.Interface.CustomAdapter;
import com.example.android1.Interface.EndScrollListener;
import com.example.android1.MainActivity;
import com.example.android1.Model.ApiResponse;
import com.example.android1.Model.Episodes.ApiResponseEpisode;
import com.example.android1.Model.Episodes.RickMortyEpisode;
import com.example.android1.R;

import java.util.List;

import retrofit2.http.PATCH;

public class EpisodeAdapter extends RecyclerView.Adapter<EpisodeAdapter.EpisodeViewHolder> implements CustomAdapter {

    private List<RickMortyEpisode> dataList;
    private EndScrollListener scrollEndListener;
    private MainActivity parent;

    /**
     * Constructor
     * @param response
     * @param parent
     */
    public EpisodeAdapter(ApiResponseEpisode response, MainActivity parent) {
        this.dataList = response.getResults();
        this.scrollEndListener = parent;
        this.parent = parent;
    }

    @Override
    public void clear() {
        dataList.clear();
    }

    //region ViewHolder Class
    class EpisodeViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

        TextView episodeName;
        TextView episodeSeason;
        TextView episodeDate;
        ImageView favoriteIcon;


        /**
         * Constructor
         * @param itemView
         */
        EpisodeViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            favoriteIcon = mView.findViewById(R.id.episode_favorite_icon);
            episodeName = mView.findViewById(R.id.episode_name);
            episodeSeason = mView.findViewById(R.id.episode_season);
            episodeDate = mView.findViewById(R.id.episode_date);
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
    public EpisodeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.rickmortyepisode, parent, false);
        return new EpisodeViewHolder(view);
    }

    /**
     * Load the data of the visible items, verify if the last item visible is the last load to
     * launch the loading of the next page
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(EpisodeViewHolder holder, int position) {
        RickMortyEpisode item = (RickMortyEpisode) dataList.get(position);
        if (item.isFavorite()){
            holder.favoriteIcon.setVisibility(View.VISIBLE);
        }
        else {
            holder.favoriteIcon.setVisibility(View.INVISIBLE);
        }
        holder.episodeName.setText(item.getName());
        holder.episodeSeason.setText(item.getEpisode());
        holder.episodeDate.setText(item.getAirDate());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                parent.addPreferences(item);
            }
        });

        if (position == dataList.size() - 1){
            scrollEndListener.onScrollEnd(this);
        }
    }

    /**
     *
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
        if (response instanceof ApiResponseEpisode){
            ApiResponseEpisode tmp = (ApiResponseEpisode) response;
            dataList.addAll(tmp.getResults());
            this.notifyDataSetChanged();
        }
    }

}

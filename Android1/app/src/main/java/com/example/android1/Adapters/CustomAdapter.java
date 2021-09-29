package com.example.android1.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.android1.Interface.EndScrollListener;
import com.example.android1.Model.ApiResponse;
import com.example.android1.Model.RickMortyCharacter;
import com.example.android1.R;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private List<RickMortyCharacter> dataList;
    private Context context;
    private EndScrollListener scrollEndListener;

    /**
     * Constructor
     * @param context
     * @param response
     * @param listener
     */
    public CustomAdapter(Context context,ApiResponse response, EndScrollListener listener){
        this.context = context;
        this.dataList = response.getResults();
        this.scrollEndListener = listener;
    }

    //region ViewHolder Class
    class CustomViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

        ImageView characterImage;
        TextView characterName;
        TextView characterStatusOrigin;
        TextView characterType;
        TextView characterGender;


        /**
         * Constructor
         * @param itemView
         */
        CustomViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            characterImage = mView.findViewById(R.id.character_image);
            characterName = mView.findViewById(R.id.character_name);
            characterStatusOrigin = mView.findViewById(R.id.character_status_origin);
            characterType = mView.findViewById(R.id.character_type);
            characterGender = mView.findViewById(R.id.character_gender);
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
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.rickmortycharacter, parent, false);
        return new CustomViewHolder(view);
    }

    /**
     * Load the data of the visible items, verify if the last item visible is the last load to
     * launch the loading of the next page
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        RickMortyCharacter item = (RickMortyCharacter) dataList.get(position);
        holder.characterName.setText(item.getName());
        holder.characterGender.setText(item.getGender());
        holder.characterStatusOrigin.setText(item.getStatus() + " - " + item.getOrigin().getName());
        holder.characterType.setText(item.getType());

        Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context));
        builder.build().load(dataList.get(position).getImage())
                .placeholder((R.drawable.ic_launcher_background))
                .error(R.drawable.ic_launcher_background)
                .into(holder.characterImage);

        if (position == dataList.size() - 1){
            scrollEndListener.onScrollEnd();
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
    public void addAll(ApiResponse response){
        dataList.addAll(response.getResults());
    }
}

package com.example.android1.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.android1.Model.ApiResponse;
import com.example.android1.Model.Data;
import com.example.android1.Model.RickMortyCharacter;
import com.example.android1.R;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private List<RickMortyCharacter> dataList;
    private Context context;

    public CustomAdapter(Context context,ApiResponse response){
        this.context = context;
        this.dataList = response.getResults();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

        ImageView characterImage;
        TextView characterName;
        TextView characterStatusOrigin;
        TextView characterType;
        TextView characterGender;


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

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.rickmortycharacter, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        RickMortyCharacter item = (RickMortyCharacter) dataList.get(position);
        holder.characterName.setText(item.getName());
        holder.characterGender.setText(item.getGender());
        holder.characterStatusOrigin.setText(item.getStatus() + " - " + item.getOrigin());
        holder.characterType.setText(item.getType());

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}

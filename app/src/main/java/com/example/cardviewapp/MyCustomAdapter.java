package com.example.cardviewapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyCustomAdapter extends RecyclerView.Adapter<MyCustomAdapter.ViewHolder> {
    // 1- Data
    private Context context;
    private ArrayList<GameModel> gamesList;

    // 2- Constructor


    public MyCustomAdapter(Context context, ArrayList<GameModel> gamesList) {
        this.context = context;
        this.gamesList = gamesList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        GameModel model = gamesList.get(position);
        holder.gameName.setText(model.getGameName());
        holder.gameImage.setImageResource(model.getGameImage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "You Choose "+gamesList.get(position).getGameName(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return gamesList.size();
    }

    // 3- ViewHolder

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView gameImage;
        private TextView gameName;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            gameImage = itemView.findViewById(R.id.cv_iv_item);
            gameName = itemView.findViewById(R.id.cv_tv_item);

        }
    }
}

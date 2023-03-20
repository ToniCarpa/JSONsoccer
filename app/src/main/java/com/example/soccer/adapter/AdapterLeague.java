package com.example.soccer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soccer.R;
import com.example.soccer.model.League;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AdapterLeague extends RecyclerView.Adapter<AdapterLeague.ViewHolder> {
    private Context context;
    private List<League> listLeague;

    public AdapterLeague(Context context, List<League> listLeague) {
        this.context = context;
        this.listLeague = listLeague;
    }

    @NonNull
    @Override
    public AdapterLeague.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.league, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterLeague.ViewHolder holder, int position) {
        holder.name.setText(listLeague.get(position).getStrLeague());
        holder.desc.setText(listLeague.get(position).getStrDescriptionEN());
        Picasso.get().load(listLeague.get(position).getStrBadge())
                .fit()
                .centerCrop()
                .into(holder.flag);
        holder.butVisit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        ArrayList<String> images = new ArrayList<>();
        images.add(listLeague.get(position).getStrFanart1());
        images.add(listLeague.get(position).getStrFanart2());
        images.add(listLeague.get(position).getStrFanart3());
        images.add(listLeague.get(position).getStrFanart4());

        holder.butImag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }


    @Override
    public int getItemCount() {
        return listLeague.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
       ImageView flag;
       TextView name;
       TextView desc;
       Button butVisit;
       Button butImag;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
       flag = itemView.findViewById(R.id.leagueFlag);
       name = itemView.findViewById(R.id.leagueTitle);
       desc = itemView.findViewById(R.id.leagueDescription);
       butImag = itemView.findViewById(R.id.leagueButImages);
       butVisit = itemView.findViewById(R.id.leagueButVisit);
        }
    }
}

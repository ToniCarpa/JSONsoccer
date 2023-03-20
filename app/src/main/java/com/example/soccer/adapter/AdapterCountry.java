package com.example.soccer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soccer.R;
import com.example.soccer.model.Country;
import com.example.soccer.view.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class AdapterCountry extends ArrayAdapter<Country> {
    public AdapterCountry(@NonNull Context context, @NonNull List<Country> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return startView(position, convertView, parent);
    }
    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return startView(position, convertView, parent);
    }


    private View startView(int position, View view, ViewGroup viewGroup){
        if(view == null){
            view = LayoutInflater.from(getContext()).inflate(R.layout.spinner, viewGroup, false);
        }
        ImageView imageView = viewGroup.findViewById(R.id.spinerImg);
        TextView textView = viewGroup.findViewById(R.id.spinerName);
        Country item = getItem(position);

        if(item != null){
            imageView.setImageResource(item.getImage());
            textView.setText(item.getName());
        }
        return viewGroup;
    }
}

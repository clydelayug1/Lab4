package com.layug.lab4;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class VersionAdapter extends ArrayAdapter<Version> {
    Context mContext;
    int mResource;
    public VersionAdapter(@NonNull Context context, int resource, @NonNull List<Version> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        int image = getItem(position).getLogo();
        String company = getItem(position).getCompany();
        String country = getItem(position).getCountry();
        String industry = getItem(position).getIndustry();
        String ceo = getItem(position).getCeo();
        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);
        TextView tvCom = convertView.findViewById(R.id.tvCom);
        TextView tvCoun = convertView.findViewById(R.id.tvCoun);
        TextView tvInd = convertView.findViewById(R.id.tvInd);
        TextView tvCeo = convertView.findViewById(R.id.tvCeo);
        ImageView ivLogo = convertView.findViewById(R.id.logo);
        tvCom.setText(company);
        tvCoun.setText(country);
        tvInd.setText(industry);
        tvCeo.setText(ceo);
        ivLogo.setImageResource(image);
        return convertView;
    }
}

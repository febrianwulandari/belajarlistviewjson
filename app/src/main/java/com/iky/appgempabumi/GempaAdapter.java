package com.iky.appgempabumi;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class GempaAdapter extends ArrayAdapter<Gempa> {
    //pemotongn kalimat mulai of
    private static final String LOCATION_SEPARATOR = "of";

    public GempaAdapter(Context context, List<Gempa> gempas) {
        super(context, 0,gempas);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }
        Gempa currentGempa = getItem(position);

        TextView magnitudeView = (TextView) listItemView.findViewById(R.id.magnitude);
        //supaya magnitude nya nilainya cuma 8.9 bukan 8.9909090
        String formatMagnitude = formatMagnitude(currentGempa.getMaginitude());
        magnitudeView.setText(formatMagnitude);

        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeView.getBackground();
        int magnitudeColor = getMagnitudeColor((currentGempa.getMaginitude()));
        magnitudeCircle.setColor(magnitudeColor);

        String originalLocation = currentGempa.getLocation();

        String primaryLocation;
        String locationOffset;

        if(originalLocation.contains(LOCATION_SEPARATOR)){
            String[] parts = originalLocation.split(LOCATION_SEPARATOR);
            locationOffset = parts[0] + LOCATION_SEPARATOR;
            primaryLocation = parts[1];
        }else{
            locationOffset = "Near the";
            primaryLocation = originalLocation;

        }

        TextView primaryLocationView = listItemView.findViewById(R.id.primary_location);
        primaryLocationView.setText(primaryLocation);

        TextView locationOffSetView = listItemView.findViewById(R.id.location_offset);
        locationOffSetView.setText(locationOffset);

        Date dateObject = new Date(currentGempa.getTimeMilliseconds());

        TextView dateView = listItemView.findViewById(R.id.date);
        String formattedDate = formatDate(dateObject);
        dateView.setText(formattedDate);

        TextView timeView = listItemView.findViewById(R.id.time);
        String formattedTime = formatTime(dateObject);
        timeView.setText(formattedTime);

        return listItemView;

    }
    
    private String formatMagnitude(double magnitude){
        DecimalFormat magnitudeformat = new DecimalFormat("0.0");
        return magnitudeformat.format(magnitude);
    }
    
    private String formatDate(Date dateObject){
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }
    private String formatTime(Date dateObject){
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }
    
    private int getMagnitudeColor(double magnitude){
        int magnitudeColorResourceId = 0;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor){
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.colormagnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.colormagnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.colormagnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.colormagnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.colormagnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.colormagnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.colormagnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.colormagnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.colormagnitude9;
                break;
            case 10:
                magnitudeColorResourceId = R.color.colormagnitude10;
                break;
                
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
}

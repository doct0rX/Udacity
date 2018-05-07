package com.example.doctorx.p5_tour_guide_app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by doctorX on 4/20/18.
 *
 */

public class CityAdapter extends BaseAdapter {
    private Context mContext;
    private final int[] cityName;
    private final int[] imageId;

    CityAdapter(Context c, int[] cityName, int[] imageId) {
        mContext = c;
        this.imageId = imageId;
        this.cityName = cityName;
    }

    @Override
    public int getCount() {
        return cityName.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO: Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @SuppressLint("InflateParams")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

	        if (convertView == null) {
                new View(mContext);
                assert inflater != null;
                grid = inflater.inflate(R.layout.grid_single, null);
	        	TextView textView = grid.findViewById(R.id.grid_text);
	        	ImageView imageView = grid.findViewById(R.id.grid_image);
	        	textView.setText(cityName[position]);
	        	imageView.setImageResource(imageId[position]);
	        } else {
	        	grid = convertView;
	        }

        return grid;
    }
}

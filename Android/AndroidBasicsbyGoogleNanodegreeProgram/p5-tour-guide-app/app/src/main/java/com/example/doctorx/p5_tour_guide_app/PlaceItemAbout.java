package com.example.doctorx.p5_tour_guide_app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.doctorx.p5_tour_guide_app.R;

public class PlaceItemAbout extends BaseAdapter {
    private Context mContext;
    private final int mImageId;
    private String mAboutItem;

    /**
     * My Own Custom Constructor for the City Object.
     * @param c context
     * @param imageId Image of the city
     * @param aboutItem Name of the city
     */
    PlaceItemAbout(Context c, int imageId, String aboutItem) {
        mContext = c;
        this.mImageId = imageId;
        this.mAboutItem = aboutItem;
    }

    @Override
    public int getCount() {
        return 1;
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
            grid = inflater.inflate(R.layout.place_about_item, null);
            TextView textView = grid.findViewById(R.id.txt_about_item);
            ImageView imageView = grid.findViewById(R.id.img_about_item);
            textView.setText(mAboutItem);
            imageView.setImageResource(mImageId);
        } else {
            grid = convertView;
        }

        return grid;
    }
}

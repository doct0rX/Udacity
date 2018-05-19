package com.example.doctorx.p5_tour_guide_app;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

class MainPager extends FragmentPagerAdapter{
    private Context mContext;
    /**
     * Create a new {@link MainPager} object.
     *
     * @param fm is the fragment manager that will keep each fragment's state in the adapter
     *           across swipes.
     */
    public MainPager(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.tourism);
        } else if (position == 1) {
            return mContext.getString(R.string.shop);
        } else if (position == 2) {
            return mContext.getString(R.string.restaurants);
        } else if (position == 3) {
            return mContext.getString(R.string.parks);
        } else {
            return mContext.getString(R.string.about);
        }
    }

    /**
     * Return the {@link Fragment} that should be displayed for the given page number.
     */
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new TourismFragment();
        } else if (position == 1) {
            return new ShopFragment();
        } else if (position == 2) {
            return new RestaurantFragment();
        } else if (position == 3) {
            return new ParkFragment();
        } else {
            return new AboutFragment();
        }
    }

    /**
     * Return the total number of pages.
     */
    @Override
    public int getCount() {
        return 5;
    }
}

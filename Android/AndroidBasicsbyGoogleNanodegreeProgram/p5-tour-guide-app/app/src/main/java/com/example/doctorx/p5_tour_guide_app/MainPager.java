package com.example.doctorx.p5_tour_guide_app;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

class MainPager extends FragmentPagerAdapter{
    /**
     * Create a new {@link MainPager} object.
     *
     * @param fm is the fragment manager that will keep each fragment's state in the adapter
     *           across swipes.
     */
    public MainPager(FragmentManager fm) {
        super(fm);
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
        } else {
            return new AboutFragment();
        }
    }

    /**
     * Return the total number of pages.
     */
    @Override
    public int getCount() {
        return 4;
    }
}

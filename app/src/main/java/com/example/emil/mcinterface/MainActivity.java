package com.example.emil.mcinterface;

import android.content.Context;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;



import android.widget.TextView;
import android.widget.Toast;

import com.physicaloid.lib.Physicaloid;
import com.physicaloid.lib.usb.driver.uart.ReadLisener;

import java.io.UnsupportedEncodingException;

public class MainActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private static final String TAG = MainActivity.class.getSimpleName();

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    Physicaloid mPhysicaloid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);


        mPhysicaloid = new Physicaloid(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            if(mPhysicaloid.open()) { // default 9600bps
                //setEnabledUi(true);


                //****************************************************************
                // TODO : add read callback
                mPhysicaloid.addReadListener(new ReadLisener() {
                    String readStr;

                    // callback when reading one or more size buffer
                    @Override
                    public void onRead(int size) {
                        byte[] buf = new byte[size];

                        mPhysicaloid.read(buf, size);
                        try {
                            readStr = new String(buf, "UTF-8");
                        } catch (UnsupportedEncodingException e) {
                            Log.e(TAG, e.toString());
                            return;
                        }
                        printToast(readStr);
                        // UI thread
                        // tvAppend(tvRead, readStr);
                        // draws gesture on screen



                        //  drawGesture(readStr);
                        //   drawGesture("0 1 2 3 0");
                    }
                });
            }
        }



        return super.onOptionsItemSelected(item);
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    Contacts tab1 = new Contacts();
                    return tab1;
                case 1:
                    Music tab2 = new Music();
                    return tab2;
                case 2:
                    Navigation tab3 = new Navigation();
                    return tab3;
                default:
                    return null;

            }

        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Contacts";
                case 1:
                    return "Music";
                case 2:
                    return "Navigation";
            }
            return null;
        }
    }

    Handler mHandler = new Handler();
    private void printToast(final String str) {

        mHandler.post(new Runnable() {
            @Override
            public void run() {
                Context context = getApplicationContext();


//                CharSequence text = str;
                final String s = str;
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, s, duration);
                toast.show();

            }
        });
    }

}

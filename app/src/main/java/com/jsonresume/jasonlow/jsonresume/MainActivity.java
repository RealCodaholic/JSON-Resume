package com.jsonresume.jasonlow.jsonresume;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.jsonresume.jasonlow.jsonresume.Pages.PAdapter;

public class MainActivity extends AppCompatActivity {
    private ViewPager pager;
    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tv_page = (TextView) findViewById(R.id.page_index);

        pager = (ViewPager) findViewById(R.id.pager);
        pagerAdapter = new PAdapter(getSupportFragmentManager());
        pager.setAdapter(pagerAdapter);
        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrollStateChanged(int state) {}
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

            public void onPageSelected(int position) {
                tv_page.setText("Page " + String.valueOf(position + 1) + " of 7");
            }
        });
    }
}

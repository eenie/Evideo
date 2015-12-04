package com.neusoft.eenie.evideo;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.neusoft.eenie.evideo.bmob.bean.SeryBean;
import com.neusoft.eenie.evideo.framents.IntroFragment;
import com.neusoft.eenie.evideo.framents.SeriesFragment;
import com.neusoft.eenie.evideo.framents.TalkFragment;

import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

public class VideoInfoActivity extends AppCompatActivity {

    TabLayout tabVideoInfo;
    List<Fragment> fragmentList;
    List<String> titles = new ArrayList<>();
    ViewPager rootPage;
    PageAdapter pageAdapter;
    SeryBean seryBean;

    ImageView imageThumbnail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_info);




        seryBean = (SeryBean) getIntent().getBundleExtra("bundleInfo").getSerializable("videoInfo");




        findView();

        initFragment();
        pageAdapter = new PageAdapter(getSupportFragmentManager());
        rootPage.setAdapter(pageAdapter);
        tabVideoInfo.setupWithViewPager(rootPage);

        x.image().bind(imageThumbnail, seryBean.getThumbnail().getFileUrl(VideoInfoActivity.this));

    }

    private void initFragment() {
        fragmentList = new ArrayList<>();
        IntroFragment introFragment = new IntroFragment();
        SeriesFragment seriesFragment = new SeriesFragment();
        fragmentList.add(introFragment);
        fragmentList.add(seriesFragment);
        titles.add("简介");
        titles.add("剧集");

        seriesFragment.setSeriesUrl(seryBean.getSeriesUrl());

        introFragment.setIntro(seryBean.getIntro());
    }

    private void findView() {
        tabVideoInfo = (TabLayout) findViewById(R.id.tabVideoInfo);
        rootPage = (ViewPager) findViewById(R.id.rootPage);
        imageThumbnail = (ImageView) findViewById(R.id.imageThumbnail);
    }


    private class PageAdapter extends FragmentPagerAdapter{
        public PageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);//页卡标题
        }

    }
}

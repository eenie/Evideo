package com.neusoft.eenie.evideo.framents;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.neusoft.eenie.evideo.BaseFragment;
import com.neusoft.eenie.evideo.R;
import com.neusoft.eenie.evideo.VideoPlayActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SeriesFragment extends BaseFragment {

    GridView seriesList;

    SeriesListAdapter seriesListAdapter;

    private List<String> seriesUrl = new ArrayList<>();

    public List<String> getSeriesUrl() {
        return seriesUrl;
    }

    public void setSeriesUrl(List<String> seriesUrl) {
        this.seriesUrl = seriesUrl;
    }

    public SeriesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_series, container, false);
        findView(rootView);
        seriesListAdapter = new SeriesListAdapter();

        seriesList.setAdapter(seriesListAdapter);
        seriesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent videoIntent = new Intent(getContext(), VideoPlayActivity.class);
                videoIntent.putExtra("videoPath", seriesUrl.get(position));
                startActivity(videoIntent);
            }
        });


        return rootView;
    }

    private void findView(View rootView) {

        seriesList = (GridView) rootView.findViewById(R.id.seriesList);

    }


    private class SeriesListAdapter extends BaseAdapter{


        @Override
        public int getCount() {
            return seriesUrl.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView textCount;
            if (convertView == null) {
                convertView = getLayoutInflater(Bundle.EMPTY).inflate(R.layout.item_series, null);
                textCount = (TextView) convertView.findViewById(R.id.textCount);
                convertView.setTag(textCount);

            } else {
                textCount = (TextView) convertView.getTag();
            }
            textCount.setText(String.valueOf(position + 1));
            return convertView;
        }
    }

}

package com.neusoft.eenie.evideo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.neusoft.eenie.evideo.bmob.bean.SeryBean;
import org.xutils.x;
import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.update.BmobUpdateAgent;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button btnPlay;
    RecyclerView indexList;
    IndexListAdapter indexListAdapter;
    List<SeryBean> seriesList;

    Toolbar rootToolbar;

    SwipeRefreshLayout swipeLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BmobUpdateAgent.setUpdateOnlyWifi(false);
        BmobUpdateAgent.update(this);
        findView();
        seriesList = new ArrayList<>();
        indexListAdapter = new IndexListAdapter();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        indexList.setLayoutManager(gridLayoutManager);
        indexList.setAdapter(indexListAdapter);
        btnPlay.setOnClickListener(this);

        rootToolbar.setTitle("首页");
        setSupportActionBar(rootToolbar);


        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getAllSeries();
            }
        });
        getAllSeries();

    }

    private void findView() {
        btnPlay = (Button) findViewById(R.id.btnPlay);
        indexList = (RecyclerView) findViewById(R.id.indexList);
        rootToolbar = (Toolbar) findViewById(R.id.rootToolbar);
        swipeLayout = (SwipeRefreshLayout) findViewById(R.id.swipeLayout);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnPlay:


                break;
        }

    }


    private class IndexListAdapter extends RecyclerView.Adapter {

        private class Holder extends RecyclerView.ViewHolder {

            ImageView indexPic;
            TextView textSeryTitle;
            TextView textSeryState;

            public Holder(View itemView) {
                super(itemView);
                indexPic = (ImageView) itemView.findViewById(R.id.indexPic);
                textSeryTitle = (TextView) itemView.findViewById(R.id.textSeryTitle);
                textSeryState = (TextView) itemView.findViewById(R.id.textSeryState);
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent video = (new Intent(MainActivity.this, VideoInfoActivity.class));


                        Bundle bundle = new Bundle();

                        bundle.putSerializable("videoInfo",seriesList.get(getPosition()));

                        video.putExtra("bundleInfo", bundle);
                        startActivity(video);

                    }
                });
            }
        }


        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View contentView = getLayoutInflater().inflate(R.layout.item_index, null);
            Holder holder = new Holder(contentView);
            return holder;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

            ((Holder) holder).textSeryTitle.setText(seriesList.get(position).getTitle());

            ((Holder) holder).textSeryState.setText(seriesList.get(position).getState());

            x.image().bind(((Holder) holder).indexPic, seriesList.get(position).getIndexPic().getFileUrl(MainActivity.this));

        }

        @Override
        public int getItemCount() {
            return seriesList.size();
        }

    }


    private void getAllSeries() {
        BmobQuery<SeryBean> query = new BmobQuery<>();


        query.findObjects(MainActivity.this, new FindListener<SeryBean>() {
            @Override
            public void onSuccess(List<SeryBean> list) {
                seriesList = list;
                indexListAdapter.notifyDataSetChanged();


                if (swipeLayout.isRefreshing()) {
                    swipeLayout.setRefreshing(false);

                }

            }

            @Override
            public void onError(int i, String s) {
                if (swipeLayout.isRefreshing()) {
                    swipeLayout.setRefreshing(false);

                }
            }
        });


    }


}

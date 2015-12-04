package com.neusoft.eenie.evideo.framents;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.neusoft.eenie.evideo.BaseFragment;
import com.neusoft.eenie.evideo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class IntroFragment extends BaseFragment {


    TextView textIntro;
    String intro;

    public IntroFragment() {
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View contentView=inflater.inflate(R.layout.fragment_intro, container, false);
        textIntro = (TextView) contentView.findViewById(R.id.textIntro);

        textIntro.setText(intro);

        return contentView;
    }


    public void setIntro(String intro) {
        this.intro = intro;
    }

}

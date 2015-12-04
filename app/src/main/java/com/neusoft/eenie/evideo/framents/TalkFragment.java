package com.neusoft.eenie.evideo.framents;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.neusoft.eenie.evideo.BaseFragment;
import com.neusoft.eenie.evideo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TalkFragment extends BaseFragment {


    public TalkFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_talk, container, false);
    }

}

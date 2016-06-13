package com.jsonresume.jasonlow.jsonresume.Pages;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jsonresume.jasonlow.jsonresume.JSONResume;
import com.jsonresume.jasonlow.jsonresume.R;

import org.json.JSONObject;

/**
 * Created by Jason Low on 6/12/2016.
 */
public class About extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.about, container, false);

        TextView tv_about = (TextView) view.findViewById(R.id.tv_about);

        JSONObject root = new JSONResume(this.getActivity(), null).getJSONObject();
        tv_about.setText(root.optString("About"));

        return view;
    }
}

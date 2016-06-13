package com.jsonresume.jasonlow.jsonresume.Pages;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jsonresume.jasonlow.jsonresume.JSONResume;
import com.jsonresume.jasonlow.jsonresume.R;

import org.json.JSONArray;
import org.json.JSONException;

/**
 * Created by Jason Low on 6/12/2016.
 */
public class Personality extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.personality, container, false);

        TextView tv_p = (TextView) view.findViewById(R.id.tv_personality);

        String data = "";
        try {
            JSONArray ts_list = new JSONResume(this.getActivity(), null).getJSONObject().getJSONArray("Personality");
            for (int i = 0; i < ts_list.length(); i++)
                data += String.valueOf(i + 1) + ". " + ts_list.getJSONObject(i).getString("title") + "\n\n";
        } catch (JSONException e) {
            data = "Failed to retrieve data.";
            e.printStackTrace();
        }

        tv_p.setText(data);
        return view;
    }
}

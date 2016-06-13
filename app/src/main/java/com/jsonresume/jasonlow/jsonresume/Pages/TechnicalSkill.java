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
public class TechnicalSkill extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.technical_skill, container, false);

        TextView tv_ts = (TextView) view.findViewById(R.id.tv_ts);

        String data = "";
        try {
            JSONArray ts_list = new JSONResume(this.getActivity(), null).getJSONObject().getJSONArray("Technical Skills");
            for (int i = 0; i < ts_list.length(); i++)
                data += "[" + ts_list.getJSONObject(i).getString("title") + "]\n" + ts_list.getJSONObject(i).getString("level") + "/10\n\n";
        } catch (JSONException e) {
            e.printStackTrace();
        }

        tv_ts.setText(data);
        return view;
    }
}

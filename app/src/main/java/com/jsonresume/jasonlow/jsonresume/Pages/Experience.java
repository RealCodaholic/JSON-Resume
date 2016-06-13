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
 * Created by Jason Low on 6/13/2016.
 */
public class Experience extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.experience, container, false);

        TextView tv1 = (TextView) view.findViewById(R.id.tv_1),
                tv2 = (TextView) view.findViewById(R.id.tv_2),
                tv3 = (TextView) view.findViewById(R.id.tv_3);

        String d1, d2, d3;
        d1 = d2 = d3 = "";
        try {
            JSONArray e_list = new JSONResume(this.getActivity(), null).getJSONObject().getJSONArray("Experience");
            for (int i = 0; i < e_list.length(); i++) {
                if (i == 0)
                    d1 += "[" + e_list.getJSONObject(i).getString("title") + "]\n" +
                        e_list.getJSONObject(i).getString("description") + "\n\nTechniques used: " +
                        e_list.getJSONObject(i).getString("technique") + "\n\n";
                else if (i == 1 || i == 2)
                    d2 += "[" +  e_list.getJSONObject(i).getString("title") + "]\n" +
                            e_list.getJSONObject(i).getString("description") + "\n\nTechniques used: " +
                            e_list.getJSONObject(i).getString("technique") + "\n\n";
                else
                    d3 += "[" +  e_list.getJSONObject(i).getString("title") + "]\n" +
                            e_list.getJSONObject(i).getString("description") + "\n\nTechniques used: " +
                            e_list.getJSONObject(i).getString("technique") + "\n\n";
            }
        } catch (JSONException e) {
            d1 = d2 = d3 = "Failed to retrieve data.";
            e.printStackTrace();
        }

        tv1.setText(d1);
        tv2.setText(d2);
        tv3.setText(d3);
        return view;
    }
}

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
public class EducationBackground extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.education_background, container, false);

        TextView tv_edu_bg = (TextView) view.findViewById(R.id.tv_edu_bg);

        String data = "";
        try {
            JSONArray e_list = new JSONResume(this.getActivity(), null).getJSONObject().getJSONArray("Education Background");
            for (int i = 0; i < e_list.length(); i++) {
                data += "[" + e_list.getJSONObject(i).getString("subject") + "]\n" +
                        e_list.getJSONObject(i).getString("description") + "\n\nAssessment (" +
                        e_list.getJSONObject(i).getString("assessment type") + "):\n" +
                        e_list.getJSONObject(i).getString("assessment") +
                        "\nOverall grade: " + e_list.getJSONObject(i).getString("grade") + "\n\n";
            }
        } catch (JSONException e) {
            data = "Failed to retrieve data.";
            e.printStackTrace();
        }

        tv_edu_bg.setText(data);
        return view;
    }
}

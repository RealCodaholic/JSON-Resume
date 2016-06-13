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
public class Profile extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.profile, container, false);

        TextView tv_profile = (TextView) rootView.findViewById(R.id.tv_profile);

        String data = "No data retrieved!";
        JSONObject profile = new JSONResume(this.getActivity(), "Profile").getJSONObject();
        data = "[Name]\n" + profile.optString("name") +
                "\n\n[Birthday]\n" + profile.optString("bday") +
                "\n\n[Age]\n" + profile.optString("age") +
                "\n\n[Nationality]\n" + profile.optString("nationality") +
                "\n\n[Gender]\n" + profile.optString("gender") +
                "\n\n[IC]\n" + profile.optString("nric") + "\n\n";

        tv_profile.setText(data);
        return rootView;
    }
}

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
 * Created by Jason Low on 6/13/2016.
 */
public class Contact extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.my_contact, container, false);

        TextView tv_contact = (TextView) view.findViewById(R.id.tv_contact);

        String data = "No data retrieved!";
        JSONObject my_cont = new JSONResume(this.getActivity(), "My Contact").getJSONObject();
        data = "[Name]\n" + my_cont.optString("name") +
                "\n\n[Address]\n" + my_cont.optString("address") +
                "\n\n[Contact number]\n" + my_cont.optString("contact") +
                "\n\n[Email]\n" + my_cont.optString("email");

        tv_contact.setText(data);
        return view;
    }
}

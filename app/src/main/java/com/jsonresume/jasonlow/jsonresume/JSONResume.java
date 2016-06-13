package com.jsonresume.jasonlow.jsonresume;

import android.app.Activity;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Jason Low on 6/12/2016.
 */
public class JSONResume {

    private final JSONObject obj;

    public JSONResume(Activity a, String obj) {
        String data = "";
        JSONObject o = null;
        try {
            InputStream is = a.getAssets().open("cv.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            data = new String(buffer, "UTF-8");
            if (obj != null)
                o = new JSONObject(data).optJSONObject(obj);
            else
                o = new JSONObject(data);

        } catch (IOException | JSONException ex) {
            Log.d("JSON", ex.getMessage());
        }

        this.obj = o;
    }

    public JSONObject getJSONObject() {
        return obj;
    }
}

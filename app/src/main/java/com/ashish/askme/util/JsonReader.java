package com.ashish.askme.util;

import com.ashish.askme.activity.BaseActivity;
import com.ashish.askme.global.ApplicationAskMe;
import com.ashish.askme.model.Template;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by akohlikashish on 20/04/16.
 */
public class JsonReader {

    public static String loadJSONFromAsset(String fileName) {
        String json = null;
        try {
            InputStream is = getActivity().getAssets().open(fileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            return null;
        } catch (NullPointerException ex) {
            return null;
        }
        return json;
    }

    private static BaseActivity getActivity() {
        return ApplicationAskMe.getmInstance().getmActivity();
    }

    public static List<Template> getTemplatesFromLocalJson(String fileName) {
        String json = loadJSONFromAsset(fileName);
        if (json == null) {
            return null;
        }
        Template[] templates = (Template[]) JsonParser.parseJson(json, Template[].class);
        List<Template> templateList = new ArrayList<Template>();
        for (int i = 0; i < templates.length; i++) {
            templateList.add(templates[i]);
        }
        return templateList;
    }

}

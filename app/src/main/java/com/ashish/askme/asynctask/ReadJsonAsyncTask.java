package com.ashish.askme.asynctask;

import android.os.AsyncTask;

import com.ashish.askme.model.Template;
import com.ashish.askme.util.JsonReader;

import java.util.List;

/**
 * Created by akohlikashish on 20/04/16.
 */
public class ReadJsonAsyncTask extends AsyncTask<Void, Void, List<Template>> {
    final AsyncCallback mCallback;
    String fileName;

    public ReadJsonAsyncTask(AsyncCallback mCallback, String fileName) {
        this.mCallback = mCallback;
        this.fileName = fileName;
    }

    protected List<Template> doInBackground(Void... params) {
        return JsonReader.getTemplatesFromLocalJson(fileName);
    }

    @Override
    protected void onPostExecute(List<Template> templates) {
        super.onPostExecute(templates);
        if (mCallback != null) {
            mCallback.onAsyncCompleted(templates);
        }
    }

    public interface AsyncCallback {
        void onAsyncCompleted(List<Template> result);
    }

}

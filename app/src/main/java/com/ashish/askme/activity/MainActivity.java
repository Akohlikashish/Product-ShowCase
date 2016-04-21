package com.ashish.askme.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ashish.askme.R;
import com.ashish.askme.adapter.ProductListRecyclerViewAdapter;
import com.ashish.askme.model.Templates;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by akohlikashish on 20/04/16.
 */
public class MainActivity extends BaseActivity {
    ProductListRecyclerViewAdapter mAdapter;
    RecyclerView mListView;
    Templates templates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_layout);
        Bundle bundle = getIntent().getExtras();
        templates = (Templates) bundle.getSerializable("data");
        if (templates == null || templates.templates == null) {
            showToast("Can't fetch template data, Restart!");
            return;
        }
        initView();
    }

    private void fetchProductData() {
        //no api integration has been done. this method will fetch data from assets .
//        showProgressDialog();
//        new ReadJsonAsyncTask(new ReadJsonAsyncTask.AsyncCallback() {
//            @Override
//            public void onAsyncCompleted(List<Template> result) {
//                if (isDead())
//                    return;
//
//                hideProgressDialog();
//                populateData(result);
//            }
//        }).execute();
    }

    private void initView() {
        mListView = (RecyclerView) findViewById(R.id.product_list);
        mAdapter = new ProductListRecyclerViewAdapter(templates.templates, getApplicationContext());
        LinearLayoutManager llm = new LinearLayoutManager(this);
        mListView.setLayoutManager(llm);
        mListView.setAdapter(mAdapter);
    }

}

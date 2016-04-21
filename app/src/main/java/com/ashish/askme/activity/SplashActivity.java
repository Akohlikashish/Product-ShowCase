package com.ashish.askme.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.ashish.askme.R;
import com.ashish.askme.asynctask.ReadJsonAsyncTask;
import com.ashish.askme.model.Template;
import com.ashish.askme.model.Templates;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by akohlikashish on 20/04/16.
 */
public class SplashActivity extends BaseActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_layout);
        editText = (EditText) findViewById(R.id.file_name);
        Button submit = (Button) findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(editText.getText().toString())) {
                    showToast("Please enter file name: eg: f_one.json");
                    return;
                }
                fetchProductData();
            }
        });
        ImageView imageView = (ImageView) findViewById(R.id.image);
        String url = "http://img01.ibnlive.in/ibnlive/uploads/875x584/jpg/2015/11/Google-doodle-group-1.jpg";
        Glide.with(SplashActivity.this).load(url).into(imageView);
    }

    private void fetchProductData() {
        showProgressDialog();
        //no api integration has been done. this method will fetch data from assets .
        showProgressDialog();
        new ReadJsonAsyncTask(new ReadJsonAsyncTask.AsyncCallback() {
            @Override
            public void onAsyncCompleted(List<Template> result) {
                if (isDead())
                    return;
                hideProgressDialog();
                passData(result);
            }
        }, editText.getText().toString()).execute();
    }

    private void passData(List<Template> templates) {
        Templates templates1 = new Templates();
        templates1.templates = templates;
        if (templates1 == null || templates1.templates == null) {
            showToast("Can't fetch template data, Restart!");
            return;
        }
        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("data", templates1);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}

package com.ashish.askme.activity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.ashish.askme.R;
import com.ashish.askme.global.ApplicationAskMe;


/**
 * Created by akohlikashish on 20/04/16.
 */
public class BaseActivity extends AppCompatActivity {
    ProgressDialog mActivityProgressDialog;

    @Override
    protected void onResume() {
        super.onResume();
        ApplicationAskMe.getmInstance().saveActivity(this);
    }


    public void showProgressDialog() {
        showProgressDialog(getString(R.string.progress_message));
    }

    public void showProgressDialog(String message) {
        if (isDead())
            return;
        if (mActivityProgressDialog == null) {
            mActivityProgressDialog = new ProgressDialog(this);
            mActivityProgressDialog.setIndeterminate(true);
            mActivityProgressDialog.setMessage(message);
            mActivityProgressDialog.setCanceledOnTouchOutside(false);
            mActivityProgressDialog.setCancelable(false);

        }

        if (!mActivityProgressDialog.isShowing()) {
            mActivityProgressDialog.show();
        }
    }

    public boolean isDead() {
        return !isAlive();
    }

    public boolean isAlive() {
        return this != null && !this.isFinishing();
    }

    public void hideProgressDialog() {
        if (mActivityProgressDialog != null && mActivityProgressDialog.isShowing()) {
            mActivityProgressDialog.dismiss();
        }
    }

    protected void showToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);

    }
}

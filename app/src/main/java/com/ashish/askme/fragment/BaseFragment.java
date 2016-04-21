package com.ashish.askme.fragment;

import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Toast;

/**
 * Created by akohlikashish on 20/04/16.
 */
public class BaseFragment extends Fragment {

    protected View findViewById(int id) {
        if (getView() == null) {
            throw new NullPointerException("no view attached to this fragment");
        }
        return getView().findViewById(id);
    }

    protected void gracefullyExit() {
        Toast.makeText(getContext(), "Error!, exiting retry", Toast.LENGTH_SHORT);
        getActivity().finish();
    }
}

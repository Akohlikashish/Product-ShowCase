package com.ashish.askme.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ashish.askme.R;
import com.ashish.askme.model.Item;
import com.bumptech.glide.Glide;

/**
 * Created by akohlikashish on 20/04/16.
 */
public class ViewPagerItemFragment extends BaseFragment {
    private Item item;

    public static ViewPagerItemFragment newInstance(Item item) {
        ViewPagerItemFragment fragment = new ViewPagerItemFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("item",item);
        fragment.setArguments(bundle);
        return fragment;
    }

    public ViewPagerItemFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.view_pager_item_layout_fragment, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = getArguments();
        item = (Item) bundle.getSerializable("item");
        if (item == null) {
            gracefullyExit();
            return;
        }

        ImageView imageView = (ImageView) findViewById(R.id.template2_image);
        TextView label = (TextView) findViewById(R.id.pager_item_label);
        ImageView callImage = (ImageView) findViewById(R.id.call);
        Glide.with(getContext()).load(item.image).into(imageView);

        label.setText(item.label);
        callImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(item.webUrl));
                startActivity(browserIntent);
            }
        });

    }
}

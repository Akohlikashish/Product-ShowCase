package com.ashish.askme.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ashish.askme.R;
import com.ashish.askme.global.ApplicationAskMe;
import com.ashish.askme.model.Template;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by akohlikashish on 20/04/16.
 */
public class ProductListRecyclerViewAdapter extends RecyclerView.Adapter<ProductListRecyclerViewAdapter.ViewHolder> {

    List<Template> mList;
    private Context mContext;

    public ProductListRecyclerViewAdapter(List<Template> list, Context context) {
        this.mList = list;
        this.mContext = context;
    }

    public ProductListRecyclerViewAdapter() {
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case Template.TEMPLATE_1:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_template1, parent, false);
                return new Template1RowViewHolder(view);

            case Template.TEMPLATE_2:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_template2, parent, false);
                return new Template2RowViewHolder(view);

            case Template.TEMPLATE_3:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_template3, parent, false);
                return new Template3RowViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        switch (mList.get(position).getTemplateType()) {

            case Template.TEMPLATE_1:
                Template1RowViewHolder h1 = (Template1RowViewHolder) holder;
                h1.labelTextView.setText(mList.get(position).items.get(0).label);
                h1.productLabelTextView.setText(mList.get(position).label);
                Glide.with(mContext).load(mList.get(position).items.get(0).image).into(h1.imageView);
                //// TODO: 20/04/16 left to right onlick. webview handling

                break;

            case Template.TEMPLATE_2:
                Template2RowViewHolder h2 = (Template2RowViewHolder) holder;
                h2.productLabelTextView.setText(mList.get(position).label);

                ViewPagerTemplate2Adapter adapter = new ViewPagerTemplate2Adapter(ApplicationAskMe.getmInstance().getmActivity().getSupportFragmentManager(), mList.get(position).items);
                h2.viewPager.setAdapter(adapter);
                break;

            case Template.TEMPLATE_3:
                Template3RowViewHolder h3 = (Template3RowViewHolder) holder;
                h3.productLabelTextView.setText(mList.get(position).label);
                ViewPagerTemplate3Adapter adapter1 = new ViewPagerTemplate3Adapter(ApplicationAskMe.getmInstance().getmActivity().getSupportFragmentManager(), mList.get(position).items);
                h3.viewPager.setAdapter(adapter1);
                h3.dotContainer.removeAllViews();
                int dotsCount = adapter1.getCount();
                ImageView[] dots = new ImageView[dotsCount];
                for (int i=0;i<dotsCount;i++){
                    dots[i] = new ImageView(mContext);
                    dots[i].setImageDrawable(mContext.getResources().getDrawable(R.drawable.non_selected_dot_drawable));

                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.WRAP_CONTENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT);

                    params.setMargins(4, 0, 4, 0);
                    h3.dotContainer.addView(dots[i], params);
                }

                dots[0].setImageDrawable(mContext.getResources().getDrawable(R.drawable.selected_dot_drawable));

                h3.viewPager.setOnPageChangeListener(new PageChangeListener(dots));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mList.get(position).getTemplateType();
    }

    public abstract class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }


    public class Template1RowViewHolder extends ViewHolder {
        ImageView imageView;
        TextView labelTextView;
        TextView productLabelTextView;

        public Template1RowViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.template1_image);
            labelTextView = (TextView) itemView.findViewById(R.id.template1_label);
            productLabelTextView = (TextView) itemView.findViewById(R.id.template1_product_label);
        }
    }


    public class Template2RowViewHolder extends ViewHolder {
        ViewPager viewPager;
        TextView productLabelTextView;
        ViewPagerTemplate2Adapter adapter;

        public Template2RowViewHolder(View itemView) {
            super(itemView);
            productLabelTextView = (TextView) itemView.findViewById(R.id.template2_product_label);
            viewPager = (ViewPager) itemView.findViewById(R.id.pager);
            viewPager.setPageMargin((int) convertDpToPixel(10f, mContext));
        }
    }

    public class Template3RowViewHolder extends ViewHolder {
        ViewPager viewPager;
        TextView productLabelTextView;
        LinearLayout dotContainer;

        public Template3RowViewHolder(View itemView) {
            super(itemView);
            viewPager = (ViewPager) itemView.findViewById(R.id.pager);
            viewPager.setPageMargin((int) convertDpToPixel(10f, mContext));
            productLabelTextView = (TextView) itemView.findViewById(R.id.template3_product_label);
            dotContainer = (LinearLayout)itemView.findViewById(R.id.dot_container);
        }
    }

    public float convertDpToPixel(float dp, Context context) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        return dp * (metrics.densityDpi / 160f);
    }

    public class PageChangeListener implements ViewPager.OnPageChangeListener{

        ImageView[] dots ;
        public PageChangeListener(ImageView[] dotGroup){
            this.dots = dotGroup;
        }
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {
            for (int i = 0; i < dots.length; i++) {
                dots[i].setImageDrawable(mContext.getResources().getDrawable(R.drawable.non_selected_dot_drawable));
            }
            dots[position].setImageDrawable(mContext.getResources().getDrawable(R.drawable.selected_dot_drawable));
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

}


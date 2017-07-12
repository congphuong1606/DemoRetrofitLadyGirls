package ominext.android.vn.ladygirls.Adapter;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import ominext.android.vn.ladygirls.Model.TopSchoolGirl;
import ominext.android.vn.ladygirls.R;


public class SlidingImage_Adapter extends PagerAdapter {


    private ArrayList<TopSchoolGirl> topSchoolGirls;
    private LayoutInflater inflater;
    private Context context;


    public SlidingImage_Adapter(Context context, ArrayList<TopSchoolGirl> topSchoolGirls) {
        this.context = context;
        this.topSchoolGirls = topSchoolGirls;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return topSchoolGirls.size();
    }

    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        Context context = view.getContext();
        View imageLayout = inflater.inflate(R.layout.sliding_image_layout, view, false);

        assert imageLayout != null;
        final ImageView imageView = (ImageView) imageLayout
                .findViewById(R.id.image);
        String a = topSchoolGirls.get(position).getHinhDaiDien();
        boolean isGif = a.charAt(a.length() - 1) == 'f' ? true : false;
        if (isGif) {
            Glide.with(context)
                    .load(topSchoolGirls.get(position).getHinhDaiDien())
                    .asGif()
                    .into(imageView);
        } else {
            Glide.with(context)
                    .load(topSchoolGirls.get(position).getHinhDaiDien())
                    .into(imageView);
        }

        view.addView(imageLayout, 0);

        return imageLayout;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }


}
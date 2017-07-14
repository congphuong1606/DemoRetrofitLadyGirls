package ominext.android.vn.ladygirls.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import ominext.android.vn.ladygirls.Activity.DetailActivity;
import ominext.android.vn.ladygirls.Model.SchoolGirl;
import ominext.android.vn.ladygirls.R;

/**
 * Created by MyPC on 10/07/2017.
 */

public class SchoolGirlAdapter extends RecyclerView.Adapter<SchoolGirlAdapter.ViewHolder> {
    ArrayList<SchoolGirl> schoolGirls;
    Context context;

    private SchoolGirl schoolGirl;


    public SchoolGirlAdapter(Context context, int layout, ArrayList<SchoolGirl> schoolGirls) {
        this.schoolGirls = schoolGirls;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_layout, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        schoolGirl = schoolGirls.get(position);

        holder.mHinhDaiDien = schoolGirl.getmHinhDaiDien();
        holder.mHoTen = schoolGirl.getmHoTen();
        holder.mQueQuan = schoolGirl.getmQueQuan();
        holder.mChieuCao = schoolGirl.getmChieuCao();
        holder.mCanNang = schoolGirl.getmCanNang();
        holder.mSoDoBaVong = schoolGirl.getmSoDoBaVong();
        holder.mSothich = schoolGirl.getmSothich();
        holder.mCauNoiYeuThich = schoolGirl.getmCauNoiYeuThich();
        holder.tvNgaysinh.setText(schoolGirl.getmNgaySinh());
        holder.tvHoten.setText(holder.mHoTen);
        Glide.with(context).load(holder.mHinhDaiDien)
                .error(R.mipmap.ic_launcher)
                .crossFade(2000)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(holder.imvHinhDaiDien);
    }

    @Override
    public int getItemCount() {
        return schoolGirls.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        String mHinhDaiDien;
        String mHoTen;
        String mQueQuan;
        String mChieuCao;
        String mCanNang;
        String mSoDoBaVong;
        String mSothich;
        String mCauNoiYeuThich;
        @BindView(R.id.imv_hinh_dai_dien)
        ImageView imvHinhDaiDien;
        @BindView(R.id.tv_hoten)
        TextView tvHoten;
        @BindView(R.id.tv_ngaysinh)
        TextView tvNgaysinh;

        public ViewHolder(final View itemView) {
            super(itemView);
            TextView tvNgaysinh;
            ButterKnife.bind(this,itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(), DetailActivity.class);
                    intent.putExtra("hinhdaidien", mHinhDaiDien);
                    intent.putExtra("hoten", mHoTen);
                    intent.putExtra("quequan", mQueQuan);
                    intent.putExtra("chieucao", mChieuCao);
                    intent.putExtra("cannang", mCanNang);
                    intent.putExtra("sodobavong", mSoDoBaVong);
                    intent.putExtra("sothich", mSothich);
                    intent.putExtra("caunoiyeuthich", mCauNoiYeuThich);
                    view.getContext().startActivity(intent);
                }
            });

        }
    }
}

package ominext.android.vn.ladygirls.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import butterknife.BindView;
import butterknife.ButterKnife;
import ominext.android.vn.ladygirls.R;

public class DetailActivity extends AppCompatActivity {

    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.tv_ho_ten)
    TextView tvHoTen;
    @BindView(R.id.tv_que_quan)
    TextView tvQueQuan;
    @BindView(R.id.tv_chieu_cao)
    TextView tvChieuCao;
    @BindView(R.id.tv_can_nang)
    TextView tvCanNang;
    @BindView(R.id.tv_so_do_ba_vong)
    TextView tvSoDoBaVong;
    @BindView(R.id.tv_so_thich)
    TextView tvSoThich;
    @BindView(R.id.tv_cau_noi_yeu_thich)
    TextView tvCauNoiYeuThich;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        Glide.with(this).load(getIntent().getStringExtra("hinhdaidien"))
                .error(R.mipmap.ic_launcher)
                .crossFade(3000)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(imageView);
        tvCanNang.setText("Cân nặng:" + getIntent().getStringExtra("cannang"));
        tvHoTen.setText(getIntent().getStringExtra("hoten"));
        tvCauNoiYeuThich.setText("Câu nói yêu thích:" + getIntent().getStringExtra("caunoiyeuthich"));
        tvChieuCao.setText("chiều cao:" + getIntent().getStringExtra("chieucao"));
        tvQueQuan.setText(getIntent().getStringExtra("quequan"));
        tvSoThich.setText("Sở thích:" + getIntent().getStringExtra("sothich"));
        tvSoDoBaVong.setText("Số đo ba vòng:" + getIntent().getStringExtra("sodobavong"));

    }
}

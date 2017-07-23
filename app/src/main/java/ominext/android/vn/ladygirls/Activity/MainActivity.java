package ominext.android.vn.ladygirls.Activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.disposables.CompositeDisposable;
import me.relex.circleindicator.CircleIndicator;
import ominext.android.vn.ladygirls.APIService;
import ominext.android.vn.ladygirls.Adapter.SchoolGirlAdapter;
import ominext.android.vn.ladygirls.Adapter.SlidingImage_Adapter;
import ominext.android.vn.ladygirls.Model.SchoolGirl;
import ominext.android.vn.ladygirls.Model.TopSchoolGirl;
import ominext.android.vn.ladygirls.Presenter.MainPresenter;
import ominext.android.vn.ladygirls.R;
import ominext.android.vn.ladygirls.View.MainView;

public class MainActivity extends AppCompatActivity implements MainView {


    @Override
    public void fail() {
        Log.d("onFailure", "Error");
    }

    @BindView(R.id.recycleview)
    RecyclerView recycleview;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.indicator)
    CircleIndicator indicator;
    private RecyclerView.LayoutManager layoutManager;
    private SchoolGirlAdapter nusinhAdpater;
    private APIService mAPIService;
    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        layoutManager = new GridLayoutManager(this, 1);
        recycleview.setLayoutManager(layoutManager);
        recycleview.setHasFixedSize(true);
        presenter = new MainPresenter(this);
        presenter.getDataNuSinh();
        presenter.getDataTopSchoolGirl();

//        mAPIService = ApiUtils.getIapiService();
//        mAPIService.getListNuSinh().enqueue(new Callback<ArrayList<SchoolGirl>>() {
//            @Override
//            public void onResponse(Call<ArrayList<SchoolGirl>> call, Response<ArrayList<SchoolGirl>> response) {
//                try {
//                    final ArrayList<SchoolGirl> nuSinhs = response.body();
//                    nusinhAdpater = new SchoolGirlAdapter(MainActivity.this, R.layout.row_item_layout, nuSinhs);
//                    recycleview.setAdapter(nusinhAdpater);
//                } catch (Exception e) {
//                    Log.d("onResponse", "Error");
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ArrayList<SchoolGirl>> call, Throwable t) {
//                Log.d("onFailure", t.toString());
//            }
//        });
    }
    @Override
    public void getListNuSinhSuccess(ArrayList<SchoolGirl> list) {
        nusinhAdpater = new SchoolGirlAdapter(MainActivity.this, R.layout.row_item_layout, list);
        recycleview.setAdapter(nusinhAdpater);

    }

    @Override
    public void getListTopSchoolGirlSuccess(ArrayList<TopSchoolGirl> list) {
        viewPager.setAdapter(new SlidingImage_Adapter(MainActivity.this, list));
        indicator.setViewPager(viewPager);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();

    }
}

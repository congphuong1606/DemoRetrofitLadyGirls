package ominext.android.vn.ladygirls;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import ominext.android.vn.ladygirls.Adapter.NuSinhAdapter;
import ominext.android.vn.ladygirls.Model.NuSinh;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recycleview)
    RecyclerView recycleview;

    private RecyclerView.LayoutManager layoutManager;
    private NuSinhAdapter nusinhAdpater;
    private IAPIService mIAPIService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        layoutManager = new GridLayoutManager(this, 1);
        recycleview.setLayoutManager(layoutManager);
        recycleview.setHasFixedSize(true);
        mIAPIService = ApiUtils.getIapiService();
        mIAPIService.getListNuSinh().enqueue(new Callback<ArrayList<NuSinh>>() {
            @Override
            public void onResponse(Call<ArrayList<NuSinh>> call, Response<ArrayList<NuSinh>> response) {
                try {
                    final ArrayList<NuSinh> nuSinhs = response.body();
                    nusinhAdpater = new NuSinhAdapter(MainActivity.this, R.layout.row_item_layout, nuSinhs);
                    recycleview.setAdapter(nusinhAdpater);
                } catch (Exception e) {
                    Log.d("onResponse", "Error");
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<NuSinh>> call, Throwable t) {
                Log.d("onFailure", t.toString());
            }
        });
    }


}

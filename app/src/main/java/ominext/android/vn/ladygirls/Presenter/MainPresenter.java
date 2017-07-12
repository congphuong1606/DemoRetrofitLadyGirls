package ominext.android.vn.ladygirls.Presenter;

import java.util.ArrayList;

import ominext.android.vn.ladygirls.APIService;
import ominext.android.vn.ladygirls.ApiUtils;
import ominext.android.vn.ladygirls.Model.SchoolGirl;
import ominext.android.vn.ladygirls.Model.TopSchoolGirl;
import ominext.android.vn.ladygirls.View.MainView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by MyPC on 11/07/2017.
 */

public class MainPresenter {
    private APIService mAPIService = ApiUtils.getIapiService();
    private MainView view;

    public MainPresenter(MainView view) {
        this.view = view;
    }

    public void getDataNuSinh() {
        mAPIService.getListNuSinh().enqueue(new Callback<ArrayList<SchoolGirl>>() {
            @Override
            public void onResponse(Call<ArrayList<SchoolGirl>> call, Response<ArrayList<SchoolGirl>> response) {
                view.getListNuSinhSuccess(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<SchoolGirl>> call, Throwable t) {
                view.fail();
            }
        });
    }

    public void getDataTopSchoolGirl() {
        mAPIService.getListTopSchoolGirl().enqueue(new Callback<ArrayList<TopSchoolGirl>>() {
            @Override
            public void onResponse(Call<ArrayList<TopSchoolGirl>> call, Response<ArrayList<TopSchoolGirl>> response) {
                view.getListTopSchoolGirlSuccess(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<TopSchoolGirl>> call, Throwable t) {
                view.fail();
            }
        });
    }
}

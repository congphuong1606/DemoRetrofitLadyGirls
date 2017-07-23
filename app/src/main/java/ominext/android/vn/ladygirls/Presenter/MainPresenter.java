package ominext.android.vn.ladygirls.Presenter;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import ominext.android.vn.ladygirls.APIService;
import ominext.android.vn.ladygirls.ApiUtils;
import ominext.android.vn.ladygirls.Model.SchoolGirl;
import ominext.android.vn.ladygirls.Model.TopSchoolGirl;
import ominext.android.vn.ladygirls.View.MainView;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by MyPC on 11/07/2017.
 */

public class MainPresenter {
    public static final String BASE_URL = "http://www.mocky.io";
    private APIService mAPIService = ApiUtils.getIapiService();
    CompositeDisposable compositeDisposable;
    private MainView view;


    public MainPresenter(MainView view) {
        this.view = view;
        compositeDisposable = new CompositeDisposable();
    }

    public void getDataNuSinh() {

        APIService apiService = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(APIService.class);
        compositeDisposable.add(apiService.register()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse, this::handleError));


    }

    private void handleResponse(List<SchoolGirl> schoolGirls) {
        view.getListNuSinhSuccess((ArrayList<SchoolGirl>) schoolGirls);

    }
//        mAPIService.getListNuSinh().enqueue(new Callback<ArrayList<SchoolGirl>>() {
//            @Override
//            public void onResponse(Call<ArrayList<SchoolGirl>> call, Response<ArrayList<SchoolGirl>> response) {
//                view.getListNuSinhSuccess(response.body());
//            }
//
//            @Override
//            public void onFailure(Call<ArrayList<SchoolGirl>> call, Throwable t) {
//                view.fail();
//            }
//        });


    private void handleError(Throwable throwable) {
        view.fail();
    }

    public void getDataTopSchoolGirl() {
        APIService apiService = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build().create(APIService.class);
        compositeDisposable.add(apiService.registertop()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::getTopSuccess, this::getTopError));
//        mAPIService.getListTopSchoolGirl().enqueue(new Callback<ArrayList<TopSchoolGirl>>() {
//            @Override
//            public void onResponse(Call<ArrayList<TopSchoolGirl>> call, Response<ArrayList<TopSchoolGirl>> response) {
//                view.getListTopSchoolGirlSuccess(response.body());
//            }
//
//            @Override
//            public void onFailure(Call<ArrayList<TopSchoolGirl>> call, Throwable t) {
//                view.fail();
//            }
//        });
    }

    private void getTopSuccess(List<TopSchoolGirl> topSchoolGirls) {
        view.getListTopSchoolGirlSuccess((ArrayList<TopSchoolGirl>) topSchoolGirls);
    }

    private void getTopError(Throwable throwable) {
        view.fail();
    }


    public void onDestroy() {
        compositeDisposable.clear();
    }
}

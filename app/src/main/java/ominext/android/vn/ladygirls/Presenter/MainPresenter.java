package ominext.android.vn.ladygirls.Presenter;

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

        compositeDisposable.add(mAPIService.register()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::getDataNusinhSuccess, this::getDataNusinhError));

    }

    private void getDataNusinhSuccess(List<SchoolGirl> schoolGirls) {
        view.getListNuSinhSuccess((ArrayList<SchoolGirl>) schoolGirls);
    }

    private void getDataNusinhError(Throwable throwable) {
        view.fail();
    }

    private void handleResponse(List<SchoolGirl> schoolGirls) {
        view.getListNuSinhSuccess((ArrayList<SchoolGirl>) schoolGirls);

    }



    private void handleError(Throwable throwable) {
        view.fail();
    }

    public void getDataTopSchoolGirl() {
        compositeDisposable.add(mAPIService.registertop()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::getTopSuccess, this::getTopError));

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

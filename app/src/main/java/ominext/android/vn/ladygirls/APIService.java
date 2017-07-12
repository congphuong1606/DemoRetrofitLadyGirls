package ominext.android.vn.ladygirls;

import java.util.ArrayList;

import ominext.android.vn.ladygirls.Model.SchoolGirl;
import ominext.android.vn.ladygirls.Model.TopSchoolGirl;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by MyPC on 10/07/2017.
 */

public interface APIService {
    @GET("/v2/596594ca110000ca00c8f202")
    Call<ArrayList<TopSchoolGirl>> getListTopSchoolGirl();

    @GET("/v2/59642aac26000069083d72e3")
    Call<ArrayList<SchoolGirl>> getListNuSinh();

}

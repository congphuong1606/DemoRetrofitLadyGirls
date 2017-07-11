package ominext.android.vn.ladygirls;

import java.util.ArrayList;

import ominext.android.vn.ladygirls.Model.NuSinh;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by MyPC on 10/07/2017.
 */

public interface IAPIService {
    @GET("/v2/59642aac26000069083d72e3")
    Call<ArrayList<NuSinh>> getListNuSinh();

}

package ominext.android.vn.ladygirls;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by MyPC on 10/07/2017.
 */

public class RetrofitClient {
    private static Retrofit  retrofit=null;
    public static Retrofit getClient(String baseUrl){
        if(retrofit==null){
            retrofit=new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}

package ominext.android.vn.ladygirls;

/**
 * Created by MyPC on 10/07/2017.
 */

public class ApiUtils {
    public static final String BASE_URL = "http://www.mocky.io";

    private ApiUtils() {

    }

    public static APIService getIapiService() {
        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}

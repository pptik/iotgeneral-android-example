package id.pptik.sampleiotgeneral.Networks;

import id.pptik.sampleiotgeneral.Models.General;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface RestServiceInterface {

    @Headers("Content-Type: application/json")
    @GET("show/{device_code}")
    Call<General> getGeneral(@Path("device_code") String deviceCode);
}
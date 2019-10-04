package com.kubatov.androidthree.data.network;

import com.kubatov.androidthree.data.model.current_weather.CurrentWeatrerModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface RetrofitService {
    @GET("weather")
    Call<CurrentWeatrerModel> getWeatherByCity(@Query("q") String city, @Query("APPID") String appid);
}

package com.example.introscreen.data.network;

import com.example.introscreen.data.model.current_weather.CurrentWeatrerModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitService {
    @GET("weather")
    Call<CurrentWeatrerModel> getWeatherByCity(@Query("q") String city, @Query("APPID") String appid);
}

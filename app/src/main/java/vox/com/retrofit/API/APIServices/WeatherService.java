package vox.com.retrofit.API.APIServices;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import vox.com.retrofit.Models.City;

/**
 * Created by DanielMartin on 28/01/2018.
 */

public interface WeatherService {

        @GET("weather")
        Call<City> getCity(@Query("q") String city, @Query("appid") String key);

        @GET("weather")
        Call<City> getCityCelsius(@Query("q") String city, @Query("appid") String key);


        @GET("forecast")
        Call<City> getCityCelsiusEs(@Query("q") String city, @Query("appid") String key, @Query("units") String value);


        @GET("forecast")
        Call<City> getCityCelsiusEs(@Query("q") String city, @Query("appid") String key);

}

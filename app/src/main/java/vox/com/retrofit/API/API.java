package vox.com.retrofit.API;

import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import vox.com.retrofit.API.Deserializers.MyDeserializer;
import vox.com.retrofit.Models.City;

/**
 * Created by DanielMartin on 28/01/2018.
 */

public class API {

    public static final String BASE_URL = "http://api.openweathermap.org/data/2.5/";
    public static final String APPKEY = "83045b6997624637de9222c821cb4202";
    public static final String UNITS = "metric";
    public static final String LENGUAGE = "es";

    private static Retrofit retrofit = null;

    public static Retrofit getApi(){
        if(retrofit == null){
                GsonBuilder builder = new GsonBuilder();
                builder.registerTypeAdapter(City.class,new MyDeserializer());

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(builder.create()))
                    .build();
        }
        return retrofit;
    }

    /*
    public static Retrofit getApi(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
*/
}

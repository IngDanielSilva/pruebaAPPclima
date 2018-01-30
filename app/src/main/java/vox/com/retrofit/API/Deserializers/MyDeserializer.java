package vox.com.retrofit.API.Deserializers;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

import vox.com.retrofit.Models.City;

/**
 * Created by DanielMartin on 28/01/2018.
 */

public class MyDeserializer implements JsonDeserializer<City> {

    @Override
    public City deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        String[] temp = new String[5];
        String[] description = new String[5];
        String[] icon = new String[5];
        String[] tempMax = new String[5];
        String[] tempMin = new String[5];


        int id = json.getAsJsonObject().get("city").getAsJsonObject().get("id").getAsInt();
        String name = json.getAsJsonObject().get("city").getAsJsonObject().get("name").getAsString();
        String county = json.getAsJsonObject().get("city").getAsJsonObject().get("country").getAsString();

        icon[0] = json.getAsJsonObject().get("list").getAsJsonArray().get(6).getAsJsonObject().get("weather").getAsJsonArray().get(0).getAsJsonObject().get("icon").getAsString();
        icon[1] = json.getAsJsonObject().get("list").getAsJsonArray().get(10).getAsJsonObject().get("weather").getAsJsonArray().get(0).getAsJsonObject().get("icon").getAsString();
        icon[2] = json.getAsJsonObject().get("list").getAsJsonArray().get(18).getAsJsonObject().get("weather").getAsJsonArray().get(0).getAsJsonObject().get("icon").getAsString();
        icon[3] = json.getAsJsonObject().get("list").getAsJsonArray().get(26).getAsJsonObject().get("weather").getAsJsonArray().get(0).getAsJsonObject().get("icon").getAsString();
        icon[4] = json.getAsJsonObject().get("list").getAsJsonArray().get(34).getAsJsonObject().get("weather").getAsJsonArray().get(0).getAsJsonObject().get("icon").getAsString();

        temp[0] = json.getAsJsonObject().get("list").getAsJsonArray().get(6).getAsJsonObject().get("main").getAsJsonObject().get("temp").getAsString();
        temp[1] = json.getAsJsonObject().get("list").getAsJsonArray().get(10).getAsJsonObject().get("main").getAsJsonObject().get("temp").getAsString();
        temp[2] = json.getAsJsonObject().get("list").getAsJsonArray().get(18).getAsJsonObject().get("main").getAsJsonObject().get("temp").getAsString();
        temp[3] = json.getAsJsonObject().get("list").getAsJsonArray().get(26).getAsJsonObject().get("main").getAsJsonObject().get("temp").getAsString();
        temp[4] = json.getAsJsonObject().get("list").getAsJsonArray().get(34).getAsJsonObject().get("main").getAsJsonObject().get("temp").getAsString();

        tempMax[0] = json.getAsJsonObject().get("list").getAsJsonArray().get(4).getAsJsonObject().get("main").getAsJsonObject().get("temp_max").getAsString();
        tempMax[1] = json.getAsJsonObject().get("list").getAsJsonArray().get(11).getAsJsonObject().get("main").getAsJsonObject().get("temp_max").getAsString();
        tempMax[2] = json.getAsJsonObject().get("list").getAsJsonArray().get(19).getAsJsonObject().get("main").getAsJsonObject().get("temp_max").getAsString();
        tempMax[3] = json.getAsJsonObject().get("list").getAsJsonArray().get(26).getAsJsonObject().get("main").getAsJsonObject().get("temp_max").getAsString();
        tempMax[4] = json.getAsJsonObject().get("list").getAsJsonArray().get(34).getAsJsonObject().get("main").getAsJsonObject().get("temp_max").getAsString();

        tempMin[0] = json.getAsJsonObject().get("list").getAsJsonArray().get(0).getAsJsonObject().get("main").getAsJsonObject().get("temp_min").getAsString();
        tempMin[1] = json.getAsJsonObject().get("list").getAsJsonArray().get(7).getAsJsonObject().get("main").getAsJsonObject().get("temp_min").getAsString();
        tempMin[2] = json.getAsJsonObject().get("list").getAsJsonArray().get(15).getAsJsonObject().get("main").getAsJsonObject().get("temp_min").getAsString();
        tempMin[3] = json.getAsJsonObject().get("list").getAsJsonArray().get(23).getAsJsonObject().get("main").getAsJsonObject().get("temp_min").getAsString();
        tempMin[4] = json.getAsJsonObject().get("list").getAsJsonArray().get(31).getAsJsonObject().get("main").getAsJsonObject().get("temp_min").getAsString();



        description[0] = json.getAsJsonObject().get("list").getAsJsonArray().get(6).getAsJsonObject().get("weather").getAsJsonArray().get(0).getAsJsonObject().get("description").getAsString();;
        description[1] = json.getAsJsonObject().get("list").getAsJsonArray().get(10).getAsJsonObject().get("weather").getAsJsonArray().get(0).getAsJsonObject().get("description").getAsString();;
        description[2] = json.getAsJsonObject().get("list").getAsJsonArray().get(18).getAsJsonObject().get("weather").getAsJsonArray().get(0).getAsJsonObject().get("description").getAsString();;
        description[3] = json.getAsJsonObject().get("list").getAsJsonArray().get(26).getAsJsonObject().get("weather").getAsJsonArray().get(0).getAsJsonObject().get("description").getAsString();;
        description[4] = json.getAsJsonObject().get("list").getAsJsonArray().get(34).getAsJsonObject().get("weather").getAsJsonArray().get(0).getAsJsonObject().get("description").getAsString();;




        City city = new City(id, name, county, icon, temp,tempMax,tempMin, description);

        return city;
    }
}

package vox.com.retrofit.Activities;

/**
 * Created by DanielMartin on 29/01/2018.
 */

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vox.com.retrofit.API.API;
import vox.com.retrofit.API.APIServices.WeatherService;
import vox.com.retrofit.Models.City;
import vox.com.retrofit.R;

public class ClimaCiudades extends AppCompatActivity {

    private ImageView clima, clima1, clima2, clima3, clima4;
    private TextView estado, estado1, estado2, estado3, estado4;
    private TextView location;
    private TextView temperature;
    private TextView tempMax, tempMax1, tempMax2, tempMax3, tempMax4;
    private TextView tempMin, tempMin1, tempMin2, tempMin3, tempMin4;
    private int[] imagenes;
    private Button btn;
    private WeatherService service;
    private Call<City> cityCall;
    public List<String> names;
    private City city;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mexicali);

        String ciudad = getIntent().getStringExtra("country");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher_round);

        btn = (Button) findViewById(R.id.btn);
        imagenes = getPartyPics();
        estado = (TextView) findViewById(R.id.estado);
        clima = (ImageView) findViewById(R.id.TiempoImagen);
        temperature = (TextView) findViewById(R.id.temperature);
        location = (TextView) findViewById(R.id.locationTextView); //Locacion Londres
        tempMax = (TextView) findViewById(R.id.tempMax);
        tempMin = (TextView) findViewById(R.id.tempMin);

        clima1 = (ImageView) findViewById(R.id.TiempoImagen1);
        clima2 = (ImageView) findViewById(R.id.TiempoImagen2);
        clima3 = (ImageView) findViewById(R.id.TiempoImagen3);
        clima4 = (ImageView) findViewById(R.id.TiempoImagen4); //icon

        tempMax1 = (TextView) findViewById(R.id.tempMax1);
        tempMin1 = (TextView) findViewById(R.id.tempMin1);
        tempMax2 = (TextView) findViewById(R.id.tempMax2);
        tempMin2 = (TextView) findViewById(R.id.tempMin2);
        tempMax3 = (TextView) findViewById(R.id.tempMax3); //Temperatura Maxima y minima
        tempMin3 = (TextView) findViewById(R.id.tempMin3);
        tempMax4 = (TextView) findViewById(R.id.tempMax4);
        tempMin4 = (TextView) findViewById(R.id.tempMin4);

        // condicion climatica
        estado1 = (TextView) findViewById(R.id.descripcion1);
        estado2 = (TextView) findViewById(R.id.descripcion2);
        estado3 = (TextView) findViewById(R.id.descripcion3);
        estado4 = (TextView) findViewById(R.id.descripcion4);

        service = API.getApi().create(WeatherService.class);
        cityCall = service.getCityCelsiusEs(ciudad, API.APPKEY, API.UNITS);
        cityCall.enqueue(new Callback<City>() {

            @Override
            public void onResponse(Call<City> call, Response<City> response) {
                city = response.body();
                Toast.makeText(ClimaCiudades.this, "City", Toast.LENGTH_LONG).show();
                // clima.setImageResource(imagenes[0]);

                clima.setImageResource(dibujoIcono(city.getIcon()[0]));
                temperature.setText(city.getTemp()[0].toString() + " C ");
                estado.setText(city.getDescription()[0].toString());//Condicion
                location.setText(city.getName().toString());
                tempMax.setText(city.getTempMax()[0] + "C");
                tempMin.setText(city.getTempMin()[0] + "C");

                clima1.setImageResource(dibujoIcono(city.getIcon()[1]));
                estado1.setText(city.getDescription()[1].toString());//Condicion
                tempMax1.setText(city.getTempMax()[1] + "C");
                tempMin1.setText(city.getTempMin()[1] + "C");

                clima2.setImageResource(dibujoIcono(city.getIcon()[2]));
                estado2.setText(city.getDescription()[2].toString());//Condicion
                tempMax2.setText(city.getTempMax()[2] + "C");
                tempMin2.setText(city.getTempMin()[2] + "C");

                clima3.setImageResource(dibujoIcono(city.getIcon()[3]));
                estado3.setText(city.getDescription()[3].toString());//Condicion
                tempMax3.setText(city.getTempMax()[3] + "C");
                tempMin3.setText(city.getTempMin()[3] + "C");

                clima4.setImageResource(dibujoIcono(city.getIcon()[4]));
                estado4.setText(city.getDescription()[4].toString());//Condicion
                tempMax4.setText(city.getTempMax()[4] + "C");
                tempMin4.setText(city.getTempMin()[4] + "C");


            }

            @Override
            public void onFailure(Call<City> call, Throwable t) {
                Toast.makeText(ClimaCiudades.this, "Error", Toast.LENGTH_LONG).show();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ClimaCiudades.this, ListaActivity.class);
                startActivity(intent);
            }
        });
    }

    private int dibujoIcono(String icon) {
        switch (icon) {
            case "01d":
                return imagenes[0];
            case "01n":
                return imagenes[0];
            case "02d":
                return imagenes[1];
            case "02n":
                return imagenes[1];
            case "03d":
                return imagenes[2];
            case "03n":
                return imagenes[2];
            case "04d":
                return imagenes[3];
            case "04n":
                return imagenes[3];
            case "09d":
                return imagenes[4];
            case "09n":
                return imagenes[4];
            case "10d":
                return imagenes[5];
            case "10n":
                return imagenes[5];
            case "11d":
                return imagenes[6];
            case "11n":
                return imagenes[6];
            case "13d":
                return imagenes[7];
            case "13n":
                return imagenes[7];

        }
        return imagenes[8];
    }

    public int[] getPartyPics() {
        int[] value = {R.drawable.d01d, R.drawable.d02d, R.drawable.d03d, R.drawable.d04d, R.drawable.d09d, R.drawable.d10d, R.drawable.d11d, R.drawable.d13d, R.drawable.nada};
        return value;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            Toast.makeText(ClimaCiudades.this, "onActivityResult", Toast.LENGTH_SHORT).show();

        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }

}

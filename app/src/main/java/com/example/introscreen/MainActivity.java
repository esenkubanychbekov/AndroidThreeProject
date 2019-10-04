package com.example.introscreen;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.introscreen.data.model.OnBoardModel;
import com.example.introscreen.data.model.current_weather.CurrentWeatrerModel;
import com.example.introscreen.data.network.RetrofitBuilder;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;

import javax.sql.CommonDataSource;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Button show;
    private EditText name;
    private TextView cityName, temperature, description;
    private String cityID;
    ImageView imageView;

    public static void start(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getCurrentWeather();
    }

    private void getCurrentWeather() {
        show = findViewById(R.id.show);
        cityName = findViewById(R.id.cityName);
        temperature = findViewById(R.id.temperature);
        imageView = findViewById(R.id.imageView);
        description = findViewById(R.id.description);


        cityID= "Lindon";

       show.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               RetrofitBuilder.getService().getWeatherByCity(cityID, getResources().getString(R.string.api_key))
                       .enqueue(new Callback<CurrentWeatrerModel>() {
                           @Override
                           public void onResponse(@Nullable Call<CurrentWeatrerModel> call, @Nullable Response<CurrentWeatrerModel> response) {
                               if (response != null && response.isSuccessful() && response.body() != null) {

                                   Toast.makeText(getApplicationContext(), response.body().getName(), Toast.LENGTH_LONG).show();
                                   Log.e("getCurrentWeather", response.body().getName());
                                   cityName.setText("Weather in "+cityID);
                                   DecimalFormat decimalFormat = new DecimalFormat("#.#");
                                   response.body().getMain().getTempMax();
                                   String tempFormat = decimalFormat.format(response.body().getMain().getTempMax());
                                   temperature.setText(tempFormat + "°C");
                                   description.setText(response.body().getWeather().get(0).getDescription());
                                   OnBoardModel onBoardModel = new OnBoardModel();
                                   Picasso.with(MainActivity.this).load(onBoardModel.getImage(response.body().getWeather().get(0).getIcon())).into(imageView);
                                   //Glide.with(MainActivity.this).load("http://goo.gl/gEgYUd").into(imageView);

                               }
                           }

                           @Override
                           public void onFailure(@Nullable Call<CurrentWeatrerModel> call, @Nullable Throwable t) {
                               if (t != null)
                                   Log.e("getCurrentWeather", t.getLocalizedMessage());
                           }
                       });
           }
       });


    }
}

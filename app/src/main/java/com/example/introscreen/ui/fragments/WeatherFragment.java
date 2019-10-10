package com.example.introscreen.ui.fragments;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.introscreen.R;
import com.example.introscreen.data.model.OnBoardModel;
import com.example.introscreen.data.model.current_weather.CurrentWeatrerModel;
import com.example.introscreen.data.network.RetrofitBuilder;
import com.example.introscreen.ui.main.MainActivity;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class WeatherFragment extends Fragment {

    private Button show;
    private EditText name;
    private TextView cityName, temperature, description;
    private String cityID;
    ImageView imageView;


    public WeatherFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

             View view =   inflater.inflate(R.layout.fragment_weather, container, false);
        show = view.findViewById(R.id.show);
        cityName = view.findViewById(R.id.cityName);
        temperature = view.findViewById(R.id.temperature);
        imageView = view.findViewById(R.id.imageView);
        description =  view.findViewById(R.id.description);
        getCurrentWeather();
        return view;

        }

    private void getCurrentWeather() {
        cityID = "London";

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RetrofitBuilder.getService().getWeatherByCity(cityID, getResources().getString(R.string.api_key))
                        .enqueue(new Callback<CurrentWeatrerModel>() {
                            @Override
                            public void onResponse(@Nullable Call<CurrentWeatrerModel> call, @Nullable Response<CurrentWeatrerModel> response) {
                                if (response != null && response.isSuccessful() && response.body() != null) {

                                    Toast.makeText(getContext(), response.body().getName(), Toast.LENGTH_LONG).show();
                                    Log.e("getCurrentWeather", response.body().getName());
                                    cityName.setText("Weather in " + cityID);
                                    temperature.setText(response.body().getMain().getTempMax().intValue()+ "°C");
                                    description.setText(response.body().getWeather().get(0).getDescription());
                                    OnBoardModel onBoardModel = new OnBoardModel();
                                    Picasso.with(getContext()).load(onBoardModel.getImage(response.body().getWeather().get(0).getIcon())).into(imageView);

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

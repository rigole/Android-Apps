package com.example.weather_app;

import android.os.Build;
import android.os.Bundle;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.example.weather_app.model.Forecast;

import java.io.Serializable;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ForecastFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ForecastFragment extends Fragment {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ForecastFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ForecastFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ForecastFragment newInstance(String param1, String param2) {
        ForecastFragment fragment = new ForecastFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View forecastView = inflater.inflate(R.layout.fragment_forecast, container, false);
        ImageView forecastIcon = forecastView.findViewById(R.id.forecastingId);
        TextView forecastTemp = forecastView.findViewById(R.id.forecastTemp);
        TextView forecastDate = forecastView.findViewById(R.id.forecastingDateText);
        TextView forecastHigh = forecastView.findViewById(R.id.forecastHighText);
        TextView forecastLow = forecastView.findViewById(R.id.forecastLowText);
        TextView forecastDescripton = forecastView.findViewById(R.id.forecastDescriptionTextview);

        Forecast forecast = (Forecast) getArguments().getBinder("forecast");
        forecastTemp.setText(forecast.getCurrentTemperature());
        forecastDate.setText(forecast.getForecastDate());
        forecastHigh.setText(forecast.getForecastHighTemp());
        forecastLow.setText(forecast.getForecastLowTemp());
        forecastDescripton.setText(forecast.getGetForecastWeatherDescription());


        return forecastView;
    }
    public static final ForecastFragment newInstance (Forecast forecast){
        ForecastFragment forecastFragment = new ForecastFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("forecast", (Serializable) forecast);
        forecastFragment.setArguments(bundle);
        return forecastFragment;
    }
}
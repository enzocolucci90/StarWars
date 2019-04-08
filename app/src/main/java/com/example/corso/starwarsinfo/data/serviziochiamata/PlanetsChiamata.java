package com.example.corso.starwarsinfo.data.serviziochiamata;

import android.util.Log;

import com.example.corso.starwarsinfo.data.People;
import com.example.corso.starwarsinfo.data.Person;
import com.example.corso.starwarsinfo.data.Planet;
import com.example.corso.starwarsinfo.data.Planets;
import com.example.corso.starwarsinfo.presenters.PeoplePresenter;
import com.example.corso.starwarsinfo.presenters.PlanetsPresenter;
import com.example.corso.starwarsinfo.retrofit.UtilManager;
import com.example.corso.starwarsinfo.retrofit.UtilManagerInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlanetsChiamata {

    private UtilManagerInterface utilManagerInterface;
    public UtilManagerInterface getUtilManagerInterface(){
        if (utilManagerInterface == null){
            utilManagerInterface = UtilManager.getClient().create(UtilManagerInterface.class);
        }

            return utilManagerInterface;
    }



    //Metodo che restituirà la lista completa dei personaggi

    public void getAllPlanets(final PlanetsPresenter presenter){
    Call<Planets> call = getUtilManagerInterface().getPlanetsAllList();
    call.enqueue(new Callback<Planets>() {
        @Override
        public void onResponse(Call<Planets> call, Response<Planets> response) {

            Log.d("error","chiamata effettuata");
            Planets planets;
            planets = response.body();
            List<Planet> listaPlanet= new ArrayList<>();
            listaPlanet = planets.getResults();  //Sarebbe il getPlanets();
            presenter.listaPlanets(listaPlanet);
        }

        @Override
        public void onFailure(Call<Planets> call, Throwable t) {
            Log.d("error","error chiamata");
        }

    });
    }

}

package com.example.corso.starwarsinfo.data.serviziochiamata;

import android.util.Log;

import com.example.corso.starwarsinfo.data.People;
import com.example.corso.starwarsinfo.data.Person;
import com.example.corso.starwarsinfo.data.Starship;
import com.example.corso.starwarsinfo.data.StarshipLigth;
import com.example.corso.starwarsinfo.data.Starships;
import com.example.corso.starwarsinfo.presenters.PeoplePresenter;
import com.example.corso.starwarsinfo.presenters.StarshipDetailPresenter;
import com.example.corso.starwarsinfo.presenters.StarshipsPresenter;
import com.example.corso.starwarsinfo.retrofit.UtilManager;
import com.example.corso.starwarsinfo.retrofit.UtilManagerInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StarshipsChiamata {

    private UtilManagerInterface utilManagerInterface;
    public UtilManagerInterface getUtilManagerInterface(){
        if (utilManagerInterface == null){
            utilManagerInterface = UtilManager.getClient().create(UtilManagerInterface.class);
        }

            return utilManagerInterface;
    }



    //Metodo che restituirà la lista completa dei personaggi

    public void getAllStarships(final StarshipsPresenter presenter){
    Call<Starships> call = getUtilManagerInterface().getStarshipsAllList();
    call.enqueue(new Callback<Starships>() {
        @Override
        public void onResponse(Call<Starships> call, Response<Starships> response) {

            Starships starships;
            starships = response.body();
            List<Starship> listaStarship= new ArrayList<>();
            listaStarship = starships.getResults();
            presenter.listaPersonaggi(listaStarship);
        }

        @Override
        public void onFailure(Call<Starships> call, Throwable t) {
            Log.d("error","error");
        }

    });
    }

    public void getStarship(final StarshipDetailPresenter presenter, String url){
        Call<Starship> call = getUtilManagerInterface().getStarship(url);
        call.enqueue(new Callback<Starship>() {
            @Override
            public void onResponse(Call<Starship> call, Response<Starship> response) {

                String starshipName = response.body().getName();
                String starshipModel = response.body().getModel();
                String starshipManufacturer = response.body().getManufacturer();
                String starshipCostInCredits = response.body().getCostInCredits();
                String starshipLength = response.body().getLength();
                StarshipLigth starshipLigth = new StarshipLigth(starshipName,starshipModel,starshipManufacturer,starshipCostInCredits,starshipLength);
                presenter.starship(starshipLigth);
            }

            @Override
            public void onFailure(Call<Starship> call, Throwable t) {
                Log.d("error","error");
            }

        });
    }

}

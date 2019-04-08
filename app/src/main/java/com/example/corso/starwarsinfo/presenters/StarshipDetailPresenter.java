package com.example.corso.starwarsinfo.presenters;

import com.example.corso.starwarsinfo.contracts.PlanetDetailContract;
import com.example.corso.starwarsinfo.contracts.StarshipDetailContract;
import com.example.corso.starwarsinfo.data.Planet;
import com.example.corso.starwarsinfo.data.Starship;
import com.example.corso.starwarsinfo.data.StarshipLigth;
import com.example.corso.starwarsinfo.data.serviziochiamata.StarshipsChiamata;

import java.util.List;

public class StarshipDetailPresenter implements StarshipDetailContract.Presenter{

    StarshipDetailContract.View pdFragment;
    StarshipsChiamata sc = new StarshipsChiamata();

    public StarshipDetailPresenter(StarshipDetailContract.View view) {
        pdFragment = view;
        view.setPresenter(this);
    }

    @Override
    public void getStarship(String url) {
        sc.getStarship(this, url);


    }

    public void starship(StarshipLigth starshipLigth){

        pdFragment.presenterToFragment(starshipLigth);

    }

    @Override
    public void start() {

    }
}

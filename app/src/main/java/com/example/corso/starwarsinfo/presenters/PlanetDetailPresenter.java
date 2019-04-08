package com.example.corso.starwarsinfo.presenters;

import com.example.corso.starwarsinfo.contracts.PersonDetailContract;
import com.example.corso.starwarsinfo.contracts.PlanetDetailContract;
import com.example.corso.starwarsinfo.data.Person;
import com.example.corso.starwarsinfo.data.Planet;

public class PlanetDetailPresenter implements PlanetDetailContract.Presenter{

    PlanetDetailContract.View pdFragment;

    public PlanetDetailPresenter(PlanetDetailContract.View view) {
        pdFragment = view;
        view.setPresenter(this);
    }

    @Override
    public void getPlanet(Planet Planet) {

    }

    @Override
    public void start() {

    }
}

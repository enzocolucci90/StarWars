package com.example.corso.starwarsinfo.presenters;

import com.example.corso.starwarsinfo.contracts.PeopleContract;
import com.example.corso.starwarsinfo.contracts.PlanetsContract;
import com.example.corso.starwarsinfo.data.Planet;
import com.example.corso.starwarsinfo.data.serviziochiamata.PlanetsChiamata;
import com.example.corso.starwarsinfo.data.Person;

import java.util.List;

public class PlanetsPresenter implements PlanetsContract.Presenter{

    PlanetsContract.View pFragment;
    PlanetsChiamata sc = new PlanetsChiamata();

    public PlanetsPresenter(PlanetsContract.View view) {
        pFragment = view;
        view.setPresenter(this);
    }

    @Override
    public void getAllPlanets() {
        sc.getAllPlanets(this);
    }

    @Override
    public void start() {

    }

    public void listaPlanets(List<Planet> listaPlanet){

        pFragment.presenterToFragment(listaPlanet);

    }





}

package com.example.corso.starwarsinfo.presenters;

import com.example.corso.starwarsinfo.contracts.PeopleContract;
import com.example.corso.starwarsinfo.contracts.StarshipsContract;
import com.example.corso.starwarsinfo.data.Person;
import com.example.corso.starwarsinfo.data.Starship;
import com.example.corso.starwarsinfo.data.serviziochiamata.PeopleChiamata;
import com.example.corso.starwarsinfo.data.serviziochiamata.StarshipsChiamata;

import java.util.List;

public class StarshipsPresenter implements StarshipsContract.Presenter{

    StarshipsContract.View pFragment;
    StarshipsChiamata sc = new StarshipsChiamata();

    public StarshipsPresenter(StarshipsContract.View view) {
        pFragment = view;
        view.setPresenter(this);
    }

    @Override
    public void getAllStarships() {
        sc.getAllStarships(this);
    }

    @Override
    public void start() {

    }

    public void listaPersonaggi(List<Starship> listaStarship){

        pFragment.presenterToFragment(listaStarship);

    }





}

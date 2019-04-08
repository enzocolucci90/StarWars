package com.example.corso.starwarsinfo.presenters;

import com.example.corso.starwarsinfo.contracts.PeopleContract;
import com.example.corso.starwarsinfo.data.serviziochiamata.PeopleChiamata;
import com.example.corso.starwarsinfo.data.Person;

import java.util.List;

public class PeoplePresenter implements PeopleContract.Presenter{

    PeopleContract.View pFragment;
    PeopleChiamata sc = new PeopleChiamata();

    public PeoplePresenter(PeopleContract.View view) {
        pFragment = view;
        view.setPresenter(this);
    }

    @Override
    public void getAllPeople() {
        sc.getAllPeople(this);
    }

    @Override
    public void start() {

    }

    public void listaPersonaggi(List<Person> listaPerson){

        pFragment.presenterToFragment(listaPerson);

    }





}

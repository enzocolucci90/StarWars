package com.example.corso.starwarsinfo.presenters;

import com.example.corso.starwarsinfo.contracts.PersonDetailContract;
import com.example.corso.starwarsinfo.data.Person;

public class PersonDetailPresenter implements PersonDetailContract.Presenter{

    PersonDetailContract.View pdFragment;

    public PersonDetailPresenter(PersonDetailContract.View view) {
        pdFragment = view;
        view.setPresenter(this);
    }

    @Override
    public void getPerson(Person person) {

    }

    @Override
    public void start() {

    }
}

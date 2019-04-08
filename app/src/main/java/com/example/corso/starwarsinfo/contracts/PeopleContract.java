package com.example.corso.starwarsinfo.contracts;

import com.example.corso.starwarsinfo.BasePresenter;
import com.example.corso.starwarsinfo.BaseView;
import com.example.corso.starwarsinfo.data.Person;

import java.util.List;

public interface PeopleContract {

    //Metodi implementati dalla View per comunicare con il Presenter
    interface View extends BaseView<Presenter> {

        void presenterToFragment(List<Person> people);

    }

    //Metodi implementati dal Presenter per comunicare con la View
    interface Presenter extends BasePresenter {

        void getAllPeople ();

    }

}

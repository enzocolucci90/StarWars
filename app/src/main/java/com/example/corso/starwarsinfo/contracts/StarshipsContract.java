package com.example.corso.starwarsinfo.contracts;

import com.example.corso.starwarsinfo.BasePresenter;
import com.example.corso.starwarsinfo.BaseView;
import com.example.corso.starwarsinfo.data.Person;
import com.example.corso.starwarsinfo.data.Starship;

import java.util.List;

public interface StarshipsContract {

    //Metodi implementati dalla View per comunicare con il Presenter
    interface View extends BaseView<Presenter> {

        void presenterToFragment(List<Starship> starships);

    }

    //Metodi implementati dal Presenter per comunicare con la View
    interface Presenter extends BasePresenter {

        void getAllStarships();

    }

}

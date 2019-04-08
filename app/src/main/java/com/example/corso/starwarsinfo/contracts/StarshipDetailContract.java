package com.example.corso.starwarsinfo.contracts;

import com.example.corso.starwarsinfo.BasePresenter;
import com.example.corso.starwarsinfo.BaseView;
import com.example.corso.starwarsinfo.data.Person;
import com.example.corso.starwarsinfo.data.Starship;
import com.example.corso.starwarsinfo.data.StarshipLigth;

import java.util.List;

public interface StarshipDetailContract {

    //Metodi implementati dalla View per comunicare con il Presenter
    interface View extends BaseView<Presenter> {

        void presenterToFragment(StarshipLigth starshipLigth);

    }

    //Metodi implementati dal Presenter per comunicare con la View
    interface Presenter extends BasePresenter {

        void getStarship(String url);

    }

}

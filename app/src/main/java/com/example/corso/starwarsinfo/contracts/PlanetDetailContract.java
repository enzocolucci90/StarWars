package com.example.corso.starwarsinfo.contracts;

import com.example.corso.starwarsinfo.BasePresenter;
import com.example.corso.starwarsinfo.BaseView;
import com.example.corso.starwarsinfo.data.Person;
import com.example.corso.starwarsinfo.data.Planet;

public interface PlanetDetailContract {

    //Metodi implementati dalla View per comunicare con il Presenter
    interface View extends BaseView<Presenter> {



    }

    //Metodi implementati dal Presenter per comunicare con la View
    interface Presenter extends BasePresenter {

        void getPlanet(Planet planet);

    }

}

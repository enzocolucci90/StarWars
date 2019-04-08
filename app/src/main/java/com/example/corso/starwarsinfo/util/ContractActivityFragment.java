package com.example.corso.starwarsinfo.util;

import com.example.corso.starwarsinfo.data.Person;
import com.example.corso.starwarsinfo.data.Planet;
import com.example.corso.starwarsinfo.data.Starship;

public interface ContractActivityFragment{

    interface View{

        public void onPersonSelected(int position, Person person);

        public void onPlanetSelected(int position, Planet planet);

        public void onStarshipSelected(int position, Starship Starship);

        public void onPeopleClicked();
        public void onPlanetsClicked();
        public void onStarshipsClicked();

    }

    interface Presenter {

    }



}

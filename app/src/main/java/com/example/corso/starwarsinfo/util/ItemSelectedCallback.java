package com.example.corso.starwarsinfo.util;

import com.example.corso.starwarsinfo.data.Person;
import com.example.corso.starwarsinfo.data.Planet;
import com.example.corso.starwarsinfo.data.Starship;

public interface ItemSelectedCallback {

    public void onPersonClicked(int position, Person person);

    public void onPlanetClicked(int position, Planet planet);

    public void onStarshipClicked(int position, Starship starship);




}

package com.example.corso.starwarsinfo;

import android.content.res.Configuration;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.corso.starwarsinfo.contracts.StarshipDetailContract;
import com.example.corso.starwarsinfo.data.Person;
import com.example.corso.starwarsinfo.data.Planet;
import com.example.corso.starwarsinfo.data.Starship;
import com.example.corso.starwarsinfo.fragment.ActivityFragment;
import com.example.corso.starwarsinfo.fragment.PeopleFragment;
import com.example.corso.starwarsinfo.fragment.PersonDetailFragment;
import com.example.corso.starwarsinfo.fragment.PlanetDetailFragment;
import com.example.corso.starwarsinfo.fragment.PlanetsFragment;
import com.example.corso.starwarsinfo.fragment.StarshipDetailFragment;
import com.example.corso.starwarsinfo.fragment.StarshipsFragment;
import com.example.corso.starwarsinfo.presenters.PeoplePresenter;
import com.example.corso.starwarsinfo.presenters.PlanetsPresenter;
import com.example.corso.starwarsinfo.presenters.StarshipDetailPresenter;
import com.example.corso.starwarsinfo.presenters.StarshipsPresenter;
import com.example.corso.starwarsinfo.util.ContractActivityFragment;

public class MainActivity extends AppCompatActivity implements ContractActivityFragment.View{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityFragment f = new ActivityFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, f).commit();
    }

    @Override
    public void onPeopleClicked() {

        PeopleFragment f = new PeopleFragment();
        new PeoplePresenter(f);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, f).addToBackStack(null).commit();
    }

    @Override
    public void onPlanetsClicked() {

        PlanetsFragment f = new PlanetsFragment();
        new PlanetsPresenter(f);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, f).addToBackStack(null).commit();

    }

    @Override
    public void onStarshipsClicked() {

        StarshipsFragment f = new StarshipsFragment();
        new StarshipsPresenter(f);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, f).addToBackStack(null).commit();

    }

    @Override
    public void onPersonSelected(int position, Person person) {

        PersonDetailFragment newFragment = PersonDetailFragment.newInstance(person);
            /*Bundle args = new Bundle();
            args.putInt(PersonDetailFragment.ARG_POSITION, position);
            newFragment.setArguments(args);*/

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            transaction.replace(R.id.container, newFragment).addToBackStack(null);
            // Commit the transaction
            transaction.commit();

    }

    @Override
    public void onPlanetSelected(int position, Planet planet) {

        PlanetDetailFragment newFragment = PlanetDetailFragment.newInstance(planet);
            /*Bundle args = new Bundle();
            args.putInt(PersonDetailFragment.ARG_POSITION, position);
            newFragment.setArguments(args);*/

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack so the user can navigate back
        transaction.replace(R.id.container, newFragment).addToBackStack(null);
        // Commit the transaction
        transaction.commit();

    }

    @Override
    public void onStarshipSelected(int position, Starship starship) {
        StarshipDetailFragment newFragment = StarshipDetailFragment.newInstance(starship);
        new StarshipDetailPresenter(newFragment);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack so the user can navigate back
        transaction.replace(R.id.container, newFragment).addToBackStack(null);
        // Commit the transaction
        transaction.commit();

    }


}

package com.example.corso.starwarsinfo.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.corso.starwarsinfo.R;
import com.example.corso.starwarsinfo.contracts.PersonDetailContract;
import com.example.corso.starwarsinfo.contracts.PlanetDetailContract;
import com.example.corso.starwarsinfo.data.Person;
import com.example.corso.starwarsinfo.data.Planet;
import com.example.corso.starwarsinfo.util.ContractActivityFragment;

public class PlanetDetailFragment extends Fragment implements PlanetDetailContract.View, ContractActivityFragment.Presenter{

    final static String ITEM_KEY = "planet";
    Planet planet;
    PlanetDetailContract.Presenter planetDetailPresenter;
    TextView nameText;
    TextView detailText;

    public PlanetDetailFragment() {    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        //peopleDetailPresenter.getPerson();

        View rootView = inflater.inflate(R.layout.fragment_item_detail, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        detailText = (TextView) view.findViewById(R.id.detail_item_detail_fragment);
        nameText = (TextView) view.findViewById(R.id.title_item_detail_fragment);
        nameText.setText(planet.getName());
        StringBuilder ris = new StringBuilder();
        ris.append("Rotation:                  "+planet.getRotationPeriod()).append("\n").append("\n")
           .append("Orbital:                    "+planet.getOrbitalPeriod()).append("\n").append("\n")
           .append("Diameter:             "+planet.getDiameter()).append("\n").append("\n")
           .append("Climate:             "+planet.getClimate());
        detailText.setText(ris);
    }

    @Override
    public void setPresenter(PlanetDetailContract.Presenter presenter) {
        planetDetailPresenter = presenter;
    }

    public static PlanetDetailFragment newInstance (Planet planet){

        PlanetDetailFragment newFragment = new PlanetDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable(ITEM_KEY, planet);
        newFragment.setArguments(args);
        return newFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments()!= null){
            planet = getArguments().getParcelable(ITEM_KEY);
        }

    }
}

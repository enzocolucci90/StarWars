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
import com.example.corso.starwarsinfo.contracts.PlanetDetailContract;
import com.example.corso.starwarsinfo.contracts.StarshipDetailContract;
import com.example.corso.starwarsinfo.data.Planet;
import com.example.corso.starwarsinfo.data.Starship;
import com.example.corso.starwarsinfo.data.StarshipLigth;
import com.example.corso.starwarsinfo.util.ContractActivityFragment;

public class StarshipDetailFragment extends Fragment implements StarshipDetailContract.View, ContractActivityFragment.Presenter{

    final static String ITEM_KEY = "url";
    String url;
    StarshipDetailContract.Presenter starshipDetailPresenter;
    TextView nameText;
    TextView detailText;
    StarshipLigth starshipLigth;

    public StarshipDetailFragment() {    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {


        View rootView = inflater.inflate(R.layout.fragment_item_detail, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        detailText = (TextView) view.findViewById(R.id.detail_item_detail_fragment);
        nameText = (TextView) view.findViewById(R.id.title_item_detail_fragment);
        starshipDetailPresenter.getStarship(url);

    }

    public static StarshipDetailFragment newInstance (Starship starship){

        StarshipDetailFragment newFragment = new StarshipDetailFragment();
        Bundle args = new Bundle();
        args.putString(ITEM_KEY, starship.getUrl());
        newFragment.setArguments(args);
        return newFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments()!= null){
            url = getArguments().getString(ITEM_KEY);
        }

    }

    @Override
    public void setPresenter(StarshipDetailContract.Presenter presenter) {
        starshipDetailPresenter = presenter;
    }

    @Override
    public void presenterToFragment(StarshipLigth starshipLigth) {
        this.starshipLigth = starshipLigth;

        nameText.setText(starshipLigth.getStarshipName());
        StringBuilder ris = new StringBuilder();
        ris.append("Model:                  "+starshipLigth.getStarshipModel()).append("\n").append("\n")
                .append("Manufacturer:                    "+starshipLigth.getStarshipManufacturer()).append("\n").append("\n")
                .append("Cost In:             "+starshipLigth.getStarshipCostInCredits()).append("\n").append("\n")
                .append("Length:             "+starshipLigth.getStarshipLength());
        detailText.setText(ris);
    }
}

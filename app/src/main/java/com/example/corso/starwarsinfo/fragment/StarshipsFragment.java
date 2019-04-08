package com.example.corso.starwarsinfo.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.corso.starwarsinfo.R;
import com.example.corso.starwarsinfo.contracts.PeopleContract;
import com.example.corso.starwarsinfo.contracts.StarshipsContract;
import com.example.corso.starwarsinfo.data.Person;
import com.example.corso.starwarsinfo.data.Planet;
import com.example.corso.starwarsinfo.data.Starship;
import com.example.corso.starwarsinfo.presenters.StarshipsPresenter;
import com.example.corso.starwarsinfo.util.ContractActivityFragment;
import com.example.corso.starwarsinfo.util.GenericAdapter;
import com.example.corso.starwarsinfo.util.ItemSelectedCallback;

import java.util.List;

public class StarshipsFragment extends Fragment implements StarshipsContract.View,ItemSelectedCallback {


    private RecyclerView myRecyclerView;
    private RecyclerView.Adapter myAdapter;
    private RecyclerView.LayoutManager myLayoutManager;
    StarshipsContract.Presenter starshipsPresenter;
    ContractActivityFragment.View mCallback;
    ListView starshipsList;

    public StarshipsFragment() {    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new StarshipsPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {

        View rootView = inflater.inflate(R.layout.fragment_item, container, false);
        return rootView;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        myRecyclerView = (RecyclerView) view.findViewById(R.id.item_list);
        myRecyclerView.setHasFixedSize(true);
        myLayoutManager = new LinearLayoutManager(getActivity());
        myRecyclerView.setLayoutManager(myLayoutManager);
        starshipsPresenter.getAllStarships();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mCallback = (ContractActivityFragment.View) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString());
        }
    }

    @Override
    public void setPresenter(StarshipsContract.Presenter presenter) {

        starshipsPresenter = presenter;

    }

    @Override
    public void presenterToFragment(List<Starship> listaStarship) {

        GenericAdapter adapter=new GenericAdapter(getActivity(), listaStarship, this);
        myRecyclerView.setAdapter(adapter);
    }


    @Override
    public void onStarshipClicked(int position, Starship starship) {
        mCallback.onStarshipSelected(position,starship);
    }

    @Override
    public void onPersonClicked(int position, Person person) {

    }

    @Override
    public void onPlanetClicked(int position, Planet planet) {

    }


}

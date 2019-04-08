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
import com.example.corso.starwarsinfo.data.Person;
import com.example.corso.starwarsinfo.util.ContractActivityFragment;

public class PersonDetailFragment extends Fragment implements PersonDetailContract.View, ContractActivityFragment.Presenter{

    final static String PERSON_KEY = "person";
    Person person;
    PersonDetailContract.Presenter peopleDetailPresenter;
    TextView nameText;
    TextView detailText;

    public PersonDetailFragment() {    }

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
        nameText.setText(person.getName());
        StringBuilder ris = new StringBuilder();
        ris.append("Height:                  "+person.getHeight()).append("\n").append("\n")
           .append("Mass:                    "+person.getMass()).append("\n").append("\n")
           .append("Hair Color:             "+person.getHairColor()).append("\n").append("\n")
           .append("Skin Color:             "+person.getSkinColor());
        detailText.setText(ris);
    }

    @Override
    public void setPresenter(PersonDetailContract.Presenter presenter) {
        peopleDetailPresenter = presenter;
    }

    public static PersonDetailFragment newInstance (Person person){

        PersonDetailFragment newFragment = new PersonDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable(PERSON_KEY, person);
        newFragment.setArguments(args);
        return newFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments()!= null){
            person = getArguments().getParcelable(PERSON_KEY);
        }

    }

}

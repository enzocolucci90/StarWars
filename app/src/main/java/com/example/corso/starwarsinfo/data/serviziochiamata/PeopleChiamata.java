package com.example.corso.starwarsinfo.data.serviziochiamata;

import android.util.Log;

import com.example.corso.starwarsinfo.data.People;
import com.example.corso.starwarsinfo.data.Person;
import com.example.corso.starwarsinfo.presenters.PeoplePresenter;
import com.example.corso.starwarsinfo.retrofit.UtilManager;
import com.example.corso.starwarsinfo.retrofit.UtilManagerInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PeopleChiamata {

    private UtilManagerInterface utilManagerInterface;
    public UtilManagerInterface getUtilManagerInterface(){
        if (utilManagerInterface == null){
            utilManagerInterface = UtilManager.getClient().create(UtilManagerInterface.class);
        }

            return utilManagerInterface;
    }



    //Metodo che restituirà la lista completa dei personaggi

    public void getAllPeople(final PeoplePresenter presenter){
    Call<People> call = getUtilManagerInterface().getPeopleAllList();
    call.enqueue(new Callback<People>() {
        @Override
        public void onResponse(Call<People> call, Response<People> response) {

            People people;
            people = response.body();
            List<Person> listaPerson= new ArrayList<>();
            listaPerson = people.getPerson();
            presenter.listaPersonaggi(listaPerson);
        }

        @Override
        public void onFailure(Call<People> call, Throwable t) {
            Log.d("error","error");
        }

    });
    }

}

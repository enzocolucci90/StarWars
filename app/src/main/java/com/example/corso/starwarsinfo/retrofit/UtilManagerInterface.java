package com.example.corso.starwarsinfo.retrofit;

import com.example.corso.starwarsinfo.data.People;
import com.example.corso.starwarsinfo.data.Person;
import com.example.corso.starwarsinfo.data.Planets;
import com.example.corso.starwarsinfo.data.Starship;
import com.example.corso.starwarsinfo.data.Starships;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface UtilManagerInterface {

    @GET("people/")
    public Call<People> getPeopleAllList();

    @GET("planets/")
    public Call<Planets> getPlanetsAllList();

    @GET("starships/")
    public Call<Starships> getStarshipsAllList();

    @GET()
    public Call<Starship> getStarship(@Url String url);

}

package com.pradum.dogsbreeds.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DogApi {

    public static String BASE_URL = "https://dog.ceo/";

    public static ApiService api_services;
    public  static  ApiService getApi_services(){

        if(api_services==null){

            Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

            api_services=retrofit.create(ApiService.class);

        }
        return  api_services;

    }


}

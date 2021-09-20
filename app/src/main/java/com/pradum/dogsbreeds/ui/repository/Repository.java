package com.pradum.dogsbreeds.ui.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.pradum.dogsbreeds.api.DogApi;
import com.pradum.dogsbreeds.model.breedImage;
import com.pradum.dogsbreeds.model.breeds;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {


    private static  Repository mRepository;

    public static Repository getInstance() {

        if (mRepository == null) {

            mRepository =new Repository();

        }

        return mRepository;

    }



    public MutableLiveData<breeds> getBreeds(String list) {

        MutableLiveData<breeds> data = new MutableLiveData<>();

        DogApi.getApi_services().getALlbreeds(list).enqueue(new Callback<breeds>() {
            @Override
            public void onResponse(Call<breeds> call, Response<breeds> response) {
                    data.postValue(response.body());

            }

            @Override
            public void onFailure(Call<breeds> call, Throwable t) {
                data.postValue(null);


            }
        });

    return data ;
    }




    public MutableLiveData<breedImage> getRandomImage(String list) {

        MutableLiveData<breedImage> data = new MutableLiveData<>();

        DogApi.getApi_services().geRandomImage(list).enqueue(new Callback<breedImage>() {
            @Override
            public void onResponse(Call<breedImage> call, Response<breedImage> response) {
                    data.postValue(response.body());

            }

            @Override
            public void onFailure(Call<breedImage> call, Throwable t) {
                data.postValue(null);


            }
        });

    return data ;
    }





}

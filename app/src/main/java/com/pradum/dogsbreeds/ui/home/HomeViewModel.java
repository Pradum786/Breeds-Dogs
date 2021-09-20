package com.pradum.dogsbreeds.ui.home;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.pradum.dogsbreeds.model.breeds;
import com.pradum.dogsbreeds.ui.repository.Repository;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<breeds> breeds;
    private HomeViewModel HomeViewModel;
    private Repository mRepository;


    public  void  init(String list){

        if(HomeViewModel!=null){

            HomeViewModel=null;

        }

        mRepository = Repository.getInstance();
        breeds= mRepository.getBreeds(list);






    }


    public LiveData<breeds> getbreeds() {
        return breeds;
    }
}
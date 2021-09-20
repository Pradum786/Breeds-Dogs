package com.pradum.dogsbreeds.ui.Rendom_Image;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.pradum.dogsbreeds.model.breedImage;
import com.pradum.dogsbreeds.model.breeds;
import com.pradum.dogsbreeds.ui.home.HomeViewModel;
import com.pradum.dogsbreeds.ui.repository.Repository;

public class RandomViewModel extends ViewModel {

    private MutableLiveData<breedImage> breedimage;
    private RandomViewModel RandomViewModel;
    private Repository mRepository;
    
    
    public  void  init(String list){

        if(RandomViewModel!=null){

            RandomViewModel=null;

        }

        mRepository = Repository.getInstance();

        breedimage= mRepository.getRandomImage(list);




    }


    public LiveData<breedImage> getrandomImg() {
        return breedimage;
    }

}
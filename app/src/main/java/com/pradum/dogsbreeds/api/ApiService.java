package com.pradum.dogsbreeds.api;

import com.pradum.dogsbreeds.model.breedImage;
import com.pradum.dogsbreeds.model.breeds;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    @GET("api/breeds/{list}")
    Call<breeds> getALlbreeds(@Path("list") String list);

    @GET("api/breed/{breedname}/images/random/10")
    Call<breedImage> getBreedImg(@Path("breedname") String breedname);

    @GET("api/breeds/image/random/{count}")
    Call<breedImage>geRandomImage(@Path("count" )String count);

}

package com.pradum.dogsbreeds.ui.detail_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.pradum.dogsbreeds.R;
import com.pradum.dogsbreeds.api.DogApi;
import com.pradum.dogsbreeds.model.breedImage;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Detail_Activity extends AppCompatActivity {

    BreedIMGAdptare breedIMGAdptare;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        listView=findViewById(R.id.breed_image);

        DogApi.getApi_services().getBreedImg(getIntent().getStringExtra("name")).enqueue(new Callback<breedImage>() {
            @Override
            public void onResponse(Call<breedImage> call, Response<breedImage> response) {

                 breedImage breedImage= response.body();
                breedIMGAdptare= new BreedIMGAdptare(Detail_Activity.this,breedImage.getMessage());
                listView.setAdapter(breedIMGAdptare);
            }

            @Override
            public void onFailure(Call<breedImage> call, Throwable t) {

            }
        });

    }
}
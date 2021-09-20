package com.pradum.dogsbreeds.ui.Rendom_Image;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.pradum.dogsbreeds.R;
import com.pradum.dogsbreeds.databinding.FragmentRandomBinding;
import com.pradum.dogsbreeds.model.breedImage;
import com.pradum.dogsbreeds.ui.detail_activity.BreedIMGAdptare;
import com.pradum.dogsbreeds.ui.home.BreedAdpater;

public class RandomFragment extends Fragment {

    private RandomViewModel mViewModel;
    private FragmentRandomBinding binding;
    BreedIMGAdptare breedIMGAdptare;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel =
                new ViewModelProvider(this).get(RandomViewModel.class);
        ConnectivityManager cm = (ConnectivityManager)getActivity().getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo nInfo = cm.getActiveNetworkInfo();
        boolean connected = nInfo != null && nInfo.isAvailable() && nInfo.isConnected();

        if (connected) {

            mViewModel.init("50");
            data();
        }else {

            Toast.makeText(getActivity(), "No Internet Conection", Toast.LENGTH_LONG).show();


        }
        binding = FragmentRandomBinding.inflate(inflater, container, false);
        View root = binding.getRoot();







        return root;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private  void data(){

        mViewModel.getrandomImg().observe(getViewLifecycleOwner(), new Observer<breedImage>() {
            @Override
            public void onChanged(breedImage breedImage) {

                breedIMGAdptare= new BreedIMGAdptare(getActivity(),breedImage.getMessage());
                binding.randomList.setAdapter(breedIMGAdptare);

            }
        });


    }

}
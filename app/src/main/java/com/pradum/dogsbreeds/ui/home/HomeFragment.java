package com.pradum.dogsbreeds.ui.home;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.pradum.dogsbreeds.R;
import com.pradum.dogsbreeds.databinding.FragmentHomeBinding;
import com.pradum.dogsbreeds.model.breeds;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    BreedAdpater breedAdpater;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        ConnectivityManager cm = (ConnectivityManager)getActivity().getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo nInfo = cm.getActiveNetworkInfo();
        boolean connected = nInfo != null && nInfo.isAvailable() && nInfo.isConnected();

        if (connected) {

            homeViewModel.init("list");
            data();
        }else {

            Toast.makeText(getActivity(), "No Internet Conection", Toast.LENGTH_LONG).show();


        }


        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();





        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }



    private void data(){
        homeViewModel.getbreeds().observe(getViewLifecycleOwner(), new Observer<breeds>() {
            @Override
            public void onChanged(breeds breeds) {

                breedAdpater= new BreedAdpater(getActivity(),breeds.getMessage());
                binding.breedsList.setAdapter(breedAdpater);

            }
        });

    }


}
package com.pradum.dogsbreeds.ui.home;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;

import com.google.android.material.snackbar.Snackbar;
import com.pradum.dogsbreeds.MainActivity;
import com.pradum.dogsbreeds.R;
import com.pradum.dogsbreeds.model.breeds;
import com.pradum.dogsbreeds.ui.detail_activity.Detail_Activity;

import java.util.ArrayList;
import java.util.List;


public class BreedAdpater extends ArrayAdapter  {

    private Context mContext;
    private List<String> BreedsList = new ArrayList<>();


    public BreedAdpater(@NonNull Context context, @NonNull List objects) {
        super(context,0, objects);

        mContext = context;
        BreedsList = objects;

    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.breed_list,parent,false);

        TextView name = (TextView) listItem.findViewById(R.id.name);
        name.setText(BreedsList.get(position));

        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                mContext.startActivity(new Intent(mContext, Detail_Activity.class).putExtra("name",BreedsList.get(position)));

            }
        });

        return listItem;
    }
}

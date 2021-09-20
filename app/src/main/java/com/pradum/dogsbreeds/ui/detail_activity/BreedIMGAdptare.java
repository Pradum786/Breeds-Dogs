package com.pradum.dogsbreeds.ui.detail_activity;

import static android.content.Context.DOWNLOAD_SERVICE;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;

import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;

import com.bumptech.glide.Glide;
import com.pradum.dogsbreeds.R;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BreedIMGAdptare extends ArrayAdapter {

    private Context mContext;
    CircularProgressDrawable circularProgressDrawable;
    private List<String> BreedIMG = new ArrayList<>();


    public BreedIMGAdptare(@NonNull Context context, @NonNull List objects) {
        super(context,0, objects);

        mContext = context;
        BreedIMG = objects;

    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.detail_image,parent,false);

        ImageView image = (ImageView) listItem.findViewById(R.id.imageView2);
        Button button =(Button) listItem.findViewById(R.id.download);
         circularProgressDrawable = new CircularProgressDrawable(mContext);
        circularProgressDrawable.setStrokeWidth(5f);
        circularProgressDrawable.setCenterRadius(30f);
        circularProgressDrawable.start();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                beginDownload(BreedIMG.get(position));
            }
        });

        Glide.with(mContext).load(BreedIMG.get(position)).placeholder(circularProgressDrawable).into(image);



        return listItem;
    }

    private void beginDownload( String imagurl){
        String url = imagurl;

        String titile= URLUtil.guessFileName(url,null,null);
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url))
                .setTitle(titile)
                .setDescription("Downloading...")
                .setAllowedOverMetered(true)
                .setAllowedOverRoaming(true)
                .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
                .setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,titile);
        DownloadManager downloadManager=(DownloadManager) mContext.getSystemService(DOWNLOAD_SERVICE);
        downloadManager.enqueue(request);

        Toast.makeText(mContext,"Download Start", Toast.LENGTH_SHORT).show();

    }
}

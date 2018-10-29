package com.example.work;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Администратор on 23.10.2018.
 */

public class NewsList extends ArrayAdapter<News> implements ImageLoad.Listener {

    private Activity context;
    private List<News> ArrayNewsList;
    ImageLoad imageLoad;
    Date date = new Date();
    Long dateLong;
    TextView name,description,dateNews;
    ImageView image;


    public NewsList(Activity context, List<News> ArrayNewsList) {
        super(context, R.layout.news_list_layout, ArrayNewsList);
        this.context = context;
        this.ArrayNewsList = ArrayNewsList;
    }

    @NonNull
    @Override
    public View getView(int position, View contentView, ViewGroup parent) {
        LayoutInflater layoutInflater = context.getLayoutInflater();
        View listItemView = layoutInflater.inflate(R.layout.news_list_layout, null, true);
        //Обявление ячеек дял инфы
        name = listItemView.findViewById(R.id.name);
        image = listItemView.findViewById(R.id.image);
        description = listItemView.findViewById(R.id.description);
        dateNews = listItemView.findViewById(R.id.date);
        //Присваевание инфы
        //Получение позиций
        News news = ArrayNewsList.get(position);
        //Получение имени
        name.setText(news.getName());
        Log.d("NEWSLIST ", "News LIST NAME :" + news.getName());
        //Получение описания
        description.setText(news.getDescription());
        Log.d("NEWSLIST ", "News Desc :" + news.getDescription());

        //Получение изображения URL
        String urlImage = news.getImage();
       // Drawable drawable = LoadImageFromWebOperations(urlImage);
       // image.setImageDrawable(drawable);
        // new ImageLoad(this).execute(urlImage);
        Log.d("NEWSLIST ", "News IMAGE URL :" + urlImage);
        
        //Получение времени
        Log.d("NWSLIST", "NEWS DATE" + news.getDate());
        dateLong = news.getDate() * 1000;
        date = new java.util.Date(dateLong);
        String dateTimeNews = new SimpleDateFormat("MM dd, yyyy, hh:mma").format(date);
        Log.d("NWSLIST", "NEWS DATE " + dateTimeNews);
        dateNews.setText(dateTimeNews);
        return listItemView;
    }


    public static Drawable LoadImageFromWebOperations(String url) {
        try {
            InputStream is = (InputStream) new URL(url).getContent();
            Drawable d = Drawable.createFromStream(is, "");
            return d;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void onImageLoaded(Bitmap bitmap) {
        image.setImageBitmap(bitmap);
    }

    @Override
    public void onError() {
        Log.d("NWSLIST", "Image Load Error ");
    }

}





package com.example.work;

import android.util.Log;


/**
 * Created by Администратор on 23.10.2018.
 */

public class News {
    private Long date;
    private String description;
    private String image;
    private String name;

    public News() {

    }

    public News(String name, String description, Long date, String image) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.image = image;
    }

    public String getName() {
        Log.w("NEWS", "News Name :" + this.name); return name;
    }

    public String getDescription() {
        Log.d("NEWS", "News Desc :" + this.description);return description;
    }

    public Long getDate() {
        Log.d("NEWS", "News DATE :" + this.date);
        return date;
    }

    public String getImage() {
        Log.d("NEWS", "News Image :" + this.image);
        return image;
    }


}

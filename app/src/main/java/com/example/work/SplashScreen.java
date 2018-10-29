package com.example.work;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by Администратор on 25.10.2018.
 */

public class SplashScreen extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plash_sreen);
        Intent startActivityMain = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(startActivityMain);
    }
}

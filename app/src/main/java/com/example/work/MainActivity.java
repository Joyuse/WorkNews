package com.example.work;

import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private static final String TAG= "MainActivity ";

    ListView newsListView;
    FirebaseDatabase database;
    DatabaseReference databaseReference;
    List<News> newsList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        //ListView
        newsListView = findViewById(R.id.NewsListView);
        newsList= new ArrayList<>();
        //FireBase
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("news");
        Log.d(TAG, "CHECK 1");
    }

    @Override
    protected void onStart() {
        super.onStart();
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                newsList.clear();
                for(DataSnapshot newsSnapshot: dataSnapshot.getChildren()){
                    News news  = newsSnapshot.getValue(News.class);
                    newsList.add(news);
                }
                ArrayAdapter adapter = new NewsList(MainActivity.this, newsList);
                newsListView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
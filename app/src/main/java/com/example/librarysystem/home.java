package com.example.librarysystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class home extends AppCompatActivity {

    SimpleDateFormat date,time;

    MyAdapter adapter;

    ArrayList<String> id,name,email,password;
    RecyclerView recyclerView;

    AccountDatabase accountDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        accountDatabase = new AccountDatabase(home.this);

        date = new SimpleDateFormat("MM/dd/yy");
        time = new SimpleDateFormat("hh:mm:ss a");

        String currentDate = date.format(new Date());
        String currentTime = time.format(new Date());





        recyclerView = findViewById(R.id.rvList);
        id = new ArrayList<>();
        name = new ArrayList<>();
        email = new ArrayList<>();
        password = new ArrayList<>();
        adapter = new MyAdapter(this,id,name,email,password);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        showData();


        recyclerView = findViewById(R.id.rvList);
        id = new ArrayList<>();
        adapter = new MyAdapter(this,id);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        showData();






    }

    private void showData() {
        Cursor cursor = accountDatabase.getAllData();
        if(cursor.getCount() == 0){

        }else{
            while(cursor.moveToNext()){
                id.add(cursor.getString(0));

            }
        }
    }



    public void showAllData(){
        Cursor res = accountDatabase.getAllData();
        if(res.getCount() == 0){

        }else{
            while (res.moveToNext()){
                id.add(res.getString(0));
            }
        }
    }
}
package com.example.demomvvmapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.demomvvmapplication.data.adapter.CustomAdapter;
import com.example.demomvvmapplication.data.api.GetDataService;
import com.example.demomvvmapplication.data.api.RetrofitClientInstance;
import com.example.demomvvmapplication.data.pojo.UserDetail;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private CustomAdapter adapter;
    private RecyclerView recyclerView;
    ProgressDialog progressDoalog;
    LiveData<List<UserDetail>> allUserData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDoalog = new ProgressDialog(MainActivity.this);
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();


        GetDataService dataService = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<UserDetail>> listCall = dataService.getAllUserDetails();
        listCall.enqueue(new Callback<List<UserDetail>>() {
            @Override
            public void onResponse(Call<List<UserDetail>> call, Response<List<UserDetail>> response) {
                if (response.isSuccessful()) {
                    progressDoalog.dismiss();
                  generateDataList(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<UserDetail>> call, Throwable t) {

            }
        }) ;




    }

    private void generateDataList(List<UserDetail> photoList) {
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new CustomAdapter(photoList,MainActivity.this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
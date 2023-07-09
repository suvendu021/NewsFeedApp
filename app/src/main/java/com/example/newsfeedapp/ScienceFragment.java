package com.example.newsfeedapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ScienceFragment extends Fragment {
    String apiKey="3dcbb1ef2d8c4d5b945fedf5d7997ae6";

    List<ModelClass> mModel;
    Adapter adapter;
    String country="in";
    private RecyclerView recyclerViewOfScience;

    private String category="science";



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_science, container, false);

        recyclerViewOfScience=view.findViewById(R.id.recycleViewOfScience);
        mModel=new ArrayList<>();
        recyclerViewOfScience.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter=new Adapter(getContext(),mModel);
        recyclerViewOfScience.setAdapter(adapter);

        findNews();
        return view;
    }
    private void findNews() {

        ApiUtilities.getApiInterface().getCategoryNews(country,category,100,apiKey).enqueue(new Callback<MainNews>() {
            @Override
            public void onResponse(Call<MainNews> call, Response<MainNews> response) {
                if(response.isSuccessful()){
                    mModel.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<MainNews> call, Throwable t) {

            }
        });



    }
}
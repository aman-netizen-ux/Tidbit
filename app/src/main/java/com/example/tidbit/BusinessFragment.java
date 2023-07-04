package com.example.tidbit;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class BusinessFragment extends Fragment {

    String api = "4ce96961add94ee68a3d4e7807a4ee26";
    ArrayList<ModelClass> modelClassArrayList;
    Adapter adapter;
    String country = "in";
    private RecyclerView recyclerViewBu;
    private String category = "business";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_business, null);
        recyclerViewBu=view.findViewById(R.id.BusinessRecycler);
        modelClassArrayList = new ArrayList<>();
        recyclerViewBu.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new Adapter(getContext(),modelClassArrayList);
        recyclerViewBu.setAdapter(adapter);
        findNews();
        return view;
    }

    private void findNews() {
        ApiUtilities.getApiInterface().getCategoryNews(country,category,100,api).enqueue(new Callback<Article>() {
            @Override
            public void onResponse(Call<Article> call, Response<Article> response) {
                if(response.isSuccessful()){
                    modelClassArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<Article> call, Throwable t) {

            }
        });
    }

}
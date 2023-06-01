package com.example.tidbit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiUtilities {


    private static Retrofit retroFit = null;

    public static ApiInterface getApiInterface(){
        if(retroFit==null){
            //creation of retrofit object if its null
            retroFit= new Retrofit.Builder().baseUrl(ApiInterface.BASE_URL).addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retroFit.create(ApiInterface.class);

    }
}

package com.example.uasmobprog;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Methods {

    @GET("stage2/people/?nim=2301887143&nama=Mikail_Crito_Husada")
    Call<Model> getAllData();
}

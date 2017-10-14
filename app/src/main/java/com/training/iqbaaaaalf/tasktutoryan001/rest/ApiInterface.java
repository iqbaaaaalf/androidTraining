package com.training.iqbaaaaalf.tasktutoryan001.rest;

import com.training.iqbaaaaalf.tasktutoryan001.model.DestinationResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by iqbaaaaalf on 10/8/2017.
 */

public interface ApiInterface {
    @GET("Search")
    Call<DestinationResponse> getDestinasionResponse(@Query("key") String query);
}

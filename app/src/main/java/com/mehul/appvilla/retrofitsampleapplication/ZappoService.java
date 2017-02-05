package com.mehul.appvilla.retrofitsampleapplication;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Mehul on 05/02/17.
 */
public interface ZappoService {

    @GET("/Search")
    Call<Products> getProductItemInformation(@Query("term") String paramterm,
                                             @Query("key") String paramKey);

   // Products getProductItemInformation1(@Query("term") String paramterm,
     //                                        @Query("key") String paramKey);

}

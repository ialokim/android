package com.github.gotify.client.api;

import com.github.gotify.client.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;

import com.github.gotify.client.model.Application;
import com.github.gotify.client.model.Client;
import com.github.gotify.client.model.Error;
import java.io.File;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface TokenApi {
  /**
   * Create an application.
   * 
   * @param body the application to add (required)
   * @return Call&lt;Application&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("application")
  Call<Application> createApp(
    @retrofit2.http.Body Application body
  );

  /**
   * Create a client.
   * 
   * @param body the client to add (required)
   * @return Call&lt;Client&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("client")
  Call<Client> createClient(
    @retrofit2.http.Body Client body
  );

  /**
   * Delete an application.
   * 
   * @param id the application id (required)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @DELETE("application/{id}")
  Call<Void> deleteApp(
    @retrofit2.http.Path("id") Integer id
  );

  /**
   * Delete a client.
   * 
   * @param id the client id (required)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @DELETE("client/{id}")
  Call<Void> deleteClient(
    @retrofit2.http.Path("id") Integer id
  );

  /**
   * Return all applications.
   * 
   * @return Call&lt;List&lt;Application&gt;&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @GET("application")
  Call<List<Application>> getApps();
    

  /**
   * Return all clients.
   * 
   * @return Call&lt;List&lt;Client&gt;&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @GET("client")
  Call<List<Client>> getClients();
    

  /**
   * 
   * Upload an image for an application
   * @param file the application image (required)
   * @param id the application id (required)
   * @return Call&lt;Application&gt;
   */
  @retrofit2.http.Multipart
  @POST("application/{id}/image")
  Call<Application> uploadAppImage(
    @retrofit2.http.Part("file\"; filename=\"file") RequestBody file, @retrofit2.http.Path("id") Integer id
  );

}

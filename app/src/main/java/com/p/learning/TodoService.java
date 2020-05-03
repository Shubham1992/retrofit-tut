package com.p.learning;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TodoService {
    @GET("/todos")
    Call<List<Todo>> listTodos();

    @GET("/todos/{id}")
    Call<Todo> getTodo(@Path("id") String id);

    // You can have more such API declarations here
}

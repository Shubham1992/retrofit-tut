package com.p.learning;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private Call<List<Todo>> callList;
    private Call<Todo> callSingleTodo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TodoService service = retrofit.create(TodoService.class);
        callList = service.listTodos();
        callList.enqueue(new Callback<List<Todo>>() {
            @Override
            public void onResponse(Call<List<Todo>> call, Response<List<Todo>> response) {
                System.out.println(response.body());
                // Use the response object to get list of ToDos
            }

            @Override
            public void onFailure(Call<List<Todo>> call, Throwable t) {

            }
        });


        callSingleTodo = service.getTodo("2");
        callSingleTodo.enqueue(new Callback<Todo>() {
            @Override
            public void onResponse(Call<Todo> call, Response<Todo> response) {
                System.out.println(response.body());
                // Use the response object to get ToDo Object

            }

            @Override
            public void onFailure(Call<Todo> call, Throwable t) {

            }
        });
    }
}

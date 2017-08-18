package com.example.ishaandhamija.volleypractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    Button request;
    TextView showText;
    RequestQueue requestQueue;
    City city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        request= (Button) findViewById(R.id.btnRequest);
        showText= (TextView) findViewById(R.id.tv);

        final Gson gson = new Gson();
        requestQueue = Volley.newRequestQueue(this);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest("http://api.openweathermap.org/data/2.5/weather?q=Delhi,india&appid=dec34e8465b0c6d6008899fb0f30e05f",
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try
                        {
                            Toast.makeText(MainActivity.this, "Response Successful"+response.toString(), Toast.LENGTH_SHORT).show();

                            /*JSONArray array=response.getJSONArray("weather");
                            JSONObject js=array.getJSONObject(0);
                            Toast.makeText(MainActivity.this,js.getString("main"), Toast.LENGTH_SHORT).show();*/


                       city = gson.fromJson(response.toString(), City.class);
                       Toast.makeText(MainActivity.this, "Temprature: "+ city.getMain().getTemp(), Toast.LENGTH_SHORT).show();
                            Toast.makeText(MainActivity.this, city.getWeather().get(0).getMain(), Toast.LENGTH_SHORT).show();

                        }
                        catch (Exception e)
                        {
                            Toast.makeText(MainActivity.this,e.getMessage(), Toast.LENGTH_SHORT).show();
//fuckyoubitches
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
                        Log.d("Yo", "onErrorResponse: "+ error.toString());
                        Toast.makeText(MainActivity.this, "Error Found", Toast.LENGTH_SHORT).show();
                    }
                });
        requestQueue.add(jsonObjectRequest);


    }


}

package com.example.soccer.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.soccer.R;
import com.example.soccer.adapter.AdapterLeague;
import com.example.soccer.model.League;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {
    ArrayList<League> leagues = new ArrayList<>();
    private RecyclerView recyclerView;
    AdapterLeague adapterLeague;

private String getJSONUrl(){
    Intent intent = getIntent();
    String country = intent.getStringExtra(MainActivity.JSON_URL);
    String url = "https://www.thesportsdb.com/api/v1/json/2/search_all_leagues.php?c=" + country + "&s=Soccer";
    return url;
}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        recyclerView = findViewById(R.id.recyclerView);
        getLeague();
}

    private void getLeague(){
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                getJSONUrl(),
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray leagueArray = response.getJSONArray("countrys");
                            for (int i = 0; i < response.length(); i++){
                                try {
                                    JSONObject leagueObject = leagueArray.getJSONObject(i);
                                    League league = new League();
                                    league.setStrBadge(leagueObject.getString("strBadge"));
                                    league.setStrLeague(leagueObject.getString("strLeague"));
                                    league.setStrDescriptionEN(leagueObject.getString("strDescriptionEN"));
                                    league.setStrWebsite(leagueObject.getString("strWebsite"));
                                    league.setStrFanart1(leagueObject.getString("strFanart1"));
                                    league.setStrFanart1(leagueObject.getString("strFanart2"));
                                    league.setStrFanart1(leagueObject.getString("strFanart3"));
                                    league.setStrFanart1(leagueObject.getString("strFanart4"));
                                    leagues.add(league);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

                        adapterLeague = new AdapterLeague(getApplicationContext(), leagues);
                        recyclerView.setAdapter(adapterLeague);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("tag", "onErrorResponse: "+ error.getMessage());
                    }
                }
        );
        queue.add(jsonObjectRequest);
    }

}
package com.training.iqbaaaaalf.tasktutoryan001.view;

import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.EditText;

import com.google.gson.Gson;
import com.training.iqbaaaaalf.tasktutoryan001.R;
import com.training.iqbaaaaalf.tasktutoryan001.model.DestinationModel;
import com.training.iqbaaaaalf.tasktutoryan001.model.DestinationResponse;
import com.training.iqbaaaaalf.tasktutoryan001.utils.CardAdapter;
import com.training.iqbaaaaalf.tasktutoryan001.rest.ApiClient;
import com.training.iqbaaaaalf.tasktutoryan001.rest.ApiInterface;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public RecyclerView rvCard;

    public CardAdapter rvAdapter;

    public static List<DestinationModel> destinationObj = new ArrayList<>();

    final Gson gson = new Gson();

    public static void  setList(List<DestinationModel> destList){
        destinationObj = new ArrayList<>(destList);
        Log.i("container list main : ", String.valueOf(destinationObj.size()));
        for (int i = 0; i< destinationObj.size(); i++){
            Log.i("iter through list: ", destinationObj.get(i).getTripName());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        rvCard = (RecyclerView) findViewById(R.id.rv_list);

        getData(getWindow().getDecorView());

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        rvCard.setLayoutManager(layoutManager);

        rvCard.setHasFixedSize(true);

//        kalo mau input query pake EditText uncomment dibawah ini dan jangan lupa tambahin edit text di xmlnya

//        queryInput = (EditText)findViewById(R.id.et_query);
//        queryInput.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                charSequence = charSequence.toString().toLowerCase();
//                List<DestinationModel> lastList = new ArrayList<DestinationModel>();
//
//                for(int j = 0 ; j<destinationObj.size(); j++){
//                    String title = destinationObj.get(j).getTripName().toLowerCase();
//                    if(title.contains(charSequence)){
//                        lastList.add(destinationObj.get(j));
//                    }
//                }
//
//                rvAdapter = new CardAdapter(lastList);
//                rvCard.setAdapter(rvAdapter);
//                rvAdapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//
//            }
//        });
    }

    public void getData(final View view){
//        String query = queryInput.getText().toString();

        String defaultQuery = "";
//        kalo make http biasa di uncomment semua yang di comment di method ini
//        URL searchURL = Network.buildURL(query);
//        System.out.println(searchURL.toString());

        ApiInterface apiInterface =
                ApiClient.getClient().create(ApiInterface.class);
        Call<DestinationResponse> call = apiInterface.getDestinasionResponse(defaultQuery);
        call.enqueue(new Callback<DestinationResponse>() {
            @Override
            public void onResponse(Call<DestinationResponse> call, Response<DestinationResponse> response) {
                destinationObj = response.body().getResult();
                rvAdapter = new CardAdapter(destinationObj);
                rvCard.setAdapter(rvAdapter);
                String json = gson.toJson(destinationObj);
                Log.i("OnResponse dataSource :",response.body().getMessage());
            }

            @Override
            public void onFailure(Call<DestinationResponse> call, Throwable t) {
                Snackbar.make(view, R.string.connection_error,Snackbar.LENGTH_LONG).show();
                Log.i("OnResponse dataSource :","Internet connection error, Fetch Failed");
            }
        });
//        new QueryTask().execute(searchURL);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);

        SearchManager searchManager =  (SearchManager) getSystemService(Context.SEARCH_SERVICE);

        MenuItem searchItem = menu.findItem(R.id.search);

        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);

        searchView.setSearchableInfo(searchManager.getSearchableInfo(new ComponentName(getApplicationContext(), MainActivity.class)));

//        searchView.setIconifiedByDefault(false);


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                rvAdapter.getFilter().filter(query);
                rvAdapter.notifyDataSetChanged();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                rvAdapter.getFilter().filter(newText);
                rvAdapter.notifyDataSetChanged();

                return true;
            }
        });

        return true;
    }

    //    public class QueryTask extends AsyncTask<URL, Void, Void> {
//
//        List<DestinationModel> destinationData = new ArrayList<DestinationModel>();
//
//        @Override
//        protected Void doInBackground(URL... urls) {
//            URL searchUrl = urls[0];
//            String searchResult = null;
//            try{
//                searchResult = Network.getResponseFromHttpUrl(searchUrl);
//                jsonObject = new JSONObject(searchResult);
//                JSONArray jsonArray = jsonObject.getJSONArray("data");
//                int length = jsonArray.length();
//
//                for (int i = 0; i<length; i++){
//                    DestinationModel destinationModel;
//                    JSONObject jsonIter = jsonArray.getJSONObject(i);
//
//                    String idTrip = jsonIter.getString("id_trip");
//                    String tripName = jsonIter.getString("trip_name");
//                    String photoUrl = jsonIter.getString("photo");
//
//                    destinationModel = new DestinationModel(idTrip,tripName,null, photoUrl, null, null, null, null, null,
//                            null, null, null, null, null, null);
//
//                    destinationData.add(destinationModel);
//
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//
//            setList(destinationData);
//
//            Log.i("check last size ", "temp : " + destinationData.size() + " result : " + destinationObj.size());
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(Void aVoid) {
//            super.onPostExecute(aVoid);
//
//            rvAdapter = new CardAdapter(destinationObj, destinationObj.size());
//            rvCard.setAdapter(rvAdapter);
//
//        }
//
//    }
}


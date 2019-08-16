package com.example.currencyexchangerate;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.currencyexchangerate.adapter.CurrencyAdapter;
import com.example.currencyexchangerate.config.Constants;
import com.example.currencyexchangerate.model.Currency;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class CurrencyExchangeRateActivity extends AppCompatActivity {
    ListView lvCurrency;
    List<Currency> currencies;
    CurrencyAdapter currencyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_exchange_rate);

        initView();
        addEvent();
    }


    private void addEvent() {
    }

    private void initView() {
        lvCurrency = findViewById(R.id.lv_currency);
        currencies = new ArrayList<>();
        currencyAdapter = new CurrencyAdapter(CurrencyExchangeRateActivity.this, R.layout.currency_item, currencies);
        lvCurrency.setAdapter(currencyAdapter);

        CurrencyTask currencyTask = new CurrencyTask();
        currencyTask.execute();
    }

    class CurrencyTask extends AsyncTask<Void, Void, ArrayList<Currency>> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            currencyAdapter.clear();
        }

        @Override
        protected void onPostExecute(ArrayList<Currency> currencies) {
            super.onPostExecute(currencies);
            currencyAdapter.clear();
            currencyAdapter.addAll(currencies);
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected ArrayList<Currency> doInBackground(Void... voids) {
            ArrayList<Currency> currencies = new ArrayList<>();
            try {
                URL url = new URL(Constants.getURL());
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setRequestProperty("Content-type", "application/json");
                connection.setRequestProperty("User-Agent", "Mozilla/5.0 ( compatible ) ");
                connection.setRequestProperty("Accept", "*/*");

                InputStream inputStream = connection.getInputStream();
                InputStreamReader reader = new InputStreamReader(inputStream, "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(reader);
                String line = bufferedReader.readLine();
                StringBuilder builder = new StringBuilder();
                while (line != null){
                    builder.append(line);
                    line = bufferedReader.readLine();
                }
                String json = builder.toString();
                json = json.replace("(","").replace(")","");
                JSONObject jsonObject = new JSONObject(json);
                JSONArray jsonArray = jsonObject.getJSONArray("items");
                for(int i =0; i < jsonArray.length(); i++){
                    JSONObject item = jsonArray.getJSONObject(i);
                    Currency currency = new Currency();
                    if(item.has("type")){
                        currency.setType(item.getString("type"));
                    }
                    if(item.has("imageurl")){
                        currency.setImageurl(item.getString("imageurl"));
                        url = new URL(currency.getImageurl());
                        connection = (HttpURLConnection) url.openConnection();
                        connection.setRequestMethod("GET");
                        connection.setRequestProperty("Content-type", "application/json");
                        connection.setRequestProperty("User-Agent", "Mozilla/5.0 ( compatible ) ");
                        connection.setRequestProperty("Accept", "*/*");
                        Bitmap bitmap = BitmapFactory.decodeStream(connection.getInputStream());
                        currency.setBitmap(bitmap);
                    }
                    if(item.has("muatienmat")){
                        currency.setBuycash(item.getString("muatienmat"));
                    }
                    if(item.has("bantienmat")){
                        currency.setSellcash(item.getString("bantienmat"));
                    }
                    if(item.has("muack")){
                        currency.setBuycredit(item.getString("muack"));
                    }
                    if(item.has("banck")){
                        currency.setSellcredit(item.getString("banck"));
                    }
                    currencies.add(currency);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return currencies;
        }
    }
}

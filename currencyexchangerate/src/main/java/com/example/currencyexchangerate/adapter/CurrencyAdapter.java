package com.example.currencyexchangerate.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.currencyexchangerate.R;
import com.example.currencyexchangerate.model.Currency;

import java.util.List;

public class CurrencyAdapter extends ArrayAdapter<Currency> {
    Activity context;
    int resource;
    List<Currency> currencies;

    public CurrencyAdapter(Activity context, int resource, List<Currency> currencies) {
        super(context, resource, currencies);
        this.context = context;
        this.resource = resource;
        this.currencies = currencies;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = this.context.getLayoutInflater();
        View item = inflater.inflate(this.resource, null);

        Currency currency = this.currencies.get(position);

        ImageView imageFlag = item.findViewById(R.id.iv_flag);
        TextView txtTitleCurrency = item.findViewById(R.id.text_title_currency);
        TextView txtCashBuy = item.findViewById(R.id.text_cash_buy);
        TextView txtCashSell = item.findViewById(R.id.text_cash_sell);
        TextView txtCreditBuy = item.findViewById(R.id.text_credit_buy);
        TextView txtCreditSell = item.findViewById(R.id.text_credit_sell);

        imageFlag.setImageBitmap(currency.getBitmap());
        txtTitleCurrency.setText(currency.getType());
        txtCashBuy.setText(currency.getBuycash());
        txtCashSell.setText(currency.getSellcash());
        txtCreditBuy.setText(currency.getBuycredit());
        txtCreditSell.setText(currency.getSellcredit());

        return item;
    }
}

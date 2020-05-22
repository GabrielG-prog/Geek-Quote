package fr.mds.geekquote.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.text.DateFormat;
import java.util.List;

import fr.mds.geekquote.R;
import fr.mds.geekquote.model.Quote;

public class QuotesAdapter extends ArrayAdapter<Quote> {

    public QuotesAdapter(@NonNull Context context, @NonNull List<Quote> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Quote quote = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_quote, parent, false);
        }

        if(position %2==0) {
            convertView.setBackgroundColor(Color.parseColor("#FFD700"));
        }

        TextView tv_item_quote_strQuote = convertView.findViewById(R.id.tv_item_quote_strQuote);
        TextView tv_item_quote_date = convertView.findViewById(R.id.tv_item_quote_date);
        TextView tv_item_quote_rate = convertView.findViewById(R.id.tv_item_quote_rate);

        tv_item_quote_strQuote.setText("Quote: " + quote.getStrQuote());
        tv_item_quote_date.setText("Date: " + DateFormat.getDateTimeInstance().format(quote.getCreatingDate()));
        tv_item_quote_rate.setText("Rate: " + quote.getRating());

        if(quote.getRating() == 0){
            tv_item_quote_rate.setVisibility(View.INVISIBLE);
        } else {
            tv_item_quote_rate.setVisibility(View.VISIBLE);
        }

        return convertView;

    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getView(position, convertView, parent);
    }

}


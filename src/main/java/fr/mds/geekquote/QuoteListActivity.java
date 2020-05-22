package fr.mds.geekquote;

import android.content.Intent;
import android.net.sip.SipSession;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import fr.mds.geekquote.adapter.QuotesAdapter;
import fr.mds.geekquote.model.Quote;

public class QuoteListActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    protected ArrayList<Quote> quotes = new ArrayList<>();

    private Button bt_add_quote;
    private EditText et_edit_quote;
    private ListView lv_list_quote;

    private QuotesAdapter quotesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quote_list);

        bt_add_quote = findViewById(R.id.bt_add_quote);
        et_edit_quote = findViewById(R.id.et_edit_quote);
        lv_list_quote = findViewById(R.id.lv_list_quote);

        bt_add_quote.setOnClickListener(this);
        lv_list_quote.setOnItemClickListener(this);

        quotesAdapter = new QuotesAdapter(this, quotes);
        lv_list_quote.setAdapter(quotesAdapter);

        String[] quoteArray = getResources().getStringArray(R.array.quoteArray);

        for (String s : quoteArray) {
            addQuote(s);
        }

    }

    public void addQuote(String strQuote) {
        Quote quote = new Quote(strQuote);
        quotes.add(0, quote);

        quotesAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        String editTextQuote = et_edit_quote.getText().toString();
        addQuote(editTextQuote);
        et_edit_quote.getText().clear();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Quote quote = quotes.get(position);

        Intent intent = new Intent(this, QuoteViewActivity.class);
        intent.putExtra("quote", quote);
        intent.putExtra("position", position);
        startActivityForResult(intent, 0);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 0 && resultCode == 1 && data != null) {

            int position = data.getIntExtra("position", 0);
            float rating = data.getFloatExtra("rating", 0);

            quotes.get(position).setRating((int) rating);

            quotesAdapter.notifyDataSetChanged();
        }
    }
}

package fr.mds.geekquote;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.text.DateFormat;

import fr.mds.geekquote.model.Quote;

public class QuoteViewActivity extends Activity implements View.OnClickListener {

    private Button bt_quote_view_cancel, bt_quote_view_ok;
    private EditText et_quote_edit;

    private TextView tv_quote_date, tv_quote_content;
    private RatingBar rt_quote_rating;

    private Quote quote;
    private int position;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quote_view);

        bt_quote_view_ok = findViewById(R.id.bt_quote_view_ok);
        bt_quote_view_cancel = findViewById(R.id.bt_quote_view_cancel);
        tv_quote_date = findViewById(R.id.tv_quote_date);
        tv_quote_content = findViewById(R.id.tv_quote_content);
        rt_quote_rating = findViewById(R.id.rt_quote_rating);
        et_quote_edit = findViewById(R.id.et_quote_edit);

        bt_quote_view_ok.setOnClickListener(this);
        bt_quote_view_cancel.setOnClickListener(this);

        Bundle bundle = getIntent().getExtras();

        if(bundle != null){
            quote = (Quote) bundle.getSerializable("quote");
            position = bundle.getInt("position");
        }

        if (quote != null){
            tv_quote_content.setText(quote.getStrQuote());
            tv_quote_date.setText(DateFormat.getDateTimeInstance().format(quote.getCreatingDate()));
            rt_quote_rating.setRating(quote.getRating());
        }
    }

    @Override
    public void onClick(View v) {

        if (v == bt_quote_view_ok) {
            getIntent().putExtra("position", position);
            getIntent().putExtra("rating", rt_quote_rating.getRating());
            setResult(1, getIntent());
        }
        finish();

    }
}

package fr.mds.geekquote;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends Activity implements View.OnClickListener {

    private Button bt_main_signin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        bt_main_signin = findViewById(R.id.bt_main_signin);

        bt_main_signin.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}

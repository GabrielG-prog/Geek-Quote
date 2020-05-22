package fr.mds.geekquote;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class LoginActivity extends Activity implements View.OnClickListener {

    private EditText et_login_username, et_login_password;
    private Button bt_login_submit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        et_login_username = findViewById(R.id.et_login_username);
        et_login_password = findViewById(R.id.et_login_password);
        bt_login_submit = findViewById(R.id.bt_login_submit);

        bt_login_submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String username = et_login_username.getText().toString();
        String password = et_login_password.getText().toString();

        if (username.equals("Gabriel") && password.equals("gabriel")){
            Intent intent = new Intent(this, QuoteListActivity.class);
            startActivity(intent);
            finish();
        }

    }
}

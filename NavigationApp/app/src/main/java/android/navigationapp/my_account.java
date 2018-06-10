package android.navigationapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class my_account extends AppCompatActivity {

    private TextView account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);

        account=(TextView)findViewById(R.id.tvAccount);
    }
}

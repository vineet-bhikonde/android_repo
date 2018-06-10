package android.navigationapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class settings extends AppCompatActivity {

    private TextView settings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        settings=(TextView)findViewById(R.id.tvSettings);
    }
}

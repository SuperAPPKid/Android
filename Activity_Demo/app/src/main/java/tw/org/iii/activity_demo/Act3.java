package tw.org.iii.activity_demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Act3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act3);
        Intent intent = getIntent();
        Bundle bund = intent.getExtras();
        String data = bund.getString("a");

        TextView textView = findViewById(R.id.text);
        textView.setText(data);
    }
}

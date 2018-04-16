package tw.org.iii.daraaccess;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActMain extends AppCompatActivity {

    private View.OnClickListener btnShared_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(ActMain.this,ActShared.class));
        }
    };
    private View.OnClickListener btnOpen_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(ActMain.this,ActFile.class));
        }
    };
    private View.OnClickListener btnSql_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(ActMain.this,ActSQLite.class));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_main);
        InitialComponet();
    }

    private void InitialComponet() {
        btnShared = findViewById(R.id.shared);
        btnOpen = findViewById(R.id.open);
        btnSql = findViewById(R.id.sql);
        btnShared.setOnClickListener(btnShared_click);
        btnOpen.setOnClickListener(btnOpen_click);
        btnSql.setOnClickListener(btnSql_click);
    }

    Button btnShared;
    Button btnOpen;
    Button btnSql;
}

package tw.org.iii.daraaccess;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ActShared extends AppCompatActivity {

    private View.OnClickListener set_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SharedPreferences table = getSharedPreferences("T1",0);
            SharedPreferences.Editor row = table.edit();
            row.putString("KK",setView.getText().toString()).commit();

            Toast.makeText(ActShared.this,"儲存資料成功",Toast.LENGTH_SHORT).show();
        }
    };

    private View.OnClickListener get_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SharedPreferences table = getSharedPreferences("T1",0);
            String data = table.getString("KK","NoDATA");
            getView.setText(data);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_shared);
        InitialComponent();
    }

    private void InitialComponent() {
        set = findViewById(R.id.set);
        set.setOnClickListener(set_click);
        get = findViewById(R.id.get);
        get.setOnClickListener(get_click);
        getView = findViewById(R.id.viewGet);
        setView = findViewById(R.id.viewSet);
    }
    Button set;
    Button get;
    TextView getView;
    EditText setView;
}

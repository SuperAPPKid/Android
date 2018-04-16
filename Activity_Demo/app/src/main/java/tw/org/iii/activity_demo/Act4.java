package tw.org.iii.activity_demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Act4 extends AppCompatActivity {

    private View.OnClickListener yes_click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            SetMyChoice("有");
        }
    };
    private View.OnClickListener no_click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            SetMyChoice("沒有");
        }
    };
    private void SetMyChoice(String p) {
        Bundle bund = new Bundle();
        bund.putString("a",p);

        Intent intent = new Intent();
        intent.putExtras(bund);

        setResult(0,intent);
        finish();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act4);
        InitialComponent();
    }

    private void InitialComponent() {
        yes = findViewById(R.id.yes);
        yes.setOnClickListener(yes_click);
        no = findViewById(R.id.no);
        no.setOnClickListener(no_click);
    }

    Button yes;
    Button no;
}

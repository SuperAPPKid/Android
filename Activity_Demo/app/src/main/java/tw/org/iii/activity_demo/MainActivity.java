package tw.org.iii.activity_demo;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private View.OnClickListener btn_click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this,Act2.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener sendBtn_click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Bundle bund = new Bundle();
            bund.putString("a","apple");
            Intent intent = new Intent(MainActivity.this,Act3.class);
            intent.putExtras(bund);
            startActivity(intent);
        }
    };

    private View.OnClickListener getResultBtn_click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this,Act4.class);
            startActivityForResult(intent,9999);
        }
    };

    private View.OnClickListener toListBtn_click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this,ActList.class);
            Log.v("Activity_DEMO","準備切換");
            startActivityForResult(intent,9998);
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==9999){
            if (data==null) {
                textView.setText("沒有設定管理員");
                return;
            }
            if(data.getExtras()==null) {
                textView.setText("沒設定包裹");
                return;
            }
            String result = data.getExtras().getString("a");
            textView.setText("結果："+result);
        }
        if(requestCode==9998){
            if (data==null) {
                textView.setText("沒有設定管理員");
                return;
            }
            if(data.getExtras()==null) {
                textView.setText("沒設定包裹");
                return;
            }
            String result = data.getExtras().getString("a");
            textView.setText("結果："+result);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitialComponent();
        Log.i("Act_Demo","onCreate()");
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Act_Demo","onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Act_Demo","onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Act_Demo","onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Act_Demo","onStop()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Act_Demo","onRestart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Act_Demo","onDestroy()");
    }

    private void InitialComponent() {
        textView = findViewById(R.id.textView);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(btn_click);
        sendBtn = findViewById(R.id.send_btn);
        sendBtn.setOnClickListener(sendBtn_click);
        getResultBtn = findViewById(R.id.getResult_btn);
        getResultBtn.setOnClickListener(getResultBtn_click);
        toListBtn = findViewById(R.id.toList_btn);
        toListBtn.setOnClickListener(toListBtn_click);
    }

    TextView textView;
    Button btn;
    Button sendBtn;
    Button getResultBtn;
    Button toListBtn;
}

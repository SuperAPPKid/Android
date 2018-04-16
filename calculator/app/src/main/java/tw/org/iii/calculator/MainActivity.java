package tw.org.iii.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int i = 0;
    private String symbol = "";
    private boolean needClear = false;

    View.OnClickListener btn0_click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (!answerView.getText().toString().equals("0")) {
                String s = answerView.getText()+"0";
                answerView.setText(s);
            }
            needClear = false;
        }
    };

    View.OnClickListener btn1_click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(answerView.getText().toString().equals("0")||needClear) {
                answerView.setText("1");
            } else {
                String s = answerView.getText()+"1";
                answerView.setText(s);
            }
            needClear = false;
        }
    };

    View.OnClickListener btn2_click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(answerView.getText().toString().equals("0")||needClear) {
                answerView.setText("2");
            } else {
                String s = answerView.getText()+"2";
                answerView.setText(s);
            }
            needClear = false;
        }
    };

    View.OnClickListener btn3_click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(answerView.getText().toString().equals("0")||needClear) {
                answerView.setText("3");
            } else {
                String s = answerView.getText()+"3";
                answerView.setText(s);
            }
            needClear = false;
        }
    };

    View.OnClickListener btn4_click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(answerView.getText().toString().equals("0")||needClear) {
                answerView.setText("4");
            } else {
                String s = answerView.getText()+"4";
                answerView.setText(s);
            }
            needClear = false;
        }
    };

    View.OnClickListener btn5_click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(answerView.getText().toString().equals("0")||needClear) {
                answerView.setText("5");
            } else {
                String s = answerView.getText()+"5";
                answerView.setText(s);
            }
            needClear = false;
        }
    };

    View.OnClickListener btn6_click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(answerView.getText().toString().equals("0")||needClear) {
                answerView.setText("6");
            } else {
                String s = answerView.getText()+"6";
                answerView.setText(s);
            }
            needClear = false;
        }
    };

    View.OnClickListener btn7_click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(answerView.getText().toString().equals("0")||needClear) {
                answerView.setText("7");
            } else {
                String s = answerView.getText()+"7";
                answerView.setText(s);
            }
            needClear = false;
        }
    };

    View.OnClickListener btn8_click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(answerView.getText().toString().equals("0")||needClear) {
                answerView.setText("8");
            } else {
                String s = answerView.getText()+"8";
                answerView.setText(s);
            }
            needClear = false;
        }
    };

    View.OnClickListener btn9_click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(answerView.getText().toString().equals("0")||needClear) {
                answerView.setText("9");
            } else {
                String s = answerView.getText()+"9";
                answerView.setText(s);
            }
            needClear = false;
        }
    };


    ViewStub.OnClickListener btnPlus_click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (!answerView.getText().toString().equals("0")) {
                String s = answerView.getText().toString();
                i = Integer.valueOf(s);
                symbol = "+" ;
                needClear = true;
            }
        }
    };

    ViewStub.OnClickListener btnMinus_click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (!answerView.getText().toString().equals("0")) {
                String s = answerView.getText().toString();
                i = Integer.valueOf(s);
                symbol = "-" ;
                needClear = true;
            }
        }
    };

    ViewStub.OnClickListener btnCross_click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (!answerView.getText().toString().equals("0")) {
                String s = answerView.getText().toString();
                i = Integer.valueOf(s);
                symbol = "*" ;
                needClear = true;
            }
        }
    };

    ViewStub.OnClickListener btnOver_click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (!answerView.getText().toString().equals("0")) {
                String s = answerView.getText().toString();
                i = Integer.parseInt(s);
                symbol = "/" ;
                needClear = true;
            }
        }
    };

    ViewStub.OnClickListener btnEq_click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int j = Integer.parseInt(answerView.getText().toString());
            if("+".equals(symbol))
                answerView.setText(String.valueOf(i+j));
            if("-".equals(symbol))
                answerView.setText(String.valueOf(i-j));
            if("*".equals(symbol))
                answerView.setText(String.valueOf(i*j));
            if("/".equals(symbol))
                answerView.setText(String.valueOf(i/j));
        }
    };

    ViewStub.OnClickListener btnClear_click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            answerView.setText("0");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("Log_demo","系統啟動");
        super.onCreate(savedInstanceState);
        Log.d("Log_demo","指定xml");
        setContentView(R.layout.activity_main);
        Log.d("Log_demo","初始化系統");
        InitialComponent();
        Log.d("Log_demo","就緒");
    }

    private void InitialComponent() {
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnCross = findViewById(R.id.btnCross);
        btnOver = findViewById(R.id.btnOver);
        btnEq = findViewById(R.id.btnEq);
        btnClear = findViewById(R.id.btnClear);
        answerView = findViewById(R.id.answer);
        btn0.setOnClickListener(btn0_click);
        btn1.setOnClickListener(btn1_click);
        btn2.setOnClickListener(btn2_click);
        btn3.setOnClickListener(btn3_click);
        btn4.setOnClickListener(btn4_click);
        btn5.setOnClickListener(btn5_click);
        btn6.setOnClickListener(btn6_click);
        btn7.setOnClickListener(btn7_click);
        btn8.setOnClickListener(btn8_click);
        btn9.setOnClickListener(btn9_click);
        btnPlus.setOnClickListener(btnPlus_click);
        btnMinus.setOnClickListener(btnMinus_click);
        btnCross.setOnClickListener(btnCross_click);
        btnOver.setOnClickListener(btnOver_click);
        btnEq.setOnClickListener(btnEq_click);
        btnClear.setOnClickListener(btnClear_click);
    }

    Button btn0;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    Button btnPlus;
    Button btnMinus;
    Button btnCross;
    Button btnOver;
    Button btnEq;
    Button btnClear;
    TextView answerView;
}

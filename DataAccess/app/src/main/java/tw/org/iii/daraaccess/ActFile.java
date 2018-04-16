package tw.org.iii.daraaccess;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public class ActFile extends AppCompatActivity {

    private View.OnClickListener set_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            try {
                OutputStream streamOut = openFileOutput("MyFile.txt",0);
                streamOut.write(setView.getText().toString().getBytes("utf-8"));
                streamOut.close();
                Toast.makeText(ActFile.this,"儲存資料成功",Toast.LENGTH_SHORT).show();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };

    private View.OnClickListener get_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try {
                InputStream streamIn = openFileInput("MyFile.txt");
                byte[] datas = new byte[1000];
                int max = streamIn.read(datas);
                String content = new String(datas,0,max,"utf-8");
                getView.setText(content);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_file);        InitialComponent();
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

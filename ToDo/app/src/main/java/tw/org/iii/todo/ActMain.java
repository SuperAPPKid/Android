package tw.org.iii.todo;

import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class ActMain extends AppCompatActivity {

    private View.OnClickListener btnSubmit_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SharedPreferences table = getSharedPreferences("tToDo",MODE_PRIVATE);
            int count = table.getInt("COUNT",0);
            count++;
            table.edit().putInt("COUNT",count).commit();

            String keyT = "T"+String.valueOf(count);
            String keyD = "D"+String.valueOf(count);
            table.edit().putString(keyT,setToDo.getText().toString()).commit();
            table.edit().putString(keyD,setDate.getText().toString()).commit();

            setToDo.setText("");

            Toast.makeText(ActMain.this,"新增代辦工作完成",Toast.LENGTH_SHORT).show();
        }
    };
    private View.OnClickListener btnList_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SharedPreferences table = getSharedPreferences("tToDo",0);
            int count = table.getInt("COUNT",0);
            if ( count == 0 ){
                Toast.makeText(ActMain.this,"沒有任何代辦工作",Toast.LENGTH_SHORT).show();
                return;
            }
            ArrayList<String> list = new ArrayList<String>();
            for (int i =1 ; i<=count ; i++) {
                String keyT = "T"+String.valueOf(i);
                String keyD = "D"+String.valueOf(i);
                if(table.contains(keyT)) {
                    list.add(table.getString(keyT,"")+"\r\n"+table.getString(keyD,""));
                }
            }
            AlertDialog.Builder message = new AlertDialog.Builder(ActMain.this);
            message.setItems(list.toArray(new String[list.size()]),null);
            message.create().show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("tag","完成創造");
        setContentView(R.layout.activity_act_main);
        Log.i("tag","完成xml");
        InitialComponent();
    }

    private void InitialComponent() {
        setToDo = findViewById(R.id.setToDo);
        setDate = findViewById(R.id.setDate);
        btnSubmit = findViewById(R.id.add);
        btnSubmit.setOnClickListener(btnSubmit_click);
        btnList = findViewById(R.id.list);
        btnList.setOnClickListener(btnList_click);
    }
    EditText setToDo;
    EditText setDate;
    Button btnSubmit;
    Button btnList;
}

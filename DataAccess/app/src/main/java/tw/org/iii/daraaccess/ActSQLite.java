package tw.org.iii.daraaccess;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActSQLite extends AppCompatActivity {

    private View.OnClickListener btnNew_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ContentValues data = new ContentValues();
            data.put("fId",id.getText().toString());
            data.put("fName",name.getText().toString());
            data.put("fAddress",address.getText().toString());
            data.put("fPhone",phone.getText().toString());
            data.put("fEmail",mail.getText().toString());

            CDbManager db = new CDbManager(ActSQLite.this);
            db.insert("tCustomer",data);
            Toast.makeText(ActSQLite.this,"新增資料成功",Toast.LENGTH_SHORT).show();
        }
    };

    private View.OnClickListener btnDelete_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            CDbManager db = new CDbManager(ActSQLite.this);
            db.delete("tCustomer",0);
        }
    };

    private View.OnClickListener btnUpdate_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            CDbManager db = new CDbManager(ActSQLite.this);
            ContentValues data = new ContentValues();
            data.put("fId",id.getText().toString());
            data.put("fName",name.getText().toString());
            data.put("fAddress",address.getText().toString());
            data.put("fPhone",phone.getText().toString());
            data.put("fEmail",mail.getText().toString());
            db.update("tCustomer",data,0);
        }
    };

    private View.OnClickListener btnSelect_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Cursor table=(new CDbManager(ActSQLite.this)).getBySql("SELECT * FROM tCustomer");
            if(table.getCount()<=0) {
                Toast.makeText(ActSQLite.this,"No Data",Toast.LENGTH_SHORT).show();
                return;
            }
            table.moveToFirst();
            String[] datas = new String[table.getCount()];
            for(int i=0;i<datas.length;i++){
                datas[i]=table.getString(2)+"\r\n"+
                        table.getString(3)+" / "+table.getString(4);
                table.moveToNext();
            }

            AlertDialog.Builder message = new AlertDialog.Builder(ActSQLite.this);
            message.setItems(datas,null);
            message.create().show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_sqlite);
        InitialComponent();
    }

    private void InitialComponent() {
        name = findViewById(R.id.txtName);
        id = findViewById(R.id.txtId);
        address = findViewById(R.id.txtAddress);
        phone = findViewById(R.id.txtPhone);
        mail = findViewById(R.id.txtEmail);

        btnNew = findViewById(R.id.新增);
        btnDelete = findViewById(R.id.刪除);
        btnUpdate = findViewById(R.id.修改);
        btnSelect = findViewById(R.id.重整);

        btnNew.setOnClickListener(btnNew_click);
        btnDelete.setOnClickListener(btnDelete_click);
        btnUpdate.setOnClickListener(btnUpdate_click);
        btnSelect.setOnClickListener(btnSelect_click);
    }

    EditText name;
    EditText id;
    EditText address;
    EditText phone;
    EditText mail;
    Button btnNew;
    Button btnDelete ;
    Button btnUpdate;
    Button btnSelect ;
}

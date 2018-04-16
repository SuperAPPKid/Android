package tw.org.iii.customer;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class ActMain extends AppCompatActivity {

    CCustomerFactory factory = new CCustomerFactory();

    private void DisplayCustomerInfo() {
        name.setText(factory.GetCurrent().getName());
        id.setText(factory.GetCurrent().getAccount());
        address.setText(factory.GetCurrent().getAddress());
        mail.setText(factory.GetCurrent().getEmail());
        phone.setText(factory.GetCurrent().getPhone());
    }

    private View.OnClickListener btnFirst_Click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            factory.MoveFirst();
            DisplayCustomerInfo();
        }
    };
    private View.OnClickListener btnLast_Click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            factory.MoveLast();
            DisplayCustomerInfo();
        }
    };
    private View.OnClickListener btnNext_Click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            factory.MoveNext();
            DisplayCustomerInfo();
        }
    };
    private View.OnClickListener btnPrevious_Click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            factory.MovePrevious();
            DisplayCustomerInfo();
        }
    };
    private View.OnClickListener btnList_Click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String[] customers = new String[factory.GetAll().length];
            int count = 0;
            for (CCustomer customer:factory.GetAll()) {
                customers[count] = customer.getName()+ "\r\n" + customer.getPhone();
                        count++;
            }
            Bundle bund = new Bundle();
            bund.putStringArray(Dictionary.CUSTOMER_LIST,customers);
            Intent intent = new Intent(ActMain.this,ActList.class);
            intent.putExtras(bund);
            startActivityForResult(intent,Dictionary.AID_ACTLIST);
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data==null)
            return;
        if(data.getExtras()==null)
            return;
        if (requestCode==Dictionary.AID_ACTLIST) {
            int position = data.getExtras().getInt(Dictionary.SELECTED_INDEX);
            factory.MoveTo(position);
            DisplayCustomerInfo();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_main);
        InitialComponent();
    }

    private void InitialComponent() {
         name = findViewById(R.id.txtName);
         id = findViewById(R.id.txtId);
         address = findViewById(R.id.txtAddress);
         phone = findViewById(R.id.txtPhone);
         mail = findViewById(R.id.txtEmail);
         btnFirst = findViewById(R.id.btnFirst);
         btnLast = findViewById(R.id.btnLast);
         btnNext = findViewById(R.id.btnNext);
         btnPrevious = findViewById(R.id.btnPrevious);
         btnList = findViewById(R.id.btnList);
         btnFirst.setOnClickListener(btnFirst_Click);
         btnLast.setOnClickListener(btnLast_Click);
         btnNext.setOnClickListener(btnNext_Click);
         btnPrevious.setOnClickListener(btnPrevious_Click);
         btnList.setOnClickListener(btnList_Click);
    }

    EditText name;
    EditText id;
    EditText address;
    EditText phone;
    EditText mail;
    ImageButton btnFirst;
    ImageButton btnLast ;
    ImageButton btnNext;
    ImageButton btnPrevious ;
    ImageButton btnList;

}

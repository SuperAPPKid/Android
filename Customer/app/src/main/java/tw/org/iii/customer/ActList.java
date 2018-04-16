package tw.org.iii.customer;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * Created by user37 on 2018/2/8.
 */


public class ActList extends ListActivity{
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Bundle bund = new Bundle();
        bund.putInt(Dictionary.SELECTED_INDEX,position);

        Intent intent = new Intent();
        intent.putExtras(bund);
        setResult(0,intent);
        finish();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] userNames = getIntent().getExtras().getStringArray(Dictionary.CUSTOMER_LIST);
        ListAdapter adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                userNames
        );
        setListAdapter(adapter);
    }
}

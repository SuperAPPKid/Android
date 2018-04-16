package tw.org.iii.activity_demo;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class ActList extends ListActivity {


    String[] userNames = new String[]{
            "aaa","bbb","ccc","ddd","eee","fff","ggg","hhh","iii","jjj","kkk","lll","mmm","nnn","ooo","ppp","qqq","rrr","sss","ttt","uuu","vvv","www","xxx","yyy","zzz"
    };

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        SetMyChoice(userNames[position]);
        Log.i("Activity_DEMO", "位置是"+String.valueOf(position));
        Log.i("Activity_DEMO", String.valueOf(id));
    }
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
        Log.v("Activity_DEMO","切換完成");

        ListAdapter adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_expandable_list_item_1,
                userNames
        );
        setListAdapter(adapter);
    }
}

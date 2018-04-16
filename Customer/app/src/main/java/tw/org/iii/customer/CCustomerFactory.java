package tw.org.iii.customer;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by user37 on 2018/2/8.
 */

public class CCustomerFactory {
    private int position;
    private ArrayList<CCustomer> list = new ArrayList<CCustomer>();

    public CCustomerFactory() {
        LoadData();
    }

    private void LoadData() {
        list.add(new CCustomer("A001","nameA","phoneA","mailA","addressA"));
        list.add(new CCustomer("A002","nameB","phoneB","mailB","addressB"));
        list.add(new CCustomer("A003","nameC","phoneC","mailC","addressC"));
    }

    public void  MoveFirst() {
        position = 0;
    }
    public void  MoveLast() {
        position = list.size()-1;
    }
    public void  MoveNext() {
        position++;
        if(position>=list.size())
            MoveLast();
    }
    public void  MovePrevious() {
        position--;
        if(position<0)
            MoveFirst();
    }
    public void  MoveTo(int to) {
        position = to;
    }
    public CCustomer  GetCurrent() {
        return list.get(position);
    }
    public CCustomer[] GetAll() {
        return list.toArray(new CCustomer[list.size()]);
    }
}

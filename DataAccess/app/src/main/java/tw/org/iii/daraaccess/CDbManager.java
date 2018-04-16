package tw.org.iii.daraaccess;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by user37 on 2018/2/12.
 */

public class CDbManager extends SQLiteOpenHelper {

    public CDbManager(Context context) {
        super(context, "dbDemo.db", null, 1);
    }

    public void  insert(String tbName,ContentValues data){
        getWritableDatabase().insert(tbName,null,data);
    }

    public void  delete(String tbName,int pk){
        getWritableDatabase().delete(tbName,"_id="+String.valueOf(pk),null);
    }

    public void  update(String tbName,ContentValues data,int pk){
        getWritableDatabase().update(tbName,data,"_id="+String.valueOf(pk),null);
    }
    public Cursor getBySql(String sql){
        return getReadableDatabase().rawQuery(sql,null);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="CREATE TABLE tCustomer (";
        sql+=" _id INTEGER PRIMARY KEY, ";
        sql+=" fId TEXT NOT NULL, ";
        sql+=" fName TEXT, ";
        sql+=" fPhone TEXT, ";
        sql+=" fEmail TEXT, ";
        sql+=" fAddress TEXT) ";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

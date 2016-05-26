package nsu.dhaka.sqlitedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by abrarkhan on 5/24/16.
 */
public class LocalDatabaseHelper extends SQLiteOpenHelper{

    public static final String DATABASE_NAME="local.db";
    public static final String TABLE_NAME="local";
    public static final String NAME="name";
    public static final String ID="id";
    public static final int VERSION=1;
    public static final String TABLE_CREATE="CREATE TABLE "+
            TABLE_NAME+"("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
            +NAME+" TEXT NOT NULL"+");";
    public LocalDatabaseHelper(Context context) {
        super(context,DATABASE_NAME,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST "+TABLE_NAME);

    }
    public void insert(Name name){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("NAME",name.getName());
        db.insert(TABLE_NAME,null,values);
    }
    public Cursor query(){
           SQLiteDatabase db=getWritableDatabase();
      return db.query(TABLE_NAME,new String[]{"ID","NAME"},null,null,null,null,null);
    }
}

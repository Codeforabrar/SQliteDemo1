package nsu.dhaka.sqlitedemo;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CursorAdapter;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    LocalDatabaseHelper helper;
    Name name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helper=new LocalDatabaseHelper(this);
        name=new Name();
    }
    public void insert(View view){
        String str="abrar";
         name.setName(str);
        helper.insert(name);
    }
    public void fetch(View view){
             Cursor cursor=helper.query();
        if(cursor.moveToFirst()) {

            do {
                String name = cursor.getString(cursor.getColumnIndex("name"));
                Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
            }while (cursor.isAfterLast());
        }
    }
}

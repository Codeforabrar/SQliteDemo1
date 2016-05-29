package nsu.dhaka.sqlitedemo;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    private static int REQUEST_CODE=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

    }
    public void onClick(View view){
          Intent intent=new Intent(Intent.ACTION_PICK,
                  ContactsContract.CommonDataKinds.Phone.CONTENT_URI);
        startActivityForResult(intent,REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_CODE){
            Uri uri=data.getData();
            ContentResolver res=getContentResolver();
            Cursor cursor=res.query(uri,null,null,null,null);
            if(cursor.moveToFirst()){
               do{
                   String str=cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                   Toast.makeText(this,str,Toast.LENGTH_LONG).show();
               }while (cursor.moveToNext());






            }
        }
    }
}

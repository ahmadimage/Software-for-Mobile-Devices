package com.example.sidkh.contactsmsreader;

import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SMS extends AppCompatActivity {
    ListView list;
    TextView textV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        list=(ListView) findViewById(R.id.listView);
        List<Map<String, String>> list_cont= new ArrayList<>() ;
        textV=(TextView) findViewById(R.id.textView2);
        int no=0;
        try {
            Cursor smsReader = getContentResolver().query(Uri.parse("content://sms"), null, null, null, null);
            while(smsReader.moveToNext()) {
                HashMap<String, String> temp = new HashMap<String, String>();
                int s = smsReader.getInt(smsReader.getColumnIndex("type"));
                String status =new String();
                String m=null;
                if(s==1){
                    status="send by :";
                }
                else if(s==2)
                    status="send to :";
                String number = smsReader.getString(smsReader.getColumnIndex("address"));
                temp.put("name", status+number);

                    //while(phoneNumber.moveToNext()){
                String message = smsReader.getString(smsReader.getColumnIndex("body"));
                temp.put("number", message);
                    //}

                list_cont.add(temp);
            }
            String asd= new String();
            for(int i=0;i<smsReader.getColumnCount();i++){
                asd+=smsReader.getColumnName(i);
                asd+=", ";
            }
            textV.setText("Total SMS: "+smsReader.getCount());
        }
        catch (Exception e){

        }
        //for(int i=0;i<15;i++) {

        //}
        String[] keys={"name", "number"};
        int[] ids1 = {R.id.name, R.id.number};
        SimpleAdapter adapt = new SimpleAdapter(this, list_cont,R.layout.cont, keys, ids1);
        list.setAdapter(adapt);
    }
}

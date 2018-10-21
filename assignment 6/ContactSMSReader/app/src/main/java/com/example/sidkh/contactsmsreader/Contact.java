package com.example.sidkh.contactsmsreader;

import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class Contact extends AppCompatActivity {

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
            Cursor contacts = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
            while(contacts.moveToNext()) {
                HashMap<String, String> temp = new HashMap<String, String>();

                temp.put("name", contacts.getString(contacts.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)));
                int n = Integer.parseInt(contacts.getString(contacts.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER)));
                if (n > 0) {
                    Cursor phoneNumber = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ? ", new String[]{contacts.getString(contacts.getColumnIndex(ContactsContract.Contacts._ID))}, null);
                    //while(phoneNumber.moveToNext()){
                    phoneNumber.moveToNext();
                    String phone = phoneNumber.getString(phoneNumber.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                    temp.put("number", phone);
                    //}
                }
                list_cont.add(temp);
            }
            textV.setText("Total contacts: "+contacts.getCount());
        }
        catch (Exception e){

        }
        //for(int i=0;i<15;i++) {

        //}
        String[] keys={"name", "number"};
        int[] ids1 = {R.id.name, R.id.number};
        SimpleAdapter adapt = new SimpleAdapter(this, list_cont,R.layout.cont, keys, ids1);
        list.setAdapter(adapt);
        //list.notifyAll();
    }
}

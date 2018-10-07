package com.example.ahmadspc.bonus;

import android.content.Context;
import android.graphics.Bitmap;
import android.icu.util.RangeValueIterator;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import android.widget.Toolbar;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class MainActivity extends AppCompatActivity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);
       //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       //setSupportActionBar(toolbar);

       try {
           WriteFile();
           WriteIn();
           getTempFile(this, "/sdcard");
       } catch (IOException e) {
           e.printStackTrace();
       }

   }

   public void WriteIn() throws IOException{
       String filename = "myfile";
       String fileContents = "Hello world!";
       FileOutputStream outputStream;

       try {
           outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
           outputStream.write(fileContents.getBytes());
           outputStream.close();
       } catch (Exception e) {
           e.printStackTrace();
       }

   }

    public void WriteFile() throws IOException {
        if(isExternalStorageWritable()) {
            Toast.makeText(this, "Accessible ", Toast.LENGTH_LONG).show();
            File dir=Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);

            /*if(new File("/sdcard").exists()) {
                Toast.makeText(this, "Accessible " + dir, Toast.LENGTH_LONG).show();
            }*/

            File myDir=new File(dir.toString()+"/InternalDownloadFolder");
            if (!myDir.exists()) {
                myDir.mkdirs();
            }

            File f = new File(dir, "myFile.txt");

            FileOutputStream fos = new FileOutputStream(f);

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            bw.write("hello world");
            bw.close();

            f=new File(myDir,"myFile.txt");
            fos=new FileOutputStream(f);
            bw = new BufferedWriter(new OutputStreamWriter(fos));
            bw.write("abcdef");
            bw.close();
        }
    }

    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }



    private void getTempFile(Context context, String url) {
        File file;
        try {
            String fileName = Uri.parse(url).getLastPathSegment();
            file = File.createTempFile(fileName, null, context.getCacheDir());
            Toast.makeText(this, "Accessible " + context.getCacheDir(), Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            // Error while creating file
        }
        //return file;
    }


//    public void saveImageToExternalStorage(Bitmap image) {
//        String fullPath = Environment.getExternalStorageDirectory().getAbsolutePath(RangeValueIterator.Element);
//        try
//        {
//            File dir = new File(fullPath);
//            if (!dir.exists()) {
//                dir.mkdirs();
//            }
//            OutputStream fOut = null;
//            File file = new File(fullPath, "image.png");
//            if(file.exists())
//                file.delete();
//            file.createNewFile();
//            fOut = new FileOutputStream(file);
//            // 100 means no compression, the lower you go, the stronger the compression
//            image.compress(Bitmap.CompressFormat.PNG, 100, fOut);
//            fOut.flush();
//            fOut.close();
//        }
//        catch (Exception e)
//        {
//            Log.e("saveToExternalStorage()", e.getMessage());
//        }
//    }

}

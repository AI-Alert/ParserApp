package com.example.parserapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

//public class MainActivity extends Activity {
//    public Elements content;
//    public ArrayList<String> titlelist = new ArrayList<String>();
//    private ArrayAdapter<String> adapter;
//    private ListView listView;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        listView = (ListView) findViewById(R.id.list_view1);
//        new NewThread().execute();
//        adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.text_item, titlelist);
//
//
//    }
//
//    public class NewThread extends AsyncTask<String, Void, String>{
//        @Override
//        protected String doInBackground(String... arg){
//            Document doc;
//            try {
//                doc = Jsoup.connect("https://akipress.org").get();
//                content = doc.select("h3.rpwe-title");
//                titlelist.clear();
//                for (Element contents: content){
//                    titlelist.add(contents.text());
//
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            return null;
//        }
//        @Override
//        protected void onPostExecute(String result){
//            listView.setAdapter(adapter);
//        }
//    }
//
//
//}



public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.tex_1);
        Button but = (Button) findViewById(R.id.btn_1);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new textparse().execute();
            }
        });
    }
    public class textparse extends AsyncTask<Void, Void, Void> {
        String words;

        @Override
        protected Void doInBackground(Void...params) {
            try {
                Document doc = Jsoup.connect("https://ru.sputnik.kg/keyword_universitety/").get();
                doc.select("a.list__title");
                words = doc.text();
            } catch(Exception e){e.printStackTrace();}
            return null;
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            textView.setText(words);
        }
    }
}
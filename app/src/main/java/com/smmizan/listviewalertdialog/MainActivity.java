package com.smmizan.listviewalertdialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;

import android.app.AlertDialog;

import android.content.DialogInterface;

import android.view.LayoutInflater;

import android.view.View;

import android.view.View.OnClickListener;

import android.widget.AdapterView;

import android.widget.AdapterView.OnItemClickListener;

import android.widget.Button;

import android.widget.ListView;

import android.widget.TextView;

import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnDialog;

    AlertDialog.Builder alertDialog;

    ArrayList<String> myList;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        textView = (TextView) findViewById(R.id.textView);

        myList = new ArrayList<String>();

        myList.add("One");
        myList.add("Two");
        myList.add("Three");
        myList.add("Four");
        myList.add("Five");
        myList.add("Six");
        myList.add("Seven");
        myList.add("Eight");
        myList.add("Nine");
        myList.add("Ten");
        myList.add("Eleven");
        myList.add("Twelve");
        myList.add("Thirteen");
        myList.add("Fourteen");
        myList.add("Fifteen");
        myList.add("Sixteen");
        myList.add("Seventeen");

        alertDialog = new AlertDialog.Builder(MainActivity.this);

        btnDialog = (Button) findViewById(R.id.btnDialog);

        btnDialog.setOnClickListener(new OnClickListener() {

            @Override

            public void onClick(View v) {

                // TODO Auto-generated method stub

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(

                        MainActivity.this);

                LayoutInflater inflater = getLayoutInflater();

                View convertView = (View) inflater.inflate(R.layout.second_actitity, null);

                alertDialog.setNegativeButton("Cancel",

                        new DialogInterface.OnClickListener() {

                            @Override

                            public void onClick(DialogInterface dialog,

                                                int which) {

                                // TODO Auto-generated method stub



                            }

                        });



                // add custom view in alert dialog

                alertDialog.setView(convertView);

                ListView listView = (ListView) convertView.findViewById(R.id.mylistview);

                final AlertDialog alert = alertDialog.create();

                alert.setTitle("Select Your Items...."); // Title

                MyCustomAdapter myadapter = new MyCustomAdapter(MainActivity.this,

                        R.layout.list_item, myList);

                listView.setAdapter(myadapter);

                listView.setOnItemClickListener(new OnItemClickListener() {

                    @Override

                    public void onItemClick(AdapterView<?> arg0, View arg1,

                                            int position, long arg3) {

                        // TODO Auto-generated method stub

                        Toast.makeText(MainActivity.this,

                                "You have selected -: " + myList.get(position),

                                Toast.LENGTH_SHORT).show();


                        textView.setText(myList.get(position));

                        alert.cancel();

                    }

                });

                alert.show();

            }

        });

    }
}

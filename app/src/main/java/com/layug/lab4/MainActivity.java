package com.layug.lab4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    String[] com, coun, ind, ceo, description;
    ListView list;
    int[] cLogo = {R.drawable.icbc, R.drawable.jpm, R.drawable.ccb, R.drawable.agri, R.drawable.boa,
            R.drawable.apple, R.drawable.ping, R.drawable.boc, R.drawable.shell, R.drawable.wells,
            R.drawable.exxon, R.drawable.att, R.drawable.samsung, R.drawable.citi};

    ArrayList<Version> VersionList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        com = getResources().getStringArray(R.array.company);
        coun = getResources().getStringArray(R.array.country);
        ind = getResources().getStringArray(R.array.industry);
        ceo = getResources().getStringArray(R.array.ceo);
        description = getResources().getStringArray(R.array.description);
        list = findViewById(R.id.lvVersions);
        for(int i = 0; i < com.length; i++){
            VersionList.add(new Version(cLogo[i], com[i], coun[i], ind[i], ceo[i], description[i]));
        }
        list = findViewById(R.id.lvVersions);
        VersionAdapter adapter = new VersionAdapter(this, R.layout.item ,VersionList);
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);

    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, final int i, long id) {


        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle(VersionList.get(i).getCompany());
        dialog.setIcon(VersionList.get(i).getLogo());
        final String com = VersionList.get(i).getCompany();
        final String coun = VersionList.get(i).getCountry();
        final String ceo = VersionList.get(i).getCeo();
        dialog.setMessage(VersionList.get(i).getDescription());
        dialog.setNeutralButton("CLOSE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick (DialogInterface dialog,int which){
                dialog.dismiss();
                Toast.makeText(MainActivity.this, com + "" + "(" + coun + ")" + "\n" + ceo, Toast.LENGTH_LONG).show();
            }
        });
        dialog.create().show();


    }

    //Toast.makeText(this, api[i], Toast.LENGTH_LONG).show();
}

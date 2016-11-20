package csitmnr.acid;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Manoj Budha Ayer on 11/5/2016.
 */
public class NavDrawer extends AppCompatActivity {
    ListView l;
    TextView tv;
    DrawerLayout drawerlayout;
    View v;
    List<String> ls =new  ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.nav_drawer);
        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setHomeButtonEnabled(true);
        ab.setDisplayHomeAsUpEnabled(true);

        drawerlayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        v = findViewById(R.id.drawerview);

        l = (ListView) findViewById(R.id.country);

        ls.add("Nepal");
        ls.add("Japan");
        ls.add("Brazil");

        ArrayAdapter<String> ad = new ArrayAdapter<String>(this,R.layout.list_item,ls) ;
        l.setAdapter(ad);
        tv = (TextView) findViewById(R.id.new1);
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Snackbar.make(view,adapterView.getItemAtPosition(i)+" is selected",Snackbar.LENGTH_SHORT).show();
                drawerlayout.closeDrawer(v);
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}

package csitmnr.acid;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Manoj Budha Ayer on 11/6/2016.
 */
public class DatabaseIll extends AppCompatActivity {
    EditText e1,e2,e3;
    Button b1,b2,b3,b4;
    TextView t1;
    DBHelper dbh;
    ListView lv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.database_ill);

        dbh = new DBHelper(this);

        e1 = (EditText) findViewById(R.id.dbname);
        e2 = (EditText) findViewById(R.id.dbclass);
        b1 = (Button) findViewById(R.id.dbinsert);
        b2= (Button) findViewById(R.id.dbshow);
        t1 = (TextView) findViewById(R.id.dbdisplay);
        t1.setMovementMethod(new ScrollingMovementMethod());
        e3= (EditText) findViewById(R.id.dbid);
        b4 = (Button) findViewById(R.id.btdelete);
        b3 = (Button) findViewById(R.id.dbupdate);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = e1.getText().toString();
                String grade = e2.getText().toString();
                boolean result = dbh.insertData(name,grade);

                if (result){
                    Toast.makeText(DatabaseIll.this,"Successfully inserted",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(DatabaseIll.this,"Database Failed",Toast.LENGTH_LONG).show();
                }

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data= null;
                Cursor result = dbh.getAlldata();
                int count = result.getCount();

                if(count == 0){
                    data = "Data is not found";
                }else {
                    while(result.moveToNext()){
                        data = data + result.getString(1)+" "+result.getString(2)+"\n";

                    }
                }
                t1.setText(data);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = e1.getText().toString();
                String grade = e2.getText().toString();
                String id = e3.getText().toString();
                dbh.upDateData(name, grade, id);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = e3.getText().toString();
                Integer result = dbh.deleteData(id);
                if (result>0){
                    Toast.makeText(DatabaseIll.this,"Deleted Successfully",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(DatabaseIll.this,"Sorry Cant Deleted",Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}

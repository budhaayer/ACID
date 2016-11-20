package csitmnr.acid;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView l;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        l = (ListView) findViewById(R.id.lv1);

        List <String> ls = new ArrayList<>();
            ls.add("AlertBox");
            ls.add("FlashLight");
            ls.add("Data Communication");
            ls.add("Action Bar");
            ls.add("Login");
            ls.add("Notificatio");
            ls.add("CustomLV");
            ls.add("FragmentDemo");
            ls.add("Swap Tag");
            ls.add("ScrollTextView");
            ls.add("NavDrawer");
            ls.add("Data Illustratar");
            ls.add("Messanger");
            ls.add("Caller");
            ls.add("SnackBar/FAB");
            ls.add("Json Parsor");
            ls.add("Image Loader");
            ls.add("Post Using Volley");
            ls.add("Upload Image");
            ls.add("PDF viewer");
            ls.add("Google map");
            ls.add("Camera");
            ls.add("Music Player");
            ls.add("Custom List");
            ls.add("Other");
        ArrayAdapter<String> ad = new ArrayAdapter<String>(this,R.layout.list_item,ls);
        l.setAdapter(ad);

        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i==0){
                    AlertDialog.Builder adb= new AlertDialog.Builder(MainActivity.this);
                        adb.setTitle("Alert");
                        adb.setMessage("Do you rally want to delete!");
                        adb.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainActivity.this,"You clicked Yes",Toast.LENGTH_SHORT).show();
                            }
                        });
                        adb.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainActivity.this,"You click No",Toast.LENGTH_SHORT).show();
                            }
                        });
                        adb.setNeutralButton("Cancle", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainActivity.this,"You Click Cancle",Toast.LENGTH_SHORT).show();

                            }
                        });
                    adb.show();
                }
                    else if(i==2){
                    Intent in = new Intent("csitmnr.acid.DATACOMM");
                    String data = "Data to be transferred";
                    Bundle b = new Bundle();
                    b.putString("dt",data);
                    in.putExtras(b);
                    startActivity(in);
                }
                else if (i==3){
                    Intent in = new Intent("csitmnr.acid.ACTIONBAR");
                    startActivity(in);
                }
                else if (i==4){
                    Intent in = new Intent("csitmnr.acid.LOGINACTIVITY");
                    startActivity(in);
                }else if (i==5){
                    Intent in = new Intent("csitmnr.acid.NOTIFICATION");
                    startActivity(in);
                }
                else if (i==6){
                    Intent in = new Intent("csitmnr.acid.CUSTOMLV");
                    startActivity(in);
                }
                else if(i== 7){
                    Intent in =new Intent("csitmnr.acid.FRAGMENTDEMO");
                    startActivity(in);
                }
                else if (i== 8){
                    Intent in = new Intent("csitmnr.acid.SWAPTAG");
                    startActivity(in);
                }else if(i==10){
                    Intent in = new Intent("csitmnr.acid.NAVDRAWER");
                    startActivity(in);

                }else if(i==11){
                    Intent in = new Intent("csitmnr.acid.DATABASEILL");
                    startActivity(in);
                }else if(i ==12){
                    Intent in = new Intent(MainActivity.this,Messanger.class);
                    startActivity(in);
                }else if(i ==13){
                    Intent in = new Intent(MainActivity.this,Caller.class);
                    startActivity(in);
                }else if(i==14){
                    Intent in = new Intent(MainActivity.this,Sfab.class);
                    startActivity(in);
                }else if(i==1){
                    Intent in = new Intent(MainActivity.this,FlashLight.class);
                    startActivity(in);
                }else if (i==15){
                    Intent in = new Intent(MainActivity.this,JsonParsor.class);
                    startActivity(in);

                }else if (i==16){

                    Intent in = new Intent(MainActivity.this,VolleyImage.class);
                    startActivity(in);
                }else if (i==17){
                    Intent in = new Intent(MainActivity.this,VolleyPost.class);
                    startActivity(in);
                }else if (i==18){
                    Intent in = new Intent(MainActivity.this,PostImage.class);
                    startActivity(in);
                }else if (i==19){
                    Intent in = new Intent(MainActivity.this,PDFViewer.class);
                    startActivity(in);
                }else if(i==20){
                    Intent in = new Intent(MainActivity.this,GMap.class);
                    startActivity(in);
                }
            }
        });
    }
}

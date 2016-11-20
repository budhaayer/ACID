package csitmnr.acid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.internal.view.menu.MenuView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Manoj Budha Ayer on 10/24/2016.
 */
public class CustomLV extends AppCompatActivity {
    ListView lv;
    List<Product> l = new ArrayList<Product>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.customlv);

        lv = (ListView) findViewById(R.id.customlv);



        l.add(new Product("CPU","This is dual core from Intel 2.40GZ","12$",R.drawable.application_exit));
        l.add(new Product("RAM","This is dual core from Intel 2.40GZ","12$",R.drawable.application_exit));
        l.add(new Product("DELL","This is dual core from Intel 2.40GZ","12$",R.drawable.application_exit));
        l.add(new Product("ACER","This is dual core from Intel 2.40GZ","12$",R.drawable.application_exit));
        l.add(new Product("SAMSUNG","This is dual core from Intel 2.40GZ","12$",R.drawable.application_exit));
        l.add(new Product("MOTHERBOARD","This is dual core from Intel 2.40GZ","12$",R.drawable.application_exit));
        l.add(new Product("CU","This is dual core from Intel 2.40GZ","12$",R.drawable.application_exit));
        l.add(new Product("ALU","This is dual core from Intel 2.40GZ","12$",R.drawable.application_exit));
        l.add(new Product("LUX","This is dual core from Intel 2.40GZ","12$",R.drawable.application_exit));
        l.add(new Product("SABUN","This is dual core from Intel 2.40GZ","12$",R.drawable.application_exit));

        ArrayAdapter<Product> ad = new MyListAdapter();
        lv.setAdapter(ad);
    }
    public class MyListAdapter extends ArrayAdapter<Product> {
        public MyListAdapter() {
            super(CustomLV.this,R.layout.custom_listitem,l);

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View itemView = convertView;
            if (convertView==null){
                itemView = getLayoutInflater().inflate(R.layout.custom_listitem,parent,false);
            }
            Product currentProduct = l.get(position);
            ImageView imageView = (ImageView) itemView.findViewById(R.id.lvicon);
            TextView titleView = (TextView) itemView.findViewById(R.id.lvtitle);
            final TextView descView = (TextView) itemView.findViewById(R.id.lvdesc);
            TextView priceView = (TextView) itemView.findViewById(R.id.lvprice);

            imageView.setImageResource(currentProduct.getIcon());
            titleView.setText(currentProduct.getTitle());
            descView.setText(currentProduct.getDesc());
            priceView.setText(currentProduct.getPrice());
           lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
               @Override
               public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                   if (i==1){
                       descView.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               Intent in = new Intent("csitmnr.acid.ACTIONBAR");
                               startActivity(in);
                           }
                       });

                   }
               }
           });

            return itemView;

        }
    }
}

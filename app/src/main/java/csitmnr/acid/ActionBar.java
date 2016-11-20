package csitmnr.acid;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * Created by Manoj Budha Ayer on 10/21/2016.
 */
public class ActionBar extends AppCompatActivity {
    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.actionbar);

        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setTitle("Accountbar Illusration");
        ab.setSubtitle("This is test");
        ColorDrawable cd = new ColorDrawable(Color.parseColor("#fb6904"));
        ab.setBackgroundDrawable(cd);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id==R.id.action_settings){

        }
        else if (id==R.id.exit){


        }
        else if(id==R.id.refresh)
        {

        }
        return super.onOptionsItemSelected(item);
    }
}

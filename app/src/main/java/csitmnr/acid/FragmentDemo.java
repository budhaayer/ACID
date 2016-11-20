package csitmnr.acid;


import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Manoj Budha Ayer on 10/25/2016.
 */
public class FragmentDemo extends AppCompatActivity implements Communicator {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_demo);


    }

    @Override
    public void respond(String data) {
        FragmentManager manager= getSupportFragmentManager();
        FragmentB fb = (FragmentB) manager.findFragmentById(R.id.fragmentB);

        fb.changedData(data);
    }
    public void respond(int position){
        FragmentManager manager = getSupportFragmentManager();
        FragmentB fb = (FragmentB) manager.findFragmentById(R.id.fragmentB);

        fb.changedData(position);
    }
}

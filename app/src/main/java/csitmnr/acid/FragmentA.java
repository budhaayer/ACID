package csitmnr.acid;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Manoj Budha Ayer on 10/25/2016.
 */
public class FragmentA extends Fragment{
    Button b;
    ListView lv;
    int counter = 0;
    int position;
    Communicator comm;
    List<String> ls = new ArrayList<String>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_a,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        comm = (Communicator) getActivity();
        b = (Button) getActivity().findViewById(R.id.fragAbtn);
        lv = (ListView) getActivity().findViewById(R.id.newlv1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                counter++;
                comm.respond("The button is clicked " + counter + " times");
            }
        });
        ls.add("CPU");
        ls.add("ROM");
        ls.add("MOTHERBOARD");
        ls.add("KEYBOARD");

        ArrayAdapter<String> ad = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,ls);
        lv.setAdapter(ad);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                comm.respond(i);
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("count",counter);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(savedInstanceState==null){

        }
        else {
            counter = savedInstanceState.getInt("count");
        }
    }
}

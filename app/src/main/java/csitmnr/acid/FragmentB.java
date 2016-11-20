package csitmnr.acid;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Manoj Budha Ayer on 10/25/2016.
 */
public class FragmentB extends Fragment {
   TextView t;
    List<String> des = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_b,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
     t = (TextView) getActivity().findViewById(R.id.fragBtv);
        des.add("CUP with good processing speed");
        des.add("Is a primary memory");
        des.add("Aconnector");
        des.add("Input device.");

    }

    public void changedData(String data){
        t.setText(data);

    }
    public void changedData(int position){
        t.setText(des.get(position));
    }
}

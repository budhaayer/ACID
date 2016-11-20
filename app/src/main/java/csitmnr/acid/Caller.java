package csitmnr.acid;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Caller extends AppCompatActivity {
    EditText e1;
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caller);

        e1 = (EditText) findViewById(R.id.callnumber);
        b1 = (Button) findViewById(R.id.callsend);
        b2 = (Button) findViewById(R.id.dailsend);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String cnum = e1.getText().toString();
                Intent in = new Intent(Intent.ACTION_CALL);
                in.setData(Uri.parse("tel:"+cnum));
                startActivity(in);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cnum = e1.getText().toString();
                Intent in = new Intent(Intent.ACTION_DIAL);
                in.setData(Uri.parse("tel:"+cnum));
                startActivity(in);

            }
        });
    }
}

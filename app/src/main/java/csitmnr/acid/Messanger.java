package csitmnr.acid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Messanger extends AppCompatActivity {
    EditText e1,e2;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messanger);
        e1  = (EditText) findViewById(R.id.message);
        e2 = (EditText) findViewById(R.id.number);
        b1 = (Button) findViewById(R.id.mbutton);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg = e1.getText().toString();
                String number = e2.getText().toString();

                SmsManager sm = SmsManager.getDefault();
                sm.sendTextMessage(number,null,msg,null,null);
                // receivers number , senders details , actual message

            }
        });

    }
}

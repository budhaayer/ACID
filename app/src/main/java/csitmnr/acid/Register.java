package csitmnr.acid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Manoj Budha Ayer on 10/22/2016.
 */
public class Register extends AppCompatActivity{
    TextView loginnow;
    EditText rfullname,rusername,rpassword,rconfirmpassword;
    Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);
        loginnow = (TextView) findViewById(R.id.loginnow1);

        rfullname= (EditText) findViewById(R.id.fullname1);
        rusername= (EditText) findViewById(R.id.username);
        rpassword= (EditText) findViewById(R.id.password1);
        rconfirmpassword = (EditText) findViewById(R.id.password12);
        register = (Button) findViewById(R.id.register);

        loginnow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent("csitmnr.acid.LOGINACTIVITY");
                startActivity(in);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullname = rfullname.getText().toString();
                String username= rusername.getText().toString();
                String password = rpassword.getText().toString();
                String cpassword = rconfirmpassword.getText().toString();

                Set<String> st =new HashSet<String>();
                st.add("abc");
                st.add("def");

                if(!fullname.equals("") && !password.equals("") && !username.equals("") && !cpassword.equals("") && password.equals(cpassword)){

                    SharedPreferences data = getSharedPreferences("acid",0);
                    SharedPreferences.Editor edi=data.edit();
                    edi.putString("fullname",fullname);
                    edi.putString("username",username);
                    edi.putString("password",password);
                    edi.putStringSet("ac",st);
                    edi.commit();
                        Toast.makeText(Register.this,"Registeration sucessful",Toast.LENGTH_SHORT).show();
                    rfullname.setText("");
                    rusername.setText("");
                    rpassword.setText("");
                    rconfirmpassword.setText("");
                }
                else {
                    Toast.makeText(Register.this,"Register fails",Toast.LENGTH_SHORT).show();
                }
        }});

    }
}

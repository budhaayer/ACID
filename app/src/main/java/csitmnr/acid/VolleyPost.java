package csitmnr.acid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class VolleyPost extends AppCompatActivity {
    EditText e1,e2;
    Button b1;
    String name,email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.volley_post);
        e1 = (EditText) findViewById(R.id.postname);
        e2 = (EditText) findViewById(R.id.postemail);
        b1 = (Button) findViewById(R.id.post);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = e1.getText().toString();
                email = e2.getText().toString();
                makeJsonObjectRequest();
            }
        });
    }
    private void makeJsonObjectRequest(){
        StringRequest sr = new StringRequest(Request.Method.POST, "http://192.168.43.79/phpcrawler/senddata.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(VolleyPost.this,response.toString(),Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(VolleyPost.this,error.getMessage(),Toast.LENGTH_LONG).show();
            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("name",name);
                params.put("email",email);

                return params;

            }
        };
        AppController.getInstance().addToRequestQueue(sr);
    }
}



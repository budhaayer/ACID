package csitmnr.acid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

public class VolleyImage extends AppCompatActivity {
    Button b1;
    NetworkImageView niv;
    ImageLoader imageLoader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.volley_image);
        niv = (NetworkImageView) findViewById(R.id.niv);
        b1 = (Button) findViewById(R.id.loadni);
        imageLoader = AppController.getInstance().getImageLoader();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                niv.setImageUrl("http://images.slideplayer.com/16/4957212/slides/slide_33.jpg",imageLoader);
            }
        });
    }

}

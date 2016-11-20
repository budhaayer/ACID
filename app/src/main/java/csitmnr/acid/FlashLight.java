package csitmnr.acid;

import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.hardware.Camera;
import android.media.MediaPlayer;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FlashLight extends AppCompatActivity {
    Button b1;
    TextView linktv,customfont;
    boolean isFlashOn,hasFlash;
    Camera.Parameters params;
    MediaPlayer mp;
    Camera camera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_light);
        linktv = (TextView) findViewById(R.id.linktv);
        b1 = (Button) findViewById(R.id.fon);
        customfont = (TextView) findViewById(R.id.customfont);

        Typeface customface = Typeface.createFromAsset(getAssets(),"fonts/newfont.ttf");
        customfont.setTypeface(customface);
        customfont.setText("jaldfsdfjlflelldsklfidfla;ljdflfjlflfljjdie");

        String text = "<a href='http://facebook.com'>Facebook</a>";
        linktv.setLinksClickable(true);
        linktv.setMovementMethod(LinkMovementMethod.getInstance());
        linktv.setText(Html.fromHtml(text));



        hasFlash = getApplicationContext().getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
        if(!hasFlash){
            finish();
        }
        camera = Camera.open();
        params = camera.getParameters();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if (b1.getText().toString().equals("on")){
                   turnOnFlash();
                   b1.setText("off");
               }
                else if(b1.getText().toString().equals("off")){
                    turnOffFlash();
                   b1.setText("on");
                }

            }
        });
    }
    public void turnOnFlash(){
        if (!isFlashOn){
            params = camera.getParameters();
            params.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
            camera.setParameters(params);
            camera.startPreview();
            isFlashOn = true;
            mp = MediaPlayer.create(this,R.raw.click);
            mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mp.release();
                }
            });
            mp.start();
        }
    }
    public void turnOffFlash(){
        if(isFlashOn){
            params = camera.getParameters();
            params.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
            camera.setParameters(params);
            camera.stopPreview();
            isFlashOn = false;
            mp = MediaPlayer.create(this,R.raw.click);
            mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mp.release();
                }
            });
            mp.start();
        }
    }
}

package csitmnr.acid;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Manoj Budha Ayer on 10/23/2016.
 */
public class Notificatio extends AppCompatActivity {
  Button b;
            String nottitle = "New Notificatio";
            String notmessage = "This is new message";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification);
        b= (Button) findViewById(R.id.btnnotify);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationManager nmanager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                Notification notification = new Notification(R.drawable.application_exit,nottitle,System.currentTimeMillis());
                Intent notIntent = new Intent("csitmnr.acid.NOTIFICATION");
                PendingIntent pIntent = PendingIntent.getActivity(Notificatio.this,0,notIntent,0);
                notification.setLatestEventInfo(Notificatio.this,nottitle,notmessage,pIntent);
                nmanager.notify(9999,notification);

            }
        });
    }
}

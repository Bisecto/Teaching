package ken.example.anew;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Notification extends AppCompatActivity {
String CHANNEL_ID;

int Notificaton_ID= 001;
Button btn;
NotificationChannel notificationChannel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        btn= findViewById(R.id.btn);
    }
    public  void showNoitfication(View view){
        NotificationManager notificationManager= (NotificationManager) this.getSystemService(this.NOTIFICATION_SERVICE);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            CHANNEL_ID="MY_CHANNEL_ID";
            String NAME="MY_CHANNEL";
            String DESCRIPTION ="This is actually my channel";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel notificationChannel= new NotificationChannel(CHANNEL_ID,NAME,importance);
            notificationChannel.setDescription(DESCRIPTION);
            notificationChannel.enableLights(true);
            notificationChannel.enableVibration(true);
            notificationChannel.setShowBadge(false);
            notificationManager.createNotificationChannel(notificationChannel);

        }
        NotificationCompat.Builder builder= new NotificationCompat.Builder(this,CHANNEL_ID);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle("A Tittle");
        builder.setContentText("its suposed to say a tittle");

        Intent i = new Intent(Notification.this, MainActivity.class);
        TaskStackBuilder stackBuilder= null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
            stackBuilder = TaskStackBuilder.create(this);
            stackBuilder.addParentStack(Notification.class);
            stackBuilder.addNextIntent(i);

            PendingIntent pendingIntent= stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
            builder.setContentIntent(pendingIntent);
            notificationManager.notify(Notificaton_ID,builder.build());
        }



    }

    public void notify(View view) {
        showNoitfication(view);
    }
}
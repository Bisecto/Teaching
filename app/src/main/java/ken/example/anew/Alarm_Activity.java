package ken.example.anew;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Alarm_Activity extends AppCompatActivity {
    Calendar calender1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_);
        setAlarm(this);
    }
    public void setAlarm(Context context){
        String string1= "15:35:00";
        Date time1=null;
        try {
            time1=new SimpleDateFormat("HH:mm:ss").parse(string1);
            calender1 = Calendar.getInstance();
            calender1.setTime(time1);
            calender1.add(Calendar.DATE,1);
            AlarmManager am= (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
            Intent i= new Intent(context, alarm.class);
            Toast.makeText(this, "dhh", Toast.LENGTH_SHORT).show();
            PendingIntent pi= PendingIntent.getBroadcast(context,0,i,0);
            am.setRepeating(AlarmManager.RTC_WAKEUP, calender1.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pi);
        } catch (ParseException e){
            e.printStackTrace();
        }
    }


}
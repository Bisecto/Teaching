package ken.example.anew;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

      Button btn;
      TextView txt;
      Button apply;
      int num;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.button);
        txt=findViewById(R.id.text);
        //apply=findViewById(R.id.but);
        num=0;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num++;
                txt.setText("you Clicked the button"+ String.valueOf(num) +"times");

                if (num==5){
                   System.exit(0);

                }
            }
        });
    }
  public void openpage(View view){
        Intent intent = new Intent (this,ImageSliderActivity.class);
        startActivity(intent);
  }

    public void browser(View view) {
           Intent intent = new Intent(MainActivity.this,browser.class);

        startActivity(intent);
    }

    public void shareprefrence(View view) {
        Intent intent = new Intent(MainActivity.this,SharePrefrence.class);

        startActivity(intent);

    }

    public void List(View view) {
        Intent intent = new Intent(MainActivity.this, ListviewActivity.class);

        startActivity(intent);
        //how to swipe in a fragment using viewpager.
    }

    public void volley(View view) {
        Intent intent = new Intent(MainActivity.this, volley.class);

        startActivity(intent);

    }

    public void webview(View view) {
        Intent intent = new Intent(MainActivity.this, WebviewActivity2.class);

        startActivity(intent);
    }

    public void Fragment(View view) {
        Intent intent = new Intent(MainActivity.this, FragmentActivity.class);

        startActivity(intent);
    }

    public void Fragment2(View view) {
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);

        startActivity(intent);
    }

    public void sql(View view) {
        Intent intent = new Intent(MainActivity.this, SQLiteActivity.class);

        startActivity(intent);
    }

    public void Alarm(View view) {
        Intent i= new Intent(MainActivity.this, Alarm_Activity.class);
        startActivity(i);
    }
}
package ken.example.anew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class SplashScreenActivity extends AppCompatActivity {
    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        logo = findViewById(R.id.logo);
        Thread thread= new Thread() {
            public void run() {
                try {
                    sleep(5000);
                    Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                    finish();

                    startActivity(intent);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        };
        thread.start();
    }
}
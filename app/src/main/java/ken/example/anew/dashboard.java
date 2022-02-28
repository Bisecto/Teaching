package ken.example.anew;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class dashboard extends AppCompatActivity {
TextView name, username,pass, gen;
    String uname, uusername, upassword, ugender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        username = findViewById(R.id.username);
        name = findViewById(R.id.name);
       uname = getIntent().getStringExtra("iname");
        uusername = getIntent().getStringExtra("iusername");
        upassword = getIntent().getStringExtra("ipassword");
        ugender = getIntent().getStringExtra("igender");
        name.setText(uname);
        username.setText(ugender);


        Bundle bundle = getIntent().getExtras();
        String bund = bundle.getString("iname");
        Log.i("my bundle message", bund);

    }
}
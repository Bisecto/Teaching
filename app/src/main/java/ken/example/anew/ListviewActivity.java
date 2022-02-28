package ken.example.anew;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ListView;

import java.util.ArrayList;

public class ListviewActivity extends AppCompatActivity {
    LayoutInflater inflater;
    ArrayList<String> firstname,lastname,email,image;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        firstname= new ArrayList<>();
        lastname= new ArrayList<>();
        email= new ArrayList<>();
        image= new ArrayList<>();

        listView=  findViewById(R.id.listview);
        firstname.add("precious");
        firstname.add("james");
        firstname.add("samuel");
        firstname.add("jake");

        lastname.add("okafor");
        lastname.add("okeke");
        lastname.add("anih");
        lastname.add("nwankwo");

        email.add("precious@gmail.com");
        email.add("james@gmail.com");
        email.add("samuel@gmail.com");
        email.add("jake@gmail.com");

        arrayadapter array = new arrayadapter(this, firstname,lastname,email,image);
        listView.setAdapter(array);
        Log.i("erro",String.valueOf(firstname.size()));

    }
}
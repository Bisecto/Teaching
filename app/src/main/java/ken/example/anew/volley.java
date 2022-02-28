package ken.example.anew;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URI;

public class volley extends AppCompatActivity {
Context context;
LinearLayout container;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley);
        container= findViewById(R.id.container);
        Toast.makeText(volley.this, "continue", Toast.LENGTH_LONG).show();
        final LayoutInflater inflater = LayoutInflater.from(this);
                StringRequest request = new StringRequest(com.android.volley.Request.Method.GET, "https://reqres.in/api/users?pages=2", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i("myresponse",response);
                URI url=null;
                Toast.makeText(volley.this, "Succesfully", Toast.LENGTH_LONG).show();
                try {
                JSONObject jasonobject= new JSONObject(response);
                JSONArray jsonarray = jasonobject.getJSONArray("data");

                for    (int i = 0; i<jsonarray.length(); i++){
                    JSONObject obj= jsonarray.getJSONObject(i);
                       String firstname = obj.optString("first_name");
                       String lastname = obj.optString("last_name");
                       String image = obj.optString("avatar");
                       String id = String.valueOf(obj.optInt("id"));
                       String emai =obj.optString("email");

                    View view = inflater.inflate(R.layout.populate_list,container,false);
                    TextView text1 = view.findViewById(R.id.edit1);
                    TextView text2 = view.findViewById(R.id.edit2);
                    TextView text3 = view.findViewById(R.id.edit3);
                    TextView text4 = view.findViewById(R.id.edit4);
                    ImageView img= view.findViewById(R.id.img);
                    Toast.makeText(volley.this, image, Toast.LENGTH_LONG).show();
                    Picasso.get().load("https://homepages.cae.wisc.edu/~ece533/images/fruits.png").into(img);
                    text1.setText(id);
                    text2.setText(firstname);
                    text3.setText(lastname);
                    text4.setText(emai);
                   // img.setImageDrawable(Drawable.createFromPath(avatar));
                    container.addView(view);


                    }
               } catch (JSONException e) {
                    e.printStackTrace();
               }




            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                Log.i("myresponse",String.valueOf(error));
                Toast.makeText(volley.this, "This is an error", Toast.LENGTH_LONG).show();


                //check for all the errir
            }

        }
        );
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(request);
    }
}
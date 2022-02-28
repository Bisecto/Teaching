package ken.example.anew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class SQLiteActivity extends AppCompatActivity {
EditText f_name,l_name,e_name,p_no,about;
Button save, access;
    DatabaseHelper databaseHelpe;
    String fn,ln,em,ph,ab;
    boolean isUpdate;
    String fname,lname,ename,pno,abo,id;
    int i;

@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_s_q_lite);
    //homeAddress = (EditText)findViewById(R.id.edit_address);
    f_name=(EditText) findViewById(R.id.f_name);
    l_name= (EditText)findViewById(R.id.l_name);
    e_name=(EditText) findViewById(R.id.e_name);
    p_no=(EditText) findViewById(R.id.p_no);
    about=(EditText) findViewById(R.id.about);
    save= findViewById(R.id.save);
    access= findViewById(R.id.access);

//   databaseHelpe = new DatabaseHelper(this);
//    fname = getIntent().getStringExtra("firstname");
//    lname = getIntent().getStringExtra("lastname");
//    ename= getIntent().getStringExtra("email");
//    pno = getIntent().getStringExtra("phone");
//    abo = getIntent().getStringExtra("about");
//    id = getIntent().getStringExtra("id");



    }

//    public void Update(View view) {
//        f_name=(EditText) findViewById(R.id.f_name);
//        l_name= (EditText)findViewById(R.id.l_name);
//        e_name=(EditText) findViewById(R.id.e_name);
//        p_no=(EditText) findViewById(R.id.p_no);
//        about=(EditText) findViewById(R.id.about);
//        //String id= String.valueOf(id.ge)
//        fn= String.valueOf(f_name.getText());
//        ln= String.valueOf(l_name.getText());
//        ph= String.valueOf(p_no.getText());
//        em= String.valueOf(e_name.getText());
//        ab= about.getText().toString();
//
//        isUpdate=databaseHelpe.UpdateRow(String.valueOf(id),fn,ln,em,ph,ab);
//        if (isUpdate==true){
//            Toast.makeText(SQLiteActivity.this, "Sucessful", Toast.LENGTH_LONG).show();
//        } else {
//            Toast.makeText(SQLiteActivity.this, "Not Sucessful", Toast.LENGTH_LONG).show();
//        }
//    }


    public void save(View view) {
        databaseHelpe= new DatabaseHelper(SQLiteActivity.this);
       // Toast.makeText(SQLiteActivity.this,"123456789", Toast.LENGTH_LONG).show();
        f_name=(EditText) findViewById(R.id.f_name);
        l_name= (EditText)findViewById(R.id.l_name);
        e_name=(EditText) findViewById(R.id.e_name);
        p_no=(EditText) findViewById(R.id.p_no);
        about=(EditText) findViewById(R.id.about);
        fn= String.valueOf(f_name.getText());
        ln= String.valueOf(l_name.getText());
        ph= String.valueOf(p_no.getText());
        em= String.valueOf(e_name.getText());
        ab= about.getText().toString();
        if (fn.trim().equals("")){
            f_name.setError("Enter your first name");
        }
        else if (ln.trim().equals("")){
            l_name.setError("Last name needed");
        }
        else if (ph.trim().equals("")){
            p_no.setError("Phone number has an empty field");
        }
        else if (ab.trim().equals("")){
            about.setError("say something about your self");
        } else {
            Boolean isInserted = databaseHelpe.Insert(fn, ln, ph, em, ab);
            if (isInserted == true) {
                Log.i("my","correct");
                Toast.makeText(SQLiteActivity.this, "Sucessful", Toast.LENGTH_LONG).show();
                Intent i = new Intent(SQLiteActivity.this,sqliteview.class);
                startActivity(i);
            } else{
                Toast.makeText(SQLiteActivity.this, "Sucessful", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void access(View view) {
        Intent i = new  Intent(SQLiteActivity.this,sqliteview.class);
        startActivity(i);
    }


}
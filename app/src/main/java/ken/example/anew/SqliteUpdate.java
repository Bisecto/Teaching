package ken.example.anew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SqliteUpdate extends AppCompatActivity {
    EditText f_name,l_name,e_name,p_no,about;
    Button Updatebtn;
    String fname,lname,ename,pno,abo;
    Long id;
    DatabaseHelper databaseHelpe;
    String fn,ln,em,ph,ab;

    boolean isUpdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_update);
        databaseHelpe = new DatabaseHelper(this);
        f_name=(EditText) findViewById(R.id.fame);
        l_name= (EditText)findViewById(R.id.lame);
        e_name=(EditText) findViewById(R.id.eame);
        Updatebtn=(Button)findViewById(R.id.updat);
        p_no=(EditText) findViewById(R.id.pno);
        about=(EditText) findViewById(R.id.abut);
        id=getIntent().getExtras().getLong("id");
        fname = getIntent().getExtras().getString("firstname");
        lname = getIntent().getExtras().getString("lastname");
        ename= getIntent().getExtras().getString("email");
        pno = getIntent().getExtras().getString("phone");
        abo = getIntent().getExtras().getString("about");
        isUpdate= getIntent().getExtras().getBoolean("update");
        f_name.setText(fname);
        l_name.setText(lname);
        e_name.setText(ename);
        p_no.setText(pno);
        about.setText(abo);


        Updatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelpe= new DatabaseHelper(SqliteUpdate.this);
              String  fn= String.valueOf(f_name.getText());
                String  ln= String.valueOf(l_name.getText());
                String ph= String.valueOf(p_no.getText());
                String em= String.valueOf(e_name.getText());
                String ab= about.getText().toString();
              boolean  isUpdate=databaseHelpe.UpdateRow(String.valueOf(id), fn, ln, em, ph, ab);
                if (isUpdate){
                    Intent i = new Intent(SqliteUpdate.this,SQLiteActivity.class);
                    startActivity(i);
                    Toast.makeText(SqliteUpdate.this, "Sucessful", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(SqliteUpdate.this, "Not Sucessful", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
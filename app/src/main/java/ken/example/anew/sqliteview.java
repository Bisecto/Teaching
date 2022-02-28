package ken.example.anew;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class sqliteview extends AppCompatActivity {
    LinearLayout container,Linear;
    DatabaseHelper databaseHelper;
    LayoutInflater layoutInflater;
    int id;
    Cursor res;
    TextView edit1, edit2,edit3, edit4,edit5,Delete,Update;
    String firstn,lastn,email,number, abo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqliteview);
        layoutInflater = LayoutInflater.from(this);
        databaseHelper = new DatabaseHelper(this);
        res = databaseHelper.ReadData();
        container = findViewById(R.id.container);


        while (res.moveToNext()){
            final View view = layoutInflater.inflate(R.layout.populate_list,container,false);
            Delete=view.findViewById(R.id.Delete);
            Update=view.findViewById(R.id.Update);
            edit1= view.findViewById(R.id.edit1);
            edit2= view.findViewById(R.id.edit2);
            edit3= view.findViewById(R.id.edit3);
            edit4= view.findViewById(R.id.edit4);
            edit5= view.findViewById(R.id.edit5);
            Linear= view.findViewById(R.id.editit);
             id = res.getInt(res.getColumnIndex("id"));
            edit1.setText(res.getString(res.getColumnIndex("firstname")));
            edit2.setText(res.getString(res.getColumnIndex("lastname")));
            edit3.setText(res.getString(res.getColumnIndex("phone")));
            edit4.setText(res.getString(res.getColumnIndex("email")));
            edit5.setText(res.getString(res.getColumnIndex("about")));
            Delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder dialog = new AlertDialog.Builder(sqliteview.this);
                    dialog.setCancelable(false);
                    dialog.setTitle("Delete?");
                    dialog.setMessage("are you sure you want to go Delete");
                    dialog.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                           // Cursor res = databaseHelper.ReadData();
                            Toast.makeText(sqliteview.this, edit4.getText(), Toast.LENGTH_SHORT).show();
                          Integer string=  databaseHelper.DeleteRow((String) edit4.getText());
                        }
                    });
                    dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    final AlertDialog alert = dialog.create();
                    alert.show();
                }
            });
            Update.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String firstname= String.valueOf(edit1.getText());
                    String lastname=String.valueOf(edit2.getText());
                    String phone=String.valueOf(edit3.getText());
                    String email=String.valueOf(edit4.getText());
                    String about=String.valueOf(edit5.getText());
                   // int d = res.getInt(res.getColumnIndex("id"));
                    Intent i = new Intent(sqliteview.this,SqliteUpdate.class);
                    i.putExtra("id",id);
                    i.putExtra("firstname", firstname);
                    i.putExtra("lastname", lastname);
                    i.putExtra("phone", phone);
                    i.putExtra("email", email);
                    i.putExtra("about", about);
                    i.putExtra("update",true);
                    startActivity(i);
                    finish();
                        Log.i("ff", firstname);
                        Toast.makeText(sqliteview.this, firstname, Toast.LENGTH_SHORT).show();
                }
            });
            container.addView(view);

        }
    }
}
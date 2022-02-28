package ken.example.anew;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.net.URL;

public class browser extends AppCompatActivity {
    Button but;
    EditText text;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.browser);
        but = findViewById(R.id.button);
        text = findViewById(R.id.text);

    }
    public void browse(View view) {
        final String url = String.valueOf(text.getText());
        if (url.startsWith("www")){
            final AlertDialog.Builder alertDialog = new AlertDialog.Builder(browser.this);
            alertDialog.setCancelable(false);
            alertDialog.setTitle("welcome");
            alertDialog.setMessage("your are about to load a page");
            alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://"+url+""));
                    startActivity(i);
//                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("Http:"+url));
//                    startActivity(intent);
                   // Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.digitaldreamsng.com"));

                }
            });
            final AlertDialog alert = alertDialog.create();
            alert.show();
        } else {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(browser.this);
            alertDialog.setCancelable(true);
            alertDialog.setTitle("Error");
            alertDialog.setMessage("invalid url");
            alertDialog.setNegativeButton("Try again", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            final AlertDialog alert = alertDialog.create();
            alert.show();

        }
    }



}

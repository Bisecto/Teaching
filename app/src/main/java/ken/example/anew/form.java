package ken.example.anew;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.style.BackgroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class form extends AppCompatActivity {
    TextView fn,ln;
          EditText firstName, lastName;
          CheckBox check1, check2, check3, check4;
          Spinner spinner;
          RadioGroup radiogroup;
          RadioButton radio1, radio2;
          Switch swift ;
          EditText text;
          Calendar calender = Calendar.getInstance();
          SeekBar see;
          TextView seek;
         // Button button;
          LinearLayout linear;
          AutoCompleteTextView auto;
          @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
              auto= findViewById(R.id.auto);
              fn= findViewById(R.id.fn);
              ln= findViewById(R.id.ln);
        firstName= findViewById(R.id.firstname);
        lastName= findViewById(R.id.lastname);
        check1 = findViewById(R.id.check1);
        check2 = findViewById(R.id.check2);
        check3 = findViewById(R.id.check3);
        check4 = findViewById(R.id.check4);
        spinner = findViewById(R.id.spinner);
        radiogroup = findViewById(R.id.radiogroup);
        radio1 = findViewById(R.id.radio1);
        radio2 = findViewById(R.id.radio2);
        swift = findViewById(R.id.sweet);
        text = findViewById(R.id.text);
        see = findViewById(R.id.see);
        seek = findViewById(R.id.seek);
        linear = findViewById(R.id.linear);
        String one[] = {"obi","james","jude","collins"};
        ArrayAdapter array = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,one) ;
              array.setDropDownViewResource(android.R.layout.simple_spinner_item);
              auto.setAdapter(array);

              SharedPreferences sharedPreferences;

        see.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seek.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
              final DatePickerDialog.OnDateSetListener date  = new DatePickerDialog.OnDateSetListener() {
                  private  void updateLabel (){
                      String myFormat = "MM/dd/yy";
                      SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.TRADITIONAL_CHINESE);
                      text.setText(sdf.format(calender.getTime()));
                  }
                  @Override
                  public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                     calender.set(Calendar.YEAR,year);
                      calender.set(Calendar.MONTH,month);
                      calender.set(Calendar.DAY_OF_MONTH,dayOfMonth);
                      updateLabel();
                  }
              };
              text.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      new DatePickerDialog(form.this, date, calender.get(Calendar.YEAR), calender.get(Calendar.MONTH), calender.get(Calendar.DAY_OF_MONTH)).show();
                  }
              });
        swift.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (swift.isChecked()){
//                    linear.setBackgroundColor(Color.rgb(0,0,0));
//                    firstName.setBackgroundColor(Color.rgb(255,255,255));
//                    lastName.setBackgroundColor(Color.rgb(255,255,255));
//                    fn.setTextColor(Color.rgb(255,255,255));
//                    ln.setTextColor(Color.rgb(255,255,255));


                    Log.i("checked","checked");
                    Toast.makeText(form.this, "you turned something on", Toast.LENGTH_SHORT).show();
                } else{
                    return;
                }
            }
        });

         final String Male="";
              final String Female="";
        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String gender;
                if (checkedId == R.id.radio1){
                    gender= "Male";
                    Toast.makeText(form.this, "u selected " + gender, Toast.LENGTH_SHORT).show();
                } else {
                    gender= "Female";
                    Toast.makeText(form.this, "u selected " + gender, Toast.LENGTH_SHORT).show();
                }
            }
        });
              ArrayList<String> options = new ArrayList<>();
              options.add("");
              options.add("OND");
              options.add("HND");
              options.add("DEGREE");
              options.add("MASTERS");
              ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,options);
              adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
              spinner.setAdapter(adapter);
              spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                  @Override
                  public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                      String selected = parent.getItemAtPosition(position).toString();
                      if (selected.trim().equals("")){

                          return;
                      } else {

                          Toast.makeText(form.this, "u selected " + selected, Toast.LENGTH_SHORT).show();
                      }
                  }

                  @Override
                  public void onNothingSelected(AdapterView<?> parent) {

                  }
              });
    }

    public void backPage(View view) {
//              button.setOnClickListener(new View.OnClickListener() {
//                  @Override
//                  public void onClick(View v) {
//                      if (button.isSelected()){
//                          linear.setBackgroundColor(000000);
//                      }
//                  }
//              });

        if (!firstName.getText().toString().trim().equals("")) {
            if (!lastName.getText().toString().trim().equals("")) {


            } else {
                Toast.makeText(this, "last name too short", Toast.LENGTH_LONG).show();
                return;

            }
        } else {
            Toast.makeText(this, "first name too short", Toast.LENGTH_LONG).show();
            return;
        }
        String items = "";

            if(check1.isChecked()){
                items= items+ check1.getText()+"\n";
            }
            if(check2.isChecked()){
                items= items+ check2.getText()+"\n";
            }
            if(check3.isChecked()){
                items= items+ check3.getText()+ "\n";
            }
            if(check4.isChecked()){
                items= items+ check4.getText();
            }


        if (items.equals("")){
            Toast.makeText(this, "You must have at least one of the above Qualification", Toast.LENGTH_LONG).show();
            return;
        } else{
            Toast.makeText(this, items.trim(), Toast.LENGTH_LONG).show();

        }
//AlertDialog.Builder message = new AlertDialog.Builder(form.this);
//        message.setCancelable(false);
//        message.setTitle("DETAILS");
//        message.setMessage("Firstname: '"+firstName.getText()+"'\n Lastname:'"+lastName.getText()+"'");
//        message.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//
//            }
//        });



//        Intent intent = new Intent (this,MainActivity.class);
//        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
              AlertDialog.Builder dialog = new AlertDialog.Builder(form.this);
              dialog.setCancelable(false);
              dialog.setTitle("Quit?");
              dialog.setMessage("are you sure you want to go back");
              dialog.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialog, int which) {

                  }
              });
              dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialog, int which) {

                  }
              });
              final AlertDialog alert = dialog.create();
              alert.show();
       // super.onBackPressed();
    }
}

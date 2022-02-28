package ken.example.anew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SharePrefrence extends AppCompatActivity {
EditText username;
    EditText password;
    EditText name, Login_username,Login_password;
    EditText uname;
    EditText upassword;
    SharedPreferences.Editor editor;
    String urusername, urpasword, urgender, urname;
    boolean isLogin = true;
RadioGroup radioGroup;
LinearLayout loginLayout, RegistrationLayout;
Button switchBtn;
RadioButton male, female;
    String gender;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_prefrence);
        Login_password = findViewById(R.id.Login_password);
        Login_username = findViewById(R.id.Login_username);
        loginLayout = findViewById(R.id.loginLayout);
        RegistrationLayout = findViewById(R.id.RegistrationLayout);
        RegistrationLayout.setVisibility(RegistrationLayout.GONE);
        switchBtn = findViewById(R.id.swif);
         radioGroup = findViewById(R.id.rGroup);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        username = findViewById(R.id.Login_username);
        password = findViewById(R.id.Login_password);
        name = findViewById(R.id.name);
        uname = findViewById(R.id.uname);
        upassword = findViewById(R.id.upassword);
        switchBtn = findViewById(R.id.swif);

        sharedPreferences= this.getPreferences(this.MODE_PRIVATE);
        editor= sharedPreferences.edit();

               gender ="";
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.male) {

                }
                switch (checkedId){
                    case R.id.male:
                        gender = "male";
                        break;
                    case R.id.female:
                        gender = "female";

                }
            }
        });


    }

    public void Login(View view) {
        if (!Login_password.getText().toString().trim().equals("")|| ! Login_username.getText().toString().trim().equals("")){

            String user = sharedPreferences.getString("user_username", "");
            String pas = sharedPreferences.getString("user_password", "");
            String gen = sharedPreferences.getString("user_gender", "");

            if (Login_username.getText().toString().equals(user) && Login_password.getText().toString().equals(pas)){
                Intent intent = new Intent(SharePrefrence.this, dashboard.class);
//                Bundle bundle= new Bundle();
//                bundle.putString("iname",user);
//                bundle.putString("iusername",pas);
//                bundle.putString("igender",gen);
//                bundle.putString("ipassword",pas);

                intent.putExtra("iname", user );
                intent.putExtra("iusername", pas );
                intent.putExtra("igender", gen );
                intent.putExtra("ipassword", pas );

                startActivity(intent);
            } else{
                Toast.makeText(this, "wrong username or password", Toast.LENGTH_LONG).show();
            }

        } else {
            Toast.makeText(this, "please enter username and password", Toast.LENGTH_LONG).show();
        }


    }

    public void Register(View view) {
        urname= name.getText().toString();
        urpasword= upassword.getText().toString();
        urusername= uname.getText().toString();
        if (urname.trim().equals("")|| urpasword.trim().equals("") || urusername.trim().equals("")){
            Toast.makeText(this, "please fill the form ", Toast.LENGTH_LONG).show();

        } else if (gender.equals("")){
            Toast.makeText(this, "Enter your gender ", Toast.LENGTH_LONG).show();
        }
        else {
            ////////////////////Everything is ok/////////////////////////
            editor.putString("user_name", urname);
            editor.putString("user_password", urpasword);
            editor.putString("user_username", urusername);
            editor.putString("user_gender", gender);
            editor.commit();
            Toast.makeText(this, "Successfully Registered", Toast.LENGTH_LONG).show();
            name.setText("");
            upassword.setText("");
            uname.setText("");


        }
    }



    public void switch_layout(View view) {
        if(isLogin){
            isLogin= false;
            loginLayout.setVisibility(loginLayout.GONE);
            switchBtn.setText("Login");
            RegistrationLayout.setVisibility(view.VISIBLE);
        }else{
            isLogin= true;
            RegistrationLayout.setVisibility(view.GONE);
            switchBtn.setText("Register");
            loginLayout.setVisibility(loginLayout.VISIBLE);


        }
    }
}
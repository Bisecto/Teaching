package ken.example.anew;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;

public class DynamicButton extends AppCompatActivity {
Button btn;
Button newbt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_button);
        LinearLayout DynamicLayout=(LinearLayout)findViewById(R.id.DynamicLayout);

        btn=(Button)findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newBtn();
            }
        });

    }
    public void newBtn(){
        LinearLayout DynamicLayout=(LinearLayout)findViewById(R.id.DynamicLayout);
        newbt=new Button(this);
        newbt.setText("New Button");
        DynamicLayout.addView(newbt);
    }
}
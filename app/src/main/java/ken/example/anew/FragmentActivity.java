package ken.example.anew;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

public class FragmentActivity extends AppCompatActivity implements  BlankFragment.MessageListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
    }

    @Override
    public void onMessagesent(String txt) {
        Log.i("mymessage", txt);
        BlankFragment2 blankFragment2= new BlankFragment2();
        Bundle bundle = new Bundle();
        bundle.putString("message",txt);
        blankFragment2.setArguments(bundle);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frag, blankFragment2, null);
        transaction.addToBackStack(null);
        transaction.commit();

    }
}
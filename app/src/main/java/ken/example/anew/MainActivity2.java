package ken.example.anew;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity2 extends AppCompatActivity {
//Fragment fragment;
ViewPager viewPager;
Button frag1,frag2,frag3;
//LinearLayout line;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        frag1=findViewById(R.id.frag1);
        frag2=findViewById(R.id.frag2);
        frag3=findViewById(R.id.frag3);
        viewPager= findViewById(R.id.viewpager);
        viewPager.setAdapter(new FragSwipeAdapter(getSupportFragmentManager()));



    }
    public  void  first (View view){
        viewPager.setCurrentItem(0);

//        fragment = new first();
        FragmentManager fn= getSupportFragmentManager();
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        transaction.replace(R.id.fragment,fragment);
//        transaction.addToBackStack(null);
//        transaction.commit();
    }

    public void second(View view) {
        viewPager.setCurrentItem(1);
//        fragment = new second();
//        FragmentManager fn= getSupportFragmentManager();
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        transaction.replace(R.id.fragment,fragment);
//        transaction.addToBackStack(null);
//        transaction.commit();
    }

    public void third(View view) {
        viewPager.setCurrentItem(2);
//        fragment = new third();
//        FragmentManager fn= getSupportFragmentManager();
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        transaction.replace(R.id.fragment,fragment);
//        transaction.addToBackStack(null);
//        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        System.exit(0);
    }
}
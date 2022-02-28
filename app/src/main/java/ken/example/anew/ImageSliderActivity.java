package ken.example.anew;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

public class ImageSliderActivity extends AppCompatActivity {
ViewPager viewp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_slider);
        viewp= findViewById(R.id.imageslide);
        int image[]={
                R.drawable.cup,
                R.drawable.facebook,
                R.drawable.ppp
        };
        Myimageadapter my= new Myimageadapter(image,this);
        viewp.setAdapter(my);

    }
}
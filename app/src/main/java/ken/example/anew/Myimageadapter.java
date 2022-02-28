package ken.example.anew;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class Myimageadapter extends PagerAdapter {
    int image [];
    Context context;
    LayoutInflater layoutInflater;

    public Myimageadapter(int[]image, Context context) {
        this.image=image;
        this.context= context;
        layoutInflater= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        //super();
    }

    @Override
    public int getCount() {

        return image.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {

        return view== ((LinearLayout)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = layoutInflater.inflate(R.layout.slid, container,false);
        ImageView imageView= view.findViewById(R.id.img);
        imageView.setImageResource(image[position]);
       // return super.instantiateItem(container, position);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        //super.destroyItem(container, position, object);
        container.removeView((LinearLayout)object);
    }
}

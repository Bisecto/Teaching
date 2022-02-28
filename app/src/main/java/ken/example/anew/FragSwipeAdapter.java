package ken.example.anew;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class FragSwipeAdapter extends FragmentPagerAdapter {
    public FragSwipeAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new first();
            case 1:
                return new second();
            case 2:
                return new third();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}

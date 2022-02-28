package ken.example.anew;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class arrayadapter extends ArrayAdapter {
    ArrayList<String> firstname,lastname,email,image;
    Context context;

    public arrayadapter(@NonNull Context context, ArrayList<String> firstname, ArrayList<String> lastname, ArrayList<String> email, ArrayList<String> image) {
        super(context, R.layout.populate_list,firstname);
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.image = image;
        this.context = context;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
       // return super.getView(position, convertView, parent);
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.populate_list,parent,false);
        TextView text1 = view.findViewById(R.id.edit1);
        TextView text2 = view.findViewById(R.id.edit2);
        TextView text3 = view.findViewById(R.id.edit3);
        TextView text4 = view.findViewById(R.id.edit4);
        text1.setText(String.valueOf(position));
        text2.setText(firstname.get(position));
        text3.setText(lastname.get(position));
        text4.setText(email.get(position));
        return view;
    }
}

package android.example.miwok;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class WordAdaptor extends ArrayAdapter<Word> {

    private int mColorResourceId;
    public WordAdaptor(Activity context, ArrayList<Word> words, int colorResourceId){
        super(context,0,words);
        mColorResourceId = colorResourceId;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Word word = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView  miwokTextView = (TextView) listItemView.findViewById(R.id.Miwok_text_View);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        miwokTextView.setText(word.getMiwokTranslation());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_View);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        defaultTextView.setText(word.getDefaultTranslation());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.images);
        if (word.hasImage()){
            imageView.setImageResource(word.getImageResourceId());
            imageView.setVisibility(View.VISIBLE);
        }
        else{
            imageView.setVisibility(View.GONE);
        }


        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        textContainer.setBackgroundColor(color);


        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }

}


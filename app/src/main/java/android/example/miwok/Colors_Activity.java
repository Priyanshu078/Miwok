package android.example.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class Colors_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        setTitle("Colors");
        String color = "#8800A0";

        ArrayList<Word> words = new ArrayList<Word>();

        Word w = new Word("red","weṭeṭṭi",R.drawable.color_red,R.raw.color_red);
        words.add(w);
        words.add(new Word("green","chokokki",R.drawable.color_green,R.raw.color_green));
        words.add(new Word("brown","ṭakaakki",R.drawable.color_brown,R.raw.color_brown));
        words.add(new Word("gray","ṭopoppi",R.drawable.color_gray,R.raw.color_gray));
        words.add(new Word("black","kululli",R.drawable.color_black,R.raw.color_black));
        words.add(new Word("white","kelelli",R.drawable.color_white,R.raw.color_white));
        words.add(new Word("dusty yellow","ṭopiisә",R.drawable.color_dusty_yellow,R.raw.color_dusty_yellow));
        words.add(new Word("mustard yellow","chiwiiṭә",R.drawable.color_mustard_yellow,R.raw.color_mustard_yellow));

//        Word word = get
        try {
            ListView playaudio = (ListView) findViewById(R.id.list);
            playaudio.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Word word = words.get(position);
                    MediaPlayer mediaPlayer = MediaPlayer.create(Colors_Activity.this,word.getAudioResourceId());
                    mediaPlayer.start();
                }
            });
        }catch(Exception e)
        {
            Log.v("MainActivity",e.toString());
        }
        WordAdaptor adaptor = new WordAdaptor(this, words,R.color.category_colors);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adaptor);
//        listView.setBackgroundColor(Color.parseColor(color));
    }
}
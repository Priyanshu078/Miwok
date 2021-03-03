package android.example.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class numberActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        setTitle("Numbers");

        ArrayList<Word> words = new ArrayList<Word>();

        String color = "#FD8E09";

//        words.add("one");
//        words.add("two");
//        words.add("three");
//        words.add("four");
//        words.add("five");
//        words.add("six");
//        words.add("seven");
//        words.add("eight");
//        words.add("nine");
//        words.add("ten");
        Word w = new Word("one","lutti",R.drawable.number_one,R.raw.number_one);
        words.add(w);
        // we can write it in very simple snd concise manner.
        words.add(new Word("two","otiiko",R.drawable.number_two,R.raw.number_two));
        words.add(new Word("three","tolookosu",R.drawable.number_three,R.raw.number_three));
        words.add(new Word("four","oyyisa",R.drawable.number_four,R.raw.number_four));
        words.add(new Word("five","massokka",R.drawable.number_five,R.raw.number_five));
        words.add(new Word("six","temmokka",R.drawable.number_six,R.raw.number_six));
        words.add(new Word("seven","kenekaku",R.drawable.number_seven,R.raw.number_seven));
        words.add(new Word("eight","kawinta",R.drawable.number_eight,R.raw.number_eight));
        words.add(new Word("nine","wo'e",R.drawable.number_nine,R.raw.number_nine));
        words.add(new Word("ten","na'aacha",R.drawable.number_ten,R.raw.number_ten));

//        LinearLayout rootView = (LinearLayout) findViewById(R.id.rootView);
//        for(int i = 0;i<words.size();i++){
//            TextView wordView = new TextView(this);
//            wordView.setText(words.get(i));
//            rootView.addView(wordView);
//        }

        ListView playaudio = (ListView) findViewById(R.id.list);
        playaudio.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = words.get(position);

                MediaPlayer mediaPlayer = MediaPlayer.create(numberActivity.this, word.getAudioResourceId());
                mediaPlayer.start();
            }
        });
        WordAdaptor adaptor = new WordAdaptor(this, words,R.color.category_numbers);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adaptor);
//        listView.setBackgroundColor(Color.parseColor(color));

//        ArrayAdapter adaptor = new ArrayAdapter(numberActivity.this,android.R.layout.simple_list_item_1,words);
//        ListView listView = (ListView) findViewById(R.id.list);
//        listView.setAdapter(adaptor);
    }
}
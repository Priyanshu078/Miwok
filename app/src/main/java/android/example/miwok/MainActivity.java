package android.example.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView numberslist = (TextView) findViewById(R.id.numbers);
        TextView familyMembers = (TextView) findViewById(R.id.family);
        TextView colorslist = (TextView) findViewById(R.id.colors);
        TextView phraseslist = (TextView) findViewById(R.id.phrases);

        numberslist.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, numberActivity.class);
                startActivity(intent);
            }
        });
        familyMembers.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (View view){
                Intent intent = new Intent(MainActivity.this,Family_Members_Activity.class);
                startActivity(intent);
            }

        });
        colorslist.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick (View view){
                Intent intent = new Intent(MainActivity.this,Colors_Activity.class);
                startActivity(intent);
            }
        });
        phraseslist.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (View view){
                Intent intent = new Intent(MainActivity.this,Phrases_Activity.class);
                startActivity(intent);
            }
        });
    }
}
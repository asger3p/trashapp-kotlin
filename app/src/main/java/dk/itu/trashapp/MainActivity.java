package dk.itu.trashapp;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ItemsDB itemsDB = new ItemsDB();
        itemsDB.fillItemsDB();

        TextView items = findViewById(R.id.items);
        EditText inputText = findViewById(R.id.edit_text);
        Button listItems = findViewById(R.id.where_button);
        listItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                items.setBackgroundColor(Color.parseColor("#FFFFFF"));
                String a = "Trash List:" + "\n" + itemsDB.search(inputText.getText().toString().trim().toLowerCase());
                items.setText(a);
            }
        });
    }
}
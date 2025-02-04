package dk.itu.trashapp;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class addItemActivity extends AppCompatActivity {
    private static ItemsDB itemsDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additem);

        itemsDB = ItemsDB.get();

        TextView whatItemText = findViewById(R.id.what_text);
        TextView whereItemText = findViewById(R.id.where_text);

        //EditText inputWhatText = findViewById(R.id.what_text);
        //EditText inputWhereText = findViewById(R.id.where_text);

        Button addItemButton = findViewById(R.id.add_item_button);

        addItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String whatText = whatItemText.getText().toString().trim().toLowerCase();
                String whereText = whereItemText.getText().toString().trim().toLowerCase();

                if ((!whatText. isEmpty()) && (!whereText. isEmpty())) {
                    itemsDB.addItem(whatText, whereText);
                    whatItemText.setText("");
                    whereItemText.setText("");
                } else
                    Toast.makeText(addItemActivity.this, R.string.empty_toast, Toast.LENGTH_LONG).show();
            }
        });
    }
}

package ca.georgebrown.comp3074.uiprototype;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
public class EditItemsActivity extends AppCompatActivity {

    private EditText editTextItemName;
    private Button buttonAddItem;
    private Button buttonDeleteItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_items);

        editTextItemName = findViewById(R.id.editTextItemName);
        buttonAddItem = findViewById(R.id.buttonAddItem);
        buttonDeleteItem = findViewById(R.id.buttonDeleteItem);

        buttonAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle logic for adding items to ConfigurationActivity
                String newItemName = editTextItemName.getText().toString();
                // Add your logic to add the item to ConfigurationActivity data
                // ...

                // Optionally, you can finish the activity or reset the input field
                editTextItemName.getText().clear();
            }
        });

        buttonDeleteItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle logic for deleting items from ConfigurationActivity
                // ...

                // Optionally, you can finish the activity or update the UI
            }
        });
    }
}
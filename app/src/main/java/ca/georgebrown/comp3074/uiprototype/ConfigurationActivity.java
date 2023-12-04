package ca.georgebrown.comp3074.uiprototype;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class ConfigurationActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);

        listView = findViewById(R.id.listView);

        // Create sample data
        List<String> items = generateSampleData();

        // Create and set up the adapter
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);
    }

    private List<String> generateSampleData() {
        List<String> items = new ArrayList<>();
        items.add("Category       Name                 Price");
        items.add("Appetizer       Bruschetta       $8.99");
        items.add("Main Course   Spaghetti Bolognese   $14.99");
        items.add("Dessert            Tiramisu         $6.99");
        // Add more items as needed
        return items;
    }
}
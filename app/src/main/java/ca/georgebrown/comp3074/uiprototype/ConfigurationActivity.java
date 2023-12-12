package ca.georgebrown.comp3074.uiprototype;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class ConfigurationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);
        getSupportActionBar().setTitle("Configuration");

        Button add,delete;
        EditText et_category,et_name,et_number;
        ListView lv_menulist;

        add = findViewById(R.id.add);
        delete = findViewById(R.id.delete);
        lv_menulist = findViewById(R.id.lv_menulist);
        et_category = findViewById(R.id.et_category);
        et_name = findViewById(R.id.et_name);
        et_number = findViewById(R.id.et_number);

        DBHelper dbHelper = new DBHelper(ConfigurationActivity.this);

        // Retrieve items from the database
        List<MenuModel> items = dbHelper.getAllItems();

        // Create an ArrayAdapter and set it to the ListView
        MenuAdapter menuAdapter = new MenuAdapter(ConfigurationActivity.this, items);
        lv_menulist.setAdapter(menuAdapter);


        //clicking add button
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MenuModel menuModel;
                try {
                    int id = 0;
                    String category = et_category.getText().toString();
                    String name = et_name.getText().toString();
                    int number = Integer.parseInt(et_number.getText().toString());

                    menuModel = new MenuModel(id, category, name, number);

                    DBHelper dbHelper = new DBHelper(ConfigurationActivity.this);
                    boolean success = dbHelper.addOne(menuModel);
                    Toast.makeText(ConfigurationActivity.this,"Success ="+success,Toast.LENGTH_SHORT).show();

                    // Retrieve the updated list of items from the database
                    List<MenuModel> updatedItems = dbHelper.getAllItems();

                    // Create a new MenuAdapter with the updated list and set it to the ListView
                    MenuAdapter updatedMenuAdapter = new MenuAdapter(ConfigurationActivity.this, updatedItems);
                    lv_menulist.setAdapter(updatedMenuAdapter);

                }catch (Exception e){
                    Toast.makeText(ConfigurationActivity.this,"error creating item",Toast.LENGTH_SHORT).show();
                }
            }
        });

        //clicking delete button
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbHelper = new DBHelper(ConfigurationActivity.this);
                for (int id : menuAdapter.getSelectedIds()) {
                    dbHelper.deleteOne(id);
                }
                // Retrieve the updated list of items from the database
                List<MenuModel> updatedItems = dbHelper.getAllItems();

                // Create a new MenuAdapter with the updated list and set it to the ListView
                MenuAdapter updatedMenuAdapter = new MenuAdapter(ConfigurationActivity.this, updatedItems);
                lv_menulist.setAdapter(updatedMenuAdapter);

                Toast.makeText(ConfigurationActivity.this,"Deleted",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
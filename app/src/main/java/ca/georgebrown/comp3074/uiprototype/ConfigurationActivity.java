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
        ArrayAdapter<MenuModel> menuArrayAdapter = new ArrayAdapter<>(ConfigurationActivity.this, android.R.layout.simple_list_item_1, items);
        lv_menulist.setAdapter(menuArrayAdapter);


        //clicking add button
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MenuModel menuModel;
                try {
                    String category = et_category.getText().toString();
                    String name = et_name.getText().toString();
                    int number = Integer.parseInt(et_number.getText().toString());

                    menuModel = new MenuModel(category, name, number);

                    DBHelper dbHelper = new DBHelper(ConfigurationActivity.this);
                    boolean success = dbHelper.addOne(menuModel);
                    Toast.makeText(ConfigurationActivity.this,"Success ="+success,Toast.LENGTH_SHORT).show();

                }catch (Exception e){
                    Toast.makeText(ConfigurationActivity.this,"error creating item",Toast.LENGTH_SHORT).show();

                }





            }
        });

    }


}
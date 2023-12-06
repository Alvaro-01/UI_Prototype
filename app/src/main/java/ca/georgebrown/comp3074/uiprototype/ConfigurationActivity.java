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

    private ListView listView;


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

        et_category = findViewById(R.id.et_category);
        et_name = findViewById(R.id.et_name);
        et_number = findViewById(R.id.et_number);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    String category = et_category.getText().toString();
                    String name = et_name.getText().toString();
                    int number = Integer.parseInt(et_number.getText().toString());

                    MenuModel menuModel = new MenuModel(category, name, number);
                }catch (Exception e){
                    Toast.makeText(ConfigurationActivity.this,"error creating item",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


}
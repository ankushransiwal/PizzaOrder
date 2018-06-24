package com.example.ankush.pizzaorder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner spnSize;
    CheckBox cbCapsicum, cbCorn, cbOnion;
    Button btnOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    spnSize = (Spinner)findViewById(R.id.spnSize);
    cbCapsicum = (CheckBox)findViewById(R.id.cbCapsicum);
    cbOnion = (CheckBox)findViewById(R.id.cbOnion);
    cbCorn = (CheckBox)findViewById(R.id.cbCorn);
    btnOrder = (Button)findViewById(R.id.btnOrder);

        ArrayList<String> sizeList = new ArrayList<>();
        sizeList.add("Small");
        sizeList.add("Medium");
        sizeList.add("Large");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1, sizeList);

        spnSize.setAdapter(adapter);

        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String size = (String) spnSize.getSelectedItem();
                String topping = "";

                if(cbCapsicum.isChecked()){
                    topping = topping + " Capsicum";

                }
                if(cbCorn.isChecked()){
                    topping = topping + " Corn";
                }
                if(cbOnion.isChecked()){
                    topping = topping + " Onion";
                }

                Toast.makeText(MainActivity.this, "Size: "+size+ " Topping: "+topping, Toast.LENGTH_SHORT).show();
            }
        });



    }
}

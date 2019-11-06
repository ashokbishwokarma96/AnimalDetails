package com.meroapp.animaldetails;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.meroapp.animaldetails.adapter.AnimalsViewAdapter;
import com.meroapp.animaldetails.model.Animals;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName, editTextAge;
    private RadioGroup radioButtonGroupGender;
    private RadioButton radioButtonMale, radioButtonFemale;
    private Spinner spinnerImageSelector;
    private Button buttonSave;
    private RecyclerView recyclerViewAnimalDetail;
    String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTextAge = findViewById(R.id.editTextAge);

        radioButtonGroupGender = findViewById(R.id.radioButtonGroupGender);
        radioButtonMale = findViewById(R.id.radioButtonMale);
        radioButtonFemale = findViewById(R.id.radioButtonFemale);

        spinnerImageSelector = findViewById(R.id.spinnerImageSelector);
        buttonSave = findViewById(R.id.buttonSave);

        recyclerViewAnimalDetail = findViewById(R.id.recyclerViewAnimalDetail);

        final List<Animals> detail = new ArrayList<>();
        final int[] title = {
                (R.drawable.dog),
                (R.drawable.cat),
                (R.drawable.cow),
                (R.drawable.goat),
                (R.drawable.pig),

        };
        final String[] titlenaME = {
                "doh",
                "cat",
                "cow",
                "goat",
                "pig"

        };
        ArrayAdapter<String> imgtitle = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, titlenaME);
        spinnerImageSelector.setAdapter(imgtitle);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectid = radioButtonGroupGender.getCheckedRadioButtonId();
                RadioButton radioButton = findViewById(selectid);
                gender = radioButton.getText().toString();
                String name = editTextName.getText().toString();
                String age = (editTextAge.getText().toString());
                int position = (spinnerImageSelector.getSelectedItemPosition());
                int imageposition = title[position];
                detail.add(new Animals(name, age, gender, imageposition));
                AnimalsViewAdapter adapterView = new AnimalsViewAdapter(MainActivity.this, detail);
                recyclerViewAnimalDetail.setAdapter(adapterView);
                recyclerViewAnimalDetail.setLayoutManager(new LinearLayoutManager(MainActivity.this));

            }
        });



    }

}



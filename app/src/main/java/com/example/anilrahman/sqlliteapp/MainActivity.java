package com.example.anilrahman.sqlliteapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper db;
    EditText firstName, surname, marks;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);

        firstName = (EditText) findViewById(R.id.editText_name);
        surname = (EditText) findViewById(R.id.editText_surname);
        marks = (EditText) findViewById(R.id.editText_marks);
        btnAdd = (Button) findViewById(R.id.button_add);
        addData();
    }

    public void addData()
    {
        btnAdd.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                boolean isInserted = db.insertData(firstName.getText().toString(),
                                                   surname.getText().toString(),
                                                   marks.getText().toString());
                if(isInserted)
                {
                    Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Data not Inserted", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}

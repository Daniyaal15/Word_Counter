package com.example.word_counter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.word_counter.utils.TextCounter;

public class MainActivity extends AppCompatActivity {
    Spinner SpinnerCounting;
    EditText editTextInput;
    TextView TextViewResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.SpinnerCounting = findViewById(R.id.SpinnerCounting);
        this.editTextInput = findViewById(R.id.editTextInput);
        this.TextViewResult = findViewById(R.id.TextViewResult);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Counting_Options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        this.SpinnerCounting.setAdapter(adapter);

    }

    public void BtnClk(View view) {
        String phrase = this.editTextInput.getText().toString();
        int CountChar = TextCounter.CountChar(phrase);
        String formattedResult = String.valueOf(CountChar);

        if(CountChar == 0){
            Toast.makeText(this, "Please type Something :D", Toast.LENGTH_LONG).show();}
         this.TextViewResult.setText(formattedResult);
    }
}
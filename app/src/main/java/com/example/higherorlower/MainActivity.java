package com.example.higherorlower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public int randomInteger = generateRandomInteger();

    public int generateRandomInteger(){
        Random random = new Random();
        int rand = 1+random.nextInt(100);
        return rand;
    }

    public void clickFunction(View view){
        EditText guessString = (EditText)findViewById(R.id.numberEditText);
        int guessInt = Integer.parseInt(guessString.getText().toString());
        String message;

        if(guessInt > randomInteger)message = "Lower!";
        else if(guessInt < randomInteger) message = "Higher!";
        else{
            message = "Correct! Resetting answer...";
            randomInteger = generateRandomInteger();
        }

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        ((EditText)findViewById(R.id.numberEditText)).setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

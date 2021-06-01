package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.finalproject.tasks.SelectEquationLVL;
import com.example.finalproject.tasks.SelectExampleLVL;

import java.util.Objects;

public class SelectExercise extends AppCompatActivity implements View.OnClickListener {
    private Button button1, button2;
    private Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercise_activity);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        String text = "<font color='#FFFFFF'>Тренировка счёта</font>";

        Objects.requireNonNull(getSupportActionBar()).setTitle(Html.fromHtml(text));
        button1 = findViewById(R.id.button1);
        button1.setOnClickListener(this);
        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                i = new Intent(this, SelectExampleLVL.class);
                startActivity(i);
                break;
            case R.id.button2:
                i = new Intent(this, SelectEquationLVL.class);
                startActivity(i);
                break;
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
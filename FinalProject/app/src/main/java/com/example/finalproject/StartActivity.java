package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;

public class StartActivity extends AppCompatActivity implements View.OnClickListener {
    private Intent i;
    private Button gameButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity);
        gameButton = findViewById(R.id.gameButton);
        gameButton.setOnClickListener(this);
        String text = "<font color='#FFFFFF'>Тренировка счёта</font>";

        Objects.requireNonNull(getSupportActionBar()).setTitle(Html.fromHtml(text));

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.gameButton:
                i = new Intent(this, SelectExercise.class);
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
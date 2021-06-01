package com.example.finalproject.tasks;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.finalproject.R;

import java.util.Objects;

public class SelectEquationLVL extends AppCompatActivity implements View.OnClickListener {
    private Button buttonLVL1, buttonLVL2;
    private Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_equationlvl_activity);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        String text = "<font color='#FFFFFF'>Тренировка счёта</font>";
        Objects.requireNonNull(getSupportActionBar()).setTitle(Html.fromHtml(text));
        buttonLVL1 = findViewById(R.id.button1);
        buttonLVL1.setOnClickListener(this);
        buttonLVL2 = findViewById(R.id.button2);
        buttonLVL2.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                i = new Intent(this, Equation.class);
                startActivity(i);
                break;
            case R.id.button2:
                i = new Intent(this, EquationQuadratic.class);
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


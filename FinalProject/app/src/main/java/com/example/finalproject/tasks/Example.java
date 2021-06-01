package com.example.finalproject.tasks;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.finalproject.R;

import java.util.Objects;
import java.util.Random;

public class Example extends AppCompatActivity {

    private Random random;
    private TextView primer, check, score, mistakes;
    private Toast invalidInput;
    private LinearLayout linearLayout;
    private int randomer, mistakesCounter, counter;
    private Intent i;
    private Button answer, nextTask;
    private boolean isAnswer = true;
    private String otvet, text;
    private EditText field;
    CalculationsExample[] calculations = new CalculationsExample[100];

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.example_activity);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        text = "<font color='#FFFFFF'>Устный счёт</font>";
        Objects.requireNonNull(getSupportActionBar()).setTitle(Html.fromHtml(text));

        init();
        generation();

        mistakesCounter = 0; counter = 0;
        invalidInput = new Toast(this);
        random = new Random();
        randomer = random.nextInt(100);
        primer.setText(calculations[randomer].primer);
        mistakes.setText(Integer.toString(mistakesCounter));
        score.setText(Integer.toString(counter));

        answer.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                otvet = field.getText().toString();
                score.setText(Integer.toString(counter));
                if (otvet.equals(Integer.toString(calculations[randomer].result))) {
                    check.setBackgroundColor(Color.GREEN);
                    check.setText("Верно !");
                    if (isAnswer){
                        counter++;
                        score.setText(Integer.toString(counter));
                    }
                    isAnswer = false;

                }
                else if  (otvet.equals("")) {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Введите ответ !", Toast.LENGTH_SHORT);
                    toast.show();
                }else {
                        check.setBackgroundColor(Color.RED);
                        check.setText("Неверно !");
                        if (isAnswer){
                            counter--;
                            score.setText(Integer.toString(counter));
                            mistakesCounter++;
                            mistakes.setText(Integer.toString(mistakesCounter));
                            if (mistakesCounter == 3) {
                                check.setText("Вы проиграли, допустив 3 ошибки !");
                                check.setTextSize(25);
                                check.setBackgroundColor(Color.WHITE);
                                nextTask.setVisibility(View.GONE);
                                answer.setVisibility(View.GONE);
                                Button b = new Button(getApplicationContext());
                                b.setText("Заново");
                                int clr = Color.parseColor("red");
                                b.setBackgroundColor(clr);
                                b.setPadding(10, 0, 10, 0);
                                LinearLayout.LayoutParams params = new  LinearLayout.LayoutParams(
                                        LinearLayout.LayoutParams.WRAP_CONTENT,
                                        LinearLayout.LayoutParams.WRAP_CONTENT
                                );
                                params.topMargin = 70;
                                params.gravity = Gravity.CENTER;
                                b.setLayoutParams(params);
                                b.setTextSize(25);
                                b.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        field.setText("");
                                        finish();
                                        overridePendingTransition(0, 0);
                                        startActivity(getIntent());
                                        overridePendingTransition(0, 0);
                                    }
                                });
                                linearLayout.addView(b);
                            }
                        }
                        isAnswer = false;
                }
                if (counter == 20) {
                    check.setText("Поздравляем, Вы прошли этот уровень !");
                    check.setTextSize(25);
                    check.setBackgroundColor(Color.WHITE);
                    nextTask.setVisibility(View.GONE);
                    answer.setVisibility(View.GONE);
                    Button b = new Button(getApplicationContext());
                    b.setText("Следующий уровень");
                    int clr = Color.parseColor("green");
                    b.setBackgroundColor(clr);
                    b.setPadding(10, 0, 10, 0);
                    LinearLayout.LayoutParams params = new  LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.WRAP_CONTENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT
                    );
                    params.topMargin = 70;
                    params.gravity = Gravity.CENTER;
                    b.setLayoutParams(params);
                    b.setTextSize(25);
                    b.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            i = new Intent(Example.this, ExampleLVL2.class);
                            startActivity(i);
                        }
                    });
                    linearLayout.addView(b);

                }
            }
        });
        nextTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer();
            }
        });

    }
    private void answer(){
        randomer = random.nextInt(100);
        primer.setText(calculations[randomer].primer);
        isAnswer = true;
        field.getText().clear();
        check.setText("");
    }
    private void generation(){
        for (int i = 0; i < 100; i++){
            calculations[i] = new CalculationsExample();
        }
    }
    private void init(){
        answer = findViewById(R.id.answer);
        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        nextTask = findViewById(R.id.nextTask);
        field = findViewById(R.id.field);
        primer = findViewById(R.id.primer);
        check = findViewById(R.id.check);
        mistakes = findViewById(R.id.mistakes);
        score = findViewById(R.id.score);
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

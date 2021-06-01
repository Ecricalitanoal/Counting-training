package com.example.finalproject.tasks;

import android.annotation.SuppressLint;
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

import java.text.DecimalFormat;
import java.util.Objects;
import java.util.Random;


public class EquationQuadratic extends AppCompatActivity {
    private LinearLayout linearLayout;
    private Random random;
    private TextView primer, check, score, mistakes;
    private Toast invalidInput;
    private Button answer, nextTask;
    private int randomer, counter, mistakesCounter;
    private boolean isAnswer = true;
    private String otvetFSituation,  otvetSSituation, otvetFirst, otvetSecond,text;
    private EditText field1, field2;
    CalculationsEquationQuadratic[] calculations = new CalculationsEquationQuadratic[100];

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.equationlvl2_activity);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        text = "<font color='#FFFFFF'>Решение уравнений</font>";
        Objects.requireNonNull(getSupportActionBar()).setTitle(Html.fromHtml(text));

        initialization();
        generation2();

        counter = 0; mistakesCounter = 0;
        random = new Random();
        invalidInput = new Toast(this);
        randomer = random.nextInt(100);
        primer.setText(calculations[randomer].primer);
        mistakes.setText(Integer.toString(mistakesCounter));
        score.setText(Integer.toString(counter));

        answer.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                otvetFirst = field1.getText().toString();
                otvetSecond = field2.getText().toString();
                otvetFSituation = otvetFirst + otvetSecond;
                otvetSSituation = otvetSecond + otvetFirst;
                score.setText(Integer.toString(counter));
                DecimalFormat format = new DecimalFormat();
                format.setDecimalSeparatorAlwaysShown(false);
                if (otvetFSituation.equals(calculations[randomer].result) || otvetSSituation.equals(calculations[randomer].result) ) {
                    check.setBackgroundColor(Color.GREEN);
                    check.setText("Верно !");
                    check.setBackgroundColor(Color.GREEN);
                    check.setText("Верно !");
                    if (isAnswer){
                        counter++;
                        score.setText(Integer.toString(counter));
                    }
                    isAnswer = false;
                }
                else if  (otvetFirst.equals("") || otvetSecond.equals("")) {
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
                                    field1.setText("");
                                    field2.setText("");
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
                if (counter == 15) {
                    check.setText("Поздравляем, Вы прошли этот уровень !");
                    check.setTextSize(25);
                    check.setBackgroundColor(Color.WHITE);
                    nextTask.setVisibility(View.GONE);
                    answer.setVisibility(View.GONE);

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
        field1.getText().clear();
        field2.getText().clear();
        check.setText("");
    }
    private void generation2(){
        for (int i = 0; i < 100; i++){
            calculations[i] = new CalculationsEquationQuadratic();
        }
    }
    private void initialization(){
        answer = findViewById(R.id.answer);
        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        nextTask = findViewById(R.id.nextTask);
        field1 = findViewById(R.id.field1);
        field2 = findViewById(R.id.field2);
        primer = findViewById(R.id.primer);
        check = findViewById(R.id.check);
        invalidInput = new Toast(this);
        score = findViewById(R.id.score);
        mistakes = findViewById(R.id.mistakes);
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


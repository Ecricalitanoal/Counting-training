package com.example.finalproject.tasks;

import java.util.Random;

public class CalculationsExampleHard {
    public String primer;
    private String sign;
    public int result;
    private Random random;
    private int num1, num2;


    public CalculationsExampleHard() {
        generation();
    }
    private void generation(){
        random = new Random();
        String[] signs = {"+", "-", "*"};
        sign = signs[random.nextInt(3)];
        switch (sign) {
            case "+":
                num1 = random.nextInt(89) + 10;
                num2 = random.nextInt(89) + 10;
                this.result = num1 + num2;
                this.primer = Integer.toString(num1) + " " + sign + " " + Integer.toString(num2);
                break;
            case "-":
                num1 = random.nextInt(89) + 10;
                num2 = random.nextInt(89) + 10;
                this.result = num1 - num2;
                this.primer = Integer.toString(num1) + " " + sign + " " + Integer.toString(num2);
                break;
            case "*":
                num1 = random.nextInt(19) + 1;
                num2 = random.nextInt(19) + 1;
                this.result = num1 * num2;
                this.primer = Integer.toString(num1) + " " + sign + " " + Integer.toString(num2);
                break;
        }
    }
}


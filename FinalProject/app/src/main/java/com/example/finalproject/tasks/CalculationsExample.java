package com.example.finalproject.tasks;

import java.util.Random;

public class CalculationsExample {
    public String primer;
    public int result;
    private Random random;
    private String sign;
    private int num1, num2;


    public CalculationsExample() {
        generation();
    }
    private void generation(){
        random = new Random();
        String[] signs = {"+", "-", "*"};
        sign = signs[random.nextInt(3)];
        num1 = random.nextInt(9) + 1;
        num2 = random.nextInt(9) + 1;
        this.primer = Integer.toString(num1) + " " + sign + " " + Integer.toString(num2);
        switch (sign) {
            case "+":
                this.result = num1 + num2;
                break;
            case "-":
                this.result = num1 - num2;
                break;
            case "*":
                this.result = num1 * num2;
                break;
        }
    }
}

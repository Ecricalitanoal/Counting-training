package com.example.finalproject.tasks;

import java.text.DecimalFormat;
import java.util.Random;

public class CalculationsEquation{
    public String equation;
    private int num1, num2;
    public int result;
    private double num1A, num2A;
    private Random random;
    private String sign;
    private String xStr = "x";


    public CalculationsEquation() {
        generation();
    }
    private void generation(){
        String[] signs = {"+", "-", "*"};
        random = new Random();
        DecimalFormat format = new DecimalFormat();
        format.setDecimalSeparatorAlwaysShown(false);
                sign = signs[random.nextInt(3)];
                switch (sign){
                    case "+":
                        num1 = random.nextInt(45);
                        num2 = random.nextInt(45);
                        this.result = num2 - num1;
                        this.equation = xStr + " " + sign + " " + Integer.toString(num1) + " = "
                                + Integer.toString(num2);
                        break;
                    case "-":
                        //x-num1=num2
                        num1 = random.nextInt(45);
                        num2 = random.nextInt(45);
                        this.result = num2 + num1;
                        this.equation = xStr +  " "  + sign + " " + Integer.toString(num1) + " = "
                                + Integer.toString(num2);
                        break;
                    case "*":
                        num1A = random.nextInt(45) + 2; //15
                        num2A = random.nextInt(45) + 2; //16
                        double resultA = num2A / num1A;
                        if(Math.floor(resultA) == resultA){
                            this.result = (int) resultA;
                            this.equation = xStr + " " + sign + " " + format.format(num1A) + " = "
                                    + format.format(num2A);
                        } else{
                            this.result = (int) (num1A + num2A);
                            num1 = (int) num1A;
                            num2 = (int) num2A;
                            this.equation = xStr + " " + "-" + " " + Integer.toString(num1) + " = "
                                    + Integer.toString(num2);
                         }
                        break;

                }
        }


}



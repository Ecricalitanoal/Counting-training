package com.example.finalproject.tasks;

import java.util.Random;

public class CalculationsEquationQuadratic  {
    public int x1, x2, p, q;
    private Random random;
    public String primer, result;


    public CalculationsEquationQuadratic(){
        generation();
    }
    private void generation(){
        random = new Random();
        x1 = (random.nextInt(20) + 1);
        x2 = (random.nextInt(20) + 1);
        p = - (x1 + x2);
        q = x1 * x2;
        this.primer = ( "x" + (char) 0x00B2  + " " + p + "x + " + q + " = 0" );
        this.result = Integer.toString(x1) + Integer.toString(x2);
    }
}

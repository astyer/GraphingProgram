package com.company;

public class EquationSolver {

    public static double findYValue(double x, String eq, String eqType)
    {
        double y = 0;
        if(eqType.equalsIgnoreCase("linear"))
        {
            if(eq.contains("x"))
            {
                if(eq.contains("+"))
                {
                    double slope = 1;
                    if(!(eq.substring(0,eq.indexOf("x")).equals("")))
                    {
                       slope = Double.parseDouble(eq.substring(0,eq.indexOf("x")));
                    }
                    y = x*slope + Double.parseDouble(eq.substring(eq.indexOf("+")+1,eq.length()));
                }
                else if(eq.contains("-"))
                {
                    double slope = 1;
                    if(!(eq.substring(0,eq.indexOf("x")).equals("")))
                    {
                        slope = Double.parseDouble(eq.substring(0,eq.indexOf("x")));
                    }
                    y = x*slope - Double.parseDouble(eq.substring(eq.indexOf("-")+1,eq.length()));
                }
                else
                {
                    double slope = 1;
                    if(!(eq.substring(0,eq.indexOf("x")).equals("")))
                    {
                        slope = Double.parseDouble(eq.substring(0,eq.indexOf("x")));
                    }
                    y = x*slope;
                }
            }
            else
            {
                y = Double.parseDouble(eq.substring(0,eq.length()));
            }
        }
        return y;
    }

}

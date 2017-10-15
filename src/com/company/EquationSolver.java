package com.company;

public class EquationSolver {

    public static double findYValue(double x, String eq)
    {
        double y = 0;
        if(eq.contains("x"))
        {
            if(eq.contains("^"))
            {
                int lastpowop = 0;
                for(int i = 0; i < eq.length(); i++)
                {
                    if(eq.substring(i, i+1).equals("^"))
                    {
                        int oppos1 = -1;
                        boolean optype = true;
                        for(int j = i; j > 0; j--)
                        {
                            if(eq.substring(j-1, j).equals("+"))
                            {
                                oppos1 = j-1;
                                break;
                            }
                            if(eq.substring(j-1, j).equals("-"))
                            {
                                oppos1 = j-1;
                                optype = false;
                                break;
                            }
                        }
                        double mp = 1;
                        if(oppos1+1 != eq.indexOf("x", oppos1+1))
                        {
                            mp = Double.parseDouble(eq.substring(oppos1+1,eq.indexOf("x", oppos1+1)));
                        }
                        int oppos2 = 0;
                        for(int j = i; j < eq.length(); j++)
                        {
                            if(eq.substring(j, j+1).equals("+") || eq.substring(j, j+1).equals("-"))
                            {
                                oppos2 = j;
                                break;
                            }
                            oppos2 = j+1;
                        }
                        double powval = Math.pow(x, Double.parseDouble(eq.substring(i+1, oppos2)));
                        if(optype)
                        {
                            y+= mp * powval;
                        }
                        else
                        {
                            y-= mp * powval;
                        }
                        lastpowop = oppos2;
                    }
                }
                if(lastpowop != eq.length())
                {
                    if(eq.substring(lastpowop, lastpowop+1).equals("+"))
                    {
                        y+=findYValue(x, eq.substring(lastpowop+1));
                    }
                    else
                    {
                        y+=findYValue(x, eq.substring(lastpowop));
                    }
                }
            }
            else
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
        }
        else
        {
            y = Double.parseDouble(eq.substring(0,eq.length()));
        }
    return y;
    }

}

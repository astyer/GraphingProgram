package com.company;

public class EquationSolver {

    public static double findYValue(double x, String eq, String eqType)
    {
        double y = 0;
        if(eqType.equalsIgnoreCase("linear"))
        {
            if(eq.contains("x"))
            {
                if(eq.contains("^")) //magic
                {
                    int maxDegree = 1;
                    String[] parts = eq.split("\\+|\\-");
                    for(int i = 0; i < parts.length; i++) //
                    {
                        if(parts[i].contains("^"))
                        {
                            int degree = Integer.parseInt(parts[i].substring(parts[i].indexOf("^") + 1));
                            if(degree > maxDegree)
                                maxDegree = degree;
                        }
                    }
                    for(int i = 0; i < eq.length(); i++)
                    {
                        if(eq.substring(i, i + 1).equals("-"))
                            eq = eq.substring(0, i + 1) + "M" + eq.substring(i + 1);
                    }
                    double[] coef = new double[maxDegree + 1];
                    parts = eq.split("\\+|\\-");
                    for(int i = 0; i < parts.length; i++)
                    {
                        if(parts[i].contains("^"))
                        {
                            parts[i] = parts[i].replace("M", "-");
                            int degree = Integer.parseInt(parts[i].substring(parts[i].indexOf("^") + 1));
                            if(parts[i].indexOf("x") == 0)
                                coef[degree] += 1;
                            else if(parts[i].indexOf("-x") == 0)
                                coef[degree] -= 1;
                            else
                                coef[degree] += Double.parseDouble(parts[i].substring(0, parts[i].indexOf("x")));
                        }
                        else
                        {
                            parts[i]=parts[i].replace("M", "-");
                            if(!(parts[i].contains("x")))
                                coef[0] += Double.parseDouble(parts[i]);
                            else
                            {
                                if(parts[i].indexOf("x") == 0)
                                    coef[1] += 1;
                                else if(parts[i].indexOf("-x") == 0)
                                    coef[1] -= 1;
                                else
                                    coef[1] += Double.parseDouble(parts[i].substring(0, parts[i].indexOf("x")));
                            }
                        }
                    }
                    for(int i = 0; i < coef.length; i++)
                    {
                        y += coef[i] * Math.pow(x, i);
                    }
                }
                else
                {
                    if(eq.contains("+"))
                    {
                        double slope = 1;
                        if(!(eq.substring(0, eq.indexOf("x")).equals("")))
                        {
                            slope = Double.parseDouble(eq.substring(0, eq.indexOf("x")));
                        }
                        y = x * slope + Double.parseDouble(
                                eq.substring(eq.indexOf("+") + 1, eq.length()));
                    }
                    else if(eq.contains("-"))
                    {
                        double slope = 1;
                        if(!(eq.substring(0, eq.indexOf("x")).equals("")))
                        {
                            slope = Double.parseDouble(eq.substring(0, eq.indexOf("x")));
                        }
                        y = x * slope - Double.parseDouble(
                                eq.substring(eq.indexOf("-") + 1, eq.length()));
                    }
                    else
                    {
                        double slope = 1;
                        if(!(eq.substring(0, eq.indexOf("x")).equals("")))
                        {
                            slope = Double.parseDouble(eq.substring(0, eq.indexOf("x")));
                        }
                        y = x * slope;
                    }
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

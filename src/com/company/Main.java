package com.company;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Scanner inputD = new Scanner(System.in);
        System.out.println("Enter your equation in polynomial form (ex. y=3x^2+4x-2)");
        System.out.print("Input your equation: y=");
        String eq = input.nextLine();
        double xmin = -10;
        double xmax = 10;
        double ymin = -10;
        double ymax = 10;
        System.out.println("Edit window? (Enter yes or no)");
        String yorn = input.nextLine();
        if(yorn.equalsIgnoreCase("yes"))
        {
            System.out.print("Xmin=");
            xmin = inputD.nextDouble();
            System.out.print("Xmax=");
            xmax = inputD.nextDouble();
            System.out.print("Ymin=");
            ymin = inputD.nextDouble();
            System.out.print("Ymax=");
            ymax = inputD.nextDouble();
        }
        System.out.print("Xstep=");
        double xstep = inputD.nextDouble();

        ArrayList xvals = new ArrayList();
        for(double i = xmin; i <= xmax; i+=xstep)
        {
            xvals.add(i);
        }
        ArrayList yvals = new ArrayList();
        for(double i = xmin; i <= xmax; i+=xstep)
        {
            yvals.add(EquationSolver.findYValue(i, eq));
        }

        String [][] dataAr = new String[xvals.size()][2];
        for(int i = 0; i < dataAr.length; i++)
        {
            dataAr[i][0] = Double.toString((double)xvals.get(i));
        }
        for(int i = 0; i < dataAr.length; i++)
        {
            dataAr[i][1] = Double.toString((double)yvals.get(i));
        }
        String [] columnNames = {"x", "y"};

        JFrame frame = new JFrame("Table");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        JTable table = new JTable(dataAr, columnNames);
        JScrollPane sp = new JScrollPane(table);
        frame.add(sp);
        frame.setVisible(true);

        new Drawing(xvals, yvals, xmin, xmax, ymin, ymax).setVisible(true);
    }
}

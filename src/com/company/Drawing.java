package com.company;

import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import javax.swing.JFrame;

public class Drawing extends JFrame {

    public Drawing(ArrayList x, ArrayList y, double xmi, double xma, double ymi, double yma) {
        super("Graph");
        xmin = xmi;
        xmax = xma;
        ymin = ymi;
        ymax = yma;
        setSize(500, 528);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        xvals = x;
        yvals = y;
    }
    public ArrayList xvals;
    public ArrayList yvals;
    public double xmax;
    public double xmin;
    public double ymax;
    public double ymin;

    public void paint(Graphics g) {
        super.paint(g);
        drawAxis(g);
    }

    public void drawAxis(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        double xscaleFactor = 500/(xmax-xmin);
        double yscaleFactor = 500/(ymax-ymin);
        double yaxmid = 250;
        double xaxmid = 278;
        if(xmax + xmin != 0)
        {
            if(xmin <= 0)
                yaxmid = Math.abs(xmin)*xscaleFactor;
            else
                yaxmid = -xmin*xscaleFactor;
        }
        if(ymax + ymin != 0)
        {
            if(ymin <= 0)
                xaxmid = 528 - Math.abs(ymin)*yscaleFactor;
            else
                xaxmid = 528 + ymin*yscaleFactor;
        }
        g2d.draw(new Line2D.Double(yaxmid, 0, yaxmid, 528));
        g2d.draw(new Line2D.Double(0, xaxmid, 500, xaxmid));

        g2d.setColor(Color.BLUE);
        for(int i = 0; i < xvals.size()-1; i++)
        {
            g2d.draw(new Line2D.Double(yaxmid+((double)xvals.get(i)*xscaleFactor), xaxmid-((double)yvals.get(i)*yscaleFactor), yaxmid+((double)xvals.get(i+1)*xscaleFactor), xaxmid-((double)yvals.get(i+1)*yscaleFactor)));
        }

    }

}
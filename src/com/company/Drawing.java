package com.company;

import java.awt.Graphics;
import java.awt.Graphics2D;
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
        setSize((int)(xmax-xmin), (int)(ymax-ymin) + 28);
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
        //g2d.draw(new Line2D.Double(0, 40, 280, 28));
        double yaxmid = (xmax-xmin) - xmax;
        if(xmax >= 0 && xmin <=0)
        {
            g2d.draw(new Line2D.Double(yaxmid, 0, yaxmid, (ymax-ymin)+28));
        }
        double xaxmid = ((ymax-ymin)+28) + ymin;
        if(ymax >=0 && ymin <= 0)
        {
            g2d.draw(new Line2D.Double(0, xaxmid, xmax-xmin, xaxmid));
        }

        for(int i = 0; i < xvals.size()-1; i++)
        {
            g2d.draw(new Line2D.Double(yaxmid+(double)xvals.get(i), xaxmid-(double)yvals.get(i), yaxmid+(double)xvals.get(i+1), xaxmid-(double)yvals.get(i+1)));
        }

    }

}
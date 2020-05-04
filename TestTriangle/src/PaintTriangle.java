
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Drawline

/**
 *
 * @author JuanManuel
 */
public class PaintTriangle extends JPanel {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    ArrayList<Rectangle> dPoint = new ArrayList<Rectangle>();
    Point point = new Point(-1,-1);
    private Color currentColor;

    
    public void drawTriangle()
    {
        //here it comes the code to paint a triangle based on the input values
        clearDrawings();
        repaint();
    }
    //constructor
    public PaintTriangle()
    {
         setBorder(BorderFactory.createLineBorder(Color.black));
         setBackground(Color.WHITE);

         addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) 
            {
                dPoint.add(new Rectangle(point.x,point.y,e.getX(),e.getY()));
                point.x = e.getX();
                point.y = e.getY();
                repaint();
            }

             });

         addMouseListener(new MouseAdapter(){
             public void mousePressed(MouseEvent e)
             {
                 System.out.println("mousePressed X: "+e.getX()+"mousePressed Y: "+e.getY());
                 dPoint.add(new Rectangle(e.getX(),e.getY(),-1,-1));
                 point.x = e.getX();
                 point.y = e.getY();
             }
         });

         addMouseListener(new MouseAdapter(){
             public void mouseReleased(MouseEvent e)
             {
                 System.out.println("mouseReleased X: "+e.getX()+"mouseReleased Y: "+e.getY());
                 repaint();
             }
         });
    }

    @Override
    //JPanel size
    public Dimension getPreferredSize() {
        return new Dimension(300,200);
    }

    @Override
    //method that actually paints a triangle
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
       g.setColor(getCurrentColor());
        for (int i=0; i < dPoint.size(); i++) {  
            Rectangle r = dPoint.get(i);
            if (r.width != -1)
            {
              g.drawLine(r.x, r.y, r.width, r.height);  
            }
           }  
            /* Draw current point.*/ 
            g.drawLine(point.x, point.y, point.x, point.y);  
    }

    //set current drawing color
    public void changePenColor(Color color)
    {
        if (color == null)
        setCurrentColor(Color.BLACK);
        else
        setCurrentColor(color);
    }

    //clear drawings method
    public void clearDrawings()
    {
        if(!(dPoint==null))
        {
             dPoint.clear();
             repaint();
        }

    }

    private void setCurrentColor(Color currentColor) {
        this.currentColor = currentColor;
    }

    private Color getCurrentColor() {
        return currentColor;
    }
}
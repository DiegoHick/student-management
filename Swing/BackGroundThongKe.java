
package Swing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.GeneralPath;
import javax.swing.JPanel;


public class BackGroundThongKe extends JPanel{
    private float animate;
    private int header = 70;
    public float getAnimate()
    {
        return animate;
    }
    public void setAnimate(float animate)
    {
         this.animate=animate;
        repaint();
    }
   
    private float easeInOutQuint(float x) // set animation of the cubicurve2D, change the formula below to change animation
    {
        return (float) (1 - Math.pow(1 - x, 5));
    }
    
    private float easeInOutCirc(float x) // set animation of the cubicurve2D, change the formula below to change animation
    {
         return (float) (1 - Math.sqrt(1 - Math.pow(x, 2)));
    }
    
    public BackGroundThongKe()
    {
        setOpaque(false);
    }

    private boolean showpaintcs;
    
    public boolean isShowpaint()
    {
        return showpaintcs;
    }
    
    public void setShowpaint(boolean showpaint)
    {
        this.showpaintcs=showpaint;
    }
    
    @Override
    public void paint(Graphics g) {
        if(!showpaintcs)
        {
            super.paint(g);
        }
        Graphics2D g2= (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // bật chế độ khử răng cưa chống nhòe
        int height=(int) (getHeight()*(1f-easeInOutQuint(animate))); // set chuyển động animate
        g2.setColor(new Color(0, 153, 255)); // lấy màu
        g2.fill(createShape(height, 60, 70,50,100)); // vẻ đường cong
        g2.setColor(new Color(204, 235, 255));
        g2.fill(createShape(height,90,50,110,50,80));
        g2.setColor(new Color(102, 194, 255));
        g2.fill(createShape(height,80,20,60,20,80));

        int bgHeight=(int) (getHeight()*(1f-easeInOutCirc(animate)));
        bgHeight+=header;
        g2.setColor(new Color(255,255,255));
        g2.fillRect(0, bgHeight, getWidth(), getHeight());
        g2.dispose();
                
        if(showpaintcs)
        {
            super.paint(g);
        }
        
    }
    //create shape
    private Shape createShape(int location, int startInt, int... points)
    {
        int width   = getWidth();
        int height  = getHeight();
        int ss      = width/ points.length;
        int size    =location;
        GeneralPath p = new GeneralPath();
        int space   =0;
        int xs      =0;
        int ys      =location - startInt;
        for(int point: points)
        {
            point= size - point;
            int s= space+ss/2;
            p.append(new CubicCurve2D.Double(xs,ys,s,ys,s,point,xs+ss,point), true);
            space+=ss;
            xs+=ss;
            ys=point;
        }
                   
        p.lineTo(width, ys);  // line to line to create curve2D
        p.lineTo(width, height);
        p.lineTo(0, height);
        return p;   
    }
}

package lab2;
import java.awt.*;

public class RectShape extends Shape {
   public RectShape(int x1,int y1,int x2, int y2){super(x1,y1,x2,y2);}

    @Override
    public void draw(Graphics2D g2d){
        int width = Math.abs(x2 - x1);
        int height = Math.abs(y2 - y1);
        int topX = Math.min(x1,x2);
        int topY = Math.min(y1,y2);
        g2d.setColor(Color.GRAY);
        g2d.fillRect(topX,topY,width,height);
        g2d.setColor(Color.BLACK);
        g2d.drawRect(topX,topY,width,height);
   }
}

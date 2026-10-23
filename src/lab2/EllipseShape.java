package lab2;
import java.awt.*;

public class EllipseShape extends Shape {
    public EllipseShape(int x1, int y1 , int x2 , int y2){
        super(x1,y1,x2,y2);
    }
    @Override
    public void draw (Graphics2D g2d){
        int topX = Math.min(x1, x2);
        int topY = Math.min(y1, y2);
        int width = Math.abs(x2 - x1);
        int height = Math.abs(y2 - y1);
        g2d.setColor(Color.RED);
        g2d.fillOval(topX ,topY, width, height);
        g2d.setColor(Color.BLACK);
        g2d.drawOval(topX,topY,width,height);

    }
}

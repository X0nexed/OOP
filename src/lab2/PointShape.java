package lab2;
import java.awt.*;

public class PointShape extends Shape {
    public PointShape(int x1, int y1, int x2, int y2)
    { super(x1, y1, x2, y2); }

    @Override
    public void draw(Graphics2D g2d) {
        g2d.setColor(Color.BLACK);
        g2d.fillOval(x1,y1,5,5);

    }
}

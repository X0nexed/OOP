package lab2;
import java.awt.*;

public class RectShape extends Shape {
    public RectShape(int x1, int y1, int x2, int y2) {
        super(x1, y1, x2, y2);
    }

    @Override
    public void draw(Graphics2D g2d) {
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
        int topX = x1 - dx;
        int topY = y1 - dy;
        int width = 2 * dx;
        int height = 2 * dy;
        g2d.setColor(Color.GRAY);
        g2d.fillRect(topX, topY, width, height);
        g2d.setColor(Color.BLACK);
        g2d.drawRect(topX, topY, width, height);
    }

    @Override
    public void drawRubber(Graphics2D g2d) {
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
        g2d.setColor(Color.BLACK);
        g2d.drawRect(x1 - dx, y1 - dy, 2 * dx, 2 * dy);
    }
}

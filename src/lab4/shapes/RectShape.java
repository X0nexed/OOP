package lab4.shapes;

import java.awt.*;

public class RectShape extends Shape {
    private boolean filled = true;

    public RectShape() {
    }

    public RectShape(int x1, int y1, int x2, int y2) {
        super(x1, y1, x2, y2);
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    @Override
    public void draw(Graphics2D g2d) {
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
        int topX = x1 - dx;
        int topY = y1 - dy;
        int width = 2 * dx;
        int height = 2 * dy;
        if (filled) {
            g2d.setColor(Color.YELLOW);
            g2d.fillRect(topX, topY, width, height);
        }
        g2d.setColor(Color.BLACK);
        g2d.drawRect(topX, topY, width, height);
    }

    @Override
    public void drawRubber(Graphics2D g2d) {
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
        int topX = x1 - dx;
        int topY = y1 - dy;
        int width = 2 * dx;
        int height = 2 * dy;
        g2d.setColor(Color.BLACK);
        g2d.drawRect(topX, topY, width, height);
    }
}

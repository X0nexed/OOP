package lab4.shapes;

import java.awt.*;

public class LineOOShape extends Shape {
    private static final int R = 6;

    private final LineShape line = new LineShape();
    private final EllipseShape startCircle = new EllipseShape();
    private final EllipseShape endCircle = new EllipseShape();

    public LineOOShape() {
    }

    public LineOOShape(int x1, int y1, int x2, int y2) {
        super(x1, y1, x2, y2);
        updateParts();
    }

    @Override
    public void setCoords(int x1, int y1, int x2, int y2) {
        super.setCoords(x1, y1, x2, y2);
        updateParts();
    }

    @Override
    public void setEnd(int x2, int y2) {
        super.setEnd(x2, y2);
        updateParts();
    }

    private void updateParts() {
        line.setCoords(x1, y1, x2, y2);
        startCircle.setCoords(x1 - R, y1 - R, x1 + R, y1 + R);
        endCircle.setCoords(x2 - R, y2 - R, x2 + R, y2 + R);
    }

    @Override
    public void draw(Graphics2D g2d) {
        line.draw(g2d);
        startCircle.draw(g2d);
        endCircle.draw(g2d);
    }

    @Override
    public void drawRubber(Graphics2D g2d) {
        line.drawRubber(g2d);
        startCircle.drawRubber(g2d);
        endCircle.drawRubber(g2d);
    }
}

package lab4.shapes;

import java.awt.*;

public class CubeShape extends Shape {
    private static final int SHIFT_X = 30;
    private static final int SHIFT_Y = -30;

    private final RectShape frontRect = new RectShape();
    private final RectShape backRect = new RectShape();
    private final LineShape[] edges = {
            new LineShape(),
            new LineShape(),
            new LineShape(),
            new LineShape()
    };

    public CubeShape() {
        frontRect.setFilled(false);
        backRect.setFilled(false);
    }

    public CubeShape(int x1, int y1, int x2, int y2) {
        super(x1, y1, x2, y2);
        frontRect.setFilled(false);
        backRect.setFilled(false);
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
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);

        frontRect.setCoords(x1, y1, x2, y2);
        backRect.setCoords(x1 + SHIFT_X, y1 + SHIFT_Y, x2 + SHIFT_X, y2 + SHIFT_Y);

        edges[0].setCoords(x1 - dx, y1 - dy, x1 - dx + SHIFT_X, y1 - dy + SHIFT_Y);
        edges[1].setCoords(x1 + dx, y1 - dy, x1 + dx + SHIFT_X, y1 - dy + SHIFT_Y);
        edges[2].setCoords(x1 - dx, y1 + dy, x1 - dx + SHIFT_X, y1 + dy + SHIFT_Y);
        edges[3].setCoords(x1 + dx, y1 + dy, x1 + dx + SHIFT_X, y1 + dy + SHIFT_Y);
    }

    @Override
    public void draw(Graphics2D g2d) {
        frontRect.draw(g2d);
        backRect.draw(g2d);
        for (LineShape edge : edges) {
            edge.draw(g2d);
        }
    }

    @Override
    public void drawRubber(Graphics2D g2d) {
        frontRect.drawRubber(g2d);
        backRect.drawRubber(g2d);
        for (LineShape edge : edges) {
            edge.drawRubber(g2d);
        }
    }
}

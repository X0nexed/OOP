package lab4;

import lab4.shapes.Shape;
import lab4.shapes.*;
import java.awt.*;
import java.util.function.Supplier;

public class MyEditor {
    public static final MyEditor INSTANCE = new MyEditor();

    private final Shape[] shapes = new Shape[112];
    private int shapeCount = 0;
    private Shape currentShape = null;
    private Supplier<Shape> shapeFactory = PointShape::new;

    private MyEditor() {
    }

    public void start(Supplier<Shape> factory) {
        this.shapeFactory = factory;
    }

    public void onLBdown(int x, int y) {
        if (shapeFactory != null) {
            currentShape = shapeFactory.get();
            currentShape.setCoords(x, y, x, y);
        }
    }

    public void onMouseMove(int x, int y) {
        if (currentShape != null) {
            currentShape.setEnd(x, y);
        }
    }

    public void onLBup(int x, int y) {
        if (currentShape != null) {
            currentShape.setEnd(x, y);
            if (shapeCount < shapes.length) {
                shapes[shapeCount] = currentShape;
                shapeCount++;
            }
            currentShape = null;
        }
    }

    public void onPaint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        for (int i = 0; i < shapeCount; i++) {
            shapes[i].draw(g2d);
        }

        if (currentShape != null) {
            Stroke oldStroke = g2d.getStroke();
            float[] dash = {10.0f, 5.0f};
            g2d.setStroke(new BasicStroke(
                    1.0f,
                    BasicStroke.CAP_BUTT,
                    BasicStroke.JOIN_MITER,
                    10.0f,
                    dash,
                    0.0f
            ));
            currentShape.drawRubber(g2d);
            g2d.setStroke(oldStroke);
        }
    }
}

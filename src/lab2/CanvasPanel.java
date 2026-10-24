package lab2;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CanvasPanel extends JPanel {
    private Shape[] shapes = new Shape[111];
    private int shapeCount = 0;
    private Shape currentShape = null;
    private int currentMode = 1;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        for (int i = 0; i < shapeCount; i++) {
            shapes[i].draw(g2d);
        }

        if (currentShape != null) {
            float[] dash = {10.0f, 5.0f};
            BasicStroke dashed = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash, 0.0f);

            g2d.setStroke(dashed);
            currentShape.drawRubber(g2d);
            g2d.setStroke(new BasicStroke());
        }
    }

    public CanvasPanel() {
        MouseAdapter mouseHandler = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                switch (currentMode) {
                    case 1:
                        currentShape = new PointShape(x, y, x, y);
                        break;
                    case 2:
                        currentShape = new LineShape(x, y, x, y);
                        break;
                    case 3:
                        currentShape = new RectShape(x, y, x, y);
                        break;
                    case 4:
                        currentShape = new EllipseShape(x, y, x, y);
                        break;
                }
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                int x2 = e.getX();
                int y2 = e.getY();
                if (currentShape != null) {
                    currentShape.setEnd(e.getX(), e.getY());
                    repaint();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (currentShape != null) {
                    currentShape.setEnd(e.getX(), e.getY());
                    if (shapeCount < shapes.length) {
                        shapes[shapeCount] = currentShape;
                        shapeCount++;
                    }
                    currentShape = null;
                    repaint();

                }
            }
        };
        addMouseListener(mouseHandler);
        addMouseMotionListener(mouseHandler);
    }
    public void setMode(int mode) {
        this.currentMode = mode;
    }
}
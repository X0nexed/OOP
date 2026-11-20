package lab4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CanvasPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        MyEditor.INSTANCE.onPaint(g);
    }

    public CanvasPanel() {
        MouseAdapter mouseHandler = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                MyEditor.INSTANCE.onLBdown(e.getX(), e.getY());
                repaint();
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                MyEditor.INSTANCE.onMouseMove(e.getX(), e.getY());
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                MyEditor.INSTANCE.onLBup(e.getX(), e.getY());
                repaint();
            }
        };
        addMouseListener(mouseHandler);
        addMouseMotionListener(mouseHandler);
    }
}

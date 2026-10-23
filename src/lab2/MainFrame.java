package lab2;
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private CanvasPanel canvasPanel;

    public MainFrame() {
        setTitle("графічний редактор");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        canvasPanel = new CanvasPanel();
        add(canvasPanel, BorderLayout.CENTER);

        JMenuBar menuBar = new JMenuBar();
        JMenu objectsMenu = new JMenu("Об'єкти");
        menuBar.add(objectsMenu);


        JMenuItem pointItem = new JMenuItem("Крапка");
        objectsMenu.add(pointItem);
        pointItem.addActionListener(e -> {
            canvasPanel.setMode(1);
            setTitle("Крапка");
        });


        JMenuItem lineItem = new JMenuItem("Лінія");
        objectsMenu.add(lineItem);
        lineItem.addActionListener(e -> {
            canvasPanel.setMode(2);
            setTitle("Лінія");
        });

        JMenuItem rectItem = new JMenuItem("Прямокутник");
        objectsMenu.add(rectItem);
        rectItem.addActionListener(e -> {
            canvasPanel.setMode(3);
            setTitle("Прямокутник");
        });

        JMenuItem ellipseItem = new JMenuItem("Еліпс");
        objectsMenu.add(ellipseItem);
        ellipseItem.addActionListener(e -> {
            canvasPanel.setMode(4);
            setTitle("Еліпс");
        });

        setJMenuBar(menuBar);
    }
}
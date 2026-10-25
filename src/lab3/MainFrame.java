package lab3;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

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
        JMenu objectsMenu_file = new JMenu("Файл");
        JMenu objectsMenu = new JMenu("Об'єкти");
        JMenu objectsMenu_text = new JMenu("Довідка");

        menuBar.add(objectsMenu_file);
        menuBar.add(objectsMenu);
        menuBar.add(objectsMenu_text);

        JRadioButton checkItem_point = new JRadioButton("Крапка");
        checkItem_point.setSelected(true);
        objectsMenu.add(checkItem_point);
        checkItem_point.addActionListener(e -> {
            canvasPanel.setMode(1);
            setTitle("Крапка");
        });


        JRadioButton checkItem_line = new JRadioButton("лінія");
        checkItem_line .setSelected(false);
        objectsMenu.add(checkItem_line );
        checkItem_line .addActionListener(e -> {
            canvasPanel.setMode(2);
            setTitle("Лінія");
        });

        JRadioButton checkItem_rect = new JRadioButton("Прямокутник");
        objectsMenu.add(checkItem_rect);
        checkItem_rect.addActionListener(e -> {
            canvasPanel.setMode(3);
            setTitle("Прямокутник");
        });

        JRadioButton checkItem_ellipse = new JRadioButton("Еліпс");
        objectsMenu.add(checkItem_ellipse);
        checkItem_ellipse.addActionListener(e -> {
            canvasPanel.setMode(4);
            setTitle("Еліпс");
        });

        ButtonGroup group = new ButtonGroup();
        group.add(checkItem_point);
        group.add(checkItem_line);
        group.add(checkItem_rect);
        group.add(checkItem_ellipse);

        setJMenuBar(menuBar);
    }
}
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
            checkItem_point.setToolTipText("Це крапка ;)");
        checkItem_point.addActionListener(e -> {
            canvasPanel.setMode(1);
            setTitle("Крапка");
        });

        JRadioButton checkItem_line = new JRadioButton("лінія");
        objectsMenu.add(checkItem_line);
        checkItem_line.setToolTipText("А це лінія ;)");
        checkItem_line .addActionListener(e -> {
            canvasPanel.setMode(2);
            setTitle("Лінія");
        });

        JRadioButton checkItem_rect = new JRadioButton("Прямокутник");
        objectsMenu.add(checkItem_rect);
        checkItem_rect.setToolTipText("тут вже прямокутник \uD83D\uDE1B ");
        checkItem_rect.addActionListener(e -> {
            canvasPanel.setMode(3);
            setTitle("Прямокутник");
        });

        JRadioButton checkItem_ellipse = new JRadioButton("Еліпс");
        checkItem_ellipse.setToolTipText("ну тут вже цілий Еліпс \uD83D\uDE1D ");
        objectsMenu.add(checkItem_ellipse);
        checkItem_ellipse.addActionListener(e -> {
            canvasPanel.setMode(4);
            setTitle("Еліпс");
        });

        JToolBar toolbar = new JToolBar();
        JPanel panel = new JPanel();
        toolbar.add(panel);
        setJMenuBar(menuBar);
        add(toolbar, BorderLayout.NORTH);

        JRadioButton point = new JRadioButton("Крапка");
        point.setToolTipText("Це крапка ;)");
        point.addActionListener(e -> {
            canvasPanel.setMode(1);
            setTitle("Крапка");
        });

        JRadioButton line = new JRadioButton("лінія");
        line.setToolTipText("А це лінія ;)");
        line.addActionListener(e ->{
            canvasPanel.setMode(2);
            setTitle("Лінія");

        });

        JRadioButton rect = new JRadioButton("прямкутник");
        rect.setToolTipText("тут вже прямокутник \uD83D\uDE1B ");
        rect.addActionListener(e -> {
            canvasPanel.setMode(3);
            setTitle("Прямокутник");
        });

        JRadioButton Ellipse = new JRadioButton("Еліпс");
        Ellipse.setToolTipText("ну тут вже цілий Еліпс \uD83D\uDE1D ");
        Ellipse.addActionListener(e -> {
            canvasPanel.setMode(4);
            setTitle("Еліпс");
        });

        panel.add(point);
        panel.add(line);
        panel.add(rect);
        panel.add(Ellipse);
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));

        ButtonGroup group = new ButtonGroup();
        group.add(checkItem_point);
        group.add(checkItem_line);
        group.add(checkItem_rect);
        group.add(checkItem_ellipse);

        ButtonGroup group_tool = new ButtonGroup();
        group_tool.add(point);
        group_tool.add(line);
        group_tool.add(rect);
        group_tool.add(Ellipse);
    }
}

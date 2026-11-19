package lab3;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

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
        setJMenuBar(menuBar);
        JMenuItem about = new JMenuItem("Звіт");
        objectsMenu_text.add(about);
        about.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Прокопцов Кірілл ім-о51\n Lab№3", "Звіт", JOptionPane.INFORMATION_MESSAGE);
        });
        JToolBar toolbar = new JToolBar();
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        toolbar.add(panel);
        add(toolbar, BorderLayout.NORTH);

        ModeAction[] actions = new ModeAction[4];
        actions[0] = new ModeAction("Крапка", "Це крапка", 1, canvasPanel);
        actions[1] = new ModeAction("Лінія", "Лінія за двома точками", 2, canvasPanel);
        actions[2] = new ModeAction("Прямокутник", "Прямокутник за двома кутами", 3, canvasPanel);
        actions[3] = new ModeAction("Еліпс", "Еліпс від центру до кута", 4, canvasPanel);
        actions[0].putValue(Action.SELECTED_KEY, Boolean.TRUE);

        ImageIcon Point = new ImageIcon(getClass().getResource("icons/Point.png"));
        ImageIcon Ellipse = new ImageIcon(getClass().getResource("icons/ellipse.png"));
        ImageIcon rectangle = new ImageIcon(getClass().getResource("icons/rectangle.png"));
        ImageIcon line = new ImageIcon(getClass().getResource("icons/Line.png"));

        actions[0].putValue(Action.SMALL_ICON, Point);
        actions[1].putValue(Action.SMALL_ICON, line);
        actions[2].putValue(Action.SMALL_ICON, rectangle);
        actions[3].putValue(Action.SMALL_ICON, Ellipse);

        ButtonGroup group = new ButtonGroup();
        ButtonGroup group_tool = new ButtonGroup();

        for (ModeAction action : actions) {
            JToggleButton menuItem = new JToggleButton(action);
            objectsMenu.add(menuItem);
            group.add(menuItem);
        }
        for (ModeAction action : actions) {
            JToggleButton btn = new JToggleButton(action);
            btn.setHideActionText(true);
            btn.setFocusable(false);
            panel.add(btn);
            group_tool.add(btn);
        }
    }}
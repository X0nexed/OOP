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
        setJMenuBar(menuBar);

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

        ButtonGroup group = new ButtonGroup();
        ButtonGroup group_tool = new ButtonGroup();

        for (ModeAction action : actions) {
            JRadioButtonMenuItem menuItem = new JRadioButtonMenuItem(action);
            objectsMenu.add(menuItem);
            group.add(menuItem);
        }


        for (ModeAction action : actions) {
            JRadioButton btn = new JRadioButton(action);
            panel.add(btn);
            group_tool.add(btn);
        }
    }}
package lab4;

import lab4.shapes.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;

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
            JOptionPane.showMessageDialog(this, "Прокопцов Кірілл ім-о51\n Lab№4", "Звіт", JOptionPane.INFORMATION_MESSAGE);
        });

        JToolBar toolbar = new JToolBar(SwingConstants.VERTICAL);
        toolbar.setFloatable(false);
        add(toolbar, BorderLayout.WEST);

        ModeAction[] actions = new ModeAction[6];
        actions[0] = new ModeAction("Крапка", "Це крапка", PointShape::new);
        actions[1] = new ModeAction("Лінія", "Лінія за двома точками", LineShape::new);
        actions[2] = new ModeAction("Прямокутник", "Прямокутник за двома кутами", RectShape::new);
        actions[3] = new ModeAction("Еліпс", "Еліпс від центру до кута", EllipseShape::new);
        actions[4] = new ModeAction("Лінія з кружечками", "Лінія з кружечками", LineOOShape::new);
        actions[5] = new ModeAction("Каркас куба", "Каркас куба", CubeShape::new);

        for (ModeAction action : actions) {
            action.setGroupActions(actions);
        }

        actions[0].putValue(Action.SMALL_ICON, loadIcon("icons/Point.png"));
        actions[1].putValue(Action.SMALL_ICON, loadIcon("icons/Line.png"));
        actions[2].putValue(Action.SMALL_ICON, loadIcon("icons/rectangle.png"));
        actions[3].putValue(Action.SMALL_ICON, loadIcon("icons/ellipse.png"));
        actions[4].putValue(Action.SMALL_ICON, loadIcon("icons/point-line-point.png"));
        actions[5].putValue(Action.SMALL_ICON, loadIcon("icons/cube.png"));

        ButtonGroup group = new ButtonGroup();
        ButtonGroup group_tool = new ButtonGroup();

        for (ModeAction action : actions) {
            JRadioButtonMenuItem menuItem = new JRadioButtonMenuItem(action);
            objectsMenu.add(menuItem);
            group.add(menuItem);
        }
        for (ModeAction action : actions) {
            JToggleButton btn = new JToggleButton(action);
            btn.setHideActionText(true);
            btn.setFocusable(false);
            toolbar.add(btn);
            group_tool.add(btn);
        }

        actions[0].actionPerformed(null);
    }

    private ImageIcon loadIcon(String path) {
        URL url = getClass().getResource(path);
        if (url != null) {
            return new ImageIcon(url);
        }
        BufferedImage fallback = new BufferedImage(24, 24, BufferedImage.TYPE_INT_ARGB);
        return new ImageIcon(fallback);
    }
}

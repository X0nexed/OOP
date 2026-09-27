import javax.swing.*;
import java.awt.*;

public class Lab1 extends JFrame{
    private JLabel resultLabel;
    private Module1 module1;
    private Module2 module2;
    public Lab1() {
        resultLabel = new JLabel("Очікуемо вибір");
        add(resultLabel, BorderLayout.CENTER);
    setSize(400, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JMenuBar bar = new JMenuBar();
    JMenu menu = new JMenu("Menu") ;
    JMenuItem job1 = new JMenuItem("work1");
    JMenuItem job2 = new JMenuItem("work2");
    job1.addActionListener(e -> {
        if (module2 != null) {
            module2.dispose();
        }
        module1 = new Module1(this);
        module1.setVisible(true);
    });

    job2.addActionListener(e -> {
        if (module1 != null) {
            module1.dispose();
        }
        module2 = new Module2(this);
        module2.setVisible(true);
    });
    menu.add(job1);
    menu.add(job2);
    bar.add(menu);
    setJMenuBar(bar);
}
public void updateResult(String text) {
        resultLabel.setText(text);
}
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Lab1 frame = new Lab1();
            frame.setVisible(true);
        });
    }
}
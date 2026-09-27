package lab1;
import javax.swing.*;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Module2 extends JDialog{
    private JSlider slider;
    private  Lab1 parentWindow;
    public Module2(Lab1 parent){
        super(parent, "job 2", false);
        this.parentWindow = parent;
        setSize(350,180);
        slider = new JSlider(1,100,50);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        JButton yes_button = new JButton("Yes");
        JButton no_button = new JButton("No");
        JPanel slider_yes_or_no = new JPanel();
        slider_yes_or_no.add(yes_button);
        slider_yes_or_no.add(no_button);
        add(slider , BorderLayout.CENTER);
        add(slider_yes_or_no,BorderLayout.SOUTH);
        yes_button.addActionListener(new YesButtonListener());
        no_button.addActionListener(new NoButtonListener());
        slider.setMajorTickSpacing(20);
        slider.setMajorTickSpacing(5);
    }
    class YesButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int currentValue = slider.getValue();
            String textValue = String.valueOf(currentValue);
            String method_form = Utils.formatResult("job 2", textValue);
            parentWindow.updateResult(method_form);
            dispose();
        }
    }

    class NoButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    }
}







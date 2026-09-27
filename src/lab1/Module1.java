package lab1;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Module1 extends JDialog{
    private JTextField inputField;
    private Lab1 parentWindow;
    public Module1(Lab1 parent) {
        super(parent, "job 1", false);
        this.parentWindow = parent;
        setSize(300, 150);
        setLocationRelativeTo(parent);
        inputField = new JTextField(20);
        JButton okButton = new JButton("Yes");
        JButton cancelButton = new JButton("NO");
        JPanel ok_or_no = new JPanel();
        add(inputField, BorderLayout.CENTER);
        ok_or_no.add(okButton);
        ok_or_no.add(cancelButton);
        add(ok_or_no, BorderLayout.SOUTH);
        okButton.addActionListener(new OkButtonListener());
        cancelButton.addActionListener(new CancelButtonListener());
    }
    class OkButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String text = inputField.getText();
            String method_form = Utils.formatResult("job 1", text);

            parentWindow.updateResult(method_form);

            dispose();
        }
    }
    class CancelButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
        dispose();
        }
    }
}


















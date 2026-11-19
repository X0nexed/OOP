package lab3;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ModeAction extends AbstractAction {
    private final int mode;
    private final CanvasPanel canvasPanel;

    public ModeAction(String title, String tooltip, int mode, CanvasPanel canvasPanel) {
        super(title);
        putValue(Action.SHORT_DESCRIPTION, tooltip);
        this.mode = mode;
        this.canvasPanel = canvasPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        canvasPanel.setMode(mode);
        putValue(Action.SELECTED_KEY, Boolean.TRUE);
    }
}
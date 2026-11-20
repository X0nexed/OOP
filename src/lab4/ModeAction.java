package lab4;

import lab4.shapes.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.function.Supplier;

public class ModeAction extends AbstractAction {
    private final Supplier<Shape> factory;
    private ModeAction[] groupActions;

    public ModeAction(String title, String tooltip, Supplier<Shape> factory) {
        super(title);
        putValue(Action.SHORT_DESCRIPTION, tooltip);
        putValue(Action.SELECTED_KEY, Boolean.FALSE);
        this.factory = factory;
    }

    public void setGroupActions(ModeAction[] groupActions) {
        this.groupActions = groupActions;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MyEditor.INSTANCE.start(factory);
        if (groupActions != null) {
            for (ModeAction action : groupActions) {
                action.putValue(Action.SELECTED_KEY, action == this);
            }
        }
    }
}

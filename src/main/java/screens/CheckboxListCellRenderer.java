package screens;

import javax.swing.*;
import java.awt.*;

/**
 * A class that renders a checkbox list.
 * @param <E> a type parameter for what this list stores.
 */
public class CheckboxListCellRenderer<E> extends JCheckBox implements
        ListCellRenderer<E> {

    private static final long serialVersionUID = 3734536442230283966L;

    @Override
    public Component getListCellRendererComponent(JList<? extends E> list,
                                                  E value, int index, boolean isSelected, boolean cellHasFocus) {
        setComponentOrientation(list.getComponentOrientation());

        setFont(list.getFont());
        setText(String.valueOf(value));

        setBackground(list.getBackground());
        setForeground(list.getForeground());

        setSelected(isSelected);
        setEnabled(list.isEnabled());

        return this;
    }

}
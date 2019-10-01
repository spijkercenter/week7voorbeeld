package nl.avans.week7demo.view;

import nl.avans.week7demo.Controller;
import nl.avans.week7demo.model.Item;

import javax.swing.*;

class ButtonPanel extends JPanel {

    ButtonPanel(Controller controller) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        for (Item item : controller.getAllItems()) {
            JButton button = new JButton(item.getName() + " (" + item.getPriceInCents() + ")");
            button.addActionListener(actionEvent -> controller.handleItem(item));

            add(button);
        }
    }
}

package nl.avans.week7demo.view;

import nl.avans.week7demo.Controller;
import nl.avans.week7demo.UpdatableView;

import javax.swing.*;

public class CheckoutPanel extends JPanel implements UpdatableView {

    private Controller controller;
    private JLabel totalLabel;

    CheckoutPanel(Controller controller) {

        this.controller = controller;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        totalLabel = new JLabel();
        add(totalLabel);
        updateView();

        JButton button = new JButton("Afrekenen");
        button.addActionListener(ignore -> controller.handleItem(null));
        add(button);

        controller.subscribe(this);
    }

    @Override
    public void updateView() {
        totalLabel.setText("Totaal: " + controller.getTotal() + " cents");
    }
}

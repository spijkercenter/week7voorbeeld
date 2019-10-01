package nl.avans.week7demo.view;

import nl.avans.week7demo.Controller;

import javax.swing.*;
import java.awt.*;

class KassaPanel extends JPanel {

    KassaPanel(Controller controller) {
        setLayout(new GridLayout(2, 2));

        JComponent topLeft = new ButtonPanel(controller);

        JComponent topRight = new ShoppingCart(controller);
        JComponent bottomLeft = new JLabel("");
        JComponent bottomRight = new CheckoutPanel(controller);



        add(topLeft);
        add(topRight);
        add(bottomLeft);
        add(bottomRight);
    }
}

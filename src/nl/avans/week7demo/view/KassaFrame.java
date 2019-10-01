package nl.avans.week7demo.view;

import nl.avans.week7demo.Controller;

import javax.swing.*;
import java.awt.*;

public class KassaFrame extends JFrame implements Runnable {

    public KassaFrame(Controller controller) {
        super("Kassa");

        setPreferredSize(new Dimension(400, 400));

        setContentPane(new KassaPanel(controller));

        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }


    @Override
    public void run() {

    }
}
